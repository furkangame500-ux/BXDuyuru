package me.furkan.bxduyuru.command

import me.furkan.bxduyuru.BXDuyuru
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class CustomBroadcastCommand(private val plugin: BXDuyuru) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (!CommandUtils.hasPermission(sender, BXDuyuru.ADMIN_PERMISSION)) {
            return true
        }
        if (args.isEmpty()) {
            sender.sendMessage("Lütfen gönderilecek duyuru mesajını yazın.")
            return true
        }
        val message = List(1) { args.joinToString(" ")}
        plugin.foliaLib.impl.runNextTick { plugin.broadcastMessage("null", message) }
        return true
    }
}
