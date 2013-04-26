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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LoginLocationLogger extends JavaPlugin {
	 
	private File loginLogFile;
	
	/**
	 * 
	 * @param event
	 */
	@EventHandler
    public void playerJoin(PlayerJoinEvent event) {
		//On player join send them the message from config.yml
		Player player = event.getPlayer();
    	Location location = player.getLocation();    	
    	logToFile(player, location);
	}
	
	public void onEnable() {
		
		File dataFolder = getDataFolder();
        if(!dataFolder.exists())
    	{
            dataFolder.mkdir();
        }
        this.getLogger().log(Level.INFO, "It's Working, I think. Echo");
		newLoggerFile("LocationLog_", 1);
	}
	
	/**
	 * Makes new logger file, if file already exists, make a new one.
	 * @param filename
	 * @param number
	 * @return
	 */
	public File newLoggerFile(String filename, int number){
		loginLogFile = new File(getDataFolder(), (filename+number+".txt"));
        if (!loginLogFile.exists())
        {
            try 
            {
            	loginLogFile.createNewFile();
            }
	        catch (IOException e) 
	        {
	        	e.printStackTrace();
			}
        }
        else if (loginLogFile.exists())
        {
        	while(loginLogFile.exists())
        	{
        		number++;
        		loginLogFile = new File(getDataFolder(), (filename+number+".txt"));
        	}
        	try 
            {
        		loginLogFile.createNewFile();
            }
	        catch (IOException e) 
	        {
	        	e.printStackTrace();
			}
        }
        return loginLogFile;
	}

	/**
	 * Logs a entry to the file.
	 * @param file
	 * @param player
	 * @param location
	 */
	public void logToFile(Player player, Location location){
		
		String worldName = location.getWorld().getName().toString();
		String playerName = player.getName().toString();
		int x = location.getBlockX();
		int y = location.getBlockY();
		int z = location.getBlockZ();
		
		String loginLocEntry = (playerName + "   " + worldName + "   " + x + "   " + y + "   " + z); 
		try
        {
			FileWriter fw = new FileWriter(loginLogFile, true);
	        PrintWriter pw = new PrintWriter(fw);
			pw.println(loginLocEntry); 
	        pw.flush();
	        pw.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
