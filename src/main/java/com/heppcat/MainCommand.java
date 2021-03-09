package com.heppcat;

import com.heppcat.items.TPBowItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class MainCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String incorrectusage = ChatColor.RED+"/bowtp <arrows/bow>";

        if (sender instanceof Player){
            if (sender.hasPermission("BowTP.main")){
                Player player = (Player) sender;
                if (args.length == 1){
                    if (args[0].equals("bow")){
                        player.getInventory().addItem(TPBowItem.tpbow);
                    }
                    else if (args[0].equals("arrows")){
                        player.getInventory().addItem(new ItemStack(Material.ARROW, 64));
                    }
                    else {
                        player.sendMessage(incorrectusage);
                    }
                }
                else {
                    player.sendMessage(incorrectusage);
                }
            }
            else {
                sender.sendMessage(ChatColor.RED+"You do not have the required permission to run this command.");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED+"Only players cam run this command!");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1){
            List<String> commands = new ArrayList<>();
            List<String> actuallist = new ArrayList<>();
            commands.add("bow");
            commands.add("arrows");
            if (args[0].length() == 0){
                return commands;
            }
            for (int i=0; i < commands.size(); i++){
                if (commands.get(i).startsWith(args[0])){
                    actuallist.add(commands.get(i));
                }
            }
            return actuallist;
        }
        if (args.length >= 2){
            List<String> nothing = new ArrayList<>();
            return nothing;
        }
        return null;
    }
}
