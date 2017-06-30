package com.nk.commons.batchapp.model;
public class InboundMessage {
	private String from;
	private String message;
	
	public InboundMessage(){
		
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
