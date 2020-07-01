package fr.exygames.exyrank;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("[ExyRank] Is Started !");
        getCommand("classement").setExecutor(new Rank());
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("[ExyRank] Is Stopped !");
    }
}
