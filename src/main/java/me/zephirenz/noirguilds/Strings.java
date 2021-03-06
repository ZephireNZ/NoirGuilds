package me.zephirenz.noirguilds;

import org.bukkit.ChatColor;

public class Strings {

    public static final String DEFAULT_LEADER = "Leader";
    public static final String DEFAULT_DEFAULT = "Default";
    public static final String MESSAGE_PREFIX = ChatColor.RED + "[NoirGuilds] " + ChatColor.RESET;

    public static final String RANK_NOT_EXISTS = "That rank doesn't exist.";
    public static final String RANK_EXISTS = "That rank already exists.";
    public static final String NO_CONSOLE = "The console cannot use that command.";
    public static final String NO_INVITE = "You have no pending guild invite.";
    public static final String GUILD_AT_MAX = "The guild has reached it's maximum of %s members.";
    public static final String GUILD_NOT_EXISTS = "That guild does not exist.";
    public static final String GUILD_EXISTS = "A guild with that name already exists.";
    public static final String TAG_EXISTS = "A guild with that tag already exists.";
    public static final String BIG_TAG = "Tags must be a maximum of 4 characters.";
    public static final String PLAYER_NOT_ONLINE = "Player does not exist or is not online.";
    public static final String NO_COMMAND = "Command not found.";
    public static final String BANKS_NOT_ENABLED = "Guild Banks are not enabled.";

    public static final String RANK_CREATE_NO_GUILD = "You must be in a guild to create ranks.";
    public static final String RANK_CREATE_NOT_LEADER = "Only guild leaders can create ranks.";
    public static final String RANK_CREATE__WRONG_ARGS = "You must only specify a rank name.";
    public static final String RANK_CREATE_CREATED = "%s" + ChatColor.RESET + " rank has been created.";

    public static final String RANK_DELETE_NO_GUILD = "You must be in a guild to delete ranks.";
    public static final String RANK_DELETE_NOT_LEADER = "Only guild leaders can delete ranks.";
    public static final String RANK_DELETE_WRONG_ARGS = "You must only specify a rank name.";
    public static final String RANK_DELETE_DELETED = "%s" + ChatColor.RESET + " rank has been deleted.";
    public static final String RANK_DELETE_DEFAULT = "You can't delete the default rank.";
    public static final String RANK_DELETE_LEADER = "You can't delete the leader rank.";
    public static final String RANK_DELETE_RANK_DELETED = "Your rank has been deleted, you are now %s";

    public static final String RANK_EDIT_NO_GUILD = "You must be in a guild to edit ranks.";
    public static final String RANK_EDIT_NOT_LEADER = "Only guild leaders can edit ranks.";
    public static final String RANK_EDIT_WRONG_ARGS = "You must specify a rank, option and a value.";
    public static final String RANK_EDIT_CREATED = "%s" + ChatColor.RESET + " rank has been created.";
    public static final String RANK_EDIT_BAD_OPTION = "That option does not exist.";
    public static final String RANK_EDIT_NO_PERM = "%s no longer has %s permission.";
    public static final String RANK_EDIT_PERM = "%s now has %s permission.";
    public static final String RANK_EDIT_BAD_COLOUR = "Not a valid colour code. (see http://dft.ba/-chatcolours)";
    public static final String RANK_EDIT_SET_COLOUR = "Rank's colour now set to %s";
    public static final String RANK_EDIT_SET_NAME = "Rank's name now set to %s";

    public static final String RANK_LIST_NO_GUILD = "You must be in a guild to list ranks.";

    public static final String RANK_SET_WRONG_ARGS = "You must specify a member and rank to promote them to.";
    public static final String RANK_SET_NO_GUILD = "You must be in a guild to set a player's rank.";
    public static final String RANK_SET_TARGET_NO_GUILD = "That player is not in a guild.";
    public static final String RANK_SET_NOT_LEADER = "You must be the leader to edit a member's rank.";
    public static final String RANK_SET_NOT_SAME = "You must be in the same guild to edit a member's rank.";
    public static final String RANK_SET_RANK_IS_LEADER = "You cannot change the leader's rank.";
    public static final String RANK_SET_CHANGED = "%s's rank was changed to %s";

