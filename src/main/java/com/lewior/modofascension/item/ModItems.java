package com.lewior.modofascension.item;

import com.lewior.modofascension.ModofAscension;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ModofAscension.MOD_ID);

    // Tool Materials
    public static final ToolMaterial ASCENDED_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1751,
            8.5f,
            3.5f,
            12,
            Tags.Items.INGOTS_IRON
    );

    // Combat
    public static final DeferredItem<Item> ASCENSION_SWORD = ITEMS.registerItem(
            "sword_of_ascension",
            props -> new Item(
                    props.sword(
                            ASCENDED_MATERIAL,
                            3,
                            -2.4f
                    )
            )
    );

    // Ingredients
    public static final DeferredItem<Item> ASCENDED_BAR = ITEMS.registerSimpleItem("ascended_bar");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}