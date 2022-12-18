package co.pvphub.operational.system.function

import co.pvphub.operational.system.adapter.FunctionalAdapter
import co.pvphub.operational.system.OperationalContext

class OperationalFunction : FunctionalAdapter(
    "fu?n\\s\\w+\\((\\w+:\\s?\\w+(\\,\\s?\\w+:\\s?\\w+)*)?\\)\\s?\\{(.+|\\n)+}".toRegex()
) {

    override fun parse(lines: Array<String>): OperationalFunction {
        // Parse each line

        return OperationalFunction()
    }

    fun run(context: OperationalContext) {
        executes.forEach { it.run(context) }
    }
}