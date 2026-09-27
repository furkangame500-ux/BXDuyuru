# BXDuyuru

Paper/Folia sunucuları için Türkçe otomatik ve manuel duyuru eklentisi.

## Komutlar
- `/duyuru <mesaj>` — Anında duyuru gönderir.
- `/duyuru reload` — Ayarları yeniler.
- `/duyuru broadcast <isim>` — Kayıtlı duyuruyu gönderir.
- `/duyuru interval get` — Otomatik duyuru aralığını gösterir.
- `/duyuru interval set <saniye>` — Aralığı değiştirir.
- `/duyuru bossbar ...` — BossBar duyurularını yönetir.
- `/duyuru yardim` — Yardımı gösterir.

## Yetkiler
`bxduyuru.admin` — Yönetici komutları.
`bxduyuru.ignore` — Duyuruları görmeme.

## Gereksinimler
Paper veya Folia, Java 17+ ve 1.20+.

## Proje adı
BXDuyuru


---

## English Description

# BXDuyuru

BXDuyuru is a modern, lightweight, and highly customizable announcement plugin designed for Minecraft servers that need a reliable way to communicate important information to their players.

With BXDuyuru, server administrators can easily send instant announcements to all online players using the simple `/duyuru <message>` command. Whether you want to inform your community about a server update, announce an upcoming event, remind players about your rules, share your Discord server, or simply display useful server information, BXDuyuru provides an easy and flexible solution.

## 📢 Server-Wide Announcements

Send announcements instantly to every player currently online.

Simply use:

`/duyuru <message>`

For example:

`/duyuru Merhaba, sunucumuza hoş geldiniz!`

This allows staff members to quickly communicate with the entire server without complicated commands or setup.

## ⏰ Automatic Announcements

BXDuyuru can also be used for automatic server announcements.

Create your own announcement messages and configure the interval at which they should appear. This is perfect for servers that regularly want to display information such as:

* Server rules
* Discord information
* Store advertisements
* Events
* Server updates
* Gameplay tips
* Community messages
* Important notifications

## 🎨 Fully Customizable

BXDuyuru is designed to give server owners control over their announcement system.

Messages and settings can be customized through configuration files, allowing you to create announcements that match your server's style and community.

You can customize your messages without having to modify the plugin's source code.

## 🔐 Permission Support

BXDuyuru includes permission support so you can control who is allowed to use administrative commands.

The main permission is:

`bxduyuru.admin`

