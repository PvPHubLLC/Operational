package co.pvphub.operational.gui

import co.pvphub.operational.system.adapter.OperationalAdapter
import co.pvphub.operational.utils.extract

class GuiButtonAdapter : OperationalAdapter(regex) {

    var material: String = "AIR"
    var amount: Int = 1
    var slot: Int = -1

    fun parse(lines: List<String>): GuiButtonAdapter {
        material = lines[0].extract("button\\(", "\\)\\s?\\{") { uppercase().replace(" ", "_") } ?: "AIR"
        amount = lines.firstOrNull { it.matches(variable("amount").toRegex()) }?.extract("amount\\s?=\\s?") { toIntOrNull() } ?: 1
        slot = lines.firstOrNull { it.matches(variable("slot").toRegex()) }?.extract("slot\\s?=\\s?") { toIntOrNull() } ?: -1
        return this
    }

    fun variable(name: String) = "$name\\s?=\\s?.+"

    companion object {
        val regex = "button\\(\\w+\\)\\s?\\{(\\n|.)+}".toRegex()
    }
}