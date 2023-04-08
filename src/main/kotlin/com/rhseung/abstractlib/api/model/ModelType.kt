package com.rhseung.abstractlib.api.model

class ModelType(
    val parentType: ParentType?,
    vararg val keys: TextureKey
) {
    private var variant: String? = null
    fun variant(variant: String): ModelType {
        this.variant = variant
        return this
    }

    companion object {
        val CUBE = ModelType(
            ParentType.CUBE,
            TextureKey.PARTICLE,
            TextureKey.NORTH,
            TextureKey.SOUTH,
            TextureKey.EAST,
            TextureKey.WEST,
            TextureKey.UP,
            TextureKey.DOWN
        )
        val CUBE_DIRECTIONAL = ModelType(
            ParentType.CUBE_DIRECTIONAL,
            TextureKey.PARTICLE,
            TextureKey.NORTH,
            TextureKey.SOUTH,
            TextureKey.EAST,
            TextureKey.WEST,
            TextureKey.UP,
            TextureKey.DOWN
        );
        val CUBE_ALL = ModelType(ParentType.CUBE_ALL, TextureKey.ALL);
        val CUBE_MIRRORED_ALL = ModelType(ParentType.CUBE_MIRRORED_ALL, TextureKey.ALL).variant("_mirrored")
        val CUBE_NORTH_WEST_MIRRORED_ALL =
            ModelType(ParentType.CUBE_NORTH_WEST_MIRRORED_ALL, TextureKey.ALL).variant("_north_west_mirrored");
        val CUBE_COLUMN_UV_LOCKED_X =
            ModelType(ParentType.CUBE_COLUMN_UV_LOCKED_X, TextureKey.END, TextureKey.SIDE).variant("_x");
        val CUBE_COLUMN_UV_LOCKED_Y =
            ModelType(ParentType.CUBE_COLUMN_UV_LOCKED_Y, TextureKey.END, TextureKey.SIDE).variant("_y");
        val CUBE_COLUMN_UV_LOCKED_Z =
            ModelType(ParentType.CUBE_COLUMN_UV_LOCKED_Z, TextureKey.END, TextureKey.SIDE).variant("_z");
        val CUBE_COLUMN = ModelType(ParentType.CUBE_COLUMN, TextureKey.END, TextureKey.SIDE);
        val CUBE_COLUMN_HORIZONTAL =
            ModelType(ParentType.CUBE_COLUMN_HORIZONTAL, TextureKey.END, TextureKey.SIDE).variant("_horizontal");
        val CUBE_COLUMN_MIRRORED =
            ModelType(ParentType.CUBE_COLUMN_MIRRORED, TextureKey.END, TextureKey.SIDE).variant("_mirrored");
        val CUBE_TOP = ModelType(ParentType.CUBE_TOP, TextureKey.TOP, TextureKey.SIDE);
        val CUBE_BOTTOM_TOP = ModelType(ParentType.CUBE_BOTTOM_TOP, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.SIDE);
        val ORIENTABLE = ModelType(ParentType.ORIENTABLE, TextureKey.TOP, TextureKey.FRONT, TextureKey.SIDE);
        val ORIENTABLE_WITH_BOTTOM = ModelType(
            ParentType.ORIENTABLE_WITH_BOTTOM,
            TextureKey.TOP,
            TextureKey.BOTTOM,
            TextureKey.SIDE,
            TextureKey.FRONT
        );
        val ORIENTABLE_VERTICAL =
            ModelType(ParentType.ORIENTABLE_VERTICAL, TextureKey.FRONT, TextureKey.SIDE).variant("_vertical");
        val BUTTON = ModelType(ParentType.BUTTON, TextureKey.TEXTURE);
        val BUTTON_PRESSED = ModelType(ParentType.BUTTON_PRESSED, TextureKey.TEXTURE).variant("_pressed");
        val BUTTON_INVENTORY = ModelType(ParentType.BUTTON_INVENTORY, TextureKey.TEXTURE).variant("_inventory");
        val DOOR_BOTTOM_LEFT =
            ModelType(ParentType.DOOR_BOTTOM_LEFT, TextureKey.TOP, TextureKey.BOTTOM).variant("_bottom_left");
        val DOOR_BOTTOM_LEFT_OPEN =
            ModelType(ParentType.DOOR_BOTTOM_LEFT_OPEN, TextureKey.TOP, TextureKey.BOTTOM).variant("_bottom_left_open");
        val DOOR_BOTTOM_RIGHT =
            ModelType(ParentType.DOOR_BOTTOM_RIGHT, TextureKey.TOP, TextureKey.BOTTOM).variant("_bottom_right");
        val DOOR_BOTTOM_RIGHT_OPEN = ModelType(
            ParentType.DOOR_BOTTOM_RIGHT_OPEN,
            TextureKey.TOP,
            TextureKey.BOTTOM
        ).variant("_bottom_right_open");
        val DOOR_TOP_LEFT = ModelType(ParentType.DOOR_TOP_LEFT, TextureKey.TOP, TextureKey.BOTTOM).variant("_top_left");
        val DOOR_TOP_LEFT_OPEN =
            ModelType(ParentType.DOOR_TOP_LEFT_OPEN, TextureKey.TOP, TextureKey.BOTTOM).variant("_top_left_open")
        val DOOR_TOP_RIGHT =
            ModelType(ParentType.DOOR_TOP_RIGHT, TextureKey.TOP, TextureKey.BOTTOM).variant("_top_right")
        val DOOR_TOP_RIGHT_OPEN =
            ModelType(ParentType.DOOR_TOP_RIGHT_OPEN, TextureKey.TOP, TextureKey.BOTTOM).variant("_top_right_open")
        val CUSTOM_FENCE_POST =
            ModelType(ParentType.CUSTOM_FENCE_POST, TextureKey.TEXTURE, TextureKey.PARTICLE).variant("_post")
        val CUSTOM_FENCE_SIDE_NORTH =
            ModelType(ParentType.CUSTOM_FENCE_SIDE_NORTH, TextureKey.TEXTURE).variant("_side_north")
        val CUSTOM_FENCE_SIDE_EAST =
            ModelType(ParentType.CUSTOM_FENCE_SIDE_EAST, TextureKey.TEXTURE).variant("_side_east")
        val CUSTOM_FENCE_SIDE_SOUTH =
            ModelType(ParentType.CUSTOM_FENCE_SIDE_SOUTH, TextureKey.TEXTURE).variant("_side_south")
        val CUSTOM_FENCE_SIDE_WEST =
            ModelType(ParentType.CUSTOM_FENCE_SIDE_WEST, TextureKey.TEXTURE).variant("_side_west")
        val CUSTOM_FENCE_INVENTORY =
            ModelType(ParentType.CUSTOM_FENCE_INVENTORY, TextureKey.TEXTURE).variant("_inventory")
        val FENCE_POST = ModelType(ParentType.FENCE_POST, TextureKey.TEXTURE).variant("_post")
        val FENCE_SIDE = ModelType(ParentType.FENCE_SIDE, TextureKey.TEXTURE).variant("_side")
        val FENCE_INVENTORY = ModelType(ParentType.FENCE_INVENTORY, TextureKey.TEXTURE).variant("_inventory")
        val TEMPLATE_WALL_POST = ModelType(ParentType.TEMPLATE_WALL_POST, TextureKey.WALL).variant("_post")
        val TEMPLATE_WALL_SIDE = ModelType(ParentType.TEMPLATE_WALL_SIDE, TextureKey.WALL).variant("_side")
        val TEMPLATE_WALL_SIDE_TALL =
            ModelType(ParentType.TEMPLATE_WALL_SIDE_TALL, TextureKey.WALL).variant("_side_tall")
        val WALL_INVENTORY = ModelType(ParentType.WALL_INVENTORY, TextureKey.WALL).variant("_inventory")
        val TEMPLATE_CUSTOM_FENCE_GATE =
            ModelType(ParentType.TEMPLATE_CUSTOM_FENCE_GATE, TextureKey.TEXTURE, TextureKey.PARTICLE)
        val TEMPLATE_CUSTOM_FENCE_GATE_OPEN = ModelType(
            ParentType.TEMPLATE_CUSTOM_FENCE_GATE_OPEN,
            TextureKey.TEXTURE,
            TextureKey.PARTICLE
        ).variant("_open")
        val TEMPLATE_CUSTOM_FENCE_GATE_WALL = ModelType(
            ParentType.TEMPLATE_CUSTOM_FENCE_GATE_WALL,
            TextureKey.TEXTURE,
            TextureKey.PARTICLE
        ).variant("_wall")
        val TEMPLATE_CUSTOM_FENCE_GATE_WALL_OPEN =
            ModelType(ParentType.TEMPLATE_CUSTOM_FENCE_GATE_WALL_OPEN, TextureKey.TEXTURE, TextureKey.PARTICLE).variant(
                "_wall_open"
            )
        val TEMPLATE_FENCE_GATE = ModelType(ParentType.TEMPLATE_FENCE_GATE, TextureKey.TEXTURE)
        val TEMPLATE_FENCE_GATE_OPEN =
            ModelType(ParentType.TEMPLATE_FENCE_GATE_OPEN, TextureKey.TEXTURE).variant("_open")
        val TEMPLATE_FENCE_GATE_WALL =
            ModelType(ParentType.TEMPLATE_FENCE_GATE_WALL, TextureKey.TEXTURE).variant("_wall")
        val TEMPLATE_FENCE_GATE_WALL_OPEN =
            ModelType(ParentType.TEMPLATE_FENCE_GATE_WALL_OPEN, TextureKey.TEXTURE).variant("_wall_open")
        val PRESSURE_PLATE_UP = ModelType(ParentType.PRESSURE_PLATE_UP, TextureKey.TEXTURE)
        val PRESSURE_PLATE_DOWN = ModelType(ParentType.PRESSURE_PLATE_DOWN, TextureKey.TEXTURE).variant("_down")
        val PARTICLE = ModelType(null, TextureKey.PARTICLE)
        val SLAB = ModelType(ParentType.SLAB, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE)
        val SLAB_TOP =
            ModelType(ParentType.SLAB_TOP, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE).variant("_top")
        val LEAVES = ModelType(ParentType.LEAVES, TextureKey.ALL)
        val STAIRS = ModelType(ParentType.STAIRS, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE)
        val INNER_STAIRS =
            ModelType(ParentType.INNER_STAIRS, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE).variant("_inner")
        val OUTER_STAIRS =
            ModelType(ParentType.OUTER_STAIRS, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE).variant("_outer")
        val TEMPLATE_TRAPDOOR_TOP = ModelType(ParentType.TEMPLATE_TRAPDOOR_TOP, TextureKey.TEXTURE).variant("_top")
        val TEMPLATE_TRAPDOOR_BOTTOM =
            ModelType(ParentType.TEMPLATE_TRAPDOOR_BOTTOM, TextureKey.TEXTURE).variant("_bottom")
        val TEMPLATE_TRAPDOOR_OPEN = ModelType(ParentType.TEMPLATE_TRAPDOOR_OPEN, TextureKey.TEXTURE).variant("_open")
        val TEMPLATE_ORIENTABLE_TRAPDOOR_TOP =
            ModelType(ParentType.TEMPLATE_ORIENTABLE_TRAPDOOR_TOP, TextureKey.TEXTURE).variant("_top")
        val TEMPLATE_ORIENTABLE_TRAPDOOR_BOTTOM =
            ModelType(ParentType.TEMPLATE_ORIENTABLE_TRAPDOOR_BOTTOM, TextureKey.TEXTURE).variant("_bottom")
        val TEMPLATE_ORIENTABLE_TRAPDOOR_OPEN =
            ModelType(ParentType.TEMPLATE_ORIENTABLE_TRAPDOOR_OPEN, TextureKey.TEXTURE).variant("_open")
        val POINTED_DRIPSTONE = ModelType(ParentType.POINTED_DRIPSTONE, TextureKey.CROSS);
        val CROSS = ModelType(ParentType.CROSS, TextureKey.CROSS);
        val TINTED_CROSS = ModelType(ParentType.TINTED_CROSS, TextureKey.CROSS);
        val FLOWER_POT_CROSS = ModelType(ParentType.FLOWER_POT_CROSS, TextureKey.PLANT);
        val TINTED_FLOWER_POT_CROSS = ModelType(ParentType.TINTED_FLOWER_POT_CROSS, TextureKey.PLANT);
        val RAIL_FLAT = ModelType(ParentType.RAIL_FLAT, TextureKey.RAIL);
        val RAIL_CURVED = ModelType(ParentType.RAIL_CURVED, TextureKey.RAIL).variant("_corner");
        val TEMPLATE_RAIL_RAISED_NE =
            ModelType(ParentType.TEMPLATE_RAIL_RAISED_NE, TextureKey.RAIL).variant("_raised_ne");
        val TEMPLATE_RAIL_RAISED_SW =
            ModelType(ParentType.TEMPLATE_RAIL_RAISED_SW, TextureKey.RAIL).variant("_raised_sw");
        val CARPET = ModelType(ParentType.CARPET, TextureKey.WOOL);
        val FLOWERBED_1 = ModelType(ParentType.FLOWERBED_1, TextureKey.FLOWERBED, TextureKey.STEM).variant("_1");
        val FLOWERBED_2 = ModelType(ParentType.FLOWERBED_2, TextureKey.FLOWERBED, TextureKey.STEM).variant("_2");
        val FLOWERBED_3 = ModelType(ParentType.FLOWERBED_3, TextureKey.FLOWERBED, TextureKey.STEM).variant("_3");
        val FLOWERBED_4 = ModelType(ParentType.FLOWERBED_4, TextureKey.FLOWERBED, TextureKey.STEM).variant("_4");
        val CORAL_FAN = ModelType(ParentType.CORAL_FAN, TextureKey.FAN);
        val CORAL_WALL_FAN = ModelType(ParentType.CORAL_WALL_FAN, TextureKey.FAN);
        val TEMPLATE_GLAZED_TERRACOTTA = ModelType(ParentType.TEMPLATE_GLAZED_TERRACOTTA, TextureKey.PATTERN);
        val TEMPLATE_CHORUS_FLOWER = ModelType(ParentType.TEMPLATE_CHORUS_FLOWER, TextureKey.TEXTURE);
        val TEMPLATE_DAYLIGHT_DETECTOR =
            ModelType(ParentType.TEMPLATE_DAYLIGHT_DETECTOR, TextureKey.TOP, TextureKey.SIDE);
        val TEMPLATE_GLASS_PANE_NOSIDE =
            ModelType(ParentType.TEMPLATE_GLASS_PANE_NOSIDE, TextureKey.PANE).variant("_noside");
        val TEMPLATE_GLASS_PANE_NOSIDE_ALT =
            ModelType(ParentType.TEMPLATE_GLASS_PANE_NOSIDE_ALT, TextureKey.PANE).variant("_noside_alt");
        val TEMPLATE_GLASS_PANE_POST =
            ModelType(ParentType.TEMPLATE_GLASS_PANE_POST, TextureKey.PANE, TextureKey.EDGE).variant("_post");
        val TEMPLATE_GLASS_PANE_SIDE =
            ModelType(ParentType.TEMPLATE_GLASS_PANE_SIDE, TextureKey.PANE, TextureKey.EDGE).variant("_side");
        val TEMPLATE_GLASS_PANE_SIDE_ALT =
            ModelType(ParentType.TEMPLATE_GLASS_PANE_SIDE_ALT, TextureKey.PANE, TextureKey.EDGE).variant("_side_alt");
        val TEMPLATE_COMMAND_BLOCK =
            ModelType(ParentType.TEMPLATE_COMMAND_BLOCK, TextureKey.FRONT, TextureKey.BACK, TextureKey.SIDE);
        val TEMPLATE_CHISELED_BOOKSHELF_SLOT_TOP_LEFT = ModelType(
            ParentType.TEMPLATE_CHISELED_BOOKSHELF_SLOT_TOP_LEFT,
            TextureKey.TEXTURE
        ).variant("_slot_top_left");
        val TEMPLATE_CHISELED_BOOKSHELF_SLOT_TOP_MID =
            ModelType(ParentType.TEMPLATE_CHISELED_BOOKSHELF_SLOT_TOP_MID, TextureKey.TEXTURE).variant("_slot_top_mid");
        val TEMPLATE_CHISELED_BOOKSHELF_SLOT_TOP_RIGHT = ModelType(
            ParentType.TEMPLATE_CHISELED_BOOKSHELF_SLOT_TOP_RIGHT,
            TextureKey.TEXTURE
        ).variant("_slot_top_right");
        val TEMPLATE_CHISELED_BOOKSHELF_SLOT_BOTTOM_LEFT = ModelType(
            ParentType.TEMPLATE_CHISELED_BOOKSHELF_SLOT_BOTTOM_LEFT,
            TextureKey.TEXTURE
        ).variant("_slot_bottom_left");
        val TEMPLATE_CHISELED_BOOKSHELF_SLOT_BOTTOM_MID = ModelType(
            ParentType.TEMPLATE_CHISELED_BOOKSHELF_SLOT_BOTTOM_MID,
            TextureKey.TEXTURE
        ).variant("_slot_bottom_mid");
        val TEMPLATE_CHISELED_BOOKSHELF_SLOT_BOTTOM_RIGHT = ModelType(
            ParentType.TEMPLATE_CHISELED_BOOKSHELF_SLOT_BOTTOM_RIGHT,
            TextureKey.TEXTURE
        ).variant("_slot_bottom_right");
        val TEMPLATE_ANVIL = ModelType(ParentType.TEMPLATE_ANVIL, TextureKey.TOP);
        val STEM_GROWTH_STAGES =
            (0..8).map { ModelType(ParentType.STEM_GROWTH(it), TextureKey.STEM).variant("_stage$it") }.toTypedArray()
        val STEM_FRUIT = ModelType(ParentType.STEM_FRUIT, TextureKey.STEM, TextureKey.UPPERSTEM);
        val CROP = ModelType(ParentType.CROP, TextureKey.CROP);
        val TEMPLATE_FARMLAND = ModelType(ParentType.TEMPLATE_FARMLAND, TextureKey.DIRT, TextureKey.TOP);
        val TEMPLATE_FIRE_FLOOR = ModelType(ParentType.TEMPLATE_FIRE_FLOOR, TextureKey.FIRE);
        val TEMPLATE_FIRE_SIDE = ModelType(ParentType.TEMPLATE_FIRE_SIDE, TextureKey.FIRE);
        val TEMPLATE_FIRE_SIDE_ALT = ModelType(ParentType.TEMPLATE_FIRE_SIDE_ALT, TextureKey.FIRE);
        val TEMPLATE_FIRE_UP = ModelType(ParentType.TEMPLATE_FIRE_UP, TextureKey.FIRE);
        val TEMPLATE_FIRE_UP_ALT = ModelType(ParentType.TEMPLATE_FIRE_UP_ALT, TextureKey.FIRE);
        val TEMPLATE_CAMPFIRE = ModelType(ParentType.TEMPLATE_CAMPFIRE, TextureKey.FIRE, TextureKey.LIT_LOG);
        val TEMPLATE_LANTERN = ModelType(ParentType.TEMPLATE_LANTERN, TextureKey.LANTERN);
        val TEMPLATE_HANGING_LANTERN =
            ModelType(ParentType.TEMPLATE_HANGING_LANTERN, TextureKey.LANTERN).variant("_hanging");
        val TEMPLATE_TORCH = ModelType(ParentType.TEMPLATE_TORCH, TextureKey.TORCH);
        val TEMPLATE_TORCH_WALL = ModelType(ParentType.TEMPLATE_TORCH_WALL, TextureKey.TORCH);
        val TEMPLATE_PISTON =
            ModelType(ParentType.TEMPLATE_PISTON, TextureKey.PLATFORM, TextureKey.BOTTOM, TextureKey.SIDE);
        val TEMPLATE_PISTON_HEAD =
            ModelType(ParentType.TEMPLATE_PISTON_HEAD, TextureKey.PLATFORM, TextureKey.SIDE, TextureKey.UNSTICKY);
        val TEMPLATE_PISTON_HEAD_SHORT =
            ModelType(ParentType.TEMPLATE_PISTON_HEAD_SHORT, TextureKey.PLATFORM, TextureKey.SIDE, TextureKey.UNSTICKY);
        val TEMPLATE_SEAGRASS = ModelType(ParentType.TEMPLATE_SEAGRASS, TextureKey.TEXTURE);
        val TEMPLATE_TURTLE_EGG = ModelType(ParentType.TEMPLATE_TURTLE_EGG, TextureKey.ALL);
        val TEMPLATE_TWO_TURTLE_EGGS = ModelType(ParentType.TEMPLATE_TWO_TURTLE_EGGS, TextureKey.ALL);
        val TEMPLATE_THREE_TURTLE_EGGS = ModelType(ParentType.TEMPLATE_THREE_TURTLE_EGGS, TextureKey.ALL);
        val TEMPLATE_FOUR_TURTLE_EGGS = ModelType(ParentType.TEMPLATE_FOUR_TURTLE_EGGS, TextureKey.ALL);
        val TEMPLATE_SINGLE_FACE = ModelType(ParentType.TEMPLATE_SINGLE_FACE, TextureKey.TEXTURE);
        val TEMPLATE_CAULDRON_LEVEL1 = ModelType(
            ParentType.TEMPLATE_CAULDRON_LEVEL1,
            TextureKey.CONTENT,
            TextureKey.INSIDE,
            TextureKey.PARTICLE,
            TextureKey.TOP,
            TextureKey.BOTTOM,
            TextureKey.SIDE
        );
        val TEMPLATE_CAULDRON_LEVEL2 = ModelType(
            ParentType.TEMPLATE_CAULDRON_LEVEL2,
            TextureKey.CONTENT,
            TextureKey.INSIDE,
            TextureKey.PARTICLE,
            TextureKey.TOP,
            TextureKey.BOTTOM,
            TextureKey.SIDE
        );
        val TEMPLATE_CAULDRON_FULL = ModelType(
            ParentType.TEMPLATE_CAULDRON_FULL,
            TextureKey.CONTENT,
            TextureKey.INSIDE,
            TextureKey.PARTICLE,
            TextureKey.TOP,
            TextureKey.BOTTOM,
            TextureKey.SIDE
        );
        val TEMPLATE_AZALEA = ModelType(ParentType.TEMPLATE_AZALEA, TextureKey.TOP, TextureKey.SIDE);
        val TEMPLATE_POTTED_AZALEA_BUSH =
            ModelType(ParentType.TEMPLATE_POTTED_AZALEA_BUSH, TextureKey.TOP, TextureKey.SIDE);

        fun GENERATED(n: Int = 1) =
            ModelType(ParentType.GENERATED, *(0 until n).map { TextureKey.LAYER(it) }.toTypedArray())

        fun HANDHELD(n: Int = 1) =
            ModelType(ParentType.HANDHELD, *(0 until n).map { TextureKey.LAYER(it) }.toTypedArray())

        fun HANDHELD_ROD(n: Int = 1) =
            ModelType(ParentType.HANDHELD_ROD, *(0 until n).map { TextureKey.LAYER(it) }.toTypedArray())

        val TEMPLATE_SHULKER_BOX = ModelType(ParentType.TEMPLATE_SHULKER_BOX, TextureKey.PARTICLE);
        val TEMPLATE_BED = ModelType(ParentType.TEMPLATE_BED, TextureKey.PARTICLE);
        val TEMPLATE_BANNER = ModelType(ParentType.TEMPLATE_BANNER);
        val TEMPLATE_SKULL = ModelType(ParentType.TEMPLATE_SKULL);
        val TEMPLATE_CANDLE = ModelType(ParentType.TEMPLATE_CANDLE, TextureKey.ALL, TextureKey.PARTICLE);
        val TEMPLATE_TWO_CANDLES = ModelType(ParentType.TEMPLATE_TWO_CANDLES, TextureKey.ALL, TextureKey.PARTICLE);
        val TEMPLATE_THREE_CANDLES = ModelType(ParentType.TEMPLATE_THREE_CANDLES, TextureKey.ALL, TextureKey.PARTICLE);
        val TEMPLATE_FOUR_CANDLES = ModelType(ParentType.TEMPLATE_FOUR_CANDLES, TextureKey.ALL, TextureKey.PARTICLE);
        val TEMPLATE_CAKE_WITH_CANDLE = ModelType(
            ParentType.TEMPLATE_CAKE_WITH_CANDLE,
            TextureKey.CANDLE,
            TextureKey.BOTTOM,
            TextureKey.SIDE,
            TextureKey.TOP,
            TextureKey.PARTICLE
        );
        val TEMPLATE_SCULK_SHRIEKER = ModelType(
            ParentType.TEMPLATE_SCULK_SHRIEKER,
            TextureKey.BOTTOM,
            TextureKey.SIDE,
            TextureKey.TOP,
            TextureKey.PARTICLE,
            TextureKey.INNER_TOP
        );
    }
}