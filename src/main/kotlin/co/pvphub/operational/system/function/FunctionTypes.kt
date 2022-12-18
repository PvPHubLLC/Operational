package co.pvphub.operational.system.function

import co.pvphub.operational.types.Location
import co.pvphub.operational.types.Player
import org.bukkit.block.Block
import org.bukkit.inventory.ItemStack

enum class FunctionTypes(clazz: Class<*>) {
    STRING(String::class.java),
    INTEGER(Int::class.java),
    DOUBLE(Double::class.java),
    NUMBER(Number::class.java),
    PLAYER(Player::class.java),
    BLOCK(Block::class.java),
    LOCATION(Location::class.java),
    ITEM(ItemStack::class.java)
}