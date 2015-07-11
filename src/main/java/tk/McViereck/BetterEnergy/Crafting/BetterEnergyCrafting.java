package tk.McViereck.BetterEnergy.Crafting;

import tk.McViereck.BetterEnergy.Block.BlockRegistry;
import tk.McViereck.BetterEnergy.Item.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BetterEnergyCrafting {

	public static void vanillacrafting(){
		ItemStack ironStack = new ItemStack(Items.iron_ingot);
		ItemStack redstoneStack = new ItemStack(Items.redstone);
		ItemStack redShard = new ItemStack(ItemRegistry.Redshard);
		ItemStack greenShard = new ItemStack(ItemRegistry.Greenshard);
		ItemStack blueShard = new ItemStack(ItemRegistry.Blueshard);
		ItemStack yellowShard = new ItemStack(ItemRegistry.Yellowshard);

		
		GameRegistry.addRecipe(
			    new ItemStack(BlockRegistry.MachineBlock),
			    "iai",
			    "grb",
			    "iyi",
			    'i', ironStack, 'y', yellowShard, 'a', redShard, 'g', greenShard, 'b', blueShard, 'r', redstoneStack);
		
		GameRegistry.addRecipe(
			    new ItemStack(BlockRegistry.MachineBlock),
			    "ibi",
			    "ary",
			    "igi",
			    'i', ironStack, 'y', yellowShard, 'a', redShard, 'g', greenShard, 'b', blueShard, 'r', redstoneStack);
		
		GameRegistry.addRecipe(
			    new ItemStack(BlockRegistry.MachineBlock),
			    "iyi",
			    "brg",
			    "iai",
			    'i', ironStack, 'y', yellowShard, 'a', redShard, 'g', greenShard, 'b', blueShard, 'r', redstoneStack);
		
		GameRegistry.addRecipe(
			    new ItemStack(BlockRegistry.MachineBlock),
			    "igi",
			    "yra",
			    "ibi",
			    'i', ironStack, 'y', yellowShard, 'a', redShard, 'g', greenShard, 'b', blueShard, 'r', redstoneStack);
	}
	
	public static void infusercrafting() {
		EnergyInfuserCrafting.addRecipe(ItemRegistry.BlueIngot, Items.iron_ingot, Items.redstone, Items.redstone, ItemRegistry.Blueshard, 3000);
		EnergyInfuserCrafting.addRecipe(ItemRegistry.RedIngot, Items.iron_ingot, Items.redstone, Items.redstone, ItemRegistry.Redshard, 3000);
		EnergyInfuserCrafting.addRecipe(ItemRegistry.YellowIngot, Items.iron_ingot, Items.redstone, Items.redstone, ItemRegistry.Yellowshard, 3000);
		EnergyInfuserCrafting.addRecipe(ItemRegistry.GreenIngot, Items.iron_ingot, Items.redstone, Items.redstone, ItemRegistry.Greenshard, 3000);
		
		EnergyInfuserCrafting.addRecipe(ItemRegistry.BlueDiamond, Items.diamond, Items.redstone, Items.redstone, ItemRegistry.Blueshard, 10000);
		EnergyInfuserCrafting.addRecipe(ItemRegistry.RedDiamond, Items.diamond, Items.redstone, Items.redstone, ItemRegistry.Redshard, 10000);
		EnergyInfuserCrafting.addRecipe(ItemRegistry.YellowDiamond, Items.diamond, Items.redstone, Items.redstone, ItemRegistry.Yellowshard, 10000);
		EnergyInfuserCrafting.addRecipe(ItemRegistry.GreenDiamond, Items.diamond, Items.redstone, Items.redstone, ItemRegistry.Greenshard, 10000);
	}
	
	
}
