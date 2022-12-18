package co.pvphub.operational.utils

fun String.varname(vararg replace: Pair<String, String>): String {
    var str = lowercase().replace(" ", "_")
    replace.forEach { str = str.replace(it.first, it.second) }
    return str
}

inline fun <T : Any> String.extract(startReg: String, endReg: String? = null, parse: String.() -> T? = { null }): T? {
    var str = replace(".*$startReg".toRegex(), "")
    endReg?.let { str = str.replace("${it}.*".toRegex(), "") }
    return parse(str)
}

fun String.removeInitialWhitespace() : String {
    var str = this
    while (str.startsWith(" ") && str.isNotEmpty())
        str = str.substring(1, str.length)
    return str
}