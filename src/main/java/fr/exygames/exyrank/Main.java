package fr.exygames.exyrank;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("[ExyRank] Is Started !");
        for(Faction faction : FactionColl.get().getAll()){

        }
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("[ExyRank] Is Stopped !");
    }
}
