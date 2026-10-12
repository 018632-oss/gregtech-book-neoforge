package com.gregtechbook.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.SimpleMenuProvider;
import net.minecraftforge.network.NetworkHooks;

// NOTE: This class is a minimal placeholder. The GUI/container classes referenced below need to be implemented.
public class GregTechBookItem extends Item {
    public GregTechBookItem(Properties props) { super(props); }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            // TODO: Implement TechBookContainer server-side container
            NetworkHooks.openGui(serverPlayer, new SimpleMenuProvider((id, inventory, p) -> {
                // Replace with real container
                return null;
            }, Component.translatable("item.gregtechbook.gregtech_book")));
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
