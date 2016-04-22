package com.mdbill.exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mdbill.model.GenericException;

@ControllerAdvice
public class GenericExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public List<GenericException> handleValidationException(MethodArgumentNotValidException exception){
		List<GenericException> geList=new ArrayList<GenericException>();
		List<ObjectError> allErrors=exception.getBindingResult().getAllErrors();
		Iterator<ObjectError> it=allErrors.iterator();
		while(it.hasNext()){
			ObjectError error=it.next();
			GenericException ge=new GenericException();
			ge.setMessage(error.getDefaultMessage());
			geList.add(ge);
			//System.out.println(error.getDefaultMessage());
		}
		//ge.setMessage(exception.getBindingResult().getFieldError().getDefaultMessage());
		return geList;
	}
	
}
