package com.lewior.modofascension.block;

import com.lewior.modofascension.ModofAscension;
import com.lewior.modofascension.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ModofAscension.MOD_ID);


    public static final DeferredBlock<Block> ASCENDED_ORE = registerBlock("ascended_ore",
            properties -> new DropExperienceBlock(
                    UniformInt.of(4, 8),
                    properties.strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )
    );

    public static final DeferredBlock<Block> BLOCK_OF_ASCENSION = registerBlock("block_of_ascension",
            properties -> new Block(
                    properties.strength(5f)
                    .sound(SoundType.AMETHYST)
                    .lightLevel(state -> 4)
            )
    );


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
