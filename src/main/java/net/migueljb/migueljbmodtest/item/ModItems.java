package net.migueljb.migueljbmodtest.item;

import net.migueljb.migueljbmodtest.Migueljbmodtest;
import net.migueljb.migueljbmodtest.item.custom.ChiselItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Migueljbmodtest.MOD_ID);

    public static final RegistryObject<Item> TESTIUM = ITEMS.register("testium",
            () -> new Item(new Item.Properties().setId(ITEMS.key("testium"))));

    public static final RegistryObject<Item> TESTIUMG = ITEMS.register("testiumg",
            () -> new Item(new Item.Properties().setId(ITEMS.key("testiumg"))));
    public static final RegistryObject<Item> TESTIUMR = ITEMS.register("testiumr",
            () -> new Item(new Item.Properties().setId(ITEMS.key("testiumr"))));
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            ()-> new ChiselItem(new Item.Properties()
                    .durability(192).setId(ITEMS.key("chisel"))));

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
