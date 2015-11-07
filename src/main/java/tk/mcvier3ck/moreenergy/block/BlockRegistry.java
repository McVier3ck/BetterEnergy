package tk.mcvier3ck.moreenergy.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRegistry {

	public static Block RedOre;
	public static Block GreenOre;
	public static Block BlueOre;
	public static Block YellowOre;

	public static Block MachineBlock;

	public static void Create() {

		RedOre = new EnergyOreBasic(Material.ground).setBlockName("RedOre").setBlockTextureName("MoreEnergy:RedOre");
		GreenOre = new EnergyOreBasic(Material.ground).setBlockName("GreenOre")
				.setBlockTextureName("MoreEnergy:GreenOre");
		BlueOre = new EnergyOreBasic(Material.ground).setBlockName("BlueOre")
				.setBlockTextureName("moreenergy:BlueOre");
		YellowOre = new EnergyOreBasic(Material.ground).setBlockName("YellowOre")
				.setBlockTextureName("MoreEnergy:YellowOre");

		MachineBlock = new BasicBlock(Material.ground).setBlockName("MachineBlock")
				.setBlockTextureName("MoreEnergy:MachineBlock_Side");
	}

	public static void Registry() {

		GameRegistry.registerBlock(RedOre, "RedOre");
		GameRegistry.registerBlock(BlueOre, "BlueOre");
		GameRegistry.registerBlock(GreenOre, "GreenOre");
		GameRegistry.registerBlock(YellowOre, "YellowOre");

		GameRegistry.registerBlock(MachineBlock, "MachineBlock");
	}

}
