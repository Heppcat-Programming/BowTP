package com.heppcat;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveArrows implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack arrows = new ItemStack(Material.ARROW, 64);
            player.getInventory().addItem(arrows);
        } else {
            sender.sendMessage("This command can only be used by a player");
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
