package tk.McViereck.BetterEnergy.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockRegistry {
	
	
	public static Block RedOre;
	public static Block GreenOre;
	public static Block BlueOre;
	public static Block YellowOre;
	
	public static Block MachineBlock;

	public static void Create() {
		
		
		RedOre = new EnergyOreBasic(Material.ground).setBlockName("RedOre").setBlockTextureName("betterenergy:RedOre");
		GreenOre = new EnergyOreBasic(Material.ground).setBlockName("GreenOre").setBlockTextureName("betterenergy:GreenOre");
		BlueOre = new EnergyOreBasic(Material.ground).setBlockName("BlueOre").setBlockTextureName("betterenergy:BlueOre");
		YellowOre = new EnergyOreBasic(Material.ground).setBlockName("YellowOre").setBlockTextureName("betterenergy:YellowOre");
		
		MachineBlock = new BasicBlock(Material.ground).setBlockName("MachineBlock").setBlockTextureName("betterenergy:MachineBlock_Side");
	}
	
	
	public static void Registry() {
		
		GameRegistry.registerBlock(RedOre, "RedOre");
		GameRegistry.registerBlock(GreenOre, "GreenOre");
		GameRegistry.registerBlock(BlueOre, "BlueOre");
		GameRegistry.registerBlock(YellowOre, "YellowOre");
		
		GameRegistry.registerBlock(MachineBlock, "MachineBlock");
	}
	
	public static void Language() {
		
		LanguageRegistry.addName(RedOre, "Red Energy Ore");
		LanguageRegistry.addName(GreenOre, "Green Energy Ore");
		LanguageRegistry.addName(BlueOre, "Blue Energy Ore");
		LanguageRegistry.addName(YellowOre, "Yellow Energy Ore");
		
		LanguageRegistry.addName(MachineBlock, "MachineBlock");
	}
	
	
	
	
}
