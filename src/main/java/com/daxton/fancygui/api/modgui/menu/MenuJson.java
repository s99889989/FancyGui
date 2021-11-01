package com.daxton.fancygui.api.modgui.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class MenuJson {
	//圖片位址
	private String image = "";
	//Gui名稱
	private String menu_name = "";
	//寬度
	private int width;
	//高度
	private int height;
	//基礎位置
	private int position;
	//X偏移
	private int x;
	//Y偏移
	private int y;
	//物件表
	private Map<String, String> object_list = new HashMap<>();

	public MenuJson(FileConfiguration config, String path){
		this.menu_name = path.replace("mod_menu/", "").replace(".yml", "");
		this.image = config.getString("Gui.Image");
		this.width = config.getInt("Gui.Width");
		this.height = config.getInt("Gui.Height");
		this.position = config.getInt("Gui.Position");
		this.x = config.getInt("Gui.X");
		this.y = config.getInt("Gui.Y");
	}

	public MenuJson(String gui_id, String image, int width, int height, int position, int x, int y, Map<String, String> object_list){
		this.menu_name = gui_id;
		this.image = image;
		this.width = width;
		this.height = height;
		this.position = position;
		this.x = x;
		this.y = y;
		this.object_list = object_list;
	}

	public void addObject(String type, String data){
		object_list.put(type, data);
	}

	//把字串轉成GUI
	public static MenuJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, MenuJson.class);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Map<String, String> getObject_list() {
		return object_list;
	}

	public void setObject_list(Map<String, String> object_list) {
		this.object_list = object_list;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
}
