package me.zephirenz.noirguilds.commands.guild;

import me.zephirenz.noirguilds.commands.Commandlet;
import me.zephirenz.noirguilds.database.GuildsDatabase;
import me.zephirenz.noirguilds.objects.Guild;
import me.zephirenz.noirguilds.objects.GuildMember;
import nz.co.noirland.zephcore.Util;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.zephirenz.noirguilds.Strings.*;

public class GuildLeaveCommandlet extends Commandlet {

    /**
     *  The commandlet for leaving a guild.
     *  Usage: /guild leave
     */
    @Override
    public void run(CommandSender sender, String[] args) {
        if(isNotPlayer(sender, NO_CONSOLE)) return;

        GuildMember member = gHandler.getMember((Player) sender);

        if(isNull(member, sender, GUILD_LEAVE_NO_GUILD)) return;
        Guild guild = member.getGuild();
        if(member.getRank().isLeader()) {
            plugin.sendMessage(sender, GUILD_LEAVE_LEADER);
            return;
        }

        guild.removeMember(member);
        GuildsDatabase.inst().removeMember(member);
        guild.sendMessage(String.format(GUILD_LEAVE_GUILD_LEFT, Util.player(member.getPlayer()).getName()), true);
        plugin.sendMessage(sender, String.format(GUILD_LEAVE_PLAYER_LEFT, guild.getName()));

    }

}
