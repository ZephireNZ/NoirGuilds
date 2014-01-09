package me.zephirenz.noirguilds.commands.grank;

import me.zephirenz.noirguilds.GuildsHandler;
import me.zephirenz.noirguilds.NoirGuilds;
import me.zephirenz.noirguilds.database.DatabaseManager;
import me.zephirenz.noirguilds.database.DatabaseManagerFactory;
import me.zephirenz.noirguilds.enums.RankPerm;
import me.zephirenz.noirguilds.objects.GuildMember;
import me.zephirenz.noirguilds.objects.GuildRank;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankEditCommandlet {

    private final NoirGuilds plugin;
    private final GuildsHandler gHandler;
    private final DatabaseManager dbManager;

    public RankEditCommandlet() {
        this.plugin = NoirGuilds.inst();
        this.gHandler = plugin.getGuildsHandler();
        this.dbManager = DatabaseManagerFactory.getDatabaseManager();
    }


    /**
     *  The commandlet for editing a rank.
     *  Usage: /grank edit [rank] [option] [value]
     *
     *  @param sender the sender of the command
     *  @param args   commandlet-specific args
     */
    public void run(CommandSender sender, String[] args) {

        if(!(sender instanceof Player)) {

            plugin.sendMessage(sender, "Console cannot edit guild ranks.");
            return;
        }

        if(args.length != 3) {
            plugin.sendMessage(sender, "You must specify a rank, option and a value.");
            return;
        }
        String rankName = args[0];
        String option = args[1];
        String value = args[2];

        GuildMember mSender = gHandler.getGuildMember(sender.getName());
        if(mSender == null) {
            plugin.sendMessage(sender, "You must be in a guild to edit ranks.");
            return;
        }
        if(!mSender.getRank().isLeader()) {
            plugin.sendMessage(sender, "Only guild leaders can edit ranks.");
            return;
        }

        GuildRank rank = null;
        for(GuildRank r : mSender.getGuild().getRanks()) {
            if(r.getName().equalsIgnoreCase(rankName)) {
                rank = r;
                break;
            }
        }
        if(rank == null) {
            plugin.sendMessage(sender, "That rank doesn't exist.");
            return;
        }

        if(option.equalsIgnoreCase("colour")) {
            editColour(sender, rank, value);
        }else if(option.equalsIgnoreCase("name")) {
            editName(sender, rank, value);
        }else{
            editPerm(sender, rank, option, value);
        }

    }

    private void editPerm(CommandSender sender, GuildRank rank, String permName, String value) {

        RankPerm perm;
        try{
            perm = RankPerm.get(permName);
        }catch(IllegalArgumentException e) {
            plugin.sendMessage(sender, "Option doesn't exist.");
            return;
        }

        boolean val = Boolean.valueOf(value);
        rank.setPerm(perm, val);
        dbManager.updateRankPerm(rank, perm, val);
        if(!val) {
            plugin.sendMessage(sender, rank.getName() + " no longer has " + perm.getPerm() + " permission.");
        }else{
            plugin.sendMessage(sender, rank.getName() + " now has " + perm.getPerm() + " permission.");
        }
    }

    private void editColour(CommandSender sender, GuildRank rank, String value) {

        ChatColor colour;
        try{
            colour = ChatColor.valueOf(value);
        }catch(IllegalArgumentException e) {
            plugin.sendMessage(sender, "Not a valid colour code.");
            return;
        }

        rank.setColour(colour);
        dbManager.updateRankColour(rank, colour);
        plugin.sendMessage(sender, "Rank's colour now set to " + colour + colour.toString());

    }
    private void editName(CommandSender sender, GuildRank rank, String value) {

        for(GuildRank r : rank.getGuild().getRanks()) {
            if(r.getName().equalsIgnoreCase(value)) {
                plugin.sendMessage(sender, "A rank by that name already exists.");
                return;
            }
        }
        if(value.contains(".")) {
            plugin.sendMessage(sender, "Rank names may not contain full stops.");
            return;
        }

        dbManager.updateRankName(rank, value);
        rank.setName(value);
        plugin.sendMessage(sender, "Rank's name now set to " + value);

    }

}