    public static final String GUILD_ACCEPT_JOINED = "%s" + ChatColor.RESET + " has joined the guild!";

    public static final String GUILD_DENY_DENIED = "Your invite to %s has been denied.";

    public static final String GUILD_BANK_NO_GUILD = "You must be in a guild to see its Bank.";
    public static final String GUILD_BANK_DEPOSITED = "Deposited %s into guild bank.";
    public static final String GUILD_BANK_WITHDREW = "Withdrew %s from guild bank.";

    public static final String GUILD_PAY_NO_GUILD = "You must be in a guild to pay another guild.";
    public static final String GUILD_PAY_NO_PERMS = "You don't have permission to pay another guild.";
    public static final String GUILD_PAY_WRONG_ARGS = "You must specify a guild's name and amount to pay.";
    public static final String GUILD_PAY_SUCCESSFUL = "Sent %s to %s.";
    public static final String GUILD_PAY_RECIEVED = "Guild recieved %s from %s.";
    public static final String GUILD_PAY_INSUFFICIENT_BALANCE = "Your guild doesn't have enough money, you need %s.";
    public static final String GUILD_PAY_SELF = "You can't pay your own guild!";
    public static final String GUILD_PAY_NEGATIVE_AMOUNT = "You cannot 'pay' a guild a negative amount!";
    public static final String GUILD_PAY_ZERO_AMOUNT = "You cannot 'pay' a guild a zero amount!";

    public static final String GUILD_CREATE_WRONG_ARGS = "You must specify a guild name and guild tag (of up to 4 characters).";
    public static final String GUILD_CREATE_CONSOLE_LEADER = "Console must specify a leader";
    public static final String GUILD_CREATE_NO_PERMS = "You don't have permission to create guilds.";
    public static final String GUILD_CREATE_IN_GUILD = "Already in a guild!";
    public static final String GUILD_CREATE_CREATED = "%s has just founded %s";

    public static final String GUILD_DISBAND_NO_GUILD = "You must be in a guild to leave it.";
    public static final String GUILD_DISBAND_NOT_LEADER = "You must be the leader to disband your guild.";
    public static final String GUILD_DISBAND_CONSOLE_GUILD = "Console must specify a guild to disband.";
    public static final String GUILD_DISBAND_DISBANDED = "%s has been disbanded.";

    public static final String GUILD_EDIT_WRONG_ARGS = "You must specify an option and a value.";
    public static final String GUILD_EDIT_NO_GUILD = "You must be in a guild to edit it.";
    public static final String GUILD_EDIT_NOT_LEADER = "You must be the leader of your guild to edit it.";
    public static final String GUILD_EDIT_TAGS_DISABLED = "Changing tags is currently disbled. (Sorry!)";
    public static final String GUILD_EDIT_NAME_CHANGED = "Guild name changed to " + ChatColor.BLUE + "%s";
    public static final String GUILD_EDIT_TAG_CHANGED = "Guild tag changed to " + ChatColor.GRAY + "[%s]";

    public static final String GUILD_LIST_NO_GUILD = "You are not in a Guild, please use " + ChatColor.DARK_GRAY + "/guild info [guild]";

    public static final String GUILD_INVITE_WRONG_ARGS = "You must specify a player to invite.";
    public static final String GUILD_INVITE_NO_GUILD = "You must be in a guild to invite players.";
    public static final String GUILD_INVITE_TARGET_IN_GUILD = "That player is already in a guild.";
    public static final String GUILD_INVITE_NO_PERMS = "You do not have permission to invite players.";
    public static final String GUILD_INVITE_INVITED = "You have been invited to join " + ChatColor.BLUE + "%s" + ChatColor.RESET + " by %s";
    public static final String GUILD_INVITE_CMD_HELP = "To accept the invitation, do " + ChatColor.DARK_GRAY + "/guild accept";
    public static final String GUILD_INVITE_SENT = "Your invitation has been sent.";
    public static final String GUILD_INVITE_EXPIRED = "Your invite to %s has expired.";

