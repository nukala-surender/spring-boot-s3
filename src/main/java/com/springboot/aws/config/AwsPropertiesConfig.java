package com.springboot.aws.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "aws")
public class AwsPropertiesConfig {

	String accessKey;
	String accessPwd;
	String bucket;

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getAccessPwd() {
		return accessPwd;
	}

	public void setAccessPwd(String accessPwd) {
		this.accessPwd = accessPwd;
	}

}
