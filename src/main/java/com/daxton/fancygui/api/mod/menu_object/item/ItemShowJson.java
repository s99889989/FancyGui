package com.daxton.fancygui.api.mod.menu_object.item;

import com.daxton.fancycore.nms.NMSItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemShowJson {

	//類型
	public String type = "Item";
	//物件名稱
	private String object_name = "";
	//物品NBT字串
	private String item = "";
	//物品比例
	private float scale;
	//基礎位置
	private int position;
	//X偏移
	private int x;
	//Y偏移
	private int y;

	public ItemShowJson(String object_name, ItemStack itemStack, float scale, int position, int x, int y) {
		this.object_name = object_name;
		this.item = NMSItem.itemNBTtoString(itemStack);
		this.scale = scale;
		this.position = position;
		this.x = x;
		this.y = y;
	}

	public ItemShowJson(Player player, String object_name, ItemStack itemStack, float scale, int position, int x, int y) {
		this.object_name = object_name;
		this.item = NMSItem.itemNBTtoStringClient(itemStack, player);
		this.scale = scale;
		this.position = position;
		this.x = x;
		this.y = y;
	}

	//把字串轉成Item
	public static ItemShowJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, ItemShowJson.class);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getObject_name() {
		return object_name;
	}

	public void setObject_name(String object_name) {
		this.object_name = object_name;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
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

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}
}
