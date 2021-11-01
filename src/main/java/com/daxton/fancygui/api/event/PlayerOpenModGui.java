package com.daxton.fancygui.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerOpenModGui extends Event {

	private static final HandlerList handlers = new HandlerList();

	private Player player;

	private String gui_id;

	public PlayerOpenModGui(Player player, String gui_name){
		this.player = player;
		this.gui_id = gui_name;
	}

	public String getGui_id() {
		return gui_id;
	}

	public void setGui_id(String gui_id) {
		this.gui_id = gui_id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
	@Override
	public @NotNull HandlerList getHandlers() {
		return handlers;
	}

}
