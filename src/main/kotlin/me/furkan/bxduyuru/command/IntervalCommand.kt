package me.furkan.bxduyuru.command

import me.furkan.bxduyuru.BXDuyuru
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class IntervalCommand(private val plugin: BXDuyuru) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (!CommandUtils.hasPermission(sender, BXDuyuru.ADMIN_PERMISSION)) {
            return true
        }
        if (args.isEmpty()) {
            sender.sendMessage("Mevcut otomatik duyuru aralığı: ${plugin.getInterval()} saniye.")
            return true
        } else if (args[0].equals("get", ignoreCase = true)) {
            sender.sendMessage("Mevcut otomatik duyuru aralığı: ${plugin.getInterval()} saniye.")
        } else if (args[0].equals("set", ignoreCase = true)) {
            if (args.size < 2) {
                sender.sendMessage("Yeni aralığı saniye olarak belirtin.")
                return true
            }
            val newInterval = args[1].toLongOrNull()
            if (newInterval == null || newInterval <= 0) {
                sender.sendMessage("Geçersiz aralık. Pozitif bir sayı girin.")
                return true
            }
            plugin.config.set("interval", newInterval)
            plugin.saveConfig()
            plugin.reloadConfigs(false)
            sender.sendMessage("Otomatik duyuru aralığı $newInterval saniye olarak ayarlandı.")
        } else {
            sender.sendMessage("Geçersiz alt komut. `get` mevcut aralığı gösterir, `set` yeni aralık ayarlar.")
        }
        return true
    }
}