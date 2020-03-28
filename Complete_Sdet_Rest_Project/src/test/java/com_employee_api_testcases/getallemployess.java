package com_employee_api_testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com_base_employee_pack.Test_baseclass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getallemployess extends Test_baseclass{
	
	@BeforeClass
	void getall() throws InterruptedException {
		
		logger.info("***************stsrted get all employessclass****************");
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		RequestSpecification request= RestAssured.given();
		Response response= request.request(Method.GET,"/employees");
		Thread.sleep(3);
		}
	
	@Test
	void checkresponsebody() {
		
		logger.info("***********checking response body*********");
		
		 String responsestring=response.getBody().asString();
		 logger.info("the responsebody is"+ responsestring);
		 Assert.assertTrue(responsestring!=null);
		 
		
	}
	@Test
	void checkresponsecode() {
		logger.info("*********checkingresponse code **************");
		int code=response.getStatusCode();
		logger.info("the code is"+code);
		Assert.assertEquals(code,200);
		
		
	}
	@Test
	void checkresponsetime() {
		
		logger.info("*********checking response time*********");
	long responsetime=	response.getTime();
	if(responsetime>2000)
		logger.warn("response time is greater than expected");
	Assert.assertTrue(responsetime<2000);
		
		
	}
	
	

}
