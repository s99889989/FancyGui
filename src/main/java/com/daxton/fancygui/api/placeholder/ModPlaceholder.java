package com.daxton.fancygui.api.placeholder;

import com.daxton.fancygui.FancyGui;
import com.daxton.fancygui.manager.GuiManager;
import org.bukkit.entity.LivingEntity;

import java.util.UUID;

public class ModPlaceholder {

	public static String valueOf(LivingEntity entity, String inputString){
		UUID uuid = entity.getUniqueId();

		if(inputString.toLowerCase().startsWith("<fc_gui_text_field_")){
			String key = inputString.replace(" ","").replace("<fc_gui_text_field_","");
			if(GuiManager.player_mod_data.containsKey(uuid)){
				return GuiManager.player_mod_data.get(uuid).getInput(key);
			}
		}
		return "0";
	}

}
