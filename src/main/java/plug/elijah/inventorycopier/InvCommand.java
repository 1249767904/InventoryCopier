package plug.elijah.inventorycopier;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;

public class InvCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "InventoryCopier" + ChatColor.BLUE + "]" + ChatColor.RED + "该指令为玩家指令！");
            return true;
        }
        Player sd = (Player)sender;
        sender.sendMessage("你的名字: " + sd.getName());
        if(args.length == 1){
            String nick = args[0];
            sender.sendMessage("被复制玩家名: " + nick);
            for(Player p : Bukkit.getOnlinePlayers()){
                if(nick.equals(p.getName())){
                    // 处理背包复制
                        sd.getInventory().setContents(p.getInventory().getContents());
                        sender.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "InventoryCopier" + ChatColor.BLUE + "] " + ChatColor.GREEN + "复制完成！");
                }else if(!(nick.equals(p.getName()))){
                    sender.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "InventoryCopier" + ChatColor.BLUE + "] " + ChatColor.RED + "玩家不存在或名称不完整！");
                    sender.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "InventoryCopier" + ChatColor.BLUE + "] " + ChatColor.RED + "正确的使用方法: " + ChatColor.GREEN + "/ic <玩家名>");
                    sender.sendMessage(ChatColor.RED + "注意！请输入玩家完整名称以确认复制对象！");
                }
            }
        } else if (args.length >= 1) {
            sender.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "InventoryCopier" + ChatColor.BLUE + "] " + ChatColor.RED + "指令参数过多！ ");
            sender.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "InventoryCopier" + ChatColor.BLUE + "] " + ChatColor.RED + "正确的使用方法: " + ChatColor.GREEN + "/ic <玩家名>");
            sender.sendMessage(ChatColor.RED + "注意！请输入玩家完整名称以确认复制对象！");
            return true;
        }else {
            sender.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "InventoryCopier" + ChatColor.BLUE + "] " + ChatColor.GREEN + "使用方法: /ic <玩家名>");
        }
        return true;
    }
}