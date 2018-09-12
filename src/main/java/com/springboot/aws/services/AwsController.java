package com.springboot.aws.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class AwsController {

	
	@RequestMapping(value="/save")
	public void saveObject() {
		
	}
		
}
