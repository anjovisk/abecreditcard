package com.imarques.abecreditcard.model;

public class TransactionTraceability {
	public enum AuthorizationStatus {
		SUCCESS, 
		ERROR
	}
	private Long id;
	private PaymentAuthorization paymentAuthorization;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PaymentAuthorization getPaymentAuthorization() {
		return paymentAuthorization;
	}
	public void setPaymentAuthorization(PaymentAuthorization paymentAuthorization) {
		this.paymentAuthorization = paymentAuthorization;
	}
}
