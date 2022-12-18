package co.pvphub.operational.types

import org.bukkit.World

interface Location {
    fun x() : Double
    fun x(x: Double)
    fun y() : Double
    fun y(y: Double)
    fun z() : Double
    fun z(z: Double)
    fun blockX() : Int
    fun blockY() : Int
    fun blockZ() : Int
    fun pitch() : Double
    fun pitch(p: Double)
    fun yaw() : Double
    fun yaw(y: Double)
    fun world() : World = throw IncorrectContextException()
}