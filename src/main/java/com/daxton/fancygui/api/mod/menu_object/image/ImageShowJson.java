package com.daxton.fancygui.api.mod.menu_object.image;

import com.daxton.fancycore.api.character.conversion.StringConversion;
import com.daxton.fancygui.FancyGui;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class ImageShowJson {

	//類型
	public String type = "Image";
	//物件名稱
	private String object_name = "";
	//圖片位址
	private String image = "";
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

	public ImageShowJson(){

	}

	public ImageShowJson(String object_name, String image, String width, String height, int position, int x, int y) {
		this.object_name = object_name;
		this.image = image;
		this.width = StringConversion.getInt(null, null, 0, width);
		this.height = StringConversion.getInt(null, null, 0, height);
		this.position = position;
		this.x = x;
		this.y = y;
	}

	public ImageShowJson(LivingEntity self, LivingEntity target, String object_name, String image, String width, String height, int position, int x, int y) {
		this.object_name = object_name;
		this.image = StringConversion.getString(self, target, image);
		this.width = StringConversion.getInt(self, target, 0, width);
		this.height = StringConversion.getInt(self, target, 0, height);
		this.position = position;
		this.x = x;
		this.y = y;
		//FancyGui.sendLogger(width+" : "+this.width);
	}

	//建立
	public ImageShowJson(Player player, FileConfiguration config, FileConfiguration object_config, String key, String button_configKey, String button_key){
		this.object_name = key+"."+button_configKey+"."+button_key;
		this.position = config.getInt("ObjectList."+key+".Position");
		this.x = config.getInt("ObjectList."+key+".X");
		this.y = config.getInt("ObjectList."+key+".Y");
		this.width = StringConversion.getInt(player, null, 0, object_config.getString(button_key+".Width"));
		this.height = StringConversion.getInt(player, null, 0, object_config.getString(button_key+".Height"));
		this.image = StringConversion.getString(player, null, object_config.getString(button_key+".Image"));
	}

	//把字串轉成Image
	public static ImageShowJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, ImageShowJson.class);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getObject_name() {
		return object_name;
	}

	public void setObject_name(String object_name) {
		this.object_name = object_name;
	}
}
