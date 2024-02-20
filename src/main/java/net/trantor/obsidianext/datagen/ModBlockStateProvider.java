package net.trantor.obsidianext.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.trantor.obsidianext.ObsidianExt;
import net.trantor.obsidianext.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
	public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) { super(output, ObsidianExt.MOD_ID, exFileHelper); 	}
	@Override
	protected void registerStatesAndModels() {
		stairsBlock(((StairBlock) ModBlocks.OBSIDIAN_STAIRS.get()), blockTexture(Blocks.OBSIDIAN));
		slabBlock(((SlabBlock) ModBlocks.OBSIDIAN_SLAB.get()), blockTexture(Blocks.OBSIDIAN), blockTexture(Blocks.OBSIDIAN));
		buttonBlock(((ButtonBlock) ModBlocks.OBSIDIAN_BUTTON.get()), blockTexture(Blocks.OBSIDIAN));
		fenceBlock(((FenceBlock) ModBlocks.OBSIDIAN_FENCE.get()), blockTexture(Blocks.OBSIDIAN));
		fenceGateBlock(((FenceGateBlock) ModBlocks.OBSIDIAN_FENCE_GATE.get()), blockTexture(Blocks.OBSIDIAN));
		pressurePlateBlock((PressurePlateBlock) ModBlocks.OBSIDIAN_PRESSURE_PLATE.get(), blockTexture(Blocks.OBSIDIAN));
		wallBlock(((WallBlock) ModBlocks.OBSIDIAN_WALL.get()), blockTexture(Blocks.OBSIDIAN));
		doorBlockWithRenderType(((DoorBlock) ModBlocks.OBSIDIAN_DOOR.get()), modLoc("block/obsidian_door_bottom"), modLoc("block/obsidian_door_top"), "cutout");
		trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.OBSIDIAN_TRAPDOOR.get()), modLoc("block/obsidian_trapdoor"), true, "cutout");
	}
	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}
}