    public static final String GUILD_KICK_WRONG_ARGS = "You must specify a player to kick.";
    public static final String GUILD_KICK_NO_GUILD = "You must be in a guild to kick players.";
    public static final String GUILD_KICK_BAD_TAGET = "Player must be in your guild to kick.";
    public static final String GUILD_KICK_LEADER = "You can't kick the guild leader.";
    public static final String GUILD_KICK_NO_PERMS = "You do not have permission to kick players.";
    public static final String GUILD_KICK_KICKED =  "%s was kicked from the guild.";

    public static final String GUILD_LEAVE_NO_GUILD = "You must be in a guild to leave it.";
    public static final String GUILD_LEAVE_LEADER = "Leaders cannot leave their own guild.";
    public static final String GUILD_LEAVE_PLAYER_LEFT = "You have left %s";
    public static final String GUILD_LEAVE_GUILD_LEFT = "%s left the guild.";

    public static final String GUILD_MOTD_WRONG_ARGS = "You must specify a line and text to set the MOTD.";
    public static final String GUILD_MOTD_NO_GUILD = "You must be in a guild to edit the MOTD.";
    public static final String GUILD_MOTD_NOT_LEADER = "You must be the leader of your guild to edit the MOTD.";
    public static final String GUILD_MOTD_BAD_LINE = "Not a valid line number.";
    public static final String GUILD_MOTD_UPDATED = "Updated guild MOTD.";

    public static final String GUILD_UPGRADE_NO_GUILD = "You must be in a guild to upgrade it.";
    public static final String GUILD_UPGRADE_NOT_LEADER = "You must be the leader of your guild to upgrade it.";
    public static final String GUILD_UPGRADE_INFO = "To upgrade to %s members you must have %s in your guild's bank. Run " + ChatColor.ITALIC + "/guild upgrade" + ChatColor.RESET +" again to upgrade.";
    public static final String GUILD_UPGRADE_INSUFFICIENT_MONEY = "Your guild does not have enough money to upgrade.";
    public static final String GUILD_UPGRADE_COMPLETE = "Your guild has now been upgraded to %s members.";

    public static final String GUILD_CHAT_NO_GUILD = "You are not currently in a guild.";
    public static final String GUILD_CHAT_NAME_FORMAT = ChatColor.GRAY + " [%s%s" + ChatColor.GRAY + "] " + ChatColor.RESET + "%s"+ ChatColor.RED + ":" + ChatColor.RESET + " ";
    public static final String GUILD_CHAT_FORMAT = ChatColor.RED + "[G]" + GUILD_CHAT_NAME_FORMAT;
    public static final String GUILD_ACHAT_FORMAT = ChatColor.GREEN + "[A]" + GUILD_CHAT_NAME_FORMAT;
    public static final String GUILD_ACHAT_NO_PERMS = "You haven't got permission to use Guild Admin chat.";

    public static final String HQ_NO_GUILD = "You must be in a guild to use HQ's.";
    public static final String HQ_NO_PERMS = "You don't have permission to teleport to the HQ.";
    public static final String HQ_NOT_LEADER = "You must be the leader of your guild to create HQ's.";
    public static final String HQ_NO_HQ = "No HQ set for guild.";
    public static final String HQ_TELEPORTING = ChatColor.GOLD + "Teleporting to HQ...";
    public static final String HQ_SET = "Your guild's HQ has been set here.";

    public static final String FLAG_PVP_GUILD_TAKEN = ChatColor.GOLD + "%s" + ChatColor.RESET +" was taken from your guild.";
    public static final String FLAG_PVP_PLAYER_TAKEN = ChatColor.GOLD + "%s" + ChatColor.RESET +" was taken from your balance.";
    public static final String FLAG_PVP_WON = ChatColor.GOLD + "%s" + ChatColor.RESET +" was given to your guild for winning.";
}
