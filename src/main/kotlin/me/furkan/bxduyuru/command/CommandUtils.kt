package me.furkan.bxduyuru.command

import org.bukkit.command.CommandSender

object CommandUtils {
    fun hasPermission(sender: CommandSender, permission: String): Boolean {
        if (!sender.hasPermission(permission)) {
            sender.sendMessage("Bu komutu kullanmak için yeterli yetkiniz yok.")
            return false
        }
        return true
    }
}