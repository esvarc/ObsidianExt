package net.trantor.obsidianext.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.trantor.obsidianext.ObsidianExt;
import net.trantor.obsidianext.block.ModBlocks;

public class ModCreativeModTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ObsidianExt.MOD_ID);
	public static final RegistryObject<CreativeModeTab> OBSIDIANEXT_TAB = CREATIVE_MODE_TABS.register("obsidianext_tab",
		() -> CreativeModeTab.builder().icon(() ->new ItemStack(ModBlocks.OBSIDIAN_FENCE.get()))
			.title(Component.translatable("creativetab.obsidianext_tab"))
			.displayItems((itemDisplayParameters, output) -> {
				output.accept(ModBlocks.OBSIDIAN_BUTTON.get());
				output.accept(ModBlocks.OBSIDIAN_FENCE.get());
				output.accept(ModBlocks.OBSIDIAN_FENCE_GATE.get());
				output.accept(ModBlocks.OBSIDIAN_DOOR.get());
				output.accept(ModBlocks.OBSIDIAN_SLAB.get());
				output.accept(ModBlocks.OBSIDIAN_STAIRS.get());
				output.accept(ModBlocks.OBSIDIAN_TRAPDOOR.get());
				output.accept(ModBlocks.OBSIDIAN_WALL.get());
				output.accept(Blocks.OBSIDIAN);
			}).build());
	public static void register(IEventBus eventBus) { CREATIVE_MODE_TABS.register(eventBus); }
}
