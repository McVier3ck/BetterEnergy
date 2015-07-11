package tk.McViereck.BetterEnergy.TileEntity.Machine;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;
import tk.McViereck.BetterEnergy.Block.BlockRegistry;
import tk.McViereck.BetterEnergy.Block.EnergyInfuserBlock;
import tk.McViereck.BetterEnergy.Container.EnergyInfuserContainer;
import tk.McViereck.BetterEnergy.Crafting.EnergyInfuserCrafting;
import tk.McViereck.BetterEnergy.TileEntity.TileEntityRegistry;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import cofh.api.tileentity.ISidedTexture;

public class TileEntityEnergyInfuser extends TileEntity implements ISidedInventory, IEnergyReceiver{

	private ItemStack[] slots = new ItemStack[5];
	
    private static final int[] slotsOut = new int[] {0};
    private static final int[] slotsIn = new int[] {0,1,2,3,4};
	
	private String customeName = "Energy Storage";
	  public int energyReceive;
	  public int energySend;
	  boolean cached = false;
	  
	  public int worktime = 20*6;

	  public int tick = 0;
	  public int work = 0;
	  
	  
	  public EnergyStorage powerHandler = new EnergyStorage(30000, 10000, 0);
	
	public TileEntityEnergyInfuser(){
	}


	public void work() {
		if (worldObj.isRemote) return;
		if(slots[1] != null && slots[2] != null && slots[3] != null && slots[4] != null) {
			if(EnergyInfuserCrafting.canCraft(slots)) {
					if(powerHandler.getEnergyStored() >= EnergyInfuserCrafting.getEnergycost(slots)) {
							tick++;
							powerHandler.modifyEnergyStored(-EnergyInfuserCrafting.getEnergycost(slots)/120);
							work++;
					} else {
						reset();
						return;
					}
				
			} else {
				reset();
				return;
			}
			
			if(tick >= worktime){
				reset();
				EnergyInfuserCrafting.infuseditem(slots);
				return;
			} 
			
		} else {
			
			reset();
			return;
		}
		if(tick == 1)  {
			EnergyInfuserBlock.updateWork(true, worldObj ,xCoord ,yCoord ,zCoord);
		}
		
		
		
		return;
	}
	
	public void reset() {
		work = 0;
		tick = 0;
		EnergyInfuserBlock.updateWork(false, worldObj ,xCoord ,yCoord ,zCoord);
		
	}
	
	
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound compound = new NBTTagCompound();
		
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

	        compound.setTag("Items", nbttaglist);
		
		
	        compound.setInteger("Tick", tick);
	        compound.setInteger("Work", work);
	        
	        this.powerHandler.writeToNBT(compound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, compound);

	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
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
        work = par1.getInteger("Work");
        tick = par1.getInteger("Tick");
        
        this.powerHandler.readFromNBT(par1);
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
	        par1.setInteger("Tick", tick);
	        par1.setInteger("Work", work);
	        
	        this.powerHandler.writeToNBT(par1);
	    }
	   
	  @Override
		public void markDirty() {
			super.markDirty();
			

		}
	  
	  

	
	@Override
	public void updateEntity() {
		work();
		super.updateEntity();
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		markDirty();
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
		
		  if (this.slots[slot] != null)
	        {
	            ItemStack itemstack;

	            if (this.slots[slot].stackSize <= count)
	            {
	            	itemstack = slots[slot];
	                this.slots[slot] = null;
	                return itemstack;
	            }
	            else
	            {
	                itemstack = this.slots[slot].splitStack(count);

	                if (this.slots[slot].stackSize == 0)
	                {
	                    this.slots[slot] = null;
	                }

	                return itemstack;
	            }
	        }
	        else
	        {
	            return null;
	        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack item = getStackInSlot(i);
		if (item != null) setInventorySlotContents(i, null);
		return item;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		slots[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		
		return customeName;
	}
	
	public void setInventoryName(String name) {
		this.customeName = name;
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
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		return this.powerHandler.receiveEnergy(maxReceive, simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return powerHandler.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return powerHandler.getMaxEnergyStored();
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}


	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return true;
	}

	
	
	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		
		
		
		return slotsIn;
		
		
	}
	
	
	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
		
		
		return (slot == 1) || (slot == 2) || (slot == 3)|| (slot == 4);
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int side) {
		
		
		
		return slot == 0;
	}

	public int getWork() {
		return work;	
	}
	
	public int getTick() {
		return tick;	
	}


	
	
	
	

	
}
