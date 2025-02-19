package net.migueljb.migueljbmodtest.item;

import net.migueljb.migueljbmodtest.Migueljbmodtest;
import net.migueljb.migueljbmodtest.item.custom.ChiselItem;
import net.migueljb.migueljbmodtest.item.custom.FuelItem;
import net.migueljb.migueljbmodtest.item.custom.TesterItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

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
    public static final RegistryObject<Item> TESTER = ITEMS.register("tester",
            ()-> new TesterItem(new Item.Properties()
                    .durability(192).setId(ITEMS.key("tester"))));
    public static final RegistryObject<Item> RED_COAL = ITEMS.register("red_coal",
            ()-> new FuelItem(new Item.Properties().setId(ITEMS.key("red_coal")), 20000){
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.migueljbmodtest.red_coal"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> GREEN_BEEF = ITEMS.register("green_beef",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.GREEN_BEEF_FOOD, ModFoodProperties.GREEN_BEEF_CONSUMABLE)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation
                            .fromNamespaceAndPath("migueljbmodtest", "green_beef")))));
    public static final RegistryObject<Item> RAW_GREEN_BEEF = ITEMS.register("raw_green_beef",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.RAW_GREEN_BEEF_FOOD, ModFoodProperties.RAW_GREEN_BEEF_CONSUMABLE)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation
                            .fromNamespaceAndPath("migueljbmodtest", "raw_green_beef")))));

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
