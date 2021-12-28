package ridev.com.br.group.api;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

public class GroupStarter {

    private final Configuration config;
    private final ConfigurationSection section;
    public GroupStarter(JavaPlugin plugin, Configuration config, ConfigurationSection section) {
        Bukkit.getScheduler().runTask(plugin, this::loadAllGroups);
        this.section = section;
        this.config = config;
    }

    public void loadAllGroups() {
            int i = 0;
            for (String s : this.section.getKeys(false)) {
                boolean bd = this.config.getBoolean("cargos." + s + ".broadcast_lobby");
                if (this.config.get("cargos." + s + ".broadcast_lobby") == null) {
                    bd = false;
                }
                String perm = this.config.getString("cargos." + s + ".Permissao");
                if (this.config.getString("cargos." + s + ".Permissao").equalsIgnoreCase("empty") || this.config.getString("cargos." + s + ".Permissao").isEmpty())
                    perm = "empty";
                Group gp = new Group(this.config.getString("cargos." + s + ".Nome"), perm, this.config.getString("cargos." + s + ".Prefix"), bd, i);
                gp.createGroup();
                i++;
            }
        }
}
