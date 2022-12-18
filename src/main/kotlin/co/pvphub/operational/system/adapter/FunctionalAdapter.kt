package co.pvphub.operational.system.adapter

import co.pvphub.operational.system.OperationalExecutable
import co.pvphub.operational.system.function.OperationalFunction

abstract class FunctionalAdapter(vararg regex: Regex) : OperationalAdapter(*regex) {
    protected val executes = arrayListOf<OperationalExecutable>()

    abstract fun parse(lines: Array<String>) : FunctionalAdapter

}