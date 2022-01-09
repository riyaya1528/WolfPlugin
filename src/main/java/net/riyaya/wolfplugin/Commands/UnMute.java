package net.riyaya.wolfplugin.Commands;

import net.riyaya.wolfplugin.WolfPlugin;
import org.bukkit.ChatColor;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class UnMute implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(!sender.hasPermission("WolfPlugin.command.unmute")) {
                sender.sendMessage( ChatColor.RED + "Sorry. You don`t have permission to send this command.");
                return true;
            }
            WolfPlugin.bot.unMute();
            sender.sendMessage(ChatColor.GREEN + "ミュートを解除しました");
        }else {
            WolfPlugin.bot.mute();
            sender.sendMessage(ChatColor.GREEN + "ミュートにしました");
        }
        return true;
    }
}
