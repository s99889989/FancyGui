package com.daxton.fancygui.task;

import com.daxton.fancycore.api.fancyclient.ClientConnect;

import com.daxton.fancygui.api.build.gui.*;
import com.daxton.fancygui.api.build.hub.ModHub;
import com.daxton.fancygui.api.build.player.ModImageRenderer;
import com.daxton.fancygui.api.build.player.ModItemRenderer;
import com.daxton.fancygui.api.build.player.ModPlayerRenderer;
import com.daxton.fancygui.api.build.player.ModTextRenderer;
import com.daxton.fancygui.api.json.JsonCtrl;
import com.daxton.fancygui.api.mod.menu.MenuJson;
import com.daxton.fancygui.api.mod.menu_object.button.ClickButtonJson;
import com.daxton.fancygui.api.mod.menu_object.image.ImageShowJson;
import com.daxton.fancygui.api.mod.menu_object.text.TextLabelJson;
import com.daxton.fancygui.api.mod.menu_object.textfield.TextFieldJson;
import com.daxton.fancygui.config.FileConfig;
import com.daxton.fancygui.manager.GuiManager;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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

		ClientConnect.sendMessage(player, "updatamenu", JsonCtrl.writeJSON(menuJson));
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

		ClientConnect.sendMessage(player, "MenuOpen", JsonCtrl.writeJSON(menuJson));
	}

	//渲染玩家測試
	public static void renderPlayer(Player player){

		//圖片
		ModImageRenderer modImageRenderer = ModImageRenderer.ModImageRendererBuilder.getInstance()
			.setImage("https://i.imgur.com/PHnFyNo.png").setObjectName("Im1").setWidth(2).setHeight(2)
			.setAutoRotationZ(1).setAutoRotationY(1).setLocationHeight(0.5).build();
		//物品
		ModItemRenderer modItemRenderer = ModItemRenderer.ModItemRendererBuilder.getInstance()
			.setItemStack(new ItemStack(Material.STONE_SWORD)).setLocationHeight(1.3).setScale(3).setAutoRotationY(1)
			.setAutoRotationX(1).setObjectName("It1").build();
		//文字
		ModTextRenderer modTextRenderer = ModTextRenderer.ModTextRendererBuilder.getInstance()
			.setTextList(new String[]{"123", "456"}).setObjectName("T1").setLocationHeight(100)
			.setLocationAngle(0).setLocationDistance(100).build();

		ModPlayerRenderer modPlayerRenderer = ModPlayerRenderer.ModPlayerRendererBuilder.getInstance().build();
		modPlayerRenderer.addComponent(modItemRenderer)
			.addComponent(modImageRenderer)
			.addComponent(modTextRenderer)
			.render(player);
	}
	//取消渲染玩家測試
	public static void unRenderPlayer(Player player){


		//圖片
		ModImageRenderer modImageRenderer = ModImageRenderer.ModImageRendererBuilder.getInstance()
			.setImage("https://i.imgur.com/PHnFyNo.png")
			.setObjectName("Im1")
			.setWidth(2)
			.setHeight(3)
			.setLocationHeight(0.5)
			.build();
		//物品
		ModItemRenderer modItemRenderer = ModItemRenderer.ModItemRendererBuilder.getInstance()
			.setItemStack(new ItemStack(Material.STONE_SWORD))
			.setLocationHeight(1)
			.setObjectName("It1")
			.build();
		//文字
		ModTextRenderer modTextRenderer = ModTextRenderer.ModTextRendererBuilder.getInstance()
			.setTextList(new String[]{"123", "456"})
			.setObjectName("T1")
			.build();

		ModPlayerRenderer modPlayerRenderer = ModPlayerRenderer.ModPlayerRendererBuilder.getInstance().build();
		modPlayerRenderer.addComponent(modItemRenderer)
			.addComponent(modImageRenderer)
			.addComponent(modTextRenderer)
			.unRender(player);
	}

	//打開HUB測試
	public static void hubShow(Player player){
		ModText modText1 = ModText.ModTextBuilder.getInstance()
			.addTextList("§31Content 1").addTextList("§41Content 2").addTextList("§41Cont我我").setObjectName("t1")
			.setScale(1F).setAlign(1).setRow_height(8).setPosition(2).setX(20).setY(40).build();

		ItemStack itemStack = new ItemStack(Material.COAL_ORE);

		ModItem modItem1 = ModItem.ModItemBuilder.getInstance()
			.setObjectName("1").setPlayer(player).setItemStack(itemStack)
			.setPosition(5).setScale(2).build();

		ModImage frame = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/qVUSIuv.png").setObject_name("frame")
			.setPosition(1).setX(0).setY(0).build();
		ModImage head = ModImage.ModImageBuilder.getInstance().setImage("https://crafatar.com/avatars/&self_uuid&").setObject_name("head")
			.setPosition(1).setWidth("30").setHeight("30").setX(4).setY(4).build();
		ModImage longFrame1 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/vupzmL5.png").setObject_name("longFrame1")
			.setPosition(1).setX(40).setY(5).build();
		ModImage greanBar = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/qFf8nCS.png").setObject_name("greanBar")
			.setPosition(1).setWidth("&health_width&").setX(40).setY(5).build();
		ModImage longFrame2 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/vupzmL5.png").setObject_name("longFrame2")
			.setPosition(1).setX(40).setY(15).build();
		ModImage blueBar = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/vk0jBVG.png").setObject_name("blueBar")
			.setPosition(1).setX(40).setY(15).build();

		ModImage modImage2 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i2")
			.setPosition(3).setWidth("60").setHeight("60").build();
		ModImage modImage3 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i3")
			.setPosition(4).setWidth("60").setHeight("60").build();
		ModImage modImage4 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i4")
			.setPosition(6).setWidth("60").setHeight("60").build();
		ModImage modImage5 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i5")
			.setPosition(7).setWidth("60").setHeight("60").build();
		ModImage modImage6 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i6")
			.setPosition(8).setWidth("60").setHeight("60").build();
		ModImage modImage7 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i7")
			.setPosition(9).setWidth("60").setHeight("60").build();

		ModHub modHub = ModHub.ModHubBuilder.getInstance()
			.addComponent(frame).addComponent(head).addComponent(longFrame1).addComponent(greanBar).addComponent(longFrame2).addComponent(blueBar)
			.addComponent(modImage2).addComponent(modImage3)
			.addComponent(modImage4).addComponent(modImage5).addComponent(modImage6)
			.addComponent(modImage7)
			.addComponent(modText1)
			.addComponent(modItem1).build();
		modHub.show(player);
	}
	//關閉HUB測試
	public static void hubHide(Player player){

		ModText modText1 = ModText.ModTextBuilder.getInstance()
			.addTextList("§31Content 1").addTextList("§41Content 2").setObjectName("t1")
			.setScale(3F).setAlign(1).setRow_height(8).setPosition(2).build();

		ItemStack itemStack = new ItemStack(Material.COAL_ORE);
		ModItem modItem1 = ModItem.ModItemBuilder.getInstance()
			.setObjectName("1").setPlayer(player).setItemStack(itemStack)
			.setPosition(5).setScale(2).build();

		ModImage frame = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/qVUSIuv.png").setObject_name("frame")
			.setPosition(1).setX(0).setY(0).build();
		ModImage head = ModImage.ModImageBuilder.getInstance().setImage("https://crafatar.com/avatars/&self_uuid&").setObject_name("head")
			.setPosition(1).setX(4).setY(4).build();
		ModImage longFrame1 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/vupzmL5.png").setObject_name("longFrame1")
			.setPosition(1).setX(40).setY(5).build();
		ModImage greanBar = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/vupzmL5.png").setObject_name("greanBar")
			.setPosition(1).setX(40).setY(5).build();
		ModImage longFrame2 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/qFf8nCS.png").setObject_name("longFrame2")
			.setPosition(1).setX(40).setY(15).build();
		ModImage blueBar = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/vk0jBVG.png").setObject_name("blueBar")
			.setPosition(1).setX(40).setY(15).build();


		ModImage modImage2 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i2")
			.setPosition(3).setWidth("60").setHeight("60").build();
		ModImage modImage3 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i3")
			.setPosition(4).setWidth("60").setHeight("60").build();
		ModImage modImage4 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i4")
			.setPosition(6).setWidth("60").setHeight("60").build();
		ModImage modImage5 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i5")
			.setPosition(7).setWidth("60").setHeight("60").build();
		ModImage modImage6 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i6")
			.setPosition(8).setWidth("60").setHeight("60").build();
		ModImage modImage7 = ModImage.ModImageBuilder.getInstance().setImage("https://i.imgur.com/5B9nsam.png").setObject_name("i7")
			.setPosition(9).setWidth("60").setHeight("60").build();

		ModHub modHub = ModHub.ModHubBuilder.getInstance()
			.addComponent(frame).addComponent(head).addComponent(longFrame1).addComponent(greanBar).addComponent(longFrame2).addComponent(blueBar)
			.addComponent(modImage2).addComponent(modImage3)
			.addComponent(modImage4).addComponent(modImage5).addComponent(modImage6)
			.addComponent(modImage7)
			.addComponent(modText1)
			.addComponent(modItem1).build();
		modHub.hide(player);
	}
	//打開GUI測試
	public static void openMenuTest(Player player){
//.setImage("textures/gui/test.png")

		ModGUI modGUI = ModGUI.ModGUIBuilder.getInstance()
			.setGui_id("Test")
			.setPosition(5)
			.setImage("https://i.imgur.com/Rf9Tizv.png")
			.build();

		ModImage modImage = ModImage.ModImageBuilder.getInstance()
			.setImage("https://i.imgur.com/5B9nsam.png")
			.setPosition(5)
			.setWidth("40")
			.setHeight("40")
			.build();

		ModText modText = ModText.ModTextBuilder.getInstance()
			.addTextList("§3Add content:")
			.setScale(2F)
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
			modText.setText(1, "Input box: "+modTextField1.getText());
			modGUI.updata(player);
		});

		ModButton modButton = ModButton.ModButtonBuilder.getInstance()
			.setImage_on("https://i.imgur.com/9q8FpAt.png")
			.setImage_off("https://i.imgur.com/VmfhCq2.png")
			.setDisplay_name("Click on")
			.setPosition(1)
			.setY(25)
			.build();
		ModButton modButton1 = ModButton.ModButtonBuilder.getInstance()
			.setImage_on("https://i.imgur.com/9q8FpAt.png")
			.setImage_off("https://i.imgur.com/VmfhCq2.png")
			.setDisplay_name("Click on")
			.setPosition(9)
			.build();
		modButton.onButtonClick(clickButton -> {
			modText.setText(1, "Button: "+modTextField.getText());
			modGUI.updata(player);
		});

		ItemStack itemStack = new ItemStack(Material.COAL_ORE);
		List<String> arrayList = new ArrayList<>();
		arrayList.add("1");
		arrayList.add("2");
		arrayList.add("3");
		itemStack.setLore(arrayList);
		float sc = 2F;
		ModItem modItem1 = ModItem.ModItemBuilder.getInstance().setPlayer(player).setItemStack(itemStack).setPosition(1).setScale(sc).build();
		ModItem modItem3 = ModItem.ModItemBuilder.getInstance().setPlayer(player).setItemStack(itemStack).setPosition(3).setScale(sc).build();
		ModItem modItem4 = ModItem.ModItemBuilder.getInstance().setPlayer(player).setItemStack(itemStack).setPosition(4).setScale(sc).build();
		ModItem modItem6 = ModItem.ModItemBuilder.getInstance().setPlayer(player).setItemStack(itemStack).setPosition(6).setScale(sc).build();
		ModItem modItem7 = ModItem.ModItemBuilder.getInstance().setPlayer(player).setItemStack(itemStack).setPosition(7).setScale(sc).build();
		ModItem modItem8 = ModItem.ModItemBuilder.getInstance().setPlayer(player).setItemStack(itemStack).setPosition(8).setScale(sc).build();
		ModItem modItem9 = ModItem.ModItemBuilder.getInstance().setPlayer(player).setItemStack(itemStack).setPosition(9).setScale(sc).build();

		modGUI
			.addComponent(modButton).addComponent(modButton1)
			.addComponent(modImage)
			.addComponent(modText)
			.addComponent(modTextField)
			.addComponent(modItem1).addComponent(modItem3)
			.addComponent(modItem4).addComponent(modItem6)
			.addComponent(modItem7).addComponent(modItem8).addComponent(modItem9)
			.open(player);

	}

}
