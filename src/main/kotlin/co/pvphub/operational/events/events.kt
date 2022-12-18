package co.pvphub.operational.events

import co.pvphub.operational.system.OperationalScript

class ScriptStartEvent(script: OperationalScript) : OpScriptEvent()
class ScriptEndEvent(script: OperationalScript) : OpScriptEvent()
class ScriptReloadEvent(script: OperationalScript) : OpScriptEvent()