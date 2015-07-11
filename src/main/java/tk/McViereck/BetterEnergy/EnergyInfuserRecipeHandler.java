package tk.McViereck.BetterEnergy;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import tk.McViereck.BetterEnergy.Crafting.EnergyInfuserCrafting;
import tk.McViereck.BetterEnergy.Gui.GuiEnergyInfuser;
import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;


public class EnergyInfuserRecipeHandler extends TemplateRecipeHandler{

	@Override
	public String getRecipeName() {
		
		return "EnergyInfuser Recipe";
	}

	@Override
	public String getGuiTexture() {
		
		return "betterenergy:textures/gui/nei/EnergyInfuser.png";
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
	
	public void drawBackground(int i)
	{
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    GuiDraw.changeTexture(getGuiTexture());
	    GuiDraw.drawTexturedModalRect(-5, -15, 0, 0, 176, 164);
	    
	}
	
	@Override
	public void drawExtras(int recipe) {
		CacheRecipeEnergyInfuser Recipe = (CacheRecipeEnergyInfuser)this.arecipes.get(recipe);
		String Energy = Recipe.getEnergy() + " RF";
		GuiDraw.drawString(Energy, 72-5, 85-15, 8421504);
	}

	
		
	
	@Override
	public void loadCraftingRecipes(ItemStack result) {
		
		if(result == null) {
		      return;
		    }
		
		for(Item key : EnergyInfuserCrafting.crafting.keySet())
		{
			if(key == result.getItem()) {
				arecipes.add(new CacheRecipeEnergyInfuser(EnergyInfuserCrafting.crafting.get(key).get(0), EnergyInfuserCrafting.crafting.get(key).get(0), EnergyInfuserCrafting.crafting.get(key).get(0), EnergyInfuserCrafting.crafting.get(key).get(0), key, EnergyInfuserCrafting.energy.get(key)));
			}
			
	    }
		
		
	}
	


	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		
		      
		      for (Item key : EnergyInfuserCrafting.crafting.keySet()) {
		    	  if(EnergyInfuserCrafting.crafting.get(key).get(0) == ingredient.getItem()) {
		    		  arecipes.add(new CacheRecipeEnergyInfuser(EnergyInfuserCrafting.crafting.get(key).get(0), EnergyInfuserCrafting.crafting.get(key).get(1), EnergyInfuserCrafting.crafting.get(key).get(2), EnergyInfuserCrafting.crafting.get(key).get(3), key, EnergyInfuserCrafting.energy.get(key)));
		    	  } else if(EnergyInfuserCrafting.crafting.get(key).get(1) == ingredient.getItem()) {
		    		  arecipes.add(new CacheRecipeEnergyInfuser(EnergyInfuserCrafting.crafting.get(key).get(0), EnergyInfuserCrafting.crafting.get(key).get(1), EnergyInfuserCrafting.crafting.get(key).get(2), EnergyInfuserCrafting.crafting.get(key).get(3), key, EnergyInfuserCrafting.energy.get(key))); 
		    	  } else if(EnergyInfuserCrafting.crafting.get(key).get(2) == ingredient.getItem()) {
		    		  arecipes.add(new CacheRecipeEnergyInfuser(EnergyInfuserCrafting.crafting.get(key).get(0), EnergyInfuserCrafting.crafting.get(key).get(1), EnergyInfuserCrafting.crafting.get(key).get(2), EnergyInfuserCrafting.crafting.get(key).get(3), key, EnergyInfuserCrafting.energy.get(key))); 
		    	  } else if(EnergyInfuserCrafting.crafting.get(key).get(3) == ingredient.getItem()) {
		    		  arecipes.add(new CacheRecipeEnergyInfuser(EnergyInfuserCrafting.crafting.get(key).get(0), EnergyInfuserCrafting.crafting.get(key).get(1), EnergyInfuserCrafting.crafting.get(key).get(2), EnergyInfuserCrafting.crafting.get(key).get(3), key, EnergyInfuserCrafting.energy.get(key)));
		    	  }
		        
		      }
		   
	}

	
	public class CacheRecipeEnergyInfuser extends TemplateRecipeHandler.CachedRecipe {
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		private final  List<PositionedStack> ingredients = new ArrayList();
	    private final PositionedStack outputresult;
	    private int energy;

	    public List<PositionedStack> getIngredients()
	    {
	      return getCycledIngredients(5 / 20, this.ingredients);
	    }

	    public PositionedStack getResult()
	    {
	      return this.outputresult;
	    }

	    public int getEnergy() { 
	    	return this.energy;
	    }
	    
	    
	    public CacheRecipeEnergyInfuser(Item input1, Item input2, Item input3, Item input4, Item output, Integer Energy) {
	     

	   
	      ingredients.add(new PositionedStack(new ItemStack(input1), 80-5, 14-15));
	      ingredients.add(new PositionedStack(new ItemStack(input2), 105-5, 39-15));
	      ingredients.add(new PositionedStack(new ItemStack(input3), 80-5, 63-15));
	      ingredients.add(new PositionedStack(new ItemStack(input4), 55-5, 39-15));
	      outputresult = new PositionedStack(new ItemStack(output), 80-5, 39-15);
	      this.energy = Energy;
	      
	  }
	}
}
