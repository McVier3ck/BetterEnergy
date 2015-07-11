package tk.McViereck.BetterEnergy.Crafting;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tk.McViereck.BetterEnergy.Item.ItemRegistry;

public class EnergyInfuserCrafting {
	
	public static Map<Item, List<Item>> crafting = new HashMap<Item, List<Item>>();
	public static Map<Item, Integer> energy = new HashMap<Item, Integer>();
	
	public static void infuseditem(ItemStack[] slots) {
		for(Item key : crafting.keySet())
	    {
			if(isrecipe(crafting.get(key).get(0), crafting.get(key).get(1), crafting.get(key).get(2), crafting.get(key).get(3), slots)){
				if(slots[0] == null) {
					slots[0] = new ItemStack(key);
				} else {
					slots[0].stackSize = slots[0].stackSize +1;
				}
			}
	    }
		
		for(int i = 1; i<5 ;i++) {
			if(slots[i].stackSize == 1) {
				slots[i] = null;
			} else {
				slots[i].stackSize = slots[i].stackSize -1;
			}
		}
		
		
		
	}
	
	public static void addRecipe(Item output, Item input1, Item input2, Item input3, Item input4, Integer energycost){
		if (!crafting.containsKey(output)) {
			crafting.put(output, new LinkedList());
		  }
		crafting.get(output).add(input1);
		crafting.get(output).add(input2);
		crafting.get(output).add(input3);
		crafting.get(output).add(input4);
		energy.put(output, energycost);

	}
	
	
	public static Integer getEnergycost(ItemStack[] slots) {
		for(Item key : crafting.keySet())
		{
			if(slots[0] == null || slots[0].getItem() == key && slots[0].stackSize < 64) {
				if(isrecipe(crafting.get(key).get(0), crafting.get(key).get(1), crafting.get(key).get(2), crafting.get(key).get(3), slots)) {
					return energy.get(key);
				}
			}
			
	    }
		
		return null;
		
	}
	

	public static boolean canCraft(ItemStack[] slots) {
		for(Item key : crafting.keySet())
		{
			if(slots[0] == null || slots[0].getItem() == key && slots[0].stackSize < 64) {
				if(isrecipe(crafting.get(key).get(0), crafting.get(key).get(1), crafting.get(key).get(2), crafting.get(key).get(3), slots)) return true;
			}
			
	    }
		
		return false;
	}
	
	public static boolean isrecipe(Item item1, Item item2, Item item3, Item item4, ItemStack[] slots) {
		if(slots[1].getItem() == item1 && slots[2].getItem() == item2 && slots[3].getItem() == item3 &&slots[4].getItem() == item4) return true;
		if(slots[1].getItem() == item1 && slots[2].getItem() == item2 && slots[3].getItem() == item4 &&slots[4].getItem() == item3) return true;
		if(slots[1].getItem() == item1 && slots[2].getItem() == item3 && slots[3].getItem() == item4 &&slots[4].getItem() == item2) return true;
		if(slots[1].getItem() == item1 && slots[2].getItem() == item3 && slots[3].getItem() == item2 &&slots[4].getItem() == item4) return true;
		if(slots[1].getItem() == item1 && slots[2].getItem() == item4 && slots[3].getItem() == item2 &&slots[4].getItem() == item3) return true;
		if(slots[1].getItem() == item1 && slots[2].getItem() == item4 && slots[3].getItem() == item3 &&slots[4].getItem() == item2) return true;
		
		if(slots[1].getItem() == item2 && slots[2].getItem() == item1 &&slots[3].getItem() == item3 &&slots[4].getItem() == item4) return true;
		if(slots[1].getItem() == item2 && slots[2].getItem() == item1 &&slots[3].getItem() == item4 &&slots[4].getItem() == item3) return true;
		if(slots[1].getItem() == item2 && slots[2].getItem() == item3 &&slots[3].getItem() == item1 &&slots[4].getItem() == item4) return true;
		if(slots[1].getItem() == item2 && slots[2].getItem() == item3 &&slots[3].getItem() == item4 &&slots[4].getItem() == item2) return true;
		if(slots[1].getItem() == item2 && slots[2].getItem() == item4 &&slots[3].getItem() == item1 &&slots[4].getItem() == item3) return true;
		if(slots[1].getItem() == item2 && slots[2].getItem() == item4 &&slots[3].getItem() == item3 &&slots[4].getItem() == item1) return true;
	
		if(slots[1].getItem() == item3 && slots[2].getItem() == item1 &&slots[3].getItem() == item2 &&slots[4].getItem() == item4) return true;
		if(slots[1].getItem() == item3 && slots[2].getItem() == item1 &&slots[3].getItem() == item4 &&slots[4].getItem() == item2) return true;
		if(slots[1].getItem() == item3 && slots[2].getItem() == item2 &&slots[3].getItem() == item1 &&slots[4].getItem() == item4) return true;
		if(slots[1].getItem() == item3 && slots[2].getItem() == item2 &&slots[3].getItem() == item4 &&slots[4].getItem() == item1) return true;
		if(slots[1].getItem() == item3 && slots[2].getItem() == item4 &&slots[3].getItem() == item1 &&slots[4].getItem() == item2) return true;
		if(slots[1].getItem() == item3 && slots[2].getItem() == item4 &&slots[3].getItem() == item2 &&slots[4].getItem() == item1) return true;
		
		if(slots[1].getItem() == item4 && slots[2].getItem() == item1 &&slots[3].getItem() == item2 && slots[4].getItem() == item3) return true;
		if(slots[1].getItem() == item4 && slots[2].getItem() == item1 &&slots[3].getItem() == item3 && slots[4].getItem() == item2) return true;
		if(slots[1].getItem() == item4 && slots[2].getItem() == item2 &&slots[3].getItem() == item1 && slots[4].getItem() == item3) return true;
		if(slots[1].getItem() == item4 && slots[2].getItem() == item2 &&slots[3].getItem() == item3 && slots[4].getItem() == item1) return true;
		if(slots[1].getItem() == item4 && slots[2].getItem() == item3 &&slots[3].getItem() == item1 && slots[4].getItem() == item2) return true;
		if(slots[1].getItem() == item4 && slots[2].getItem() == item3 &&slots[3].getItem() == item2 && slots[4].getItem() == item1) return true;
	
		
		return false;
	}
	
}
