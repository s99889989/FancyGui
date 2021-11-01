package com.daxton.fancygui.api.modgui.hub;

import com.daxton.fancygui.api.modgui.menu.MenuJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class HubJson {

	//物件表
	private Map<String, String> object_list = new HashMap<>();

	public HubJson(){

	}

	public HubJson(Map<String, String> object_list){
		this.object_list = object_list;
	}
	public void addObject(String type, String data){
		object_list.put(type, data);
	}

	//把字串轉成HubJson
	public static HubJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, HubJson.class);
	}

	public Map<String, String> getObject_list() {
		return object_list;
	}

	public void setObject_list(Map<String, String> object_list) {
		this.object_list = object_list;
	}
}
