package com.daxton.fancygui.task;

import com.daxton.fancycore.api.fancyclient.ClientConnect;

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

		ClientConnect.sendMessage(player, "updatamenu:"+JsonCtrl.writeJSON(menuJson));
	}

	public static void openMenuPath(Player player, String path){
		UUID uuid = player.getUniqueId();
		GuiManager.player_mod_data.get(uuid).gui_path = path;
		FileConfiguration config = FileConfig.config_Map.get(path);
		if(config == null){
			return;
		}
		MenuJson menuJson = new MenuJson(config, path);
		GuiManager.player_mod_data.get(uuid).menu_name = menuJson.getMenu_name();
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

		ClientConnect.sendMessage(player, "menu:"+JsonCtrl.writeJSON(menuJson));
	}

	public static void hubShow(Player player){
		int fontWidth = 3;
		int fontHeight = 8;
		ModText modText1 = ModText.ModTextBuilder.getInstance().addTextList("§31增加內容").addTextList("§41增加內容雷雷").setObjectName("t1")
			.setFontSize(1F).setAlign(1).setRow_height(8).setPosition(1).setFont_width(fontWidth).setFont_height(fontHeight).build();
		ModText modText2 = ModText.ModTextBuilder.getInstance().addTextList("§32增加內容").addTextList("§42增加內容雷雷").setObjectName("t2")
			.setFontSize(1F).setAlign(1).setRow_height(8).setPosition(2).setFont_width(fontWidth).setFont_height(fontHeight).build();
		ModText modText3 = ModText.ModTextBuilder.getInstance().addTextList("§33增加內容").addTextList("§43增加內容雷雷").setObjectName("t3")
			.setFontSize(1F).setAlign(1).setRow_height(8).setPosition(3).setFont_width(fontWidth).setFont_height(fontHeight).build();
		ModText modText4 = ModText.ModTextBuilder.getInstance().addTextList("§34增加內容").addTextList("§44增加內容雷雷").setObjectName("t4")
			.setFontSize(1F).setAlign(1).setRow_height(8).setPosition(4).setFont_width(fontWidth).setFont_height(fontHeight).build();
		ModText modText5 = ModText.ModTextBuilder.getInstance().addTextList("§35增加內容").addTextList("§45增加內容雷雷").setObjectName("t5")
			.setFontSize(1F).setAlign(1).setRow_height(8).setPosition(5).setFont_width(fontWidth).setFont_height(fontHeight).build();
		ModText modText6 = ModText.ModTextBuilder.getInstance().addTextList("§36增加內容").addTextList("§46增加內容雷雷").setObjectName("t6")
			.setFontSize(1F).setAlign(1).setRow_height(8).setPosition(6).setFont_width(fontWidth).setFont_height(fontHeight).build();
		ModText modText7 = ModText.ModTextBuilder.getInstance().addTextList("§37增加內容").addTextList("§47增加內容雷雷").setObjectName("t7")
			.setFontSize(1F).setAlign(1).setRow_height(8).setPosition(7).setFont_width(fontWidth).setFont_height(fontHeight).build();
		ModText modText8 = ModText.ModTextBuilder.getInstance().addTextList("§38增加內容").addTextList("§48增加內容雷雷").setObjectName("t8")
			.setFontSize(1F).setAlign(1).setRow_height(8).setPosition(8).setFont_width(fontWidth).setFont_height(fontHeight).build();
		ModText modText9 = ModText.ModTextBuilder.getInstance().addTextList("§39增加內容").addTextList("§49增加內容雷雷").setObjectName("t9")
			.setFontSize(1F).setAlign(1).setRow_height(8).setPosition(9).setFont_width(fontWidth).setFont_height(fontHeight).build();

		ModImage modImage = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i2")
			.setPosition(6).setWidth(60).setHeight(60).build();

		ModHub modHub = ModHub.ModHubBuilder.getInstance().add(modImage)
			.add(modText1).add(modText2).add(modText3)
			.add(modText4).add(modText5).add(modText6)
			.add(modText7).add(modText8).add(modText9)
			.build();

		modHub.show(player);
	}

	public static void hubHide(Player player){

		ModText modText1 = ModText.ModTextBuilder.getInstance().addTextList("§31增加內容").addTextList("§41增加內容雷雷").setObjectName("t1")
			.setFontSize(2F).setAlign(1).setRow_height(8).setPosition(1).build();
		ModText modText2 = ModText.ModTextBuilder.getInstance().addTextList("§32增加內容").addTextList("§42增加內容雷雷").setObjectName("t2")
			.setFontSize(2F).setAlign(1).setRow_height(8).setPosition(2).build();
		ModText modText3 = ModText.ModTextBuilder.getInstance().addTextList("§33增加內容").addTextList("§43增加內容雷雷").setObjectName("t3")
			.setFontSize(2F).setAlign(1).setRow_height(8).setPosition(3).build();
		ModText modText4 = ModText.ModTextBuilder.getInstance().addTextList("§34增加內容").addTextList("§44增加內容雷雷").setObjectName("t4")
			.setFontSize(2F).setAlign(1).setRow_height(8).setPosition(4).build();
		ModText modText5 = ModText.ModTextBuilder.getInstance().addTextList("§35增加內容").addTextList("§45增加內容雷雷").setObjectName("t5")
			.setFontSize(2F).setAlign(1).setRow_height(8).setPosition(5).build();
		ModText modText6 = ModText.ModTextBuilder.getInstance().addTextList("§36增加內容").addTextList("§46增加內容雷雷").setObjectName("t6")
			.setFontSize(2F).setAlign(1).setRow_height(8).setPosition(6).build();
		ModText modText7 = ModText.ModTextBuilder.getInstance().addTextList("§37增加內容").addTextList("§47增加內容雷雷").setObjectName("t7")
			.setFontSize(2F).setAlign(1).setRow_height(8).setPosition(7).build();
		ModText modText8 = ModText.ModTextBuilder.getInstance().addTextList("§38增加內容").addTextList("§48增加內容雷雷").setObjectName("t8")
			.setFontSize(2F).setAlign(1).setRow_height(8).setPosition(8).build();
		ModText modText9 = ModText.ModTextBuilder.getInstance().addTextList("§39增加內容").addTextList("§49增加內容雷雷").setObjectName("t9")
			.setFontSize(2F).setAlign(1).setRow_height(8).setPosition(9).build();

		ModImage modImage = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i2")
			.setPosition(6).setWidth(60).setHeight(60).build();

		ModHub modHub = ModHub.ModHubBuilder.getInstance().add(modImage)
			.add(modText1).add(modText2).add(modText3)
			.add(modText4).add(modText5).add(modText6)
			.add(modText7).add(modText8).add(modText9)
			.build();

		modHub.hide(player);
	}

	public static void openMenuTest(Player player){

		ModGUI modGUI = ModGUI.ModGUIBuilder.getInstance()
			.setGui_id("Test")
			.setPosition(5)
			.setImage("https://i.imgur.com/Rf9Tizv.png")
			.build();

		ModImage modImage = ModImage.ModImageBuilder.getInstance()
			.setImage("https://i.imgur.com/5B9nsam.png")
			.setPosition(5)
			.setWidth(40)
			.setHeight(40)
			.build();

		ModText modText = ModText.ModTextBuilder.getInstance()
			.addTextList("§3增加內容:")
			.setFontSize(2F)
			.setAlign(1)
			.setRow_height(8)
			.setPosition(1)
			.setX(85)
			.build();

		ModTextField modTextField = ModTextField.ModTextFieldBuilder.getInstance()
			.setObject_name("text1")
			.setImage("https://i.imgur.com/wh32c81.png")
			.setPosition(1)
			.setHeight(20)
			.setWidth(80)
			.build();
		modTextField.onEndInput(modTextField1 -> {
			modText.setText(1, "輸入框: "+modTextField1.getText());
			modGUI.updata(player);
		});

		ModButton modButton = ModButton.ModButtonBuilder.getInstance()
			.setImage_on("https://i.imgur.com/9q8FpAt.png")
			.setImage_off("https://i.imgur.com/VmfhCq2.png")
			.setDisplay_name("增加內容")
			.setPosition(1)
			.setY(25)
			.build();
		modButton.onButtonClick(clickButton -> {
			//FancyGui.sendLogger("按下按鈕!");
			modText.setText(1, "按鈕: "+modTextField.getText());
			modGUI.updata(player);
		});

		modGUI.addComponents(modButton)
			.addComponents(modImage)
			.addComponents(modText)
			.addComponents(modTextField)
			.open(player);

	}

}
