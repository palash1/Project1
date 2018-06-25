package com.mantech;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.scheduling.support.PeriodicTrigger;

import com.mantech.data.SMS;
import com.mantech.utils.JSON;

@Configuration
@EnableIntegration
public class Configure {

	@Autowired
	private Environment env;
	
	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerMetadata defaultPoller() {

	    PollerMetadata pollerMetadata = new PollerMetadata();
	    pollerMetadata.setTrigger(new PeriodicTrigger(10));
	    return pollerMetadata;
	}
	
	@Bean
	public MqttPahoClientFactory mqttClientFactory() {
		
		String mqttURL= env.getProperty("mqtt.url");
		String userName= env.getProperty("mqtt.username");
		String password= env.getProperty("mqtt.password");
		
		DefaultMqttPahoClientFactory factory=new DefaultMqttPahoClientFactory();
		factory.setServerURIs(mqttURL);
		factory.setUserName(userName);
		factory.setPassword(password);
		
		return factory;
		
	}
	
	@Bean
	public MessageProducer smsReceiverAdapter(MqttPahoClientFactory mqttClientFactory) {
		
		String receiverClientName= env.getProperty("mqtt.client.name.receiver");
		String receiverTopicName= env.getProperty("mqtt.topic.name.receiver");
		
		MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(receiverClientName,mqttClientFactory,receiverTopicName);
		adapter.setCompletionTimeout(5000);
		adapter.setConverter(new DefaultPahoMessageConverter());
		adapter.setQos(1);
		adapter.setOutputChannel(smsValidationChannel());
		return adapter;
	}
	
	
	@Bean
	@ServiceActivator(inputChannel="sendSMSChannel")
	public MessageHandler smsSendAdapter(MqttPahoClientFactory mqttClientFactory) {
		
		String senderClientName= env.getProperty("mqtt.client.name.sender");
		String senderTopicName= env.getProperty("mqtt.topic.name.sender");
		
		MqttPahoMessageHandler messageHandler=new MqttPahoMessageHandler(senderClientName,mqttClientFactory);
		messageHandler.setAsync(true);
		messageHandler.setDefaultTopic(senderTopicName);
		return messageHandler;
	}
	
	@Bean
	@ServiceActivator(inputChannel="mqttOutboundChannel")
	public MessageHandler messageSendSave(MessageSendSaveListener  messageSendSaveListener) {
		
		 return messageSendSaveListener;
	}
	
	@Bean("mqttOutboundChannel")
	public MessageChannel mqttOutboundChannel() {
		
		return new PublishSubscribeChannel();
	}
	
	@Bean
	@ServiceActivator(inputChannel="mqttInputChannel")
	public MessageHandler messageProcess(MessageReceiverListener  messageReceiverListener) {
		
		 return messageReceiverListener;
	}
	
	@Bean
	@ServiceActivator(inputChannel="mqttInputChannel")
	public MessageHandler messageSaveInDB(MessageReceiverListenerAudit  messageReceiverListenerAudit) {
		
		 return messageReceiverListenerAudit;
	}
	
	
	
	//channels
	@Bean("smsValidationChannel")
	public MessageChannel smsValidationChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("smsTransformerChannel")
	public MessageChannel smsTransformerChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("smsRouterChannel")
	public MessageChannel smsRouterChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("smsChannel")
	public MessageChannel smsChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("smsUSSDChannel")
	public MessageChannel smsUSSDChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("smsFormatValidationChannel")
	public MessageChannel smsFormatValidationChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("garbageSmsChannel")
	public MessageChannel garbageSmsChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("mobileOrVehicleChannel")
	public MessageChannel mobileOrVehicleChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("mobileChannel")
	public MessageChannel mobileChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("vehicleChannel")
	public MessageChannel vehicleChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("smsSendChannel")
	public MessageChannel smsSendChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("helpChannel")
	public MessageChannel smsHelpChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("sendSMSCollectorChannel")
	public MessageChannel sendSMSCollectorChannel() {
		
		return new QueueChannel();
	}
	
	@Bean("sendSMSChannel")
	public MessageChannel sendSMSChannel() {
		
		return new QueueChannel();
	}
	
	//transformer
	
	@Transformer(inputChannel = "smsTransformerChannel", outputChannel = "smsRouterChannel")
    public SMS smsTransformer(Message<?> message) throws Exception{
         String jsonStr=message.getPayload().toString();
         SMS sms = JSON.fromJson(jsonStr, SMS.class);
         System.out.println("smsTransformer:" +sms);
		 return sms;
    }
}
