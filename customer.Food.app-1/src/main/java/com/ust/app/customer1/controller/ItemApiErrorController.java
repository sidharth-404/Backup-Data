package com.ust.app.customer1.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ust.app.customer1.Exception.CustomerNotFoundException;
import com.ust.app.customer1.Exception.DuplicateCustomerException;
import com.ust.app.customer1.dto.ErrorResponse;


@RestControllerAdvice
public class ItemApiErrorController { 

	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomerNotFoundException.class)
    public ErrorResponse handleItemNotFoundError(CustomerNotFoundException ex,HttpServletRequest request)
    {
        var status=HttpStatus.NOT_FOUND;
        var error=status.getReasonPhrase();
        var timestamp=LocalDateTime.now();
        var path=request.getRequestURI();
        var msg=ex.getMessage();
        return new ErrorResponse(timestamp,status.value(),error,msg,path);
    }
		
	
   @ResponseStatus(code=HttpStatus.BAD_REQUEST)
   @ExceptionHandler(DuplicateCustomerException.class)
   public ErrorResponse handleDuplicateFoundfError(DuplicateCustomerException ex,HttpServletRequest request)
	{
	   var status=HttpStatus.FOUND;
       var error=status.getReasonPhrase();
       var timestamp=LocalDateTime.now();
       var path=request.getRequestURI();
       var msg=ex.getMessage();
       return new ErrorResponse(timestamp,status.value(),error,msg,path);
	}
//	
//	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(InvalidCategoryException.class)
//	public String handleCategoryFoundfError(InvalidCategoryException ex)
//	{
//		//ErrorResponse response=new ErrorResponse(LocalDateTime.now(),status.value(),error.)
//		return ex.getMessage();
//	}

}
