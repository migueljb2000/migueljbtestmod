package net.migueljb.migueljbmodtest.item;

import net.migueljb.migueljbmodtest.Migueljbmodtest;
import net.migueljb.migueljbmodtest.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Migueljbmodtest.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TESTIUM_ITEMS_TAB = CREATIVE_MODE_TABS.register(
            "testium_items_tab", ()-> CreativeModeTab.builder().icon(
                    ()-> new ItemStack(ModItems.TESTIUM.get()))
                    .title(Component.translatable("creativetab.migueljbmodtest.testium_items"))
                    .displayItems(new CreativeModeTab.DisplayItemsGenerator() {
                        @Override
                        public void accept(CreativeModeTab.ItemDisplayParameters pParameters, CreativeModeTab.Output pOutput) {
                            pOutput.accept((ModItems.TESTIUM.get()));
                            pOutput.accept((ModItems.TESTIUMR.get()));
                            pOutput.accept((ModItems.TESTIUMG.get()));
                            pOutput.accept((ModItems.CHISEL).get());
                            pOutput.accept((ModItems.TESTER).get());

                        }
                    }).build());

    public static final RegistryObject<CreativeModeTab> TESTIUM_BLOCKS_TAB = CREATIVE_MODE_TABS.register(
            "testium_blocks_tab", ()-> CreativeModeTab.builder().icon(
                            ()-> new ItemStack(ModBlocks.TESTIUMR_BLOCK.get()))
                    .withTabsBefore(TESTIUM_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.migueljbmodtest.testium_blocks"))
                    .displayItems(new CreativeModeTab.DisplayItemsGenerator() {
                        @Override
                        public void accept(CreativeModeTab.ItemDisplayParameters pParameters, CreativeModeTab.Output pOutput) {
                            pOutput.accept((ModBlocks.TESTIUMR_BLOCK.get()));
                            pOutput.accept((ModBlocks.TAINTER_BLOCK.get()));
                        }
                    }).build());


    public static void  register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
