package com.relayr.productcomparisonservice.util;

import com.relayr.productcomparisonservice.pojo.Response;

public class ResponseGenerationUtil {

	
	public static Response<Object> generateResponse(boolean status ,String msg ,  Object o) {
		return new Response<Object>(status,msg,null , o);
	}
}
