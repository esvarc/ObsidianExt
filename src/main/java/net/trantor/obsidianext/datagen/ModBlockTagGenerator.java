package net.trantor.obsidianext.datagen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.trantor.obsidianext.ObsidianExt;
import net.trantor.obsidianext.block.ModBlocks;
import net.trantor.obsidianext.tag.ModTag;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
	public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, ObsidianExt.MOD_ID, existingFileHelper);
	}
	@Override
	protected void addTags(HolderLookup.Provider pProvider) {
		this.tag(ModTag.Blocks.OBSIDIAN_BLOCKS)
			.add(ModBlocks.OBSIDIAN_DOOR.get(),
			  ModBlocks.OBSIDIAN_BUTTON.get(),
				ModBlocks.OBSIDIAN_FENCE.get(),
				ModBlocks.OBSIDIAN_FENCE_GATE.get(),
				ModBlocks.OBSIDIAN_SLAB.get(),
				ModBlocks.OBSIDIAN_STAIRS.get(),
				ModBlocks.OBSIDIAN_TRAPDOOR.get(),
				ModBlocks.OBSIDIAN_WALL.get());
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.add(ModBlocks.OBSIDIAN_DOOR.get(),
				ModBlocks.OBSIDIAN_BUTTON.get(),
				ModBlocks.OBSIDIAN_FENCE.get(),
				ModBlocks.OBSIDIAN_FENCE_GATE.get(),
				ModBlocks.OBSIDIAN_SLAB.get(),
				ModBlocks.OBSIDIAN_STAIRS.get(),
				ModBlocks.OBSIDIAN_TRAPDOOR.get(),
				ModBlocks.OBSIDIAN_WALL.get());
		this.tag(BlockTags.FENCES)
			.add(ModBlocks.OBSIDIAN_FENCE.get());
		this.tag(BlockTags.FENCE_GATES)
			.add(ModBlocks.OBSIDIAN_FENCE_GATE.get());
		this.tag(BlockTags.WALLS)
			.add(ModBlocks.OBSIDIAN_WALL.get());
	}
}