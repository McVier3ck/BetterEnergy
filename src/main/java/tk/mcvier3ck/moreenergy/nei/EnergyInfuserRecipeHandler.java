package tk.mcvier3ck.moreenergy.nei;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import tk.mcvier3ck.moreenergy.crafting.EnergyInfuserCraftingRecipe;
import tk.mcvier3ck.moreenergy.gui.GuiEnergyInfuser;

public class EnergyInfuserRecipeHandler extends TemplateRecipeHandler {

	@Override
	public String getRecipeName() {

		return "EnergyInfuser Recipe";
	}

	@Override
	public String getGuiTexture() {

		return "MoreEnergy:textures/gui/nei/EnergyInfuser.png";
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass() {

		return GuiEnergyInfuser.class;
	}

	@Override
	public String getOverlayIdentifier() {

		return "EnergyInfuser";
	}

	@Override
	public int recipiesPerPage() {
		return 1;
	}

	public void drawBackground(int i) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GuiDraw.changeTexture(getGuiTexture());
		GuiDraw.drawTexturedModalRect(-5, -15, 0, 0, 176, 164);

	}

	@Override
	public void drawExtras(int recipe) {
		CacheRecipeEnergyInfuser Recipe = (CacheRecipeEnergyInfuser) this.arecipes.get(recipe);
		String Energy = Recipe.getEnergy() + " RF";
		GuiDraw.drawString(Energy, 72 - 5, 85 - 15, 8421504);
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		if (result == null) {
			return;
		}

		for (ItemStack key : EnergyInfuserCraftingRecipe.crafting.keySet()) {
			if (key.getItem() == result.getItem()) {
				arecipes.add(new CacheRecipeEnergyInfuser(EnergyInfuserCraftingRecipe.crafting.get(key).get(0),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(1),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(2),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(3), key,
						EnergyInfuserCraftingRecipe.energy.get(key)));
			}

		}

	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		for (ItemStack key : EnergyInfuserCraftingRecipe.crafting.keySet()) {
			if (EnergyInfuserCraftingRecipe.crafting.get(key).get(0).getItem() == ingredient.getItem()) {
				arecipes.add(new CacheRecipeEnergyInfuser(EnergyInfuserCraftingRecipe.crafting.get(key).get(0),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(1),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(2),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(3), key,
						EnergyInfuserCraftingRecipe.energy.get(key)));
			} else if (EnergyInfuserCraftingRecipe.crafting.get(key).get(1).getItem() == ingredient.getItem()) {
				arecipes.add(new CacheRecipeEnergyInfuser(EnergyInfuserCraftingRecipe.crafting.get(key).get(0),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(1),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(2),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(3), key,
						EnergyInfuserCraftingRecipe.energy.get(key)));
			} else if (EnergyInfuserCraftingRecipe.crafting.get(key).get(2).getItem() == ingredient.getItem()) {
				arecipes.add(new CacheRecipeEnergyInfuser(EnergyInfuserCraftingRecipe.crafting.get(key).get(0),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(1),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(2),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(3), key,
						EnergyInfuserCraftingRecipe.energy.get(key)));
			} else if (EnergyInfuserCraftingRecipe.crafting.get(key).get(3).getItem() == ingredient.getItem()) {
				arecipes.add(new CacheRecipeEnergyInfuser(EnergyInfuserCraftingRecipe.crafting.get(key).get(0),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(1),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(2),
						EnergyInfuserCraftingRecipe.crafting.get(key).get(3), key,
						EnergyInfuserCraftingRecipe.energy.get(key)));
			}

		}

	}

	public class CacheRecipeEnergyInfuser extends TemplateRecipeHandler.CachedRecipe {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		private final List<PositionedStack> ingredients = new ArrayList();
		private final PositionedStack outputresult;
		private int energy;

		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(5 / 20, this.ingredients);
		}

		public PositionedStack getResult() {
			return this.outputresult;
		}

		public int getEnergy() {
			return this.energy;
		}

		public CacheRecipeEnergyInfuser(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4,
				ItemStack output, Integer Energy) {

			ingredients.add(new PositionedStack(input1, 80 - 5, 14 - 15));
			ingredients.add(new PositionedStack(input2, 105 - 5, 39 - 15));
			ingredients.add(new PositionedStack(input3, 80 - 5, 63 - 15));
			ingredients.add(new PositionedStack(input4, 55 - 5, 39 - 15));
			outputresult = new PositionedStack(output, 80 - 5, 39 - 15);
			this.energy = Energy;

		}
	}
}
