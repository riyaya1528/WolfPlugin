package net.riyaya.wolfplugin;

import net.riyaya.wolfplugin.Commands.Mute;
import net.riyaya.wolfplugin.Commands.UnMute;
import net.riyaya.wolfplugin.DataBase.IgnoreUser;
import net.riyaya.wolfplugin.Utils.Discord;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class WolfPlugin extends JavaPlugin {
    public static Discord bot;
    public static IgnoreUser ignoreUser;
    public static Configuration config;
    public static WolfPlugin instance;

    @Override
    public void onEnable() {
        System.out.println("sssss");
        instance = this;

        saveDefaultConfig();
        config = getConfig();
        ignoreUser = new IgnoreUser(this);
        ignoreUser.saveDefaultConfig();

        bot = new Discord();
        bot.login();

        registerEvent(this);

        getLogger().info(ChatColor.GREEN + "The plugin has been enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.GREEN + "The plugin has been disabled");
    }

    public static WolfPlugin getInstance() {
        return instance;
    }

    private void registerEvent(Plugin plugin) {
        getCommand("mute").setExecutor(new Mute());
        getCommand("unmute").setExecutor(new UnMute());
    }
}
