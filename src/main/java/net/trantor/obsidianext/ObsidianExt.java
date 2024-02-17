package net.trantor.obsidianext;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ObsidianExt.MOD_ID)
public class ObsidianExt {
    public static final String MOD_ID = "obsidianext";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ObsidianExt() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this); // Register ourselves for server and other game events we are interested in
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC); // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
    }
    private void commonSetup(final FMLCommonSetupEvent event) {  // Some common setup code
        LOGGER.info("Setup {}", ObsidianExt.MOD_ID);
        if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)  { // Do something when the server starts
        LOGGER.info("Startup server {}", ObsidianExt.MOD_ID);
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) { // Some client setup code
            LOGGER.info("Startup client {}", ObsidianExt.MOD_ID);
            // LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}