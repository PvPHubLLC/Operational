import co.pvphub.operational.api.OpExtensionManager
import co.pvphub.operational.builtin.function.Math
import co.pvphub.operational.builtin.function.Messages
import co.pvphub.operational.system.function.OperationalListener

fun main() {
    val listener = OperationalListener().parse(
        arrayOf(
            "on(playerJoin) {",
            "   send 'Hello, %player%'",
            "}"
        )
    )
    println(listener.listenerType)

    OpExtensionManager.register(Messages())
}