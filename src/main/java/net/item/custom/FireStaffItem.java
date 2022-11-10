package net.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;


import java.util.function.Predicate;

public class FireStaffItem extends ProjectileWeaponItem {

    public FireStaffItem(Properties properties) {
        super(properties);
    }

    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int i1) {
        if (livingEntity instanceof Player player) {
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, itemStack) > 0;
            ItemStack itemstack = player.getProjectile(itemStack);

            int i = this.getUseDuration(itemStack) - i1;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(itemStack, level, player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, itemStack, player));
                    if (!level.isClientSide) {
                        ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrow abstractarrow = arrowitem.createArrow(level, itemstack, player);
                        abstractarrow = customArrow(abstractarrow);
                        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
                        if (f == 1.0F) {
                            abstractarrow.setCritArrow(true);
                        }

                        itemStack.hurtAndBreak(1, player, (p_40665_) -> {
                            p_40665_.broadcastBreakEvent(player.getUsedItemHand());
                        });
                        if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
                            abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        level.addFreshEntity(abstractarrow);
                    }

                    level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.getInventory().removeItem(itemstack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static float getPowerForTime(int i) {
        float f = (float)i / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public int getUseDuration(ItemStack itemStack) {
        return 36000;
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.CROSSBOW;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        boolean flag = !player.getProjectile(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, level, player, interactionHand, flag);
        if (ret != null) return ret;

        if (!player.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            player.startUsingItem(interactionHand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public AbstractArrow customArrow(AbstractArrow arrow) {
        return arrow;
    }

    public int getDefaultProjectileRange() {
        return 15;
    }
}
