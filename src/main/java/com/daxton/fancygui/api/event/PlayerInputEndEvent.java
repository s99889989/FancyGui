package com.daxton.fancygui.api.event;

import com.daxton.fancygui.api.json.InputJson;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

//玩家輸入結束事件
public class PlayerInputEndEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	//玩家
	private Player player;
	//介面ID
	private String gui_id;
	//最後輸入的輸入框ID
	private String button_id;
	//最後輸入的內容
	private String message;
	//所有輸入內容
	private Map<String, String> message_map;

	public PlayerInputEndEvent(Player player, Map<String, String> message_map, String button_id, String message){
		this.player = player;
		this.message_map = message_map;
		this.button_id = button_id;
		this.message = message;
	}

	public PlayerInputEndEvent(Player player, InputJson inputJson){
		this.player = player;
		this.gui_id = inputJson.getGui_id();
		this.message_map = inputJson.getMessage_map();
		this.button_id = inputJson.getButton_id();
		this.message = inputJson.getMessage();
	}

	public String getGui_id() {
		return gui_id;
	}

	public void setGui_id(String gui_id) {
		this.gui_id = gui_id;
	}

	public String getButton_id() {
		return button_id;
	}

	public void setButton_id(String button_id) {
		this.button_id = button_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Map<String, String> getMessage_map() {
		return message_map;
	}

	public void setMessage_map(Map<String, String> message_map) {
		this.message_map = message_map;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
	@Override
	public @NotNull HandlerList getHandlers() {
		return handlers;
	}
}
