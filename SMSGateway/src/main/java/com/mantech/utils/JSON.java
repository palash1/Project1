package com.mantech.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {
	
	public static String toJson( Object obj) throws JsonProcessingException {
		
		ObjectMapper mapper =new ObjectMapper();
		String jsonStr= mapper.writeValueAsString(obj);
		return jsonStr;
	}
	
	public static <T> T fromJson( String jsonStr, Class<T> clsType) throws JsonParseException,JsonMappingException,IOException {
		
		ObjectMapper mapper =new ObjectMapper();
		T obj=mapper.readValue(jsonStr, clsType);
		return obj;
	}

}
