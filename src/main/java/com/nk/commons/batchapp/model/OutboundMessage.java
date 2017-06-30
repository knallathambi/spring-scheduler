package com.nk.commons.batchapp.model;

public class OutboundMessage {
	private String to;
	private String message;
	public OutboundMessage(){}
	
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
}
