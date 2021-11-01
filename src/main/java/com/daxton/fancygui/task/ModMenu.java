package com.daxton.fancygui.task;

import com.daxton.fancygui.FancyGui;
import com.daxton.fancygui.api.FancyConnect;
import com.daxton.fancygui.api.build.*;
import com.daxton.fancygui.api.json.JsonCtrl;
import com.daxton.fancygui.api.modgui.menu.MenuJson;
import com.daxton.fancygui.api.modgui.menu_object.button.ClickButtonJson;
import com.daxton.fancygui.api.modgui.menu_object.image.ImageShowJson;
import com.daxton.fancygui.api.modgui.menu_object.text.TextLabelJson;
import com.daxton.fancygui.api.modgui.menu_object.textfield.TextFieldJson;
import com.daxton.fancygui.config.FileConfig;
import com.daxton.fancygui.manager.GuiManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ModMenu {

	public static void open(Player player, String gui_command_name){

		String
			path = GuiManager.command_Mod_Menu_Map.get(gui_command_name);
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

		openMenuPath(player, path);

	}

	public static void upDataMenu(Player player, String path){
		UUID uuid = player.getUniqueId();
		GuiManager.player_mod_data.get(uuid).gui_path = path;
		FileConfiguration config = FileConfig.config_Map.get(path);
		if(config == null){
			return;
		}
		MenuJson menuJson = new MenuJson(config, path);

		Set<String> object_key = config.getConfigurationSection("ObjectList").getKeys(false);

		for(String key : object_key){
			String objectString = config.getString("ObjectList."+key+".Object");
			String[] keys = new String[0];
			if (objectString != null) {
				keys = objectString.split("\\.");
			}
			if(keys.length == 2){
				FileConfiguration object_config = FileConfig.config_Map.get("mod_object/"+keys[0]+".yml");
				if(object_config != null){
					String type = object_config.getString(keys[1]+".Type");
					if(type != null){
						if(type.equalsIgnoreCase("Button")){
							ClickButtonJson clickButtonJson = new ClickButtonJson(player, config, object_config, key, keys[0], keys[1]);
							List<String> testList = new ArrayList<>();
							testList.add("test");
							clickButtonJson.setCustom_action_list(testList);
							menuJson.addObject(type+key, JsonCtrl.writeJSON(clickButtonJson));
							continue;
						}
						if(type.equalsIgnoreCase("TextField")){
							TextFieldJson textFieldJson = new TextFieldJson(player, config, object_config, key, keys[0], keys[1]);
							menuJson.addObject(type+key, JsonCtrl.writeJSON(textFieldJson));
							continue;
						}
						if(type.equalsIgnoreCase("Image")){
							ImageShowJson imageShowJson = new ImageShowJson(player, config, object_config, key, keys[0], keys[1]);
							menuJson.addObject(type+key, JsonCtrl.writeJSON(imageShowJson));
							continue;
						}
						if(type.equalsIgnoreCase("Text")){
							TextLabelJson textLabelJson = new TextLabelJson(player, config, object_config, key, keys[0], keys[1]);
							menuJson.addObject(type+key, JsonCtrl.writeJSON(textLabelJson));
						}
					}

				}
			}


		}

		FancyConnect.sendMessage(player, "updatamenu:"+JsonCtrl.writeJSON(menuJson));
	}

	public static void openMenuPath(Player player, String path){
		UUID uuid = player.getUniqueId();
		GuiManager.player_mod_data.get(uuid).gui_path = path;
		FileConfiguration config = FileConfig.config_Map.get(path);
		if(config == null){
			return;
		}
		MenuJson menuJson = new MenuJson(config, path);

		Set<String> object_key = config.getConfigurationSection("ObjectList").getKeys(false);

		for(String key : object_key){
			String objectString = config.getString("ObjectList."+key+".Object");
			String[] keys = new String[0];
			if (objectString != null) {
				keys = objectString.split("\\.");
			}
			if(keys.length == 2){
				FileConfiguration object_config = FileConfig.config_Map.get("mod_object/"+keys[0]+".yml");
				if(object_config != null){
					String type = object_config.getString(keys[1]+".Type");
					if(type != null){
						if(type.equalsIgnoreCase("Button")){
							ClickButtonJson clickButtonJson = new ClickButtonJson(player, config, object_config, key, keys[0], keys[1]);
							List<String> testList = new ArrayList<>();
							testList.add("test");
							clickButtonJson.setCustom_action_list(testList);
							menuJson.addObject(type+key, JsonCtrl.writeJSON(clickButtonJson));
							continue;
						}
						if(type.equalsIgnoreCase("TextField")){
							TextFieldJson textFieldJson = new TextFieldJson(player, config, object_config, key, keys[0], keys[1]);
							menuJson.addObject(type+key, JsonCtrl.writeJSON(textFieldJson));
							continue;
						}
						if(type.equalsIgnoreCase("Image")){
							ImageShowJson imageShowJson = new ImageShowJson(player, config, object_config, key, keys[0], keys[1]);
							menuJson.addObject(type+key, JsonCtrl.writeJSON(imageShowJson));
							continue;
						}
						if(type.equalsIgnoreCase("Text")){
							TextLabelJson textLabelJson = new TextLabelJson(player, config, object_config, key, keys[0], keys[1]);
							menuJson.addObject(type+key, JsonCtrl.writeJSON(textLabelJson));
						}
					}

				}
			}


		}

		FancyConnect.sendMessage(player, "menu:"+JsonCtrl.writeJSON(menuJson));
	}

	public static void openMenuTest(Player player){

		ModGUI modGUI = ModGUI.ModGUIBuilder.getInstance()
			.setPosition(5)
			.setImage("https://i.imgur.com/Rf9Tizv.png")
			.build();

		ModButton modButton = ModButton.ModButtonBuilder.getInstance()
			.setImage_on("https://i.imgur.com/9q8FpAt.png")
			.setImage_off("https://i.imgur.com/VmfhCq2.png")
			.setPosition(1)
			.build();

		ModImage modImage = ModImage.ModImageBuilder.getInstance()
			.setImage("https://i.imgur.com/5B9nsam.png")
			.setWidth(40)
			.setWidth(40)
			.build();

		ModText modText = ModText.ModTextBuilder.getInstance().addTextList("測試").build();

		ModTextField modTextField = ModTextField.ModTextFieldBuilder.getInstance()
			.setImage("https://i.imgur.com/9q8FpAt.png")
			.setHeight(40)
			.setWidth(60)
			.build();

		modGUI.addComponents(modButton)
			.addComponents(modImage)
			.addComponents(modText)
			.addComponents(modTextField)
			.open(player);

	}

}
