package tk.McViereck.BetterEnergy.Gui;

import tk.McViereck.BetterEnergy.BetterEnergy;
import tk.McViereck.BetterEnergy.Container.EnergyInfuserContainer;
import tk.McViereck.BetterEnergy.Container.EnergyStorageContainer;
import tk.McViereck.BetterEnergy.TileEntity.Machine.TileEntityEnergyInfuser;
import tk.McViereck.BetterEnergy.TileEntity.Machine.TileEntityEnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {
	public GuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(BetterEnergy.instance, this);
	}
	
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch (ID) {
			case BetterEnergy.EnergyStorageID: {
				if (entity instanceof TileEntityEnergyStorage) {
					return new EnergyStorageContainer(player.inventory, (TileEntityEnergyStorage) entity);
				}
			} 
			case BetterEnergy.EnergyInfuserID: {
				if (entity instanceof TileEntityEnergyInfuser) {
					return new EnergyInfuserContainer(player.inventory, (TileEntityEnergyInfuser) entity);
				}
			}
			
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch (ID) {
			case BetterEnergy.EnergyStorageID: {
				if (entity instanceof TileEntityEnergyStorage) {
					return new GuiEnergyStorage(player.inventory, (TileEntityEnergyStorage) entity);
				}
			}
			case BetterEnergy.EnergyInfuserID: {
				if (entity instanceof TileEntityEnergyInfuser) {
					return new GuiEnergyInfuser(player.inventory, (TileEntityEnergyInfuser) entity);
				}
			}
			}
		}
		return null;
	}

}
