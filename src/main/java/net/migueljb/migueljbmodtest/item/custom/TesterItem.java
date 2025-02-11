package net.migueljb.migueljbmodtest.item.custom;

import net.migueljb.migueljbmodtest.block.ModBlocks;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
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
}

