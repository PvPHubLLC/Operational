package co.pvphub.operational.builtin.function

import co.pvphub.operational.api.OpFunction
import co.pvphub.operational.system.OperationalContext
import kotlin.math.pow
import kotlin.math.sqrt

class Math {

    @OpFunction(regexes = ["\\d+\\s?\\+\\s?\\d+"])
    fun add(context: OperationalContext, first: Double, second: Double) : Double = first + second

    @OpFunction
    fun distanceTo(context: OperationalContext, first: Double, second: Double) =
        sqrt(distanceSquared(context, first, second))

    @OpFunction
    fun distanceSquared(context: OperationalContext, first: Double, second: Double) =
        first.pow(2) + second.pow(2)

}