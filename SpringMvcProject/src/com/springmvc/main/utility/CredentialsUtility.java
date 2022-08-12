package com.springmvc.main.utility;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class CredentialsUtility {
		public static HttpHeaders getHeaders(){
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			return httpHeaders; 
		}
}
