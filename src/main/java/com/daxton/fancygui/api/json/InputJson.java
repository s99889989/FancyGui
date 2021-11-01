package com.daxton.fancygui.api.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class InputJson {

	//最後輸入的輸入框ID
	private String button_id = "";
	//最後輸入的內容
	private String message = "";
	//所有輸入內容
	private Map<String, String> message_map = new HashMap<>();

	public InputJson(){

	}

	public InputJson(String button_id, String message){
		this.button_id = button_id;
		this.message = message;
	}

	public InputJson(String button_id, String message, Map<String, String> message_map){
		this.button_id = button_id;
		this.message = message;
		this.message_map = message_map;
	}

	public void addMessage(String button_id, String message){
		message_map.put(button_id, message);
	}

	//把字串轉成InputJson
	public static InputJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, InputJson.class);
	}

	public String getButton_id() {
		return button_id;
	}

	public void setButton_id(String button_id) {
		this.button_id = button_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getMessage_map() {
		return message_map;
	}

	public void setMessage_map(Map<String, String> message_map) {
		this.message_map = message_map;
	}
}
