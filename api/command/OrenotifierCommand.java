package net.skaizdoesmc.orenotifier.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.skaizdoesmc.orenotifier.Orenotifier;
import net.skaizdoesmc.orenotifier.gui.ConfigGUI;
import pw.skaiz.api.PluginInfo;
import pw.skaiz.api.SkaizAPI;

public class OrenotifierCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lb, String[] args) {
		
		if(!SkaizAPI.hasPerm(s, cmd)){
			s.sendMessage(PluginInfo.noPerm);
			return true;
		}else{
			
			if(args.length == 0){
				if(!(s instanceof Player)){
					s.sendMessage("§cUsage: /orenotifier <reload/about>");
					return true;
				}else{
					Player p = (Player) s;

					String ver_a = Bukkit.getServer().getClass().getPackage().getName();
					String ver = ver_a.substring(ver_a.lastIndexOf('.') + 1);

					if(!ver.contains("1_8")){
						p.sendMessage("§c§lIt seems like the server is running Bukkit version 1.9 or higher, please edit the config.yml manually rather than in game!");
					}


					p.openInventory(ConfigGUI.a(p));
				}
				return true;
			}else{

				if(args[0].equalsIgnoreCase("about")){
					String ver = Bukkit.getPluginManager().getPlugin("OreNotifier").getDescription().getVersion();
					if(ver == null) {
						s.sendMessage("§fThis server is running §aOreNotifier§r version §cerror");
						s.sendMessage("§aGitHub§r: https://skaiz.pw/go/github");
						return true;
					}else {
						s.sendMessage("§fThis server is running §aOreNotifier§r version §a"+ver);
						s.sendMessage("§aGitHub§r: https://skaiz.pw/go/github");
						return true;
					}

				}

				if(args[0].equalsIgnoreCase("reload")){
					
					try{
						Orenotifier.getInstance().reloadConfig();
					}catch(Exception ex){
						ex.printStackTrace();
						s.sendMessage("§cOops! This is awkward, some error occurred! Please check console for logs.");
						return true;
					}
					s.sendMessage("§aReloaded config!");
					
				}else{
					s.sendMessage("§cUsage: /orenotifier <reload/about>");
					return true;
				}
				
			}
			
		}
		
		return false;
	}

}
