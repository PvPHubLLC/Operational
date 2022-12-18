package co.pvphub.operational.types

import org.bukkit.Location
import org.bukkit.World
import java.util.UUID

interface Player {
    fun ping() : Int
    fun username() : String
    fun uniqueId() : UUID
    fun location() : Location
    fun world() : World? = location().world
    fun sendMessage(vararg messages: String) = messages.forEach { sendMessage(it) }
    fun sendMessage(message: String)
    fun title(title: String, subtitle: String, fadeIn: Long = 10L, stay: Long = 30L, fadeOut: Long = 10L)
    fun teleport(location: Location)
}