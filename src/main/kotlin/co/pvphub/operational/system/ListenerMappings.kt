package co.pvphub.operational.system

import co.pvphub.operational.system.function.OperationalListener
import org.bukkit.event.Event
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerLoginEvent
import org.bukkit.event.player.PlayerQuitEvent

object ListenerMappings {
    private val mappings = hashMapOf<String, Class<*>>(
        "playerJoin" to PlayerJoinEvent::class.java,
        "playerLeave" to PlayerQuitEvent::class.java,
        "playerQuit" to PlayerQuitEvent::class.java,
        "chat" to AsyncPlayerChatEvent::class.java
    )

    operator fun plusAssign(pair: Pair<String, Class<*>>) {
        mappings += pair
    }

    operator fun minusAssign(id: String) {
        mappings.remove(id)
    }

    operator fun get(id: String) = mappings[id]

    operator fun set(id: String, clazz: Class<*>) {
        mappings[id] = clazz
    }
}