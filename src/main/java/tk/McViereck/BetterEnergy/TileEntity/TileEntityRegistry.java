package tk.McViereck.BetterEnergy.TileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import tk.McViereck.BetterEnergy.BetterEnergy;
import tk.McViereck.BetterEnergy.Block.EnergyInfuserBlock;
import tk.McViereck.BetterEnergy.Block.EnergyStorageBlock;
import tk.McViereck.BetterEnergy.TileEntity.Machine.TileEntityEnergyInfuser;
import tk.McViereck.BetterEnergy.TileEntity.Machine.TileEntityEnergyStorage;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class TileEntityRegistry {
	
	
	public static Block EnergyStorage;
	public static Block EnergyInfuser;

	public static void Create() {
		
		EnergyStorage = new EnergyStorageBlock(Material.ground).setBlockName("Energystorage").setBlockTextureName("betterenergy:MachineBlock_Side");
		EnergyInfuser= new EnergyInfuserBlock(Material.ground).setBlockName("EnergyInfuser").setCreativeTab(BetterEnergy.tabBetterEnergy);

	}
	
	
	public static void Registry() {
		GameRegistry.registerTileEntity(TileEntityEnergyStorage.class, "EnergyStorage");
		GameRegistry.registerBlock(EnergyStorage, "Energystorage");
		
		GameRegistry.registerTileEntity(TileEntityEnergyInfuser.class, "EnergyInfuser");
		GameRegistry.registerBlock(EnergyInfuser, "EnergyInfuser_Work");
	}
	
	public static void Language() {
		LanguageRegistry.addName(EnergyStorage, "Energy Storage (WIP)");
		LanguageRegistry.addName(EnergyInfuser, "Energy Infuser");
	
	}
	
	
	
	
}
