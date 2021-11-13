package com.daxton.fancygui.api.mod.player;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class PlayerRenderJson {

	//物件表
	private Map<String, String> objectList = new HashMap<>();

	public PlayerRenderJson(Map<String, String> objectList) {
		this.objectList = objectList;
	}

	//把字串轉成EntityJson
	public static PlayerRenderJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, PlayerRenderJson.class);
	}

	public Map<String, String> getObjectList() {
		return objectList;
	}

	public void setObjectList(Map<String, String> objectList) {
		this.objectList = objectList;
	}
}
