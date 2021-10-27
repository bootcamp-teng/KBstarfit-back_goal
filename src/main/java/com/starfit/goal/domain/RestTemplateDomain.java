package com.starfit.goal.domain;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RestTemplateDomain {
		
	private final Logger log = LoggerFactory.getLogger(getClass());
	private final String baseUrl = "http://teng.169.56.174.139.nip.io";
	
	@Bean
	public RestTemplate getRestTemplate(){
	    return new RestTemplate();
	}
	
	public ResponseEntity<String> doRestTemplate(JSONObject jsonObject, String url, HttpMethod method) {
		log.info("jsonObject : {}" ,jsonObject.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		ResponseEntity<String> result = getRestTemplate().exchange(
		        baseUrl + url,
		        method,
		        request,
		        String.class);

		log.info("result : {}", result.toString());
		return result;
	}
}
