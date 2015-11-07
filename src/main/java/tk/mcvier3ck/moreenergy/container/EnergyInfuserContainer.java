package tk.mcvier3ck.moreenergy.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import tk.mcvier3ck.moreenergy.tileentity.machine.MachineEnergyInfuser;

public class EnergyInfuserContainer extends Container {

	private MachineEnergyInfuser tileEntity;
	private int work;
	private int energy;

	public EnergyInfuserContainer(InventoryPlayer inv, MachineEnergyInfuser tileEntity) {
		this.tileEntity = tileEntity;

		addSlotToContainer(new Slot(tileEntity, 0, 80, 44));
		addSlotToContainer(new Slot(tileEntity, 1, 80, 8));
		addSlotToContainer(new Slot(tileEntity, 2, 116, 44));
		addSlotToContainer(new Slot(tileEntity, 3, 80, 80));
		addSlotToContainer(new Slot(tileEntity, 4, 44, 44));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + (j * 18), 105 + (i * 18)));
			}
		}
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inv, i, 8 + (18 * i), 163));
		}

	}

	@Override
	public void addCraftingToCrafters(ICrafting icrafting) {
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.work);
		icrafting.sendProgressBarUpdate(this, 1, this.tileEntity.getEnergyStored(ForgeDirection.SOUTH));

	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);

			if (this.work != this.tileEntity.work) {
				icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.work);
			}
			if (this.energy != this.tileEntity.getEnergyStored(ForgeDirection.SOUTH)) {
				icrafting.sendProgressBarUpdate(this, 1, this.tileEntity.getEnergyStored(ForgeDirection.SOUTH));
			}

		}

		this.work = this.tileEntity.work;
		this.energy = this.tileEntity.getEnergyStored(ForgeDirection.SOUTH);

	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int value) {
		if (id == 0) {
			this.tileEntity.work = value;
		}
		if (id == 1) {
			this.tileEntity.powerHandler.setEnergyStored(value);
		}

	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);
		// null checks and checks if the item can be stacked (maxStackSize > 1)
		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();
			// merges the item into player inventory since its in the tileEntity
			if (slot < tileEntity.getSizeInventory()) {
				if (!this.mergeItemStack(stackInSlot, tileEntity.getSizeInventory(), 36 + tileEntity.getSizeInventory(),
						true)) {
					return null;
				}
			}
			// places it into the tileEntity is possible since its in the player
			// inventory
			else if (!this.mergeItemStack(stackInSlot, 1, tileEntity.getSizeInventory(), false)) {
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
