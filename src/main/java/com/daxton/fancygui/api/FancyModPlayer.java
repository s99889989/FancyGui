package com.daxton.fancygui.api;

import com.daxton.fancygui.FancyGui;
import com.daxton.fancygui.api.json.ImageDownLoadJson;
import com.daxton.fancygui.api.json.JsonCtrl;
import com.daxton.fancygui.config.FileConfig;
import com.daxton.fancygui.manager.GuiManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.daxton.fancygui.config.FileConfig.languageConfig;

public class FancyModPlayer {

	public Player player;

	public UUID uuid;

	public Map<String, String> text_field_value_map = new HashMap<>();
	//玩家是否裝模組
	public boolean player_have_mod;
	//玩家模組版本是否正確
	public boolean player_version_mod;
	//目前GUI路徑
	public String gui_path = "";

	public BukkitRunnable bukkitRunnable;

	public FancyModPlayer(Player player){
		this.player = player;
		this.uuid = player.getUniqueId();

	}
	//獲取輸入框的值
	public String getInput(String key){
		if(text_field_value_map.containsKey(key)){
			return text_field_value_map.get(key);
		}
		return "0";
	}

	//設置登入初始動作
	public void sendFirst(){
		FileConfiguration config = FileConfig.config_Map.get("config.yml");
		FileConfiguration downloadConfig = FileConfig.config_Map.get("preload-pictures.yml");
		List<String> download_list = downloadConfig.getStringList("image-list");

		int preload_delay = config.getInt("ClientMod.preload_delay");
		if(preload_delay < 0){
			preload_delay = 1;
		}

		boolean kick_no_mod = config.getBoolean("ClientMod.kick_no_mod");
		boolean kick_mod_version_wrong = config.getBoolean("ClientMod.kick_mod_version_wrong");


		FancyConnect.sendMessage(player, "version:1.2.x");

		new BukkitRunnable() {
			@Override
			public void run() {
				if(kick_no_mod){

					if(!player_have_mod){
						player.kickPlayer(""+languageConfig.getString("ModMessage.KickNoMod"));
					}

				}

				if(kick_mod_version_wrong){
					if(!player_version_mod){
						player.kickPlayer(""+languageConfig.getString("ModMessage.KickModVersionWrong").replace("{version}", "1.2.x"));
					}
				}

				FancyConnect.sendMessage(player, "download:"+ JsonCtrl.writeJSON(new ImageDownLoadJson(download_list)));
			}
		}.runTaskLater(FancyGui.fancyGui, 20L * (preload_delay+1));
	}

}
