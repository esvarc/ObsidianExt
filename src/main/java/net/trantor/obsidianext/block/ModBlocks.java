package net.trantor.obsidianext.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trantor.obsidianext.ObsidianExt;
import net.trantor.obsidianext.item.ModItems;

import javax.swing.*;
import java.util.function.Supplier;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ObsidianExt.MOD_ID);
	public static final RegistryObject<Block> OBSIDIAN_BUTTON = registerBlock("obsidian_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).explosionResistance(1f), BlockSetType.IRON, 10, false));
	public static final RegistryObject<Block> OBSIDIAN_DOOR = registerBlock("obsidian_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).explosionResistance(1f).noOcclusion() ,BlockSetType.IRON));
	public static final RegistryObject<Block> OBSIDIAN_FENCE = registerBlock("obsidian_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).explosionResistance(1f)));
	public static final RegistryObject<Block> OBSIDIAN_FENCE_GATE = registerBlock("obsidian_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).explosionResistance(1f),SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

	public static final RegistryObject<Block> OBSIDIAN_SLAB = registerBlock("obsidian_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
	public static final RegistryObject<Block> OBSIDIAN_STAIRS = registerBlock("obsidian_stairs", () -> new StairBlock(Blocks.OBSIDIAN::defaultBlockState,BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
	public static final RegistryObject<Block> OBSIDIAN_TRAPDOOR = registerBlock("obsidian_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).explosionResistance(1f).noOcclusion(),BlockSetType.IRON));
	public static final RegistryObject<Block> OBSIDIAN_WALL = registerBlock("obsidian_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).explosionResistance(1f)));
	private static  <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name,toReturn);
		return toReturn;
	}
	private static  <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
	public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); 	}
}