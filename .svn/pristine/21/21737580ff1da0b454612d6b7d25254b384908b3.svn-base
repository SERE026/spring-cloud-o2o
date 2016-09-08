package com.merchant.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

	
	public static String readPostContent(HttpServletRequest request){
		BufferedReader in= null;
		String content = null;
		String line = null;
		try {
			in = new BufferedReader(new InputStreamReader(request.getInputStream()));
			StringBuilder buf = new StringBuilder();
			while ((line = in.readLine()) != null) {
				buf.append(line);
			}
			content = buf.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content; 
	}
	
	
}
