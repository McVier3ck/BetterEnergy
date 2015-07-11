package tk.McViereck.BetterEnergy.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import tk.McViereck.BetterEnergy.TileEntity.Machine.TileEntityEnergyStorage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EnergyStorageContainer extends Container{

	private TileEntityEnergyStorage tileEntity;
	private int energy;
	
	public EnergyStorageContainer(InventoryPlayer inv, TileEntityEnergyStorage tileEntity) {
		this.tileEntity = tileEntity;
		
		addSlotToContainer(new Slot(tileEntity, 0, 80, 6));
		addSlotToContainer(new Slot(tileEntity, 1, 25, 61));
		addSlotToContainer(new Slot(tileEntity, 2, 62, 61));
		addSlotToContainer(new Slot(tileEntity, 3, 98, 61));
		addSlotToContainer(new Slot(tileEntity, 4, 134, 61));
		

		
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
	public void addCraftingToCrafters(ICrafting icrafting) {
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.getEnergyStored(ForgeDirection.SOUTH));
		
	}
	
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);
            
            if (this.energy != this.tileEntity.getEnergyStored(ForgeDirection.SOUTH))
            {
            	icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.getEnergyStored(ForgeDirection.SOUTH));
            }

            
        }

        this.energy = this.tileEntity.getEnergyStored(ForgeDirection.SOUTH);

	}
	
	 @SideOnly(Side.CLIENT)
	    public void updateProgressBar(int id, int value)
	    {
	    
	        if (id == 0)
	        {
	        	this.tileEntity.energyStorage.setEnergyStored(value);
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
                    if (slot < tileEntity.getSizeInventory()) {
                            if (!this.mergeItemStack(stackInSlot, tileEntity.getSizeInventory(), 36+tileEntity.getSizeInventory(), true)) {
                                    return null;
                            }
                    }
                    //places it into the tileEntity is possible since its in the player inventory
                    else if (!this.mergeItemStack(stackInSlot, 0, tileEntity.getSizeInventory(), false)) {
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
	public boolean canInteractWith(EntityPlayer player) {
		
		return tileEntity.isUseableByPlayer(player);
	}
}
