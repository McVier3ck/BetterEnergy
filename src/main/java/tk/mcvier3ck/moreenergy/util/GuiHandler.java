package tk.mcvier3ck.moreenergy.util;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tk.mcvier3ck.moreenergy.MoreEnergy;
import tk.mcvier3ck.moreenergy.container.ArmorContainer;
import tk.mcvier3ck.moreenergy.container.EnergyInfuserContainer;
import tk.mcvier3ck.moreenergy.container.EnergyStorageContainer;
import tk.mcvier3ck.moreenergy.gui.GuiArmor;
import tk.mcvier3ck.moreenergy.gui.GuiEnergyInfuser;
import tk.mcvier3ck.moreenergy.gui.GuiEnergyStorage;
import tk.mcvier3ck.moreenergy.tileentity.machine.MachineEnergyInfuser;
import tk.mcvier3ck.moreenergy.tileentity.machine.MachineEnergyStorageLow;

public class GuiHandler implements IGuiHandler {
	public GuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(MoreEnergy.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			switch (ID) {
			case MoreEnergy.EnergyStorageID: {
				TileEntity entity = world.getTileEntity(x, y, z);
				if (entity instanceof MachineEnergyStorageLow) {
					return new EnergyStorageContainer(player.inventory, (MachineEnergyStorageLow) entity);
				}
			}
			case MoreEnergy.EnergyInfuserID: {
				TileEntity entity = world.getTileEntity(x, y, z);
				if (entity instanceof MachineEnergyInfuser) {
					return new EnergyInfuserContainer(player.inventory, (MachineEnergyInfuser) entity);
				}
			}
			case MoreEnergy.ArmorID: {
				return new ArmorContainer(player.inventory);
			}

			}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			switch (ID) {
			case MoreEnergy.EnergyStorageID: {
				TileEntity entity = world.getTileEntity(x, y, z);
				if (entity instanceof MachineEnergyStorageLow) {
					return new GuiEnergyStorage(player.inventory, (MachineEnergyStorageLow) entity);
			}
			}
			case MoreEnergy.EnergyInfuserID: {
				TileEntity entity = world.getTileEntity(x, y, z);
				if (entity instanceof MachineEnergyInfuser) {
					return new GuiEnergyInfuser(player.inventory, (MachineEnergyInfuser) entity);
				}
			}
			case MoreEnergy.ArmorID: {
				
					return new GuiArmor(player.inventory, new ArmorContainer(player.inventory));
			}
			}
		return null;
	}

}
