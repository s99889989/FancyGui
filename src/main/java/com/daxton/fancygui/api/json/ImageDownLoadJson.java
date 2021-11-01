package com.daxton.fancygui.api.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class ImageDownLoadJson {

	List<String> image_path_list = new ArrayList<>();

	public ImageDownLoadJson(){

	}

	public ImageDownLoadJson(List<String> image_path_list){
		this.image_path_list = image_path_list;
	}

	//把字串轉成ActionJson
	public static ImageDownLoadJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, ImageDownLoadJson.class);
	}



	public void addImagePath(String path){
		if(path.startsWith("http")){
			image_path_list.add(path);
		}
	}

	public List<String> getImage_path_list() {
		return image_path_list;
	}

	public void setImage_path_list(List<String> image_path_list) {
		this.image_path_list = image_path_list;
	}
}
