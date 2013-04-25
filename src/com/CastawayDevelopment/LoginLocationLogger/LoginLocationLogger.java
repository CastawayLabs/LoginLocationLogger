package com.CastawayDevelopment.LoginLocationLogger;

/*
 * This file is part of Login Location Logger, LLL for short!.
 * TopPvP is licensed under GNU General Public License v3.
 * Copyright (C) 2013 The Castaway Development Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.*;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class LoginLocationLogger extends JavaPlugin {
	 
	/**
	 * 
	 * 
	 */
	public void onEnable() {
		
	}
	
	/**
	 * 
	 *  
	 *  @param number
	 */
	public void newLoggerFile(int number){
		
		
	}
	 
	/**
	 * 
	 * @param event
	 */
	@EventHandler
    public void playerJoin(PlayerJoinEvent event) {
		//On player join send them the message from config.yml
		Player player = event.getPlayer();
    	player.getLocation();
	}
	
}
