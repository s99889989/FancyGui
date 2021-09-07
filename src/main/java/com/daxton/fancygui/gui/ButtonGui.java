package com.daxton.fancygui.gui;

import com.daxton.fancycore.api.gui.GUI;
import com.daxton.fancycore.api.gui.button.GuiAction;
import com.daxton.fancycore.api.gui.button.GuiButton;
import com.daxton.fancycore.api.gui.item.GuiItem;
import com.daxton.fancycore.other.taskaction.MapGetKey;
import com.daxton.fancycore.other.taskaction.StringToMap;
import com.daxton.fancycore.task.TaskAction;
import com.daxton.fancygui.config.FileConfig;
import com.daxton.fancygui.manager.GuiManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ButtonGui implements GuiAction {

	final Player player;
	final GUI gui;
	final String buttonName;
	List<Map<String, String>> leftList;
	List<Map<String, String>> rightList;
	List<Map<String, String>> leftShiftList;
	List<Map<String, String>> rightShiftList;

	public ButtonGui(Player player, GUI gui, String buttonName, int vertical, int horizontal){
		this.player = player;
		this.gui = gui;
		this.buttonName = buttonName;

		String path = GuiManager.button_Config_Map.get(buttonName);
		if(path != null){
			FileConfiguration config = FileConfig.config_Map.get(path);

			boolean move = config.getBoolean("Buttons."+buttonName+".Move");

			leftList = StringToMap.toActiomMapList(config.getStringList("Buttons."+buttonName+".Left"));
			rightList = StringToMap.toActiomMapList(config.getStringList("Buttons."+buttonName+".Right"));
			leftShiftList = StringToMap.toActiomMapList(config.getStringList("Buttons."+buttonName+".Left_Shift"));
			rightShiftList = StringToMap.toActiomMapList(config.getStringList("Buttons."+buttonName+".Right_Shift"));

			ItemStack itemStack = GuiItem.valueOf(player, config, "Buttons."+buttonName);
			GuiButton guiButton = GuiButton.ButtonBuilder.getInstance().
				setItemStack(itemStack).
				setGuiAction(this).
				setMove(move).
				build();

			gui.setButton(guiButton, vertical, horizontal);

		}

	}

	public void execute(ClickType clickType, InventoryAction inventoryAction, int place){
		if(clickType == ClickType.LEFT){
			leftList.forEach(actionMap -> {
				TaskAction.execute(player, null, actionMap, null, String.valueOf((int)(Math.random()*100000)));
			});
		}
		if(clickType == ClickType.RIGHT){
			rightList.forEach(actionMap -> {
				TaskAction.execute(player, null, actionMap, null, String.valueOf((int)(Math.random()*100000)));
			});
		}
		if(clickType == ClickType.SHIFT_LEFT){
			leftShiftList.forEach(actionMap -> {
				TaskAction.execute(player, null, actionMap, null, String.valueOf((int)(Math.random()*100000)));
			});
		}
		if(clickType == ClickType.SHIFT_LEFT){
			rightShiftList.forEach(actionMap -> {
				TaskAction.execute(player, null, actionMap, null, String.valueOf((int)(Math.random()*100000)));
			});
		}
	}

}
