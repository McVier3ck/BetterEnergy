package tk.mcvier3ck.moreenergy.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tk.mcvier3ck.moreenergy.block.BlockRegistry;
import tk.mcvier3ck.moreenergy.item.ItemRegistry;

public class MoreEnergyCrafting {

	public static void vanillaCrafting() {
		ItemStack ironStack = new ItemStack(Items.iron_ingot);
		ItemStack redstoneStack = new ItemStack(Items.redstone);
		ItemStack redShard = new ItemStack(ItemRegistry.RedShard);
		ItemStack greenShard = new ItemStack(ItemRegistry.GreenShard);
		ItemStack blueShard = new ItemStack(ItemRegistry.BlueShard);
		ItemStack yellowShard = new ItemStack(ItemRegistry.YellowShard);
		ItemStack redIngot = new ItemStack(ItemRegistry.RedIngot);
		ItemStack greenIngot = new ItemStack(ItemRegistry.GreenIngot);
		ItemStack blueIngot = new ItemStack(ItemRegistry.BlueIngot);
		ItemStack yellowIngot = new ItemStack(ItemRegistry.YellowIngot);

		GameRegistry.addRecipe(new ItemStack(BlockRegistry.MachineBlock), "iai", "grb", "iyi", 'i', ironStack, 'y',
				yellowShard, 'a', redShard, 'g', greenShard, 'b', blueShard, 'r', redstoneStack);

		GameRegistry.addRecipe(new ItemStack(BlockRegistry.MachineBlock), "ibi", "ary", "igi", 'i', ironStack, 'y',
				yellowShard, 'a', redShard, 'g', greenShard, 'b', blueShard, 'r', redstoneStack);

		GameRegistry.addRecipe(new ItemStack(BlockRegistry.MachineBlock), "iyi", "brg", "iai", 'i', ironStack, 'y',
				yellowShard, 'a', redShard, 'g', greenShard, 'b', blueShard, 'r', redstoneStack);

		GameRegistry.addRecipe(new ItemStack(BlockRegistry.MachineBlock), "igi", "yra", "ibi", 'i', ironStack, 'y',
				yellowShard, 'a', redShard, 'g', greenShard, 'b', blueShard, 'r', redstoneStack);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.BlueBoots), "iri", "iri", 'i', blueIngot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.BlueHelmet), "iii", "iri", 'i', blueIngot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.BlueChestplate), "iri", "iii", "iii", 'i', blueIngot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.BlueLeggings), "iii", "iri", "iri", 'i', blueIngot);

	}

	public static void infuserCrafting() {
		EnergyInfuserCraftingRecipe.addRecipe(ItemRegistry.BlueIngot, Items.iron_ingot, Items.redstone, Items.redstone,
				ItemRegistry.BlueShard, 3000);
		EnergyInfuserCraftingRecipe.addRecipe(ItemRegistry.RedIngot, Items.iron_ingot, Items.redstone, Items.redstone,
				ItemRegistry.RedShard, 3000);
		EnergyInfuserCraftingRecipe.addRecipe(ItemRegistry.YellowIngot, Items.iron_ingot, Items.redstone,
				Items.redstone, ItemRegistry.YellowShard, 3000);
		EnergyInfuserCraftingRecipe.addRecipe(ItemRegistry.GreenIngot, Items.iron_ingot, Items.redstone, Items.redstone,
				ItemRegistry.GreenShard, 3000);

		EnergyInfuserCraftingRecipe.addRecipe(ItemRegistry.BlueDiamond, Items.diamond, Items.redstone, Items.redstone,
				ItemRegistry.BlueShard, 10000);
		EnergyInfuserCraftingRecipe.addRecipe(ItemRegistry.RedDiamond, Items.diamond, Items.redstone, Items.redstone,
				ItemRegistry.RedShard, 10000);
		EnergyInfuserCraftingRecipe.addRecipe(ItemRegistry.YellowDiamond, Items.diamond, Items.redstone, Items.redstone,
				ItemRegistry.YellowShard, 10000);
		EnergyInfuserCraftingRecipe.addRecipe(ItemRegistry.GreenDiamond, Items.diamond, Items.redstone, Items.redstone,
				ItemRegistry.GreenShard, 10000);

		armorUpgradeCrafting();
	}

	public static void armorUpgradeCrafting() {
		EnergyInfuserCraftingRecipe.addRecipe(new ItemStack(ItemRegistry.EmptyCrystal),
				new ItemStack(ItemRegistry.BlueDiamond), new ItemStack(ItemRegistry.RedDiamond),
				new ItemStack(ItemRegistry.GreenDiamond, 1, 8226), new ItemStack(ItemRegistry.YellowDiamond, 1, 8226),
				25000);

		EnergyInfuserCraftingRecipe.addRecipe(new ItemStack(ItemRegistry.SpeedCrystal),
				new ItemStack(ItemRegistry.EmptyCrystal), new ItemStack(Items.redstone),
				new ItemStack(Items.potionitem, 1, 8226), new ItemStack(Items.potionitem, 1, 8226), 25000);

		EnergyInfuserCraftingRecipe.addRecipe(new ItemStack(ItemRegistry.NightVisionCrystal),
				new ItemStack(ItemRegistry.EmptyCrystal), new ItemStack(Items.redstone),
				new ItemStack(Items.potionitem, 1, 8262), new ItemStack(Items.potionitem, 1, 8262), 25000);

	}

}
