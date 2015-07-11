package tk.McViereck.BetterEnergy.Block;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tk.McViereck.BetterEnergy.BetterEnergy;
import tk.McViereck.BetterEnergy.TileEntity.Machine.TileEntityEnergyStorage;

public class EnergyStorageBlock extends BlockContainer  {

	public EnergyStorageBlock(Material material) {

		super(material);
		setHardness(5.0F);
		setResistance(10.0F);
		setStepSound(soundTypeMetal);
		setCreativeTab(BetterEnergy.tabBetterEnergy);

		setHarvestLevel("pickaxe", 2);
		setHarvestLevel("pickaxe", 1, 0);
		setHarvestLevel("pickaxe", 1, 1);
		setHarvestLevel("pickaxe", 3, 6);
		setHarvestLevel("pickaxe", 3, 12);
		
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float gity, float hitz) {
		
		TileEntity entity = world.getTileEntity(x, y, z);
		if(world.isRemote) {
			return true;
		} else if (entity != null) {
			FMLNetworkHandler.openGui(player, BetterEnergy.instance, BetterEnergy.EnergyStorageID, world, x, y, z);
			
		}
		
		
		return true;
		
	}

	@Override
	public TileEntity createNewTileEntity(World world, int side) {
		
		return new TileEntityEnergyStorage();
	}
	
}
