package com.lowes.bankingapp.fundtransfer.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lowes.bankingapp.fundtransfer.model.FundTransfer;
import com.lowes.bankingapp.fundtransfer.model.ResponseMessage;
import com.lowes.bankingapp.fundtransfer.service.FundTransferService;

@RestController
@RequestMapping("/fundtransfers")
public class FundtransferController {
	@Autowired
	FundTransferService fundService;

	@PostMapping
	public ResponseEntity<ResponseMessage> createOrder(@RequestBody @Valid FundTransfer fundTransfer) throws Exception {

		fundService.create(fundTransfer);

		// Getting current resource path
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fundTransfer.getSourceAccountId())
				.toUri();

		return ResponseEntity.created(location).body(this.getResponse(fundTransfer.getSourceAccountId(), "Fund Transfer done"));
	}
////
////	@GetMapping
////	public List<Order> getAll() {
////		return orderService.list();
////	}
//
//	@PutMapping("/{id}")
//	public ResponseEntity<ResponseMessage> updateOrder(@RequestBody @Valid Order order, @PathVariable Integer id) {
//		order.setId(id);
//		orderService.update(order);
//
//		return ResponseEntity.ok().body(this.getResponse(order.getId(), "Order Updated"));
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<ResponseMessage> deleteOrder(@PathVariable Integer id) {
//		orderService.delete(id);
//
//		ResponseMessage response = getResponse(id, "Order Deleted");
//
//		return ResponseEntity.accepted().body(response);
//	}

//	@GetMapping("/{id}")
//	public Order getOrder(@PathVariable Integer id) {
//		return orderService.get(id);
//	}

	private ResponseMessage getResponse(Integer id, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setId(id);
		response.setStatus(HttpStatus.OK.name());
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage(message);
		return response;
	}

	private ResponseMessage getErrorResponse(Integer id, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setId(id);
		response.setStatus(HttpStatus.BAD_REQUEST.name());
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage(message);
		return response;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<ResponseMessage> handleValidationException(MethodArgumentNotValidException ex) {
		FieldError error = ex.getBindingResult().getFieldError("name");
		System.out.println("Error Message: " + error.getCode() + " - " + error.getDefaultMessage());
		return ResponseEntity.badRequest().body(this.getErrorResponse(-1, error.getDefaultMessage()));
	}
	
}
