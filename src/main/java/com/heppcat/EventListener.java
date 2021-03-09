package com.heppcat;

import com.heppcat.items.TPBowItem;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {
    @EventHandler
    public void ProjectileHitEvent(ProjectileHitEvent e) {
        Projectile projectile = e.getEntity();
        if (projectile instanceof Arrow) {
            Arrow arrow = (Arrow) projectile;
            if(projectile.getShooter() instanceof Player){
                Player player = (Player) projectile.getShooter();
                ItemStack iteminhand = player.getInventory().getItemInMainHand();
                if (iteminhand.getItemMeta().getEnchants().equals(TPBowItem.tpbow.getEnchantments())){
                    player.teleport(arrow.getLocation());
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                }
            }
        }
    }
}
