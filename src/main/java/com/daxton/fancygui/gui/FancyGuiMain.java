package com.daxton.fancygui.gui;

import com.daxton.fancycore.api.gui.GUI;
import com.daxton.fancygui.FancyGui;
import com.daxton.fancygui.config.FileConfig;
import com.daxton.fancygui.manager.GuiManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class FancyGuiMain {

	final public static List<String> number = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

	public static void openCustom(Player player, String key){

		String path = GuiManager.command_Menu_Map.get(key);
		if(path == null){
			return;
		}

		FileConfiguration config = FileConfig.config_Map.get(path);
		//Permission
		String permission = config.getString("Permission");
		if(permission != null){
			if(!player.hasPermission("fancygui."+permission)){
				return;
			}
		}

		//Title
		String title = config.getString("Title");
		if(title == null){
			title = "";
		}

		//Gui大小
		List<String> buttonList = config.getStringList("Sort");
		int size = 54;
		if(!buttonList.isEmpty()){
			size = getSize(buttonList.size());
		}
		//移動
		boolean move = config.getBoolean("");

		GUI gui = GUI.GUIBuilder.getInstance().
			setPlayer(player).
			setSize(size).
			setTitle(title).
			build();
		//設置打開動作
		new OpenGui(player, gui, config);
		//設置關閉動作
		new CloseGui(player, gui, config);

		gui.setMove(move);

		if(!buttonList.isEmpty()){

			for(int i = 0 ; i < buttonList.size() && i < 6 ; i++){
				String buttonL = buttonList.get(i);
				String[] buttonArray = buttonL.split("\\.");
				for(int k = 0 ; k < buttonArray.length && k < 9 ; k++){

					if(!number.contains(buttonArray[k])){
						new ButtonGui(player, gui, buttonArray[k], i+1, k+1);
					}
				}
			}
		}

		gui.open(gui);
	}

	public static int getSize(int height){
		if(height == 1){
			return 9;
		}
		if(height == 2){
			return 18;
		}
		if(height == 3){
			return 27;
		}
		if(height == 4){
			return 36;
		}
		if(height == 5){
			return 45;
		}

		return 54;
	}


}
