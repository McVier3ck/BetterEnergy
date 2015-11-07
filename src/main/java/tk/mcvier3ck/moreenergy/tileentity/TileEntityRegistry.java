package tk.mcvier3ck.moreenergy.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import tk.mcvier3ck.moreenergy.MoreEnergy;
import tk.mcvier3ck.moreenergy.block.EnergyInfuserBlock;
import tk.mcvier3ck.moreenergy.block.EnergyStorageBlock;
import tk.mcvier3ck.moreenergy.tileentity.machine.MachineEnergyInfuser;
import tk.mcvier3ck.moreenergy.tileentity.machine.MachineEnergyStorageLow;

public class TileEntityRegistry {

	public static Block EnergyStorage;
	public static Block EnergyInfuser;

	public static void Create() {

		EnergyStorage = new EnergyStorageBlock(Material.ground).setBlockName("EnergyStorage")
				.setBlockTextureName("MoreEnergy:MachineBlock_Side");
		EnergyInfuser = new EnergyInfuserBlock(Material.ground).setBlockName("EnergyInfuser")
				.setCreativeTab(MoreEnergy.tabMoreEnergy);

	}

	public static void Registry() {
		GameRegistry.registerTileEntity(MachineEnergyStorageLow.class, "EnergyStorage");
		GameRegistry.registerBlock(EnergyStorage, "EnergyStorage");

		GameRegistry.registerTileEntity(MachineEnergyInfuser.class, "EnergyInfuser");
		GameRegistry.registerBlock(EnergyInfuser, "EnergyInfuser_Work");
	}

}
