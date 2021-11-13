package com.daxton.fancygui.api.mod.menu_object.text;

import com.daxton.fancycore.api.character.conversion.StringConversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TextLabelJson {

	//類型
	public String type = "Text";
	//物件名稱
	private String object_name = "";
	//顯示文字大小
	private float scale;
	//基礎位置
	private int position;
	//X偏移
	private int x;
	//Y偏移
	private int y;
	//垂直顯示
	private boolean vertical;
	//行高
	private int row_height;
	//行距
	private int line_spacing;
	//對齊(1=靠左,2=置中,3=靠右)
	private int align;
	//文字反向排序
	private boolean reverse_sort;
	//內容列表
	private List<String> text_list = new ArrayList<>();

	public TextLabelJson(){

	}

	public TextLabelJson(String object_name, float scale, int position, int x, int y, boolean vertical, int row_height, int line_spacing, int align, boolean reverse_sort, List<String> text_list) {
		this.object_name = object_name;
		this.scale = scale;
		this.position = position;
		this.x = x;
		this.y = y;
		this.vertical = vertical;
		this.row_height = row_height;
		this.line_spacing = line_spacing;
		this.align = align;
		this.reverse_sort = reverse_sort;
		this.text_list = text_list;
	}

	public TextLabelJson(LivingEntity self, LivingEntity target, String object_name, float scale, int position, int x, int y, boolean vertical, int row_height, int line_spacing, int align, boolean reverse_sort, List<String> text_list) {
		this.object_name = object_name;
		this.scale = scale;
		this.position = position;
		this.x = x;
		this.y = y;
		this.vertical = vertical;
		this.row_height = row_height;
		this.line_spacing = line_spacing;
		this.align = align;
		this.reverse_sort = reverse_sort;
		this.text_list = StringConversion.getStringList(self, target, text_list);
	}

	public TextLabelJson(Player player, FileConfiguration config, FileConfiguration object_config, String key, String button_configKey, String button_key){
		this.object_name = key+"."+button_configKey+"."+button_key;
		this.position = config.getInt("ObjectList."+key+".Position");
		this.x = config.getInt("ObjectList."+key+".X");
		this.y = config.getInt("ObjectList."+key+".Y");
		this.vertical = object_config.getBoolean(button_key+".Vertical");
		this.row_height = object_config.getInt(button_key+".RowHeight");
		this.line_spacing = object_config.getInt(button_key+".LineSpacing");
		this.align = object_config.getInt(button_key+".Align");
		this.reverse_sort = object_config.getBoolean(button_key+".ReverseSort");
		for(String messageString : object_config.getStringList(button_key+".Text")){
			this.text_list.add(StringConversion.getString(player, null, messageString));
		}
	}

	//把字串轉成Text
	public static TextLabelJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, TextLabelJson.class);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getText_list() {
		return text_list;
	}

	public void setText_list(List<String> text_list) {
		this.text_list = text_list;
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

	public boolean isVertical() {
		return vertical;
	}

	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}

	public int getRow_height() {
		return row_height;
	}

	public void setRow_height(int row_height) {
		this.row_height = row_height;
	}

	public int getLine_spacing() {
		return line_spacing;
	}

	public void setLine_spacing(int line_spacing) {
		this.line_spacing = line_spacing;
	}

	public int getAlign() {
		return align;
	}

	public void setAlign(int align) {
		if(align > 3){
			align = 3;
		}
		if(align < 1){
			align = 1;
		}
		this.align = align;
	}

	public boolean isReverse_sort() {
		return reverse_sort;
	}

	public void setReverse_sort(boolean reverse_sort) {
		this.reverse_sort = reverse_sort;
	}

	public String getObject_name() {
		return object_name;
	}

	public void setObject_name(String object_name) {
		this.object_name = object_name;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

}
