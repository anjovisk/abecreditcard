package com.imarques.abecreditcard.aws.lambda;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.imarques.abecreditcard.model.PaymentAuthorization;
import com.imarques.abecreditcard.model.TransactionTraceability;

public interface AbeAuditService {
	@LambdaFunction(functionName = "abe-audit")
	TransactionTraceability create(PaymentAuthorization paymentAuthorization);
}