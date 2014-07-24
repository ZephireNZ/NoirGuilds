package me.zephirenz.noirguilds.database.queries.guild;

import me.zephirenz.noirguilds.database.queries.GuildsQuery;
import me.zephirenz.noirguilds.objects.Guild;
import nz.co.noirland.zephcore.Util;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class UpdateGuildQuery extends GuildsQuery {

    private static final String QUERY = "UPDATE {PREFIX}_guilds WHERE id=? SET tag=?, name=?, balance=?, motd=?, hq=?, kills=?, deaths=?;";

    public UpdateGuildQuery(Guild guild) {
        super(8, QUERY);
        setValue(1, guild.getId());
        setValue(2, guild.getTag());
        setValue(3, guild.getName());
        setValue(4, guild.getBalance());
        setValue(5, JSONValue.toJSONString(guild.getMotd()));
        if(guild.getHQ() != null) {
            JSONObject hq = new JSONObject();
            hq.putAll(Util.toMap(guild.getHQ()));
            setValue(6, hq.toString());
        } else {
            setValue(6, null);
        }
        setValue(7, guild.getKills());
        setValue(8, guild.getDeaths());
    }

}
