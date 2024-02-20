package net.trantor.obsidianext.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.trantor.obsidianext.ObsidianExt;
import net.trantor.obsidianext.block.ModBlocks;
import net.trantor.obsidianext.tag.ModTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.world.item.Item.BY_BLOCK;

public class ModItemTagProvider extends ItemTagsProvider {
	public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
														CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
		super(p_275343_, p_275729_, p_275322_, ObsidianExt.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider pProvider) {
		this.tag(ModTag.Items.OBSIDIAN_ITEMS)
			.add(byBlock(ModBlocks.OBSIDIAN_BUTTON.get()),
				byBlock(ModBlocks.OBSIDIAN_FENCE.get()),
				byBlock(ModBlocks.OBSIDIAN_FENCE_GATE.get()),
				byBlock(ModBlocks.OBSIDIAN_PRESSURE_PLATE.get()),
				byBlock(ModBlocks.OBSIDIAN_SLAB.get()),
				byBlock(ModBlocks.OBSIDIAN_STAIRS.get()),
				byBlock(ModBlocks.OBSIDIAN_TRAPDOOR.get()),
				byBlock(ModBlocks.OBSIDIAN_WALL.get()));
	}
	public static Item byBlock(Block pBlock) {
		return BY_BLOCK.getOrDefault(pBlock, Items.AIR);
	}

}