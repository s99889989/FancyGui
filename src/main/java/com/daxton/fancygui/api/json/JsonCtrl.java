package com.daxton.fancygui.api.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonCtrl {

	//把物件轉成Json字串
	public static String writeJSON(Object object) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.toJson(object);
	}

}
