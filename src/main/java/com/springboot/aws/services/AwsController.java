package com.springboot.aws.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.aws.config.AwsConfig;

@RestController
@RequestMapping(value="/api")
public class AwsController {

	@Autowired
	AwsConfig config;
	
	@RequestMapping(value="/save")
	public String saveObject() {
		return config.putObject();
	}
	
	@RequestMapping(value="/getFiles")
	public List<String> getAllFiles() {
		return config.getAllObjects();
	}
	
	@RequestMapping(value="/hello")
	public Map<String, String> helloWorld() {
		Map<String, String> message = new HashMap<>();
		message.put("message", "hello world!!");
		return message;

	}
		
}
