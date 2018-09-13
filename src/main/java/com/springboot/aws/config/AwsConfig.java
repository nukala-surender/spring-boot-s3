package com.springboot.aws.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Configuration
public class AwsConfig {
	
	@Autowired
	AwsPropertiesConfig config;

	AmazonS3 client;
	
	@PostConstruct
	public void init() {
		AWSCredentials cred = new BasicAWSCredentials(config.getAccessKey(), config.getAccessPwd());
		client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.US_EAST_2).build();
	}
	
	public String putObject() {
		
		client.putObject(new PutObjectRequest(config.getBucket(), "pom", new File("/home/surender/Downloads/test/pom.xml")).withCannedAcl(CannedAccessControlList.PublicRead));
		return "file saved!!";
	}
	
	public List<String> getAllObjects() {
		List<String> keys = new ArrayList<>();
		ObjectListing objList = client.listObjects(config.getBucket());
		for(S3ObjectSummary summary :objList.getObjectSummaries()) {
			keys.add(summary.getKey());
		}
		
		return keys;
	}
}
