package com.nk.commons.batchapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppRestController {

	@RequestMapping(method=RequestMethod.GET)
	public String getIndex(){
		return "NK Batch App";
	}
}
