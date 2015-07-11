package tk.McViereck.BetterEnergy.TileEntity.Machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;
import cofh.lib.util.helpers.BlockHelper;
import cofh.lib.util.helpers.EnergyHelper;
import cofh.lib.util.helpers.ServerHelper;

public class TileEntityEnergyStorage extends TileEntity implements ISidedInventory, IEnergyProvider{

	private ItemStack[] slots = new ItemStack[5];
	private String customeName = "Energy Storage";
	  public int energyReceive;
	  public int energySend;
	  boolean cached = false;
	
	  public EnergyStorage powerHandler;
	  IEnergyReceiver[] adjacentHandlers = new IEnergyReceiver[6];
	
	public TileEntityEnergyStorage(){
		this.powerHandler = new EnergyStorage(100000, 2500);
	}
	
	
	  protected void transferEnergy(int paramInt)
	  {
	    
	    if (this.adjacentHandlers[paramInt] == null) {
	      return;
	    }
	    this.powerHandler.modifyEnergyStored(-this.adjacentHandlers[paramInt].receiveEnergy(ForgeDirection.VALID_DIRECTIONS[(paramInt ^ 0x1)], 
	      Math.min(this.energySend, this.powerHandler
	      .getEnergyStored()), false));
	  }

	  protected void updateAdjacentHandlers()
	  {
	    if (ServerHelper.isClientWorld(this.worldObj)) {
	      return;
	    }
	    for (int i = 0; i < 6; i++) {
	      TileEntity localTileEntity = BlockHelper.getAdjacentTileEntity(this, i);

	      if (EnergyHelper.isEnergyReceiverFromSide(localTileEntity, ForgeDirection.VALID_DIRECTIONS[(i ^ 0x1)]))
	        this.adjacentHandlers[i] = ((IEnergyReceiver)localTileEntity);
	      else {
	        this.adjacentHandlers[i] = null;
	      }
	    }
	    this.cached = true;
	  }

	  protected void updateAdjacentHandler(int paramInt1, int paramInt2, int paramInt3)
	  {
	    if (ServerHelper.isClientWorld(this.worldObj)) {
	      return;
	    }
	    int i = BlockHelper.determineAdjacentSide(this, paramInt1, paramInt2, paramInt3);

	    TileEntity localTileEntity = this.worldObj.getTileEntity(paramInt1, paramInt2, paramInt3);

	    if (EnergyHelper.isEnergyReceiverFromSide(localTileEntity, ForgeDirection.VALID_DIRECTIONS[(i ^ 0x1)]))
	      this.adjacentHandlers[i] = ((IEnergyReceiver)localTileEntity);
	    else
	      this.adjacentHandlers[i] = null;
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void readFromNBT(NBTTagCompound par1)
    {
        super.readFromNBT(par1);
        NBTTagList nbttaglist = par1.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];

        if (par1.hasKey("CustomName", 8))
        {
            this.customeName = par1.getString("CustomName");
        }


        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.slots.length)
            {
                this.slots[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }
	
	
	
	
	  public void writeToNBT(NBTTagCompound par1)
	    {
	        super.writeToNBT(par1);
	        NBTTagList nbttaglist = new NBTTagList();

	        for (int i = 0; i < this.slots.length; ++i)
	        {
	            if (this.slots[i] != null)
	            {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setByte("Slot", (byte)i);
	                this.slots[i].writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        }

	        par1.setTag("Items", nbttaglist);

	        if (this.hasCustomInventoryName())
	        {
	            par1.setString("CustomName", customeName);
	        }
	    }
	   
	
	
	
	
	@Override
	public void updateEntity() {
		
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
		if(slots[slot] != null) {
			ItemStack itemStack;
			
			if(slots[slot].stackSize <= count) {
				itemStack = slots[slot];
				slots[slot] = null;
				return itemStack;
			} else {
				itemStack = slots[slot].splitStack(count);
				if(slots[slot].stackSize == 0) {
					slots[slot] = null;
				}
				return itemStack;
			}
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if(slots[slot] != null) {
			ItemStack itemStack = slots[slot];
			slots[slot] = null;
			return itemStack;
		}
		
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		slots[slot] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
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
		
		return this.worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5F, yCoord + 0.5F, zCoord + 0.5F) < 64;
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
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		
		return powerHandler.extractEnergy(maxExtract, simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		
		return powerHandler.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return powerHandler.getMaxEnergyStored();
	}


	
}
