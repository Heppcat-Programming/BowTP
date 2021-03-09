package com.heppcat;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class EventListener implements Listener {
    @EventHandler
    public void ProjectileHitEvent(ProjectileHitEvent e) {
        Projectile projectile = e.getEntity();
        if (projectile instanceof Arrow) {
            Arrow arrow = (Arrow) projectile;
            if(projectile.getShooter() instanceof Player){
                ((Player) projectile.getShooter()).teleport(arrow.getLocation());
            }
        }
    }
}
