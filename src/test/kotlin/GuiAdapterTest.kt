import co.pvphub.operational.gui.GuiAdapter

fun main() {
    val gui = GuiAdapter().parse(
        listOf(
            "gui(5) {",
            "   button(paper) {" +
            "       amount = 4",
            "       slot = 2",
            "   }",
            "   button(diamond_sword) {",
            "       amount = 64",
            "       slot = 3",
            "   }",
            "}"
        )
    )
    println(gui.buttons.size)
}