package com.daxton.fancygui.api.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class ButtonJson {

	//GUI的名稱
	private String gui_id = "";
	//按鈕ID
	private String button_id = "";
	//執行動作
	private List<String> action_list = new ArrayList<>();

	public ButtonJson(){

	}

	public ButtonJson(String button_id, List<String> action_list){
		this.button_id = button_id;
		this.action_list = action_list;
	}

	public ButtonJson(List<String> action_list){
		this.action_list = action_list;
	}

	//把字串轉成ActionJson
	public static ButtonJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, ButtonJson.class);
	}

	public String getButton_id() {
		return button_id;
	}

	public void setButton_id(String button_id) {
		this.button_id = button_id;
	}

	public List<String> getAction_list() {
		return action_list;
	}

	public void setAction_list(List<String> action_list) {
		this.action_list = action_list;
	}

	public String getGui_id() {
		return gui_id;
	}
}
