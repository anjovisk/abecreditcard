package com.imarques.abecreditcard.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imarques.abecreditcard.aws.lambda.AbeAuditService;
import com.imarques.abecreditcard.model.PaymentAuthorization;
import com.imarques.abecreditcard.model.TransactionTraceability;

@Service
@Profile("aws")
public class AuditServiceAws implements AuditService {
	@Autowired
	private ObjectMapper objectMapper;
	
	private AbeAuditService abeAuditService; 
	
	@PostConstruct
	private void prepareAuditService() {
		//https://docs.aws.amazon.com/pt_br/sdk-for-java/v1/developer-guide/credentials.html
		//copiar o arquivo credentials de src/main/resources para ~/.aws/
		abeAuditService = LambdaInvokerFactory.builder()
				.lambdaClient(AWSLambdaClientBuilder.standard().withRegion("sa-east-1").build())
				.objectMapper(objectMapper)
				.build(AbeAuditService.class);
	}
	
	public void create(PaymentAuthorization paymentAuthorization) {
		try {
			TransactionTraceability result = abeAuditService.create(paymentAuthorization);
			System.out.println("--------------Executou função lambda--------------");
			System.out.println(objectMapper.writeValueAsString(result));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException("Não foi pssível auditar a transação.");
		}
	}
}
