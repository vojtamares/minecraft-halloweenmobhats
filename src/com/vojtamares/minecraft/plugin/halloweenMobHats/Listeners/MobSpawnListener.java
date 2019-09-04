package com.vojtamares.minecraft.plugin.halloweenMobHats.Listeners;

import com.vojtamares.minecraft.plugin.halloweenMobHats.HalloweenMobHats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class MobSpawnListener implements Listener
{

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event)
    {
        switch (event.getEntity().getType())
        {
            case ZOMBIE:
                if (!HalloweenMobHats.config.getBoolean("mobs.zombie"))
                    return;
                break;
            case HUSK:
                if (!HalloweenMobHats.config.getBoolean("mobs.husk"))
                    return;
                break;
            case SKELETON:
                if (!HalloweenMobHats.config.getBoolean("mobs.skeleton"))
                    return;
                break;
            case STRAY:
                if (!HalloweenMobHats.config.getBoolean("mobs.stray"))
                    return;
                break;
            case WITHER_SKELETON:
                if (!HalloweenMobHats.config.getBoolean("mobs.wither_skeleton"))
                    return;
                break;
            default:
                return;
        }

        this.commonChecks(event.getEntity());
    }

    private void commonChecks(LivingEntity entity)
    {
        // If is wearing helmet and we are not ignoring that case, no pumpkin
        if (!HalloweenMobHats.config.getBoolean("ignoreMobHelmet"))
        {
            if (entity.getEquipment().getHelmet().getType() != Material.AIR)
                return;
        }

        Random rnd = new Random();

        if (HalloweenMobHats.config.getDouble("spawnChance") > 0.0)
        {
            double spawnChance = rnd.nextDouble() * 100;

            if (HalloweenMobHats.config.getDouble("spawnChance") < spawnChance)
                return;
        }
        else
            return;

        if (HalloweenMobHats.config.getBoolean("carved_pumpkin") && HalloweenMobHats.config.getBoolean("jack_o_lantern"))
        {
            int carvedOrLantern = rnd.nextInt(100);
            if (carvedOrLantern < 50)
                entity.getEquipment().setHelmet(new ItemStack(Material.CARVED_PUMPKIN,1));
            else
                entity.getEquipment().setHelmet(new ItemStack(Material.JACK_O_LANTERN,1));
        }
        else
        {
            if (HalloweenMobHats.config.getBoolean("carved_pumpkin"))
                entity.getEquipment().setHelmet(new ItemStack(Material.CARVED_PUMPKIN,1));
            else
                if (HalloweenMobHats.config.getBoolean("jack_o_lantern"))
                    entity.getEquipment().setHelmet(new ItemStack(Material.JACK_O_LANTERN,1));
        }

        if (HalloweenMobHats.config.getDouble("dropChance") > 0.0)
            entity.getEquipment().setHelmetDropChance((float) HalloweenMobHats.config.getDouble("dropChance"));
        else
            entity.getEquipment().setHelmetDropChance(0f);
    }

}
