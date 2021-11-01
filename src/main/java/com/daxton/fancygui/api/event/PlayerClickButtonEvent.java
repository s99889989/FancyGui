package com.daxton.fancygui.api.event;

import com.daxton.fancygui.api.json.ButtonJson;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;
//玩家點擊按鈕事件
public class PlayerClickButtonEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	//玩家
	private Player player;
	//介面ID
	private String gui_id;
	//按鈕ID
	private String button_id;
	//按鈕內容列表
	private List<String> action_list;

	public PlayerClickButtonEvent(Player player, String button_id, List<String> action_list){
		this.player = player;
		this.button_id = button_id;
		this.action_list = action_list;
	}

	public PlayerClickButtonEvent(Player player, ButtonJson buttonJson){
		this.player = player;
		this.gui_id = buttonJson.getGui_id();
		this.button_id = buttonJson.getButton_id();
		this.action_list = buttonJson.getAction_list();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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

	public List<String> getAction_list() {
		return action_list;
	}

	public void setAction_list(List<String> action_list) {
		this.action_list = action_list;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
	@Override
	public @NotNull HandlerList getHandlers() {
		return handlers;
	}
}
