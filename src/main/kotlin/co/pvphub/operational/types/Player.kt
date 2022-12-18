package co.pvphub.operational.types

import org.bukkit.World
import java.util.UUID

interface Player {
    fun getPing() : Int
    fun getName() : String
    fun getUniqueId() : UUID
    fun getLocation() : Location = throw IncorrectContextException()
    fun getWorld() : World = getLocation().world()
}