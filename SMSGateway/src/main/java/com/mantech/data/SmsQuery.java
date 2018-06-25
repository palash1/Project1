package com.mantech.data;

public class SmsQuery {
	
	private String mobileNo;
	private String type="";
	private String value="";
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "SmsQuery [mobileNo=" + mobileNo + ", type=" + type + ", value=" + value + "]";
	}
}
