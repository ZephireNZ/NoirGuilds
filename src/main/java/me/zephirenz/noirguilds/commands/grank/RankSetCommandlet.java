package me.zephirenz.noirguilds.commands.grank;

import me.zephirenz.noirguilds.Strings;
import me.zephirenz.noirguilds.commands.Commandlet;
import me.zephirenz.noirguilds.objects.Guild;
import me.zephirenz.noirguilds.objects.GuildMember;
import me.zephirenz.noirguilds.objects.GuildRank;
import nz.co.noirland.zephcore.Util;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.zephirenz.noirguilds.Strings.*;

public class RankSetCommandlet extends Commandlet {

    /**
     *  The commandlet for changing a member's rank.
     *  Usage: /grank set [player] [rank]
     */
    @Override
    public void run(CommandSender sender, String[] args) {
        if(isNotPlayer(sender, NO_CONSOLE)) return;

        if(args.length != 2) {
            plugin.sendMessage(sender, RANK_SET_WRONG_ARGS);
            return;
        }

        String promote = args[0];
        String rankName = args[1];

        GuildMember mSender = gHandler.getMember((Player) sender);
        GuildMember mPromote = gHandler.getMember(promote);

        if(isNull(mSender, sender, RANK_SET_NO_GUILD)) return;
        if(isNull(mPromote, sender, RANK_SET_TARGET_NO_GUILD)) return;

        if(!mSender.getRank().isLeader()) {
            plugin.sendMessage(sender, RANK_SET_NOT_LEADER);
            return;
        }

        if(mSender.getGuild() != mPromote.getGuild()) {
            plugin.sendMessage(sender, RANK_SET_NOT_SAME);
            return;
        }

        if(mPromote.getRank().isLeader()) {
            plugin.sendMessage(sender, RANK_SET_RANK_IS_LEADER);
            return;
        }

        Guild guild = mSender.getGuild();
        GuildRank newRank = null;

        for(GuildRank rank : guild.getRanks()) {
            if(rank.getName().equalsIgnoreCase(rankName)) {
                newRank = rank;
            }
        }
        if(isNull(newRank, sender, RANK_NOT_EXISTS)) return;

        mPromote.setRank(newRank);
        mPromote.updateDB();
        plugin.sendMessage(sender, String.format(Strings.RANK_SET_CHANGED, Util.player(mPromote.getPlayer()).getName(), newRank.getColour() + newRank.getName()));
    }

}
