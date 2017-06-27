package com.nk.commons.batchapp.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchService {
	
	@Scheduled(fixedDelay=5000)
	public void scheduledTask(){
		System.out.println("Scheduled Task");
	}

}
