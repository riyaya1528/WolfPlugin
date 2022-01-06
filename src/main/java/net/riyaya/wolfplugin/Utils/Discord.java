package net.riyaya.wolfplugin.Utils;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Member;
import net.riyaya.wolfplugin.DataBase.IgnoreUser;
import net.riyaya.wolfplugin.WolfPlugin;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;

import javax.security.auth.login.LoginException;

public class Discord {
    private static JDA jda;
    private final static Configuration config = WolfPlugin.config;
    private final static IgnoreUser ignoreUser = WolfPlugin.ignoreUser;
    private final static WolfPlugin instance = WolfPlugin.getInstance();

    public void login() {
        try {
            jda = JDABuilder.createDefault(config.getString("token")).build();
        } catch (LoginException e) {
            e.printStackTrace();
            instance.getLogger().warning(ChatColor.RED + "Botにログインができませんでした。Tokenは合っていますか?");
        }
    }

    public void mute() {
        for(Member member : jda.getVoiceChannelById(config.getString("voiceChannelID")).getMembers()) {
            if(member == null) {
                break;
            }
            if(ignoreUser.getConfig().getStringList("ignoreUserID").contains(member.getId())) {
            }else {
                member.mute(true).submit().join();
            }
        }
    }

    public void unMute() {
        for(Member member : jda.getVoiceChannelById(config.getString("voiceChannelID")).getMembers()) {
            member.mute(false).submit().join();
            if(ignoreUser.getConfig().getStringList("ignoreUserID").contains(member.getId())) {
            }else {
                member.mute(false).submit().join();
            }
        }
    }
}
