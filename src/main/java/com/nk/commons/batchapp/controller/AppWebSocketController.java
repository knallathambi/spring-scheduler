package com.nk.commons.batchapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nk.commons.batchapp.model.InboundMessage;
import com.nk.commons.batchapp.model.OutboundMessage;

@Controller
public class AppWebSocketController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AppWebSocketController.class);
	
    @Autowired
    private SimpMessagingTemplate template;

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutboundMessage send(InboundMessage message) throws Exception {
		LOG.info(new ObjectMapper().writeValueAsString(message));
	    String time = new SimpleDateFormat("HH:mm").format(new Date());
	    OutboundMessage outboundMessage = new OutboundMessage();
	    outboundMessage.setTo(message.getFrom());
	    outboundMessage.setMessage("Reply from server to "+message.getFrom());
	    return outboundMessage;
	}
	
	@Scheduled(fixedRate=5000)
	public void sendHearBear(){
	    OutboundMessage outboundMessage = new OutboundMessage();
	    outboundMessage.setTo("System");
	    outboundMessage.setMessage("Server active");
	    this.template.convertAndSend("/topic/messages", outboundMessage);
		
	}
}
