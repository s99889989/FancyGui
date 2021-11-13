package com.daxton.fancygui.api.mod.player.text;

import com.daxton.fancycore.api.character.conversion.StringConversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.entity.LivingEntity;

import java.util.ArrayList;
import java.util.List;

public class TextEntityJson {

	//類型
	public String type = "Text";
	//物件名稱
	private String objectName = "";
	//目標UUID字串
	private String uuidString;
	//顯示文字大小
	private float scale;
	//位置高度
	private double locationHeight;
	//位置選轉角度
	private double locationAngle;
	//位置選轉角度距離
	private double locationDistance;
	//每行距離
	private int rowHeight;
	//對齊(1=靠左,2=置中,3=靠右)
	private int align;
	//內容列表
	private List<String> textList;
	//旋轉角度
	private float rotateX;
	private float rotateY;
	private float rotateZ;
	//自動旋轉角度
	private int autoRotationX;
	private int autoRotationY;
	private int autoRotationZ;

	public TextEntityJson(LivingEntity self, LivingEntity target, String objectName, float scale, double locationHeight, double locationAngle, double locationDistance, int rowHeight, int align, List<String> textList, float rotateX, float rotateY, float rotateZ, int autoRotationX, int autoRotationY, int autoRotationZ) {
		this.objectName = objectName;
		this.scale = scale;
		this.locationHeight = locationHeight;
		this.locationAngle = locationAngle;
		this.locationDistance = locationDistance;
		this.rowHeight = rowHeight;
		this.align = align;
		this.textList = StringConversion.getStringList(self, target, textList);
		this.rotateX = rotateX;
		this.rotateY = rotateY;
		this.rotateZ = rotateZ;
		this.autoRotationX = autoRotationX;
		this.autoRotationY = autoRotationY;
		this.autoRotationZ = autoRotationZ;
	}

	//把字串轉成TextEntityJson
	public static TextEntityJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, TextEntityJson.class);
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getType() {
		return type;
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

	public int getRowHeight() {
		return rowHeight;
	}

	public void setRowHeight(int rowHeight) {
		this.rowHeight = rowHeight;
	}

	public int getAlign() {
		return align;
	}

	public void setAlign(int align) {
		this.align = align;
	}

	public List<String> getTextList() {
		return textList;
	}

	public void setTextList(List<String> textList) {
		this.textList = textList;
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
