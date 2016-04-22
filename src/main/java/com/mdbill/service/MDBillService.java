package com.mdbill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mdbill.model.Claim;


@Service("mdBillService")
public class MDBillService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	
	public List<Claim> getClaims(){
		return mongoTemplate.findAll(Claim.class);
	}
	
	public void createClaim(Claim claim){
		if(!mongoTemplate.collectionExists(Claim.class)){
			mongoTemplate.createCollection(Claim.class);
		}
		mongoTemplate.save(claim);
	}
	
	public boolean updateClaim(Claim claim){
		/*Investment investment=mongoTemplate.findById(claim.getClaimId(), Investment.class);
		if(investment!=null){
			mongoTemplate.save(investment);
			return true;
		}*/
		
		return false;
	}
}
