package com.daxton.fancygui.command;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TabCommand implements TabCompleter {

    private final String[] subCommands = {"reload", "gui", "modgui"};

    public static List<String> guiList = new ArrayList<>();

    public static List<String> mod_gui_list = new ArrayList<>();

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args){
        List<String> commandList = new ArrayList<>();

        if (args.length == 1){
            commandList = Arrays.stream(subCommands).filter(s -> s.startsWith(args[0])).collect(Collectors.toList());
        }

        if (args.length == 2){
            if(args[0].equals("gui")){
                commandList = guiList;
            }
            if(args[0].equals("modgui")){
                commandList = mod_gui_list;
            }
        }

        return commandList;
    }

}

