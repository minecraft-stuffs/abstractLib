package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.api.MiningLevel
import com.rhseung.abstractlib.api.ToolType

data class ToolLevel(val miningLevel: MiningLevel, val toolType: ToolType) {
	companion object {
		infix fun MiningLevel.using(toolType: ToolType) = ToolLevel(this, toolType)
	}
}