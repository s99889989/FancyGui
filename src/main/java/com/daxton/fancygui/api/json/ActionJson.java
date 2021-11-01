package com.daxton.fancygui.api.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class ActionJson {

	//執行動作
	List<String> action_list = new ArrayList<>();

	public ActionJson(){

	}

	public ActionJson(List<String> action_list){
		this.action_list = action_list;
	}

	//把字串轉成ActionJson
	public static ActionJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, ActionJson.class);
	}

	public List<String> getAction_list() {
		return action_list;
	}

	public void setAction_list(List<String> action_list) {
		this.action_list = action_list;
	}
}
