package com.heppcat;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveBow implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack bow = new ItemStack(Material.BOW);
            player.getInventory().addItem(bow);
        } else {
            sender.sendMessage("This command can only be used by a player");
        }

        return true;
    }
}
