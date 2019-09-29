package com.imarques.abecreditcard.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imarques.abecreditcard.model.PaymentAuthorization;
import com.imarques.abecreditcard.model.Transaction;
import com.imarques.abecreditcard.service.PaymentAuthorizationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("AuditControllerV1")
@RequestMapping("/v1/public/payment/authorizations")
@Api(tags = {"Transactions"})
public class PaymentAuthorizationController {
	@Autowired
	private PaymentAuthorizationService paymentAuthorizationService;
	
	@ApiOperation(value = "Autoriza o pagamento com cartão de crédito", code = 200 )
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Autorização processada com sucesso."),
			@ApiResponse(code = 406, message = "Não foi processar a autorização.")
	})
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<PaymentAuthorization> authorize(
			@ApiParam(required = true, value = "Informações da transação") @RequestBody Transaction transaction) {
		PaymentAuthorization result = paymentAuthorizationService.authorize(transaction);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(result);
	}
}
