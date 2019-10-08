package com.imarques.abecreditcard.service;

import com.imarques.abecreditcard.model.PaymentAuthorization;

public interface AuditService {
	void create(PaymentAuthorization paymentAuthorization);
}
