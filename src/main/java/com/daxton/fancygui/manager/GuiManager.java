package com.daxton.fancygui.manager;

import com.daxton.fancycore.api.gui.GUI;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GuiManager {

	public static Map<UUID, GUI> player_Gui_Map = new HashMap<>();
	//指令值 菜單
	public static Map<String, String> command_Menu_Map = new HashMap<>();
	//按鈕 設定檔
	public static Map<String, String> button_Config_Map = new HashMap<>();

}
