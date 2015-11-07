package tk.mcvier3ck.moreenergy.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import tk.mcvier3ck.moreenergy.nei.MoreEnergyNEIConfig;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);

		FMLCommonHandler.instance().bus().register(MoreEnergyNEIConfig.class);
		loadNEI();
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	public void loadNEI() {
		MoreEnergyNEIConfig nei = new MoreEnergyNEIConfig();
		nei.loadConfig();
	}

}
