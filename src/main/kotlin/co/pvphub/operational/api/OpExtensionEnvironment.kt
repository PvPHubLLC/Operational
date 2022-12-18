package co.pvphub.operational.api

enum class OpExtensionEnvironment(val id: String) {
    BUKKIT("bukkit"),
    VELOCITY("velocity");

    operator fun plus(other: OpExtensionEnvironment) = arrayOf(this, other)

    companion object {
        fun any() = values()
    }
}