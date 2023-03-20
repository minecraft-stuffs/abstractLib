package com.rhseung.abstractlib.examples

import com.rhseung.abstractlib.ModInit
import com.rhseung.abstractlib.api.registration.AbstractModRegistrations
import com.rhseung.abstractlib.api.registration.registrykeys.BasicTool
import com.rhseung.abstractlib.api.tool.ToolMaterial
import com.rhseung.abstractlib.api.tool.ToolType
import net.minecraft.item.ItemGroups

class ModTools : AbstractModRegistrations<BasicTool>() {
    override val things = listOf(
        BasicTool.of(ModInit.modid) {
            path = "test_tool"
            toolMaterial = ToolMaterial.IRON
            toolType = ToolType.PICKAXE
            settings {
                group = ItemGroups.TOOLS
            }
        }
    )
}