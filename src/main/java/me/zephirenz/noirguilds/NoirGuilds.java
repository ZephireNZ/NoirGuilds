package me.zephirenz.noirguilds;

import me.zephirenz.noirguilds.commands.*;
import me.zephirenz.noirguilds.config.PluginConfig;
import me.zephirenz.noirguilds.database.DatabaseManager;
import me.zephirenz.noirguilds.database.DatabaseManagerFactory;
import me.zephirenz.noirguilds.listeners.PlayerChatListener;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class NoirGuilds extends JavaPlugin {

    private static NoirGuilds inst;
    private GuildsHandler guildsHandler;
    private DatabaseManager dbManager;

    @Override
    public void onEnable() {
        inst = this;
        this.dbManager = DatabaseManagerFactory.getDatabaseManager();
        guildsHandler = new GuildsHandler();
        addCommands();
        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
    }

    @Override
    public void onDisable() {
        dbManager.saveAll();
        dbManager.close();
    }

    public static NoirGuilds inst() {
        return inst;
    }

    public GuildsHandler getGuildsHandler() {
        return guildsHandler;
    }

    public void sendMessage(CommandSender sender, String msg) {

        sender.sendMessage(ChatColor.RED + "[NoirGuilds] " + ChatColor.RESET + msg);
    }

    public void sendGlobalMessage(String msg) {
        getServer().broadcastMessage(ChatColor.RED + "[NoirGuilds] " + ChatColor.RESET + msg);
    }

    public void debug(String msg) {
        if(PluginConfig.getInstance().getDebug()) {
            getLogger().info("[DEBUG] " + msg);
        }
    }

    private void addCommands() {
        getCommand("guild").setExecutor(new GuildCommand());
        getCommand("guilds").setExecutor(new GuildsCommand());
        getCommand("ga").setExecutor(new GuildAdminChatCommand());
        getCommand("g").setExecutor(new GuildChatCommand());
        getCommand("gtp").setExecutor(new GuildTpCommand());
        getCommand("gtphere").setExecutor(new GuildTpHereCommand());
        getCommand("grank").setExecutor(new GuildRankCommand());
        getCommand("hq").setExecutor(new HQCommand());
    }
}
