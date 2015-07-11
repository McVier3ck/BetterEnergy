package tk.McViereck.BetterEnergy.Container;

import tk.McViereck.BetterEnergy.TileEntity.Machine.TileEntityEnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class EnergyStorageContainer extends Container{

	private TileEntityEnergyStorage entity;
	
	
	public EnergyStorageContainer(InventoryPlayer inv, TileEntityEnergyStorage entity) {
		this.entity = entity;
		
		addSlotToContainer(new Slot(entity, 0, 80, 6));
		addSlotToContainer(new Slot(entity, 1, 25, 61));
		addSlotToContainer(new Slot(entity, 2, 62, 61));
		addSlotToContainer(new Slot(entity, 3, 98, 61));
		addSlotToContainer(new Slot(entity, 4, 134, 61));
		

		
		for (int i =0; i <3; i++) {
			for (int j =0; j <9; j++) {
				addSlotToContainer(new Slot(inv, j+i*9+9, 8+ (j*18), 84 + (i*18)));
			}
		}
		for (int i =0; i <9; i++) {
			addSlotToContainer(new Slot(inv, i, 8 + (18*i), 142));
		}
		
		
	}
	
	@Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
            ItemStack stack = null;
            Slot slotObject = (Slot) inventorySlots.get(slot);

            //null checks and checks if the item can be stacked (maxStackSize > 1)
            if (slotObject != null && slotObject.getHasStack()) {
                    ItemStack stackInSlot = slotObject.getStack();
                    stack = stackInSlot.copy();

                    //merges the item into player inventory since its in the tileEntity
                    if (slot < entity.getSizeInventory()) {
                            if (!this.mergeItemStack(stackInSlot, entity.getSizeInventory(), 36+entity.getSizeInventory(), true)) {
                                    return null;
                            }
                    }
                    //places it into the tileEntity is possible since its in the player inventory
                    else if (!this.mergeItemStack(stackInSlot, 0, entity.getSizeInventory(), false)) {
                            return null;
                    }

                    if (stackInSlot.stackSize == 0) {
                            slotObject.putStack(null);
                    } else {
                            slotObject.onSlotChanged();
                    }

                    if (stackInSlot.stackSize == stack.stackSize) {
                            return null;
                    }
                    slotObject.onPickupFromSlot(player, stackInSlot);
            }
            return stack;
    }

	@Override
	public void detectAndSendChanges() {
	super.detectAndSendChanges();
	
		
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		
		return entity.isUseableByPlayer(player);
	}
}
