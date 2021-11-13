package com.daxton.fancygui.api.mod.player.image;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class ImageEntityJson {

	//類型
	private String type = "Image";
	//物件名稱
	private String objectName = "";
	//目標UUID字串
	private String uuidString;
	//圖片位址
	private String image = "";
	//縮放
	private float scale;
	//圖片寬度
	private float width;
	//圖片高度
	private float height;
	//位置高度
	private double locationHeight;
	//位置選轉角度
	private double locationAngle;
	//位置選轉角度距離
	private double locationDistance;
	//方向(1~4)
	private int direction;
	//旋轉角度
	private float rotateX;
	private float rotateY;
	private float rotateZ;
	//自動旋轉角度
	private int autoRotationX;
	private int autoRotationY;
	private int autoRotationZ;

	public ImageEntityJson(LivingEntity self, LivingEntity target, String objectName, String image, float scale, float width, float height, double locationHeight, double locationAngle, double locationDistance, int direction, float rotateX, float rotateY, float rotateZ, int autoRotationX, int autoRotationY, int autoRotationZ) {
		this.objectName = objectName;
		this.image = image;
		this.scale = scale;
		this.width = width;
		this.height = height;
		this.locationHeight = locationHeight;
		this.locationAngle = locationAngle;
		this.locationDistance = locationDistance;
		this.direction = direction;
		this.rotateX = rotateX;
		this.rotateY = rotateY;
		this.rotateZ = rotateZ;
		this.autoRotationX = autoRotationX;
		this.autoRotationY = autoRotationY;
		this.autoRotationZ = autoRotationZ;
	}

	//把字串轉成Item
	public static ImageEntityJson readJSON(String string) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(string, ImageEntityJson.class);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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
