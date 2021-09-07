package com.daxton.fancygui.task;

import com.daxton.fancycore.api.config.SearchConfigMap;
import com.daxton.fancygui.config.FileConfig;
import com.daxton.fancygui.manager.GuiManager;
import org.bukkit.configuration.file.FileConfiguration;

public class ButtonSet {

	public static void execute(){
		GuiManager.button_Config_Map.clear();

		SearchConfigMap.filePathList(FileConfig.config_Map, "button/", false).forEach(path->{
			FileConfiguration config = FileConfig.config_Map.get(path);
			for(String buttonName : config.getConfigurationSection("Buttons").getKeys(false)){
				GuiManager.button_Config_Map.put(buttonName, path);
			}

		});
	}

}
