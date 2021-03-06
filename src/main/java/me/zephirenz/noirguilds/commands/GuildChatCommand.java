package me.zephirenz.noirguilds.commands;

import me.zephirenz.noirguilds.objects.GuildMember;
import me.zephirenz.noirguilds.objects.GuildRank;
import nz.co.noirland.zephcore.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

import static me.zephirenz.noirguilds.Strings.*;

public class GuildChatCommand extends Commandlet implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(isNotPlayer(sender, NO_CONSOLE)) return true;
        Player player = (Player) sender;
        GuildMember member = gHandler.getMember(player);
        if(isNull(member, sender, GUILD_CHAT_NO_GUILD)) return true;

        GuildRank rank = member.getRank();
        String prefix = String.format(GUILD_CHAT_FORMAT, rank.getColour(), rank.getName(), player.getName());
        String msg = Util.concatenate(prefix, Arrays.asList(args), "", " ");
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        if(!(msg.length() == prefix.length())) {
            member.getGuild().sendMessage(msg, false);
            return true;
        }

        return false;
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        onCommand(sender, null, "", args);
    }
}
