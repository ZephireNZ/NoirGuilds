package me.zephirenz.noirguilds.commands.grank;

import me.zephirenz.noirguilds.GuildsHandler;
import me.zephirenz.noirguilds.NoirGuilds;
import me.zephirenz.noirguilds.objects.Guild;
import me.zephirenz.noirguilds.objects.GuildMember;
import me.zephirenz.noirguilds.objects.GuildRank;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankListCommandlet {

    NoirGuilds plugin;
    GuildsHandler gHandler;

    public RankListCommandlet() {
        this.plugin = NoirGuilds.inst();
        this.gHandler = plugin.getGuildsHandler();
    }


    /**
     *  The commandlet for listing all ranks.
     *  Usage: /grank list
     *
     *  @param sender the sender of the command
     *  @param args   commandlet-specific args
     */
    public void run(CommandSender sender, String[] args) {

        if(!(sender instanceof Player)) {

            plugin.sendMessage(sender, "Console cannot see ranks.");
            return;
        }
        GuildMember gMember = gHandler.getGuildMember(sender.getName());

        if(gMember == null) {
            plugin.sendMessage(sender, "You must be in a guild to list ranks.");
            return;
        }

        Guild guild = gMember.getGuild();

        StringBuilder sb = new StringBuilder("Ranks: ");

        String delim = "";
        for(GuildRank rank : guild.getRanks()) {
            sb.append(delim).append(rank.getColour() + rank.getName() + ChatColor.RESET);
            delim = ", ";
        }
        plugin.sendMessage(sender, sb.toString());


    }
}