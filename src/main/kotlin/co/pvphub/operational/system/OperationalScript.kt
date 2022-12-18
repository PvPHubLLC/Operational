package co.pvphub.operational.system

import co.pvphub.operational.events.ScriptEndEvent
import co.pvphub.operational.events.ScriptReloadEvent
import co.pvphub.operational.events.ScriptStartEvent
import co.pvphub.operational.system.function.OperationalFunction
import co.pvphub.operational.system.function.OperationalListener
import co.pvphub.operational.system.vars.OperationalVariable
import org.bukkit.event.Event

class OperationalScript {
    val globals = hashMapOf<String, Any>()

    fun init() {
        fireEvent(ScriptStartEvent(this), ScriptStartEvent::class.java)
    }

    fun end() {
        fireEvent(ScriptEndEvent(this), ScriptEndEvent::class.java)
    }

    fun reload() {
        fireEvent(ScriptReloadEvent(this), ScriptReloadEvent::class.java)
        init()
        end()
    }

    fun func(name: String) : OperationalFunction? {
        val value = globals["fn::${name}"] ?: return null
        return try {
            value as OperationalFunction
        } catch (_: ClassCastException) {
            null
        }
    }

    fun <T> variable(name: String) : OperationalVariable<T>? {
        val value = globals["gl::${name}"] ?: return null
        if (value is OperationalVariable<*>)
            return try {
                (value as OperationalVariable<T>)
            } catch (_: ClassCastException) {
                null
            }
        return null
    }

    fun <T: Event> fireEvent(event: T, clazz: Class<T>) {
        val value = globals["ev::${clazz.name}"] ?: return
        if (value is OperationalListener) {
            try {
                value.run(event)
            } catch (e: ClassCastException) {
                e.printStackTrace()
            }
        }
    }

}