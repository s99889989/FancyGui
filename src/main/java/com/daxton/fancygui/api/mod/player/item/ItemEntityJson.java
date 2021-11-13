package com.daxton.fancygui.api.mod.player.item;

import com.daxton.fancycore.nms.NMSItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemEntityJson {

	//類型
	public String type = "Item";
	//物件名稱
	private String objectName;
	//目標UUID字串
	private String uuidString;
	//物品NBT字串
	private String item = "";
	//物品比例
	private float scale;
	//位置高度
	private double locationHeight;
	//位置選轉角度
	private double locationAngle;
	//位置選轉角度距離
	private double locationDistance;
	//旋轉角度
	private float rotateX;
	private float rotateY;
	private float rotateZ;
	//自動旋轉角度
	private int autoRotationX;
	private int autoRotationY;
	private int autoRotationZ;

	public ItemEntityJson(Player player, String objectName, ItemStack itemStack, float scale, double locationHeight, double locationAngle, double locationDistance, float rotateX, float rotateY, float rotateZ, int autoRotationX, int autoRotationY, int autoRotationZ) {
		this.objectName = objectName;
		this.item = NMSItem.itemNBTtoStringClient(itemStack, player);
		this.scale = scale;
		this.locationHeight = locationHeight;
		this.locationAngle = locationAngle;
		this.locationDistance = locationDistance;
		this.rotateX = rotateX;
		this.rotateY = rotateY;
		this.rotateZ = rotateZ;
		this.autoRotationX = autoRotationX;
		this.autoRotationY = autoRotationY;
		this.autoRotationZ = autoRotationZ;
	}

	//把字串轉成Item
	public static ItemEntityJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, ItemEntityJson.class);
	}


	public void setType(String type) {
		this.type = type;
	}

	public String getUuidString() {
		return uuidString;
	}

	public void setUuidString(String uuidString) {
		this.uuidString = uuidString;
	}

	public String getType() {
		return type;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public double getLocationHeight() {
		return locationHeight;
	}

	public void setLocationHeight(double locationHeight) {
		this.locationHeight = locationHeight;
	}

	public double getLocationAngle() {
		return locationAngle;
	}

	public void setLocationAngle(double locationAngle) {
		this.locationAngle = locationAngle;
	}

	public double getLocationDistance() {
		return locationDistance;
	}

	public void setLocationDistance(double locationDistance) {
		this.locationDistance = locationDistance;
	}

	public float getRotateX() {
		return rotateX;
	}

	public void setRotateX(float rotateX) {
		this.rotateX = rotateX;
	}

	public float getRotateY() {
		return rotateY;
	}

	public void setRotateY(float rotateY) {
		this.rotateY = rotateY;
	}

	public float getRotateZ() {
		return rotateZ;
	}

	public void setRotateZ(float rotateZ) {
		this.rotateZ = rotateZ;
	}

	public int getAutoRotationX() {
		return autoRotationX;
	}

	public void setAutoRotationX(int autoRotationX) {
		this.autoRotationX = autoRotationX;
	}

	public int getAutoRotationY() {
		return autoRotationY;
	}

	public void setAutoRotationY(int autoRotationY) {
		this.autoRotationY = autoRotationY;
	}

	public int getAutoRotationZ() {
		return autoRotationZ;
	}

	public void setAutoRotationZ(int autoRotationZ) {
		this.autoRotationZ = autoRotationZ;
	}
}
