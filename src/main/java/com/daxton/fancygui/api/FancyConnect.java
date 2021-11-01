package com.daxton.fancygui.api;

import com.daxton.fancygui.FancyGui;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

public class FancyConnect {

	public static final int IDX = 159;
	public static final String channel = "fancycore:fancygui";

	public FancyConnect(){

	}

	public static void sendMessage(Player player, String message){
		try {
			Class<? extends CommandSender> senderClass = player.getClass();
			Method addChannel = senderClass.getDeclaredMethod("addChannel", String.class);
			addChannel.setAccessible(true);
			addChannel.invoke(player, channel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Bukkit.getScheduler().runTaskLater(FancyGui.fancyGui,
			() -> send(player, message), 1);
	}

	private static void send(Player player, String msg) {
		byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
		ByteBuf buf = Unpooled.buffer(bytes.length + 1);
		buf.writeByte(IDX);
		buf.writeBytes(bytes);
		player.sendPluginMessage(FancyGui.fancyGui, channel, buf.array());
	}

}
