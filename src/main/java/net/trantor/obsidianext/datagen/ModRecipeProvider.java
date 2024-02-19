package net.trantor.obsidianext.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.trantor.obsidianext.ObsidianExt;
import net.trantor.obsidianext.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
		public ModRecipeProvider(PackOutput pOutput) {
		super(pOutput);
	}

	@Override
	protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.OBSIDIAN_BUTTON.get(),1)
			.requires(Blocks.OBSIDIAN)
			.unlockedBy(getHasName(Blocks.OBSIDIAN), has(Blocks.OBSIDIAN))
			.group("buttons")
			.save(pWriter);
		stonecutterResultFromBase(pWriter,RecipeCategory.REDSTONE,ModBlocks.OBSIDIAN_BUTTON.get(),Blocks.OBSIDIAN);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_DOOR.get(),6)
			.pattern("OO ")
			.pattern("OO ")
			.pattern("OO ")
			.define('O', Blocks.OBSIDIAN)
			.unlockedBy(getHasName(Blocks.OBSIDIAN), has(Blocks.OBSIDIAN))
			.save(pWriter);
		stonecutterResultFromBase(pWriter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.OBSIDIAN_DOOR.get(),Blocks.OBSIDIAN, 2);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_FENCE.get(),5)
			.pattern("OOO")
			.pattern("O O")
			.pattern("   ")
			.define('O', Blocks.OBSIDIAN)
			.unlockedBy(getHasName(Blocks.OBSIDIAN), has(Blocks.OBSIDIAN))
			.save(pWriter);
		stonecutterResultFromBase(pWriter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.OBSIDIAN_FENCE.get(),Blocks.OBSIDIAN);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_FENCE_GATE.get(),5)
			.pattern("O O")
			.pattern("OOO")
			.pattern("   ")
			.define('O', Blocks.OBSIDIAN)
			.unlockedBy(getHasName(Blocks.OBSIDIAN), has(Blocks.OBSIDIAN))
			.save(pWriter);
		stonecutterResultFromBase(pWriter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.OBSIDIAN_FENCE_GATE.get(),Blocks.OBSIDIAN);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_FENCE_GATE.get(),5)
			.pattern("O O")
			.pattern("OOO")
			.pattern("   ")
			.define('O', Blocks.OBSIDIAN)
			.unlockedBy(getHasName(Blocks.OBSIDIAN), has(Blocks.OBSIDIAN))
			.save(pWriter);
		stonecutterResultFromBase(pWriter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.OBSIDIAN_FENCE_GATE.get(),Blocks.OBSIDIAN);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OBSIDIAN_SLAB.get(),6)
			.pattern("OOO")
			.pattern("   ")
			.pattern("   ")
			.define('O', Blocks.OBSIDIAN)
			.unlockedBy(getHasName(Blocks.OBSIDIAN), has(Blocks.OBSIDIAN))
			.save(pWriter);
		stonecutterResultFromBase(pWriter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.OBSIDIAN_SLAB.get(),Blocks.OBSIDIAN, 2);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OBSIDIAN_STAIRS.get(),6)
			.pattern("O  ")
			.pattern("OO ")
			.pattern("OOO")
			.define('O', Blocks.OBSIDIAN)
			.unlockedBy(getHasName(Blocks.OBSIDIAN), has(Blocks.OBSIDIAN))
			.save(pWriter);
		stonecutterResultFromBase(pWriter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.OBSIDIAN_STAIRS.get(),Blocks.OBSIDIAN);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OBSIDIAN_TRAPDOOR.get(),4)
			.pattern("OO ")
			.pattern("OO ")
			.pattern("   ")
			.define('O', Blocks.OBSIDIAN)
			.unlockedBy(getHasName(Blocks.OBSIDIAN), has(Blocks.OBSIDIAN))
			.save(pWriter);
		stonecutterResultFromBase(pWriter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.OBSIDIAN_TRAPDOOR.get(),Blocks.OBSIDIAN);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OBSIDIAN_WALL.get(),6)
			.pattern("   ")
			.pattern("OOO")
			.pattern("OOO")
			.define('O', Blocks.OBSIDIAN)
			.unlockedBy(getHasName(Blocks.OBSIDIAN), has(Blocks.OBSIDIAN))
			.save(pWriter);
		stonecutterResultFromBase(pWriter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.OBSIDIAN_WALL.get(),Blocks.OBSIDIAN);
	}

	protected static void oreSmelting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTIme, @NotNull String pGroup) {
		oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
	}

	protected static void oreBlasting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup) {
		oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
	}

	protected static void oreCooking(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, @NotNull RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup, String pRecipeName) {
		for(ItemLike itemlike : pIngredients) {
			SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
					pExperience, pCookingTime, pCookingSerializer)
				.group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
				.save(pFinishedRecipeConsumer,  ObsidianExt.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
		}
	}
	protected static void stonecutterResultFromBase(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, @NotNull RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial) {
		stonecutterResultFromBase(pFinishedRecipeConsumer, pCategory, pResult, pMaterial, 1);
	}

	protected static void stonecutterResultFromBase(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, @NotNull RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial, int pResultCount) {
		SingleItemRecipeBuilder var10000 = SingleItemRecipeBuilder.stonecutting(Ingredient.of(new ItemLike[]{pMaterial}), pCategory, pResult, pResultCount).unlockedBy(getHasName(pMaterial), has(pMaterial));
		String var10002 = getConversionRecipeName(pResult, pMaterial);
		var10000.save(pFinishedRecipeConsumer, ObsidianExt.MOD_ID + ":" + var10002 + "_stonecutting");
	}

}