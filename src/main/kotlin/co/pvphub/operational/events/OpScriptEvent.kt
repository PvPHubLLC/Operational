package co.pvphub.operational.events

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

open class OpScriptEvent : Event() {
    override fun getHandlers() = handlerList
    companion object {
        val handlerList = HandlerList()
        fun getHandlers() = handlerList
    }
}