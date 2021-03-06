package me.zephirenz.noirguilds.commands;

import me.zephirenz.noirguilds.GuildsHandler;
import me.zephirenz.noirguilds.NoirGuilds;
import me.zephirenz.noirguilds.enums.RankPerm;
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

public class GuildAdminChatCommand extends Commandlet implements CommandExecutor {

    private final NoirGuilds plugin;
    private final GuildsHandler gHandler;

    public GuildAdminChatCommand() {
        this.plugin = NoirGuilds.inst();
        this.gHandler = plugin.getGuildsHandler();
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(isNotPlayer(sender, NO_CONSOLE)) return true;
        Player player = (Player) sender;
        GuildMember member = gHandler.getMember(player);
        if(isNull(member, sender, GUILD_CHAT_NO_GUILD)) return true;

        GuildRank rank = member.getRank();
        if(!member.hasPerm(RankPerm.ADMINCHAT)) {
            plugin.sendMessage(sender, GUILD_ACHAT_NO_PERMS);
            return true;
        }

        String prefix = String.format(GUILD_ACHAT_FORMAT, rank.getColour(), rank.getName(), player.getName());
        String msg = Util.concatenate(prefix, Arrays.asList(args), "", " ");
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        if (msg.length() == prefix.length()) {
            return false;
        }
        for(GuildRank r : member.getGuild().getRanks()) {
            if(r.hasPerm(RankPerm.ADMINCHAT)) {
                r.sendMessage(msg, false);
            }
        }
        return true;
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        onCommand(sender, null, "", args);
    }
}

