package co.pvphub.operational.gui

import co.pvphub.operational.system.adapter.OperationalAdapter
import co.pvphub.operational.utils.extract
import co.pvphub.operational.utils.removeInitialWhitespace

class GuiAdapter : OperationalAdapter(
    "gui\\((\\d+|\\w)+\\)\\s?\\{(\\n|.)*}".toRegex()
) {
    var buttons = arrayListOf<GuiButtonAdapter>()
    var rows: Int = 0
//    var guiType: InventoryType? = null

    fun parse(lines: List<String>) : GuiAdapter {
        rows = lines[0].extract("gui\\(", "\\)") { toIntOrNull() } ?: -1
//        if (rows == -1) {
//            guiType = lines[0].extract("gui\\(", "\\)") { InventoryType.valueOf(uppercase().replace(" ", "_")) } ?: null
//        }
        val sublist = lines.toList().subList(1, lines.size - 1).toMutableList()
        // We can expect that every single block in here is another block
        forEveryLine(sublist, { GuiButtonAdapter.regex.matches(it) }) {
            buttons += GuiButtonAdapter().parse(it)
        }
        return this
    }
}
fun forEveryLine(list: MutableList<String>, match: (String) -> Boolean, onMatch: (List<String>) -> Unit) {
    var stringBuilder = ""
    while (list.isNotEmpty()) {
        stringBuilder += "${if (stringBuilder.isEmpty()) "" else "\n"}${list[0].removeInitialWhitespace()}"
        list.removeAt(0)
        if (match(stringBuilder)) {
            onMatch(stringBuilder.split("\n"))
            stringBuilder = ""
        }
    }
}