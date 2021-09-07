package com.daxton.fancygui.gui;

import com.daxton.fancycore.api.gui.GUI;
import com.daxton.fancycore.api.gui.button.GuiCloseAction;
import com.daxton.fancycore.other.taskaction.StringToMap;
import com.daxton.fancycore.task.TaskAction;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;

public class CloseGui implements GuiCloseAction {

	final Player player;

	List<Map<String, String>> closeList;

	public CloseGui(Player player, GUI gui, FileConfiguration config){
		this.player = player;
		closeList = StringToMap.toActiomMapList(config.getStringList("CloseActions"));
		gui.setGuiCloseAction(this);
	}

	@Override
	public void execute() {
		closeList.forEach(actionMap -> {
			TaskAction.execute(player, null, actionMap, null, String.valueOf((int)(Math.random()*100000)));
		});
	}

}
