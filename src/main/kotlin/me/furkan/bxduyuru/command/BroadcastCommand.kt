package me.furkan.bxduyuru.command

import me.furkan.bxduyuru.BXDuyuru
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class BroadcastCommand(private val plugin: BXDuyuru) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (!CommandUtils.hasPermission(sender, BXDuyuru.ADMIN_PERMISSION)) {
            return true
        }
        if (args.isEmpty()) {
            sender.sendMessage("Lütfen bir duyuru adı belirtin.")
            return true
        }
        val key = args[0]
        val broadcast = plugin.getForcedBroadcasts()[key]
        if (broadcast == null) {
            sender.sendMessage("Geçersiz duyuru adı.")
            return true
        }
        plugin.foliaLib.impl.runNextTick { plugin.broadcastMessage(key, broadcast) }
        return true
    }
}
