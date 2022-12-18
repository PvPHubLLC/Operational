package co.pvphub.operational.api

object OpExtensionManager {

    fun register(ext: OpExtension) {
        // Get each method with [OpFunction] annotation
        ext::class.java.declaredMethods.filter { it.annotations.any { a -> a is OpFunction } }
            .forEach {
                val regex = (it.annotations.find { a -> a is OpFunction } as OpFunction).regexes
                if (regex.isEmpty()) {
                    // We need to magically generate our own function regex

                }
            }
    }

}