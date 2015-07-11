package tk.McViereck.BetterEnergy.Nei;

import tk.McViereck.BetterEnergy.BetterEnergy;
import tk.McViereck.BetterEnergy.EnergyInfuserRecipeHandler;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;


public class BetterEnergyNEIConfig implements IConfigureNEI{

	@Override
	public void loadConfig() {
		
				
	}

	@Override
	public String getVersion() {
		return BetterEnergy.VERSION;
	}

	

	
	@Override
	public String getName() {
		return "Better Energy NEI Addon";
	}
}
