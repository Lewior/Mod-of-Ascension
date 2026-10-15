package com.lewior.modofascension.creativemodetab;

import com.lewior.modofascension.ModofAscension;
import com.lewior.modofascension.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModofAscension.MOD_ID);

    public static final Supplier<CreativeModeTab> MOD_COMBAT_TAB = CREATIVE_MODE_TABS.register("mod_combat_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ASCENSION_SWORD.get()))
                    .title(Component.translatable("creativetab.ModofAscension.mod_combat"))
                    .withTabsAfter(Identifier.fromNamespaceAndPath(ModofAscension.MOD_ID, "mod_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ASCENSION_SWORD);


                    }).build());


    public static final Supplier<CreativeModeTab> MOD_BLOCKS_TAB = CREATIVE_MODE_TABS.register("mod_blocks_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ASCENDED_BAR.get()))
            .title(Component.translatable("creativetab.ModofAscension.mod_blocks"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.ASCENDED_BAR);


            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
