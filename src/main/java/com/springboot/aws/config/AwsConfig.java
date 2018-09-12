package com.springboot.aws.config;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Configuration
public class AwsConfig {

	private String accessKey="";
	private String accessPwd="";
	private String region="";
	
	AmazonS3 client;
	
	@PostConstruct
	public void init() {
		AWSCredentials cred = new BasicAWSCredentials(accessKey, accessPwd);
		client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(region).build();
	}
	
	public String putObject() {
		
		client.putObject(new PutObjectRequest("", "", new File("")).withCannedAcl(CannedAccessControlList.PublicRead));
		return "file saved!!";
	}
}
