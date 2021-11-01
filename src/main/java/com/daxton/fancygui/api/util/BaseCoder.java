package com.daxton.fancygui.api.util;

import java.util.Base64;

public class BaseCoder {
	// Base64編碼
	public static String toBase64(String message){
		byte[] encodedBytes = Base64.getEncoder().encode(message.getBytes());
		return new String(encodedBytes);
	}
	// Base64解碼
	public static String toMessage(String base64){
		byte[] decodedBytes = Base64.getDecoder().decode(base64.getBytes());
		return new String(decodedBytes);
	}

}
