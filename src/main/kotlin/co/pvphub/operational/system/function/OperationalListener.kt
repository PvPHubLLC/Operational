package co.pvphub.operational.system.function

import co.pvphub.operational.system.ListenerMappings
import co.pvphub.operational.system.adapter.FunctionalAdapter
import co.pvphub.operational.utils.extract
import co.pvphub.operational.utils.removeInitialWhitespace

class OperationalListener : FunctionalAdapter(
    "on\\s?\\(\\w+\\)\\s?\\{(.|\n)+}".toRegex()
) {
    lateinit var listenerType: String

    override fun parse(lines: Array<String>): OperationalListener {
        listenerType = lines[0].extract("on\\s?\\(", "\\)\\s?\\{") { this } ?: "listener::null"
        // We now need to parse the inner part of the listener
        val sublist = lines.toList().subList(1, lines.size - 1).toMutableList()
        var stringBuilder = ""
        while (sublist.isNotEmpty()) {
            stringBuilder += "${if (stringBuilder.isEmpty()) "" else "\n"}${sublist[0].removeInitialWhitespace()}"
            sublist.removeAt(0)
            // todo Check if we can parse this section as-is
        }
        return this
    }

    fun run(event: Any) {
        // todo need a way to create a context for something (set variables) reflection?
//        val context = createContext()
//        executes.forEach { it.run(context) }
    }

    fun type() = ListenerMappings[listenerType]
}