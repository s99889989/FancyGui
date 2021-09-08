package com.daxton.fancygui.gui;

import com.daxton.fancycore.api.gui.GUI;
import com.daxton.fancycore.api.gui.button.GuiOpenAction;
import com.daxton.fancycore.other.taskaction.StringToMap;
import com.daxton.fancycore.task.TaskAction;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;

public class OpenGui implements GuiOpenAction {

	final Player player;

	List<Map<String, String>> openList;

	public OpenGui(Player player, GUI gui, FileConfiguration config){
		this.player = player;
		openList = StringToMap.toActiomMapList(config.getStringList("OpenAction"));
		gui.setGuiOpenAction(this);
	}

	@Override
	public void execute() {
		openList.forEach(actionMap -> TaskAction.execute(player, null, actionMap, null, String.valueOf((int)(Math.random()*100000))));
	}

}
