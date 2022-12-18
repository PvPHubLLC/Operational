package co.pvphub.operational.api

object OpExtensionManager {

    fun register(ext: OpExtension) {
        // Get each method with [OpFunction] annotation
        ext::class.java.declaredMethods.filter { it.annotations.any { a -> a is OpFunction } }
            .forEach {
                val regex = (it.annotations.find { a -> a is OpFunction } as OpFunction).regexes
                if (regex.isEmpty()) {
                    // We need to magically generate our own function regex
                    var strBuilder = it.name
                    println(it.parameterCount)
                    strBuilder += when(it.parameterCount) {
                        1 -> "\\s?\\(\\)"
                        2 -> "\\s?\\(?"
                        else -> "\\s?\\("
                    }
                    // Now build arguments
                    // todo need to take types into account with regex.
                    if (it.parameterCount >= 2) strBuilder += "(\\w+(\\,\\s?\\w+){${it.parameterCount - 2}})"
                    if (it.parameterCount == 2) strBuilder += "\\)?"
                    if (it.parameterCount > 2) strBuilder += "\\)"
                    println(strBuilder)
                }
            }
    }

}