package com.rtcms.controller;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("comm/v1")
public class NMSCommController {

	RestTemplate resttemplate = new RestTemplate();
	
	@GetMapping("/notedata")
	public ResponseEntity<?> getNoteDetails() throws IOException, RestClientException
	{
		String noteUrl = "http://localhost:8082/api/v1/getAllNotes";	
		ResponseEntity<?> respentity=null;
		
		try
		{
			respentity = resttemplate.exchange(noteUrl, HttpMethod.GET, getHeaders(),String.class);
		}
		catch(Exception e)
		{
			
		}
		
		return respentity;
	}
	
	private static HttpEntity<?> getHeaders() throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_XML_VALUE);
		return new HttpEntity(headers);
	}
}
