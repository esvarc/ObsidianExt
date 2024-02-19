package net.trantor.obsidianext.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.trantor.obsidianext.block.ModBlocks;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
	public ModBlockLootTables() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate() {
		this.dropSelf(ModBlocks.OBSIDIAN_STAIRS.get());
		this.dropSelf(ModBlocks.OBSIDIAN_BUTTON.get());
		this.dropSelf(ModBlocks.OBSIDIAN_TRAPDOOR.get());
		this.dropSelf(ModBlocks.OBSIDIAN_FENCE.get());
		this.dropSelf(ModBlocks.OBSIDIAN_FENCE_GATE.get());
		this.dropSelf(ModBlocks.OBSIDIAN_WALL.get());
		this.add(ModBlocks.OBSIDIAN_SLAB.get(), block -> createSlabItemTable(ModBlocks.OBSIDIAN_SLAB.get()));
		this.add(ModBlocks.OBSIDIAN_DOOR.get(), block -> createDoorTable(ModBlocks.OBSIDIAN_DOOR.get()));
	}
	protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
		return createSilkTouchDispatchTable(pBlock,
			this.applyExplosionDecay(pBlock,
				LootItem.lootTableItem(item)
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
					.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
	}
	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
