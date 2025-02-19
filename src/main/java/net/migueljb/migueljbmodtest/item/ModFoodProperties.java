package net.migueljb.migueljbmodtest.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;

public class ModFoodProperties {

    public static final Consumable GREEN_BEEF_CONSUMABLE = Consumables.defaultFood()
            .soundAfterConsume(SoundEvents.GENERIC_EAT)
            .onConsume(
                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 0), 0.3f))
            .onConsume(
                    new TeleportRandomlyConsumeEffect(10f))
            .build();

    public static final FoodProperties GREEN_BEEF_FOOD = new FoodProperties.Builder().nutrition(3)
            .saturationModifier(0.25f).build();

    public static final Consumable RAW_GREEN_BEEF_CONSUMABLE = Consumables.defaultFood()
            .soundAfterConsume(SoundEvents.GENERIC_EAT)
            .onConsume(
                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0), 0.3f))
            .onConsume(
                    new TeleportRandomlyConsumeEffect(5f))
            .onConsume(
                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 0)))
            .build();

    public static final FoodProperties RAW_GREEN_BEEF_FOOD = new FoodProperties.Builder().nutrition(1)
            .saturationModifier(0.15f).build();
}
