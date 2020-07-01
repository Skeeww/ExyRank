package fr.exygames.exyrank;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Rank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        HashMap<Integer, Faction> factions = new HashMap<>();
        for(Faction faction : Factions.getInstance().getAllFactions()){
            if(faction.getPoints() > 0) {
                factions.put(faction.getPoints(), faction);
            }
        }
        ArrayList<Integer> rank = new ArrayList<>(factions.keySet());
        Collections.sort(rank);
        sender.sendMessage(ChatColor.GREEN + "==========" + ChatColor.GOLD + "CLASSEMENT" + ChatColor.GREEN + "==========");
        if(rank.size() == 0){
            sender.sendMessage(ChatColor.DARK_PURPLE + "Pour le moment aucune faction n'est classée (pour être classé votre faction doit avoir un nombre de points supérieur à 0)");
        }
        for(int i = rank.size() - 1; i >= 0; i--){
            int r = rank.size() - i;
            Faction entry = factions.get(rank.get(i));
            switch (r){
                case 1:
                    sender.sendMessage(ChatColor.BOLD + "" + ChatColor.YELLOW + "N°"+ r + ChatColor.GOLD + " > " + ChatColor.RESET + "" + ChatColor.UNDERLINE + entry.getTag() + ChatColor.DARK_PURPLE + "(avec " + entry.getPoints() + " points)");
                    break;
                case 2:
                    sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_AQUA + "N°"+ r + ChatColor.GOLD + " > " + ChatColor.RESET + "" + ChatColor.UNDERLINE + entry.getTag() + ChatColor.DARK_PURPLE + "(avec " + entry.getPoints() + " points)");
                    break;
                case 3:
                    sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + "N°"+ r + ChatColor.GOLD + " > " + ChatColor.RESET + "" + ChatColor.UNDERLINE + entry.getTag() + ChatColor.DARK_PURPLE + "(avec " + entry.getPoints() + " points)");
                    break;
                default:
                    sender.sendMessage(ChatColor.BOLD + "" + ChatColor.RESET + "N°"+ r + ChatColor.GOLD + " > " + ChatColor.RESET + "" + ChatColor.UNDERLINE + entry.getTag() + ChatColor.DARK_PURPLE + "(avec " + entry.getPoints() + " points)");
                    break;
            }

        }
        return true;
    }
}
