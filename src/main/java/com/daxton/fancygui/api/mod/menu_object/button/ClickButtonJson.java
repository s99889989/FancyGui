package com.daxton.fancygui.api.mod.menu_object.button;


import com.daxton.fancycore.api.character.conversion.StringConversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ClickButtonJson {

	//類型
	public String type = "Button";
	//物件名稱
	private String object_name = "";
	//顯示名稱
	public String display_name = "";
	//顯示文字大小
	private int font_size;
	//圖片位址
	private String image_on = "";
	private String image_off = "";
	//啟動圖寬度
	private int width_on;
	//啟動圖高度
	private int height_on;
	//關閉寬度
	private int width_off;
	//關閉高度
	private int height_off;
	//基礎位置
	private int position;
	//X偏移
	private int x;
	//Y偏移
	private int y;
	//按下是否要關閉
	private boolean close;
	//開另外一個介面
	private String to_menu;
	//執行動作
	private List<String> leftList = new ArrayList<>();
	private List<String> rightList = new ArrayList<>();
	private List<String> leftShiftList = new ArrayList<>();
	private List<String> rightShiftList = new ArrayList<>();
	//自訂動作
	private List<String> custom_action_list = new ArrayList<>();

	public ClickButtonJson(){

	}

	public ClickButtonJson(String object_name, String display_name, int font_size, String image_on, String image_off, int width_on, int height_on, int width_off, int height_off, int position, int x, int y, boolean close, String to_menu, List<String> action_list){
		this.object_name = object_name;
		this.display_name = display_name;
		this.font_size = font_size;
		this.image_on = image_on;
		this.image_off = image_off;
		this.width_on = width_on;
		this.height_on = height_on;
		this.width_off = width_off;
		this.height_off = height_off;
		this.position = position;
		this.x = x;
		this.y = y;
		this.close = close;
		this.to_menu = to_menu;
		this.custom_action_list = action_list;
	}

	public ClickButtonJson(LivingEntity self, LivingEntity target, String object_name, String display_name, int font_size, String image_on, String image_off, int width_on, int height_on, int width_off, int height_off, int position, int x, int y, boolean close, String to_menu, List<String> action_list){
		this.object_name = object_name;
		this.display_name = StringConversion.getString(self, target, display_name);
		this.font_size = font_size;
		this.image_on = image_on;
		this.image_off = image_off;
		this.width_on = width_on;
		this.height_on = height_on;
		this.width_off = width_off;
		this.height_off = height_off;
		this.position = position;
		this.x = x;
		this.y = y;
		this.close = close;
		this.to_menu = to_menu;
		this.custom_action_list = action_list;
	}

	public ClickButtonJson(Player player, FileConfiguration config, FileConfiguration object_config, String key, String button_configKey, String button_key){
		this.object_name = key+"."+button_configKey+"."+button_key;
		this.position = config.getInt("ObjectList."+key+".Position");
		this.x = config.getInt("ObjectList."+key+".X");
		this.y = config.getInt("ObjectList."+key+".Y");
		this.display_name = object_config.getString(button_key+".DisplayName");
		this.image_on = object_config.getString(button_key+".ImageOn");
		this.image_off = object_config.getString(button_key+".ImageOff");
		this.width_on = object_config.getInt(button_key+".WidthOn");
		this.height_on = object_config.getInt(button_key+".HeightOn");
		this.width_off = object_config.getInt(button_key+".WidthOff");
		this.height_off = object_config.getInt(button_key+".HeightOff");
		this.close = object_config.getBoolean(button_key+".Close");
		this.to_menu = object_config.getString(button_key+".ToMenu");
		this.leftList = object_config.getStringList(button_key+".Action.Left");
		this.rightList = object_config.getStringList(button_key+".Action.Right");
		this.leftShiftList = object_config.getStringList(button_key+".Action.Left_Shift");
		this.rightShiftList = object_config.getStringList(button_key+".Action.Right_Shift");
	}

	//把字串轉成ClickButton
	public static ClickButtonJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, ClickButtonJson.class);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public int getFont_size() {
		return font_size;
	}

	public void setFont_size(int font_size) {
		this.font_size = font_size;
	}

	public String getImage_on() {
		return image_on;
	}

	public void setImage_on(String image_on) {
		this.image_on = image_on;
	}

	public String getImage_off() {
		return image_off;
	}

	public void setImage_off(String image_off) {
		this.image_off = image_off;
	}

	public boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}

	public String getTo_menu() {
		return to_menu;
	}

	public void setTo_menu(String to_menu) {
		this.to_menu = to_menu;
	}

	public List<String> getLeftList() {
		return leftList;
	}

	public void setLeftList(List<String> leftList) {
		this.leftList = leftList;
	}

	public List<String> getRightList() {
		return rightList;
	}

	public void setRightList(List<String> rightList) {
		this.rightList = rightList;
	}

	public List<String> getLeftShiftList() {
		return leftShiftList;
	}

	public void setLeftShiftList(List<String> leftShiftList) {
		this.leftShiftList = leftShiftList;
	}

	public List<String> getRightShiftList() {
		return rightShiftList;
	}

	public void setRightShiftList(List<String> rightShiftList) {
		this.rightShiftList = rightShiftList;
	}

	public int getWidth_on() {
		return width_on;
	}

	public void setWidth_on(int width_on) {
		this.width_on = width_on;
	}

	public int getHeight_on() {
		return height_on;
	}

	public void setHeight_on(int height_on) {
		this.height_on = height_on;
	}

	public int getWidth_off() {
		return width_off;
	}

	public void setWidth_off(int width_off) {
		this.width_off = width_off;
	}

	public int getHeight_off() {
		return height_off;
	}

	public void setHeight_off(int height_off) {
		this.height_off = height_off;
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

	public List<String> getCustom_action_list() {
		return custom_action_list;
	}

	public void setCustom_action_list(List<String> custom_action_list) {
		this.custom_action_list = custom_action_list;
	}
}
