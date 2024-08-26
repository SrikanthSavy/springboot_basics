package com.shoda.rest.webservices.restful_web_servies.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	//URL-Versioning Implementation
	@GetMapping(path = "/v1/person")
	public PersonV1 getFirstVesrionofPerson()
	{
		return new PersonV1("Srikanth Shoda");
	}
	
	@GetMapping(path = "/v2/person")
	public PersonV2 getSecondVesrionofPerson()
	{
		return new PersonV2(new Name("Srikanth","Shoda"));
	}
	
	
	//Request Parameter Versioning implemnetation - v1
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVesrionofPersonByRequestParam1()
	{
		return new PersonV1("Srikanth Shoda");
	}
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getFirstVesrionofPersonByRequestParam2()
	{
		return new PersonV2(new Name("Srikanth","Shoda"));
	}
	
	
	//Header- versionining ( Custome Headers)
	@GetMapping(path = "/person/header", headers = "X_API_VERSION=1")
	public PersonV1 getFirstVesrionofPersonByHeaders1()
	{
		return new PersonV1("Srikanth Shoda");
	}
	@GetMapping(path = "/person/header", headers = "X_API_VERSION=2")
	public PersonV2 getFirstVesrionofPersonByHeaders2()
	{
		return new PersonV2(new Name("Srikanth","Shoda"));
	}
	
	//Media Type Versioning : Akka Content-Negotiation i.e " accept header"
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVesrionofPersonByMediaType1()
	{
		return new PersonV1("Srikanth Shoda");
	}
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getFirstVesrionofPersonByMediaType2()
	{
		return new PersonV2(new Name("Srikanth","Shoda"));
	}
	
}
