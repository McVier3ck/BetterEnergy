package tk.mcvier3ck.moreenergy.item;

import net.minecraft.item.Item;
import tk.mcvier3ck.moreenergy.MoreEnergy;

public class BasicItem extends Item {

	public BasicItem() {
		maxStackSize = 64;
		setCreativeTab(MoreEnergy.tabMoreEnergy);
	}
}
