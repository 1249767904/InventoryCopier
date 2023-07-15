package plug.elijah.inventorycopier;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Elijaaaaaah
 * 高三狗毕业,老年人康复训练插件
 */
public final class InventoryCopier extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info(ChatColor.RED + "InventoryCopier Enabled! By Elijaaaaaaah");
        Bukkit.getPluginCommand("ic").setExecutor(new InvCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(ChatColor.RED + "InventoryCopier Disabled!");
    }
}
