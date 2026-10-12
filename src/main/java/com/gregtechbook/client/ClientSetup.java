package com.gregtechbook.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class ClientSetup {
    public static void init() {
        // Register screens, renderers, keybinds, etc. here
        // Example: MenuScreens.register(ModContainers.TECH_BOOK.get(), TechBookScreen::new);
        // These classes are to be implemented in the next iteration.

        if (!FMLEnvironment.production) {
            System.out.println("GregTechBook: ClientSetup initialized (dev)");
        }
    }
}
