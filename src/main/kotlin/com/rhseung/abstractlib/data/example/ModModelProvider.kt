package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractModelProvider
import com.rhseung.abstractlib.data.ItemModelHandler
import com.rhseung.abstractlib.data.Parents
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class ModModelProvider(
    output: FabricDataOutput
) : AbstractModelProvider(output) {

    override fun registerItem(handler: ItemModelHandler) {
        handler.builder {
            model {
                path { "example_ingot" }
                parent { Parents.GENERATED }
                textures {
                    texture {
                        key { "layer0" }
                        path { "item/example_ingot" }
                        path { "item/example" }
                    }
                }
            }

            overrides {
                override {

                }
            }
        }
    }
}