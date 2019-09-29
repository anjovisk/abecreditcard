package com.imarques.abecreditcard.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarques.abecreditcard.model.PaymentAuthorization;
import com.imarques.abecreditcard.model.Transaction;

@Service
public class PaymentAuthorizationService {
	private Long id = Long.valueOf(1);
	@Autowired
	private AuditService auditService;
	
	public PaymentAuthorization authorize(Transaction transaction) {
		Random random = new Random();
		PaymentAuthorization result = new PaymentAuthorization();
		result.setId(id++);
		result.setTransaction(transaction);
		result.setStatus(random.nextBoolean() ?
				PaymentAuthorization.AuthorizationStatus.SUCCESS
				:PaymentAuthorization.AuthorizationStatus.ERROR);
		result.setDate(LocalDateTime.now());
		auditService.create(result);
		return result;
	}
}
