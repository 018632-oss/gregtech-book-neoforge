package com.gregtechbook;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.gregtechbook.common.item.GregTechBookItem;
import com.gregtechbook.client.ClientSetup;

@Mod(GregTechBookMod.MODID)
public class GregTechBookMod {
    public static final String MODID = "gregtechbook";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> GREGTECH_BOOK = ITEMS.register("gregtech_book",
            () -> new GregTechBookItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

    public GregTechBookMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        // Register client setup
        net.minecraftforge.fml.DistExecutor.unsafeRunWhenOn(net.minecraftforge.api.distmarker.Dist.CLIENT, () -> () -> ClientSetup.init());
    }
}
