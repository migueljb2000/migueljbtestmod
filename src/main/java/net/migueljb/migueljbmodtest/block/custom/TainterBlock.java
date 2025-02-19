package net.migueljb.migueljbmodtest.block.custom;

import net.migueljb.migueljbmodtest.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TainterBlock extends Block {
    public TainterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity itemEntity){
            if(isValidItem(itemEntity.getItem())){
                pEntity.playSound(SoundEvents.BEACON_ACTIVATE, 1f, 1f);
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                                        Player pPlayer, BlockHitResult pHitResult) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.BLASTFURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    private boolean isValidItem(ItemStack item){
        boolean res = false;
        if(item.is(ModTags.Items.GREEN_ITEMS) || item.is(ModTags.Items.RED_ITEMS)){
            res = true;
        };
        return res;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.migueljbmodtest.tainter_block.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }

}
