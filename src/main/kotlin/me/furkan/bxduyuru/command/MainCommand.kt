package me.furkan.bxduyuru.command

import me.furkan.bxduyuru.BXDuyuru
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class MainCommand(private val plugin: BXDuyuru) : CommandExecutor, TabCompleter {
    private val reloadCommand = ReloadCommand(plugin)
    private val broadcastCommand = BroadcastCommand(plugin)
    private val intervalCommand = IntervalCommand(plugin)
    private val customBroadcastCommand = CustomBroadcastCommand(plugin)
    private val bossBarCommand = BossBarCommand(plugin)

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (args.isEmpty()) {
            sender.sendMessage("§8§m------------------------------")
            sender.sendMessage("§b§lBXDuyuru §7- Komutlar")
            sender.sendMessage("§e/duyuru <mesaj> §7- Oyunculara duyuru gönderir.")
            sender.sendMessage("§e/duyuru reload §7- Ayarları yeniler.")
            sender.sendMessage("§e/duyuru broadcast <isim> §7- Kayıtlı duyuruyu gönderir.")
            sender.sendMessage("§e/duyuru interval get/set <saniye> §7- Otomatik duyuru aralığını yönetir.")
            sender.sendMessage("§e/duyuru bossbar ... §7- BossBar duyurularını yönetir.")
            sender.sendMessage("§8§m------------------------------")
            return true
        }

        return when (args[0].lowercase()) {
            "reload", "yenile" ->
                reloadCommand.onCommand(sender, command, label, args.drop(1).toTypedArray())
            "broadcast", "kayıtlı", "kayitli" ->
                broadcastCommand.onCommand(sender, command, label, args.drop(1).toTypedArray())
            "interval", "aralık", "aralik" ->
                intervalCommand.onCommand(sender, command, label, args.drop(1).toTypedArray())
            "custom", "özel", "ozel" ->
                customBroadcastCommand.onCommand(sender, command, label, args.drop(1).toTypedArray())
            "bossbar" ->
                bossBarCommand.onCommand(sender, command, label, args.drop(1).toTypedArray())
            "yardım", "yardim", "help" -> {
                onCommand(sender, command, label, emptyArray())
                true
            }
            else -> customBroadcastCommand.onCommand(sender, command, label, args)
        }
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): MutableList<String> {
        if (args.size == 1) {
            return listOf("reload", "broadcast", "interval", "custom", "bossbar", "yardim")
                .filter { it.startsWith(args[0], ignoreCase = true) }
                .toMutableList()
        }
        if (args.size >= 2 && args[0].equals("bossbar", ignoreCase = true)) {
            return bossBarCommand.onTabComplete(sender, command, alias, args.drop(1).toTypedArray())
        }
        if (args.size == 2 && args[0].equals("broadcast", ignoreCase = true)) {
            return plugin.getForcedBroadcasts().keys
                .filter { it.startsWith(args[1], ignoreCase = true) }
                .toMutableList()
        }
        if (args.size == 2 && args[0].equals("interval", ignoreCase = true)) {
            return mutableListOf("get", "set")
                .filter { it.startsWith(args[1], ignoreCase = true) }
                .toMutableList()
        }
        return mutableListOf()
    }
}
