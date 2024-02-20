package net.trantor.obsidianext.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trantor.obsidianext.ObsidianExt;
import net.trantor.obsidianext.block.ModBlocks;
import net.trantor.obsidianext.item.ModItems;
import net.trantor.obsidianext.tag.ModTag;

public class ModItemModelProvider extends ItemModelProvider {
	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, ObsidianExt.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		simpleBlockItem(ModBlocks.OBSIDIAN_DOOR);
		fenceItem(ModBlocks.OBSIDIAN_FENCE, ForgeRegistries.BLOCKS.getKey(Blocks.OBSIDIAN).getPath());
		buttonItem(ModBlocks.OBSIDIAN_BUTTON, ForgeRegistries.BLOCKS.getKey(Blocks.OBSIDIAN).getPath());
		wallItem(ModBlocks.OBSIDIAN_WALL, ForgeRegistries.BLOCKS.getKey(Blocks.OBSIDIAN).getPath());
		evenSimplerBlockItem(ModBlocks.OBSIDIAN_STAIRS);
		evenSimplerBlockItem(ModBlocks.OBSIDIAN_SLAB);
		evenSimplerBlockItem(ModBlocks.OBSIDIAN_FENCE_GATE);
		evenSimplerBlockItem(ModBlocks.OBSIDIAN_PRESSURE_PLATE);
		trapdoorItem(ModBlocks.OBSIDIAN_TRAPDOOR);
	}

	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
			new ResourceLocation("item/generated")).texture("layer0",
			new ResourceLocation(ObsidianExt.MOD_ID,"item/" + item.getId().getPath()));
	}

	public void evenSimplerBlockItem(RegistryObject<Block> block) {
		this.withExistingParent(ObsidianExt.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
			modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
	}

	public void trapdoorItem(RegistryObject<Block> block) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
			modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
	}

	public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
			.texture("texture",  new ResourceLocation(ObsidianExt.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
	}
	public void fenceItem(RegistryObject<Block> block, String path) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
			.texture("texture",  new ResourceLocation("minecraft", "block/" + path));
	}

	public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
			.texture("texture",  new ResourceLocation(ObsidianExt.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
	}
	public void buttonItem(RegistryObject<Block> block, String path) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
			.texture("texture",  new ResourceLocation("minecraft", "block/" + path));
	}

	public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
			.texture("wall",  new ResourceLocation(ObsidianExt.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
	}
	public void wallItem(RegistryObject<Block> block, String path) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
			.texture("wall",  new ResourceLocation("minecraft", "block/" + path));
	}

	private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
		return withExistingParent(item.getId().getPath(),
			new ResourceLocation("item/generated")).texture("layer0",
			new ResourceLocation(ObsidianExt.MOD_ID,"item/" + item.getId().getPath()));
	}
}