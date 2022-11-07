package net.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VoidPickaxeItem extends PickaxeItem {

    public VoidPickaxeItem(Tier tier, int i, float v, Properties properties) {
        super(tier, i, v, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.translatable("Duplicates ores from the void.").withStyle(ChatFormatting.DARK_AQUA));
        } else {
            components.add(Component.translatable("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity plivingEntity41002_) {
        return super.mineBlock(itemStack, level, blockState, blockPos, plivingEntity41002_);
    }

// make it, so it can void a 3x3x3 with the void, then remove durability, add a cooldown of lets say 30 seconds or something.
    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        return super.useOn(useOnContext);
    }
    //add the ore duplication here, don't know if i will let it stack with fortune (so either doubles ore + drops by fortune or doubles ores * fortune)
    //do not allow silktouch on this thing
}