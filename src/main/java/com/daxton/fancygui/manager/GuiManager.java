package com.daxton.fancygui.manager;

import com.daxton.fancygui.api.FancyModPlayer;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GuiManager {

	//指令值 菜單
	public static Map<String, String> command_Menu_Map = new HashMap<>();
	//按鈕 設定檔
	public static Map<String, String> button_Config_Map = new HashMap<>();
	//指令值 菜單
	public static Map<String, String> command_Mod_Menu_Map = new HashMap<>();
	//玩家資訊
	public static Map<UUID, FancyModPlayer> player_mod_data = new HashMap<>();


}
