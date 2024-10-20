package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorDetails> exception(Exception e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(NoHandlerFoundException.class)
public ResponseEntity<ErrorDetails> NoHandlerFoundException(NoHandlerFoundException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ErrorDetails> MethodArgumentNotValidException(MethodArgumentNotValidException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(CustomerException.class)
public ResponseEntity<ErrorDetails> handleCustomerExceptions(CustomerException ce,WebRequest req){
	
	ErrorDetails myErrorDetails = new ErrorDetails();
	log.error("bad request");
	return new ResponseEntity<ErrorDetails>(new ErrorDetails(ce.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(SeedsException.class)
public ResponseEntity<ErrorDetails> handleSeedExceptions(SeedsException ce,WebRequest req){
	
	ErrorDetails myErrorDetails = new ErrorDetails();
	log.error("bad request");
	return new ResponseEntity<ErrorDetails>(new ErrorDetails(ce.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(PlantException.class)
public ResponseEntity<ErrorDetails> PlantException(PlantException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(PlanterException.class)
public ResponseEntity<ErrorDetails> PlanterException(PlanterException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(OrdersException.class)
public ResponseEntity<ErrorDetails> OrdersException(OrdersException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(LoginException.class)
public ResponseEntity<ErrorDetails> LoginException(LoginException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(CartException.class)
public ResponseEntity<ErrorDetails> CartException(CartException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(AddressException.class)
public ResponseEntity<ErrorDetails> AddressException(AddressException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(AdminException.class)
public ResponseEntity<ErrorDetails> AdminException(AdminException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}
}
