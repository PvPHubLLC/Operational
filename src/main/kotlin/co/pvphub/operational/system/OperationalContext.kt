package co.pvphub.operational.system

import java.lang.ClassCastException

class OperationalContext(val script: OperationalScript) {
    val vars = hashMapOf<String, Any>()

    /**
     * Gets a variable in this operational scope.
     * We can use this class to keep track of local variables in the scope.
     * Variables in the global scope can be gotten through this function too.
     */
    operator fun <T> get(name: String) : T? {
        if (name.matches("\\[.+]".toRegex())) {
            // It's a global function
            return try {
                script.globals[name.substring(1, name.length - 1)] as T
            } catch (_: ClassCastException) {
                null
            }
        }
        // Get the local variable
        return try {
            vars[name] as T
        } catch (_: ClassCastException) {
            return try {
                vars["this.$name"] as T
            } catch (_: ClassCastException) {
                null
            }
        }
    }

    operator fun <T : Any> set(name: String, value: T) {
        if (name.matches("\\[(\\w|\\d|\\.|::)+]".toRegex())) {
            // It's a global function
            try {
                script.globals[name.substring(1, name.length - 1)] = value
            } catch (_: ClassCastException) {
            }
            return
        }
        // Get the local variable
        try {
            vars[name] = value
        } catch (_: ClassCastException) {
            try {
                vars["this.$name"] = value
            } catch (_: ClassCastException) {
            }
        }
    }
}