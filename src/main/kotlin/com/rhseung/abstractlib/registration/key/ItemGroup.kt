package com.rhseung.abstractlib.registration.key

import com.rhseung.abstractlib.api.Languages
import com.rhseung.abstractlib.api.StringStyle.titlecase
import com.rhseung.abstractlib.api.annotation.Lang
import com.rhseung.abstractlib.api.file.path.Location
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text

typealias Group = RegistryKey<ItemGroup>

class ItemGroup(
    /**
     * The ID of the item. This is used to register the item.
     */
    override val id: Location,

    /**
     * The settings of the item.
     */
    val properties: Properties
) : IRegistryKey {

    /**
     * The language table of the item. The key is the language code, and the value is the translated string.
     */
    override val langs = Languages.LanguageTable(Languages.EN_US to id.path.titlecase())

    init {
        properties.langs.forEach { lang, name ->
            if (name != null)
                langs[lang] = name
        }
    }

    /**
     * The item group.
     */
    val group = properties.build(id)

    /**
     * The registry key of the item group.
     */
    val registrykey = RegistryKey.of(RegistryKeys.ITEM_GROUP, id)

    /**
     * Registers the item group to the [Registry].
     */
    override fun register() {
        Registry.register(Registries.ITEM_GROUP, registrykey, group)
    }

    /**
     * Returns the string representation of the item group.
     */
    override fun toString(): String {
        return "ItemGroup($id)"
    }

    class Properties {
        /**
         * The icon of the item group.
         */
        internal var icon: ItemStack = ItemStack.EMPTY

        fun icon(value: () -> ItemStack) {
            this.icon = value()
        }

        /**
         * Sets the show scrollbar of the item group.
         */
        internal var scrollbar = true

        fun scrollbar(value: () -> Boolean) {
            this.scrollbar = value()
        }

        /**
         * Sets the special of the item group.
         * note: idk
         */
        internal var special = false

        fun special(value: () -> Boolean) {
            this.special = value()
        }

        /**
         * Sets the show rendered name of the item group.
         */
        internal var showRenderName = true

        fun showRenderName(value: () -> Boolean) {
            this.showRenderName = value()
        }

        /**
         * The language table of the item. The key is the language code, and the value is the translated string.
         */
        internal val langs = Languages.LanguageTable()

        fun lang(value: () -> Lang) {
            langs[value().language] = value().translation
        }

        fun build(id: Location): ItemGroup {
            return FabricItemGroup.builder()
                .icon { icon }
                .displayName(Text.translatable("${id.namespace}.${id.path}"))
                .apply {
                    if (!scrollbar)
                        noScrollbar()
                    if (special)
                        special()
                    if (!showRenderName)
                        noRenderedName()
                }
                .build()
        }
    }
}