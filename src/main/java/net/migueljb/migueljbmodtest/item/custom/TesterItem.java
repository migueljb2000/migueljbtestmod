package net.migueljb.migueljbmodtest.item.custom;

import net.migueljb.migueljbmodtest.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class TesterItem extends Item{
    //First Item on the ender tester mod, the following list contains the teleportable blocks for the tester
    private static final List<Block> tpblocks = List.of(ModBlocks.TESTIUMR_BLOCK.get());


    public TesterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            // Create a small, invisible projectile
            ThrownEnderpearl pearl = new ThrownEnderpearl(EntityType.ENDER_PEARL, level);
            pearl.setOwner(player); // Assign player ownership
            pearl.moveTo(player.getX(), player.getEyeY(), player.getZ()); // Start at eye level

            // Set velocity in the player's look direction
            Vec3 direction = player.getViewVector(1.0F).scale(2.0); // Adjust speed as needed
            pearl.setDeltaMovement(direction);

            // Spawn the projectile
            level.addFreshEntity(pearl);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
/*
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        Level level = pContext.getLevel();
        if (player != null && !level.isClientSide) {

            // Define your custom teleport range
            double teleportRange = 100.0D; // Example range

            // Get the direction the player is looking (yaw and pitch)
            Vec3 direction = player.getViewVector(1.0F);

            // Calculate the target position by moving in the direction the player is facing
            Vec3 targetPosition = player.position().add(direction.x * teleportRange, direction.y * teleportRange, direction.z * teleportRange);

            // Convert targetPosition to BlockPos, using floor to ensure it's a valid block position in the world
            BlockPos targetPos = new BlockPos((int) Math.floor(targetPosition.x), (int) Math.floor(targetPosition.y), (int) Math.floor(targetPosition.z));

            // Check if the position is valid and is not a solid block (or whatever checks you want to perform)
            if (level.isEmptyBlock(targetPos) && level.isEmptyBlock(targetPos.above())) {
                ((ServerPlayer) player).teleportTo(targetPos.getX(), targetPos.getY(), targetPos.getZ());
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;


        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();
        double xcoordl = player.getLookAngle().x();
        double ycoordl = player.getLookAngle().y();
        double zcoordl = player.getLookAngle().z();
        int xcoordc = pContext.getClickedPos().getX();
        int ycoordc = pContext.getClickedPos().getY();
        double zcoordc = pContext.getClickedPos().getZ() + 0.5;

        //if(tpblocks.contains(clickedBlock)){
            if(!level.isClientSide()) {
                HitResult target = player.pick(100.0D,0.0F,false);
                if(target.getType() == HitResult.Type.BLOCK){
                    Vec3 vec3 = target.getLocation();
                    BlockPos targetPos = new BlockPos((int) Math.floor(vec3.x), (int) Math.floor(vec3.y), (int) Math.floor(vec3.z));
                    BlockState targetblock = level.getBlockState(targetPos);
                    //if(tpblocks.contains(targetblock.getBlock())){
                        ((ServerPlayer) player).teleportTo(targetPos.getX(), targetPos.getY(), targetPos.getZ());
                        pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                                item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                        level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
                   // }

                }


                //}

            }
        //}

        return super.useOn(pContext);


    */
    }

