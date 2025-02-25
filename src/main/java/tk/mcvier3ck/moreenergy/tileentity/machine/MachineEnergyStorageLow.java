package tk.mcvier3ck.moreenergy.tileentity.machine;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyReceiver;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class MachineEnergyStorageLow extends TileEntity implements ISidedInventory, IEnergyHandler {

	private ItemStack[] slots = new ItemStack[5];
	private String customeName = "Energy Storage";
	public int energyReceive;
	public int energySend;
	boolean cached = false;
	int[] sideConfig = { 1, 1, 1, 1, 1, 1 };
	private int maxStorage = 1000000;
	private int maxInput = 2048;
	private int maxOutput = 2048;

	public EnergyStorage energyStorage = new EnergyStorage(maxStorage, maxInput, maxOutput);

	public MachineEnergyStorageLow() {

	}

	@Override
	public void updateEntity() {
		extractEnergyItem();
		FillEnergyItem();
		for (int i = 0; i < 6; i++) {
			transferEnergy(i);
		}
	}

	protected void transferEnergy(int side) {
		if (this.sideConfig[side] != 1)
			return;
		ForgeDirection fd = ForgeDirection.VALID_DIRECTIONS[side];
		if (worldObj.getTileEntity(xCoord + fd.offsetX, yCoord + fd.offsetY,
				zCoord + fd.offsetZ) instanceof IEnergyReceiver) {
			this.energyStorage.modifyEnergyStored(-((IEnergyReceiver) worldObj.getTileEntity(xCoord + fd.offsetX,
					yCoord + fd.offsetY, zCoord + fd.offsetZ)).receiveEnergy(fd.getOpposite(),
							Math.min(maxOutput, this.energyStorage.getEnergyStored()), false));
		}
	}

	public void extractEnergyItem() {
		if (slots[0] != null) {
			if (slots[0].getItem() instanceof IEnergyContainerItem) {
				IEnergyContainerItem energyitem = (IEnergyContainerItem) slots[0].getItem();
				if (energyStorage.getEnergyStored() < energyStorage.getMaxEnergyStored()) {
					if (energyitem.getEnergyStored(slots[0]) > 0) {
						if (energyitem.getEnergyStored(slots[0]) < maxInput) {
							int lastEnergy = energyitem.getEnergyStored(slots[0]);
							int itemMaxEnergyUse = lastEnergy - energyitem.getEnergyStored(slots[0]);
							if (energyitem.getEnergyStored(slots[0]) > lastEnergy) {

								energyitem.extractEnergy(slots[0], itemMaxEnergyUse, false);
								energyStorage.modifyEnergyStored(+itemMaxEnergyUse);

							} else {
								energyitem.extractEnergy(slots[0], energyitem.getEnergyStored(slots[0]), false);
								energyStorage.modifyEnergyStored(+energyitem.getEnergyStored(slots[0]));
							}

						} else {
							int lastEnergy = energyitem.getEnergyStored(slots[0]);

							energyitem.extractEnergy(slots[0], maxInput, false);
							int itemMaxEnergyUse = lastEnergy - energyitem.getEnergyStored(slots[0]);

							energyStorage.modifyEnergyStored(+itemMaxEnergyUse);
						}

					}

				}
			}
		}
	}

	public void FillEnergyItem() {
		for (int i = 1; i < 4; i++) {
			if (slots[i] != null) {
				if (slots[i].getItem() instanceof IEnergyContainerItem) {
					IEnergyContainerItem energyitem = (IEnergyContainerItem) slots[i].getItem();
					if (energyStorage.getEnergyStored() > 0) {
						if (energyitem.getEnergyStored(slots[i]) < energyitem.getMaxEnergyStored(slots[i])) {
							if (energyStorage.getEnergyStored() < maxOutput) {

								energyitem.receiveEnergy(slots[i], energyStorage.getEnergyStored(), false);
								energyStorage.modifyEnergyStored(-energyStorage.getEnergyStored());
							} else {
								int lastEnergy = energyitem.getEnergyStored(slots[i]);

								energyitem.receiveEnergy(slots[i], maxOutput, false);
								int currentEnergy = energyitem.getEnergyStored(slots[i]);
								int itemMaxEnergyUse = currentEnergy - lastEnergy;

								energyStorage.modifyEnergyStored(-itemMaxEnergyUse);
							}

						}

					}
				}
			}
		}

	}

	@Override
	public Packet getDescriptionPacket() {

		NBTTagCompound par1 = new NBTTagCompound();

		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.slots.length; ++i) {
			if (this.slots[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		par1.setTag("Items", nbttaglist);

		if (this.hasCustomInventoryName()) {
			par1.setString("CustomName", customeName);
		}

		this.energyStorage.writeToNBT(par1);

		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, par1);

	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
	}

	public void readFromNBT(NBTTagCompound par1) {

		super.readFromNBT(par1);
		NBTTagList nbttaglist = par1.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];

		if (par1.hasKey("CustomName", 8)) {
			this.customeName = par1.getString("CustomName");
		}

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.slots.length) {
				this.slots[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
		this.energyStorage.readFromNBT(par1);
	}

	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.slots.length; ++i) {
			if (this.slots[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		par1.setTag("Items", nbttaglist);

		if (this.hasCustomInventoryName()) {
			par1.setString("CustomName", customeName);
		}

		this.energyStorage.writeToNBT(par1);
	}

	@Override
	public int getSizeInventory() {

		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {

		return slots[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int count) {
		if (slots[slot] != null) {
			ItemStack itemStack;

			if (slots[slot].stackSize <= count) {
				itemStack = slots[slot];
				slots[slot] = null;
				return itemStack;
			} else {
				itemStack = slots[slot].splitStack(count);
				if (slots[slot].stackSize == 0) {
					slots[slot] = null;
				}
				return itemStack;
			}
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (slots[slot] != null) {
			ItemStack itemStack = slots[slot];
			slots[slot] = null;
			return itemStack;
		}

		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		slots[slot] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}

	}

	@Override
	public String getInventoryName() {

		return customeName;
	}

	@Override
	public boolean hasCustomInventoryName() {

		return false;
	}

	@Override
	public int getInventoryStackLimit() {

		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {

		return this.worldObj.getTileEntity(xCoord, yCoord, zCoord) == this
				&& player.getDistanceSq(xCoord + 0.5F, yCoord + 0.5F, zCoord + 0.5F) < 64;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {

		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {

		return null;
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side) {

		return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int side) {

		return false;
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {

		return true;
	}

	@Override
	public int receiveEnergy(ForgeDirection paramForgeDirection, int paramInt, boolean paramBoolean) {
		if (paramInt > maxInput) {
			return this.energyStorage.receiveEnergy(maxInput, paramBoolean);
		}
		return this.energyStorage.receiveEnergy(paramInt, paramBoolean);

	}

	@Override
	public int extractEnergy(ForgeDirection paramForgeDirection, int paramInt, boolean paramBoolean) {
		if (paramInt > maxOutput) {
			return this.energyStorage.extractEnergy(maxOutput, paramBoolean);
		}
		return this.energyStorage.extractEnergy(paramInt, paramBoolean);

	}

	@Override
	public int getEnergyStored(ForgeDirection from) {

		return energyStorage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {

		return energyStorage.getMaxEnergyStored();
	}

}
