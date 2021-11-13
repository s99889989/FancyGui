package com.daxton.fancygui.listener;

import com.daxton.fancycore.api.event.PlayerPackReceivedEvent;
import com.daxton.fancycore.other.taskaction.StringToMap;
import com.daxton.fancycore.task.TaskAction;
import com.daxton.fancygui.FancyGui;
import com.daxton.fancygui.api.event.PlayerClickButtonEvent;
import com.daxton.fancygui.api.event.PlayerCloseModGui;
import com.daxton.fancygui.api.event.PlayerInputEndEvent;
import com.daxton.fancygui.api.event.PlayerOpenModGui;
import com.daxton.fancygui.api.json.ActionJson;
import com.daxton.fancygui.api.json.ButtonJson;
import com.daxton.fancygui.api.json.InputJson;
import com.daxton.fancygui.manager.GuiManager;
import com.daxton.fancygui.task.ModMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ClientListener implements Listener {

	@EventHandler
	public void onPlayerPackReceived(PlayerPackReceivedEvent event){

		Player player = event.getPlayer();
		String type = event.getType();
		String receivedString = event.getReceived();
		//觸發FancyCore動作
		if(type.equalsIgnoreCase("action")){
			action(player, receivedString);
			return;
		}
		//判定有無裝模組 和 模組版本正確與否
		if(type.equalsIgnoreCase("version")){
			version(player, receivedString);
			return;
		}
		//自訂按鈕事件
		if(type.equalsIgnoreCase("button")){
			button(player, receivedString);
			return;
		}
		//輸入框結束事件
		if(type.equalsIgnoreCase("input")){
			input(player, receivedString);
			return;
		}
		//GUI關閉事件
		if(type.equalsIgnoreCase("closegui")){

			PlayerCloseModGui playerCloseModGui = new PlayerCloseModGui(player, receivedString);
			Bukkit.getPluginManager().callEvent(playerCloseModGui);
			return;
		}
		//GUI開啟事件
		if(type.equalsIgnoreCase("opengui")){
			PlayerOpenModGui playerOpenModGui = new PlayerOpenModGui(player, receivedString);
			Bukkit.getPluginManager().callEvent(playerOpenModGui);
			return;
		}
		//開啟其他選單
		if(type.equalsIgnoreCase("ToMenu")){
			ModMenu.openMenuPath(player, "mod_menu/"+receivedString+".yml");
			//FancyGui.sendLogger("打開: "+receivedString);
			return;
		}

		FancyGui.sendLogger("接收測試: "+type+"  "+receivedString);
	}

	//輸入框結束事件
	public void input(Player player, String receivedString){
		InputJson inputJson = InputJson.readJSON(receivedString);
		PlayerInputEndEvent playerInputEndEvent = new PlayerInputEndEvent(player, inputJson);
		Bukkit.getPluginManager().callEvent(playerInputEndEvent);
	}
	//自訂按鈕事件
	public void button(Player player, String receivedString){
		ButtonJson buttonJson = ButtonJson.readJSON(receivedString);
		PlayerClickButtonEvent playerClickButtonEvent = new PlayerClickButtonEvent(player, buttonJson);
		Bukkit.getPluginManager().callEvent(playerClickButtonEvent);
	}

	//觸發FancyCore動作
	public void action(Player player, String receivedString){
		List<String> actionList = ActionJson.readJSON(receivedString).getAction_list();
		List<Map<String, String>> action_map_list = StringToMap.toActiomMapList(actionList);
		action_map_list.forEach(actionMap -> TaskAction.execute(player, null, actionMap, null, String.valueOf((int)(Math.random()*100000))));

	}

	//判定有無裝模組 和 模組版本正確與否
	public void version(Player player, String receivedString){
		UUID uuid = player.getUniqueId();
		GuiManager.player_mod_data.get(uuid).player_have_mod = true;
		if(receivedString.startsWith("1.2")){
			GuiManager.player_mod_data.get(uuid).player_version_mod = true;
		}
	}

}
