package net.migueljb.migueljbmodtest.item;

import net.migueljb.migueljbmodtest.Migueljbmodtest;
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

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
