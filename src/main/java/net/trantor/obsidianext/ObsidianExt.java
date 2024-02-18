package net.trantor.obsidianext;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.trantor.obsidianext.block.ModBlocks;
import net.trantor.obsidianext.creativetab.ModCreativeModTabs;
import net.trantor.obsidianext.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ObsidianExt.MOD_ID)
public class ObsidianExt {
    public static final String MOD_ID = "obsidianext";
    private static final Logger LOGGER = LogUtils.getLogger();
    public ObsidianExt() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }
    private void commonSetup(final FMLCommonSetupEvent event) { LOGGER.info("Setup {}", ObsidianExt.MOD_ID); }
    private void addCreative(BuildCreativeModeTabContentsEvent event) { }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)  { // Do something when the server starts
        LOGGER.info("Startup server {}", ObsidianExt.MOD_ID);
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) { LOGGER.info("Startup client {}", ObsidianExt.MOD_ID); }
    }
}
