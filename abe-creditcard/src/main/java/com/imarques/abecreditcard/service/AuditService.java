package com.imarques.abecreditcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.imarques.abecreditcard.model.PaymentAuthorization;

@Service
public class AuditService {
	@Autowired
	private Environment env;
	
	public void create(PaymentAuthorization paymentAuthorization) {
		RestTemplate restTemplate = new RestTemplate();
		String authServerUrl = env.getProperty("audit.server.url");
		restTemplate.postForLocation(authServerUrl, paymentAuthorization);
	}
}
