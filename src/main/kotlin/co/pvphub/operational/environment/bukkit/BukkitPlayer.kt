package co.pvphub.operational.environment.bukkit

import co.pvphub.operational.types.Player
import org.bukkit.Location
import java.util.*

class BukkitPlayer(val player: org.bukkit.entity.Player) : Player {
    override fun ping() = player.ping
    override fun username() = player.name
    override fun uniqueId() = player.uniqueId
    override fun location() = player.location
    override fun sendMessage(message: String) = player.sendMessage(message)
    override fun title(title: String, subtitle: String, fadeIn: Long, stay: Long, fadeOut: Long) =
        player.sendTitle(title, subtitle, fadeIn.toInt(), stay.toInt(), fadeOut.toInt())
    override fun teleport(location: Location) {
        player.teleport(location)
    }
}