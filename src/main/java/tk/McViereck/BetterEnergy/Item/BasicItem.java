package tk.McViereck.BetterEnergy.Item;

import tk.McViereck.BetterEnergy.BetterEnergy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicItem extends Item{
	
	public BasicItem() {
			maxStackSize = 64;
			setCreativeTab(BetterEnergy.tabBetterEnergy);
	}
}
