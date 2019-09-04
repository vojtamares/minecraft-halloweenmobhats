package com.vojtamares.minecraft.plugin.halloweenMobHats;

import com.vojtamares.minecraft.plugin.halloweenMobHats.Listeners.MobSpawnListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class HalloweenMobHats extends JavaPlugin
{

    public static FileConfiguration config;

    @Override
    public final void onEnable()
    {
        this.checkForDefaultConfig();
        config = this.getConfig();
        this.init();
    }

    @Override
    public final void onDisable()
    {
    }

    private void init()
    {
        this.getServer().getPluginManager().registerEvents(new MobSpawnListener(), this);
    }

    private void checkForDefaultConfig()
    {
        File f = new File(getDataFolder(), "config.yml");

        if (!f.exists())
        {
            this.saveDefaultConfig();
            getLogger().info("Config file (config.yml) has not been found, default config loaded instead");
        }
    }

}
