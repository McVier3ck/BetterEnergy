package tk.mcvier3ck.moreenergy.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import tk.mcvier3ck.moreenergy.MoreEnergy;

public class MoreEnergyNEIConfig implements IConfigureNEI {

	@Override
	public void loadConfig() {
		API.registerRecipeHandler(new EnergyInfuserRecipeHandler());
		API.registerUsageHandler(new EnergyInfuserRecipeHandler());

	}

	@Override
	public String getVersion() {
		return MoreEnergy.VERSION;
	}

	@Override
	public String getName() {
		return "Better Energy NEI Addon";
	}
}
