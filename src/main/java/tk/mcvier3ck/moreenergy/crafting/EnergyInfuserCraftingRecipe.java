package tk.mcvier3ck.moreenergy.crafting;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnergyInfuserCraftingRecipe {

	public static Map<ItemStack, List<ItemStack>> crafting = new HashMap<ItemStack, List<ItemStack>>();
	public static Map<ItemStack, Integer> energy = new HashMap<ItemStack, Integer>();

	public static void infuseditem(ItemStack[] slots) {
		for (ItemStack key : crafting.keySet()) {
			if (isrecipe(crafting.get(key).get(0), crafting.get(key).get(1), crafting.get(key).get(2),
					crafting.get(key).get(3), slots)) {
				if (slots[0] == null) {
					slots[0] = key;
				} else {
					slots[0].stackSize = slots[0].stackSize + 1;
				}
			}
		}

		for (int i = 1; i < 5; i++) {
			if (slots[i].stackSize == 1) {
				slots[i] = null;
			} else {
				slots[i].stackSize = slots[i].stackSize - 1;
			}
		}

	}

	public static void addRecipe(Item output, Item input1, Item input2, Item input3, Item input4, Integer energycost) {
		addRecipe(new ItemStack(output), new ItemStack(input1), new ItemStack(input2), new ItemStack(input3),
				new ItemStack(input4), energycost);

	}

	public static void addRecipe(ItemStack output, ItemStack input1, ItemStack input2, ItemStack input3,
			ItemStack input4, Integer energycost) {
		if (!crafting.containsKey(output)) {
			crafting.put(output, new LinkedList<ItemStack>());
		}
		crafting.get(output).add(input1);
		crafting.get(output).add(input2);
		crafting.get(output).add(input3);
		crafting.get(output).add(input4);
		energy.put(output, energycost);

	}

	public static Integer getEnergycost(ItemStack[] slots) {
		for (ItemStack key : crafting.keySet()) {
			if (slots[0] == null || slots[0] == key && slots[0].stackSize < 64) {
				if (isrecipe(crafting.get(key).get(0), crafting.get(key).get(1), crafting.get(key).get(2),
						crafting.get(key).get(3), slots)) {
					return energy.get(key);
				}
			}

		}

		return null;

	}

	public static boolean canCraft(ItemStack[] slots) {
		for (ItemStack key : crafting.keySet()) {
			if (slots[0] == null || slots[0] == key && slots[0].stackSize <= key.getMaxStackSize()) {
				if (isrecipe(crafting.get(key).get(0), crafting.get(key).get(1), crafting.get(key).get(2),
						crafting.get(key).get(3), slots))
					return true;
			}

		}

		return false;
	}

	public static boolean isrecipe(ItemStack item1, ItemStack item2, ItemStack item3, ItemStack item4,
			ItemStack[] slots) {

		if (checkIsEqual(1, 2, 3, 4, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(1, 2, 4, 3, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(1, 3, 2, 4, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(1, 3, 4, 2, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(1, 4, 2, 3, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(1, 4, 3, 2, item1, item2, item3, item4, slots))
			return true;

		if (checkIsEqual(2, 1, 3, 4, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(2, 1, 4, 3, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(2, 3, 1, 4, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(2, 3, 4, 1, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(2, 4, 1, 3, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(2, 4, 3, 1, item1, item2, item3, item4, slots))
			return true;

		if (checkIsEqual(3, 1, 2, 4, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(3, 1, 4, 2, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(3, 2, 1, 4, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(3, 2, 4, 1, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(3, 4, 1, 2, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(3, 4, 2, 1, item1, item2, item3, item4, slots))
			return true;

		if (checkIsEqual(4, 1, 2, 3, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(4, 1, 3, 2, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(4, 2, 1, 3, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(4, 2, 3, 1, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(4, 3, 1, 2, item1, item2, item3, item4, slots))
			return true;
		if (checkIsEqual(4, 3, 2, 1, item1, item2, item3, item4, slots))
			return true;

		return false;
	}

	public static boolean checkIsEqual(int a, int b, int c, int d, ItemStack item1, ItemStack item2, ItemStack item3,
			ItemStack item4, ItemStack[] slots) {
		if (slots[a].isItemEqual(item1) && slots[b].isItemEqual(item2) && slots[c].isItemEqual(item4)
				&& slots[d].isItemEqual(item3)) {
			if (slots[a].getTagCompound() == item1.getTagCompound()
					&& slots[b].getTagCompound() == item2.getTagCompound()
					&& slots[c].getTagCompound() == item3.getTagCompound()
					&& slots[d].getTagCompound() == item4.getTagCompound()) {
				return true;
			}

		}
		return false;
	}

}
