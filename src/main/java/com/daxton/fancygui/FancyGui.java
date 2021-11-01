package com.daxton.fancygui;

import com.daxton.fancygui.command.MainCommand;
import com.daxton.fancygui.command.TabCommand;
import com.daxton.fancygui.listener.PlayerListener;
import com.daxton.fancygui.task.Start;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class FancyGui extends JavaPlugin {

	public static FancyGui fancyGui;


	@Override
	public void onEnable() {
		fancyGui = this;
		//前置插件
		if(!DependPlugins.depend()){
			fancyGui.setEnabled(false);
			return;
		}
		//指令
		Objects.requireNonNull(Bukkit.getPluginCommand("fancygui")).setExecutor(new MainCommand());
		Objects.requireNonNull(Bukkit.getPluginCommand("fancygui")).setTabCompleter(new TabCommand());
		//玩家監聽
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), fancyGui);
		//執行任務
		Start.execute();


	}


	public static void sendLogger(String message){
		fancyGui.getLogger().info(message);
	}

	@Override
	public void onDisable() {
		FancyGui.fancyGui.getLogger().info("§4FancyGui uninstall.");
	}
}
