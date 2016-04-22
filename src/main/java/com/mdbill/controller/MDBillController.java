package com.mdbill.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdbill.model.Claim;
import com.mdbill.service.MDBillService;


@RestController
public class MDBillController {

	@Autowired
	@Qualifier("mdBillService")
	private MDBillService service;
	
	
	@RequestMapping(value="/claims",method=RequestMethod.GET,produces="application/json")
	public List<Claim> getClaims(){
			
		return service.getClaims();
		
	}
	

	@RequestMapping(value="/claim",method=RequestMethod.POST,produces="application/json")
	public void saveClaim(@Valid @RequestBody Claim claim){
			
		 service.createClaim(claim);
		
	}
}
