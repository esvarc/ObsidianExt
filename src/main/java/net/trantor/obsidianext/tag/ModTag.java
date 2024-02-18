package net.trantor.obsidianext.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.trantor.obsidianext.ObsidianExt;

public class ModTag {
	public static class Blocks {
		public static final TagKey<Block> OBSIDIAN_BLOCKS = tag("obsidian_blocks");
		private static TagKey<Block> tag(String name) { return BlockTags.create(new ResourceLocation(ObsidianExt.MOD_ID,name)); }
	}
}
