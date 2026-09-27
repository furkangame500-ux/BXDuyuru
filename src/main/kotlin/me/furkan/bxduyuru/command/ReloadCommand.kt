package me.furkan.bxduyuru.command

import me.furkan.bxduyuru.BXDuyuru
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class ReloadCommand(private val plugin: BXDuyuru) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (!CommandUtils.hasPermission(sender, BXDuyuru.ADMIN_PERMISSION)) {
            return true
        }
        plugin.reloadConfigs(false)
        sender.sendMessage("Ayarlar başarıyla yenilendi.")
        return true
    }

}