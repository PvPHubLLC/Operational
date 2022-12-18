package co.pvphub.operational.builtin

import co.pvphub.operational.system.vars.OperationalVariable

class OperationalAssignment {
    val regex = "${OperationalVariable.regex}\\s=\\s.+".toRegex()
}