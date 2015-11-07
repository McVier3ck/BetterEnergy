package tk.mcvier3ck.moreenergy.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import tk.mcvier3ck.moreenergy.block.BlockRegistry;
import tk.mcvier3ck.moreenergy.crafting.MoreEnergyCrafting;
import tk.mcvier3ck.moreenergy.item.ItemRegistry;
import tk.mcvier3ck.moreenergy.tileentity.TileEntityRegistry;
import tk.mcvier3ck.moreenergy.util.GuiHandler;
import tk.mcvier3ck.moreenergy.world.OreGeneration;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ItemRegistry.Create();
		ItemRegistry.Registry();

		BlockRegistry.Create();
		BlockRegistry.Registry();

		TileEntityRegistry.Create();
		TileEntityRegistry.Registry();

		GameRegistry.registerWorldGenerator(new OreGeneration(), 1);

	}

	public void init(FMLInitializationEvent event) {
		MoreEnergyCrafting.vanillaCrafting();
		MoreEnergyCrafting.infuserCrafting();

		new GuiHandler();
	}

	public void postInit(FMLPostInitializationEvent event) {
	}

}
