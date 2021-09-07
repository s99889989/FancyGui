package com.daxton.fancygui.task;

import com.daxton.fancycore.api.config.SearchConfigMap;
import com.daxton.fancygui.command.TabCommand;
import com.daxton.fancygui.config.FileConfig;
import com.daxton.fancygui.manager.GuiManager;
import org.bukkit.configuration.file.FileConfiguration;

public class MenuSet {

	public static void execute(){
		GuiManager.command_Menu_Map.clear();
		TabCommand.guiList.clear();
		SearchConfigMap.filePathList(FileConfig.config_Map, "menu/", false).forEach(path->{
			FileConfiguration config = FileConfig.config_Map.get(path);
			String commandKey = config.getString("Command");
			if(commandKey != null){
				GuiManager.command_Menu_Map.put(commandKey, path);
				TabCommand.guiList.add(commandKey);
			}
		});
	}


}
