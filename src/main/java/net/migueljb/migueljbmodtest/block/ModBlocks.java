package net.migueljb.migueljbmodtest.block;



import net.migueljb.migueljbmodtest.Migueljbmodtest;
import net.migueljb.migueljbmodtest.block.custom.TainterBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.migueljb.migueljbmodtest.item.ModItems.ITEMS;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Migueljbmodtest.MOD_ID);

    public static final RegistryObject<Block> TESTIUMR_BLOCK = registerBlock("testiumr_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
                    .setId(BLOCKS.key("testiumr_block"))));

    public static final RegistryObject<Block> TAINTER_BLOCK = registerBlock("tainter_block",
            ()-> new TainterBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
                    .setId(BLOCKS.key("tainter_block"))));

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ITEMS.key(name))));
    }


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        //registerBlockItem("testiumr_block", TESTIUMR_BLOCK);
        //registerBlockItem("tainter_block", TAINTER_BLOCK);
        return toReturn;
    }

    public static  void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
