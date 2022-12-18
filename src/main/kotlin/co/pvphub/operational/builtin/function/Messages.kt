package co.pvphub.operational.builtin.function

import co.pvphub.operational.api.OpFunction
import co.pvphub.operational.system.OperationalContext
import org.bukkit.entity.Player

class Messages {

    @OpFunction(regexes = ["send(\\s|\\()(\\\"|\\').+(\\\"|\\')(\\sto\\s\\w+)?"])
    fun send(context: OperationalContext, message: String) {
        val player: Player? = context["player"]
        player?.sendMessage(message)
    }

}