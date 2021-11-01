package com.daxton.fancygui.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerCloseModGui extends Event {

	private static final HandlerList handlers = new HandlerList();

	private Player player;

	private String gui_name;

	public PlayerCloseModGui(Player player, String gui_name){
		this.player = player;
		this.gui_name = gui_name;
	}

	public String getGui_name() {
		return gui_name;
	}

	public void setGui_name(String gui_name) {
		this.gui_name = gui_name;
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
