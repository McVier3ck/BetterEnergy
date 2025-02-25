package tk.mcvier3ck.moreenergy.item;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tk.mcvier3ck.moreenergy.MoreEnergy;

public class UpgradeAbleArmor extends ItemArmor {

	public String textureName;
	
	public static HashMap<UUID, Long> lastOpen = new HashMap<UUID, Long>();

	public UpgradeAbleArmor(ArmorMaterial material, String textureName, int type) {
		super(material, 0, type);
		this.textureName = textureName;
		this.setCreativeTab(MoreEnergy.tabMoreEnergy);
	}

	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return "betterenergy:textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

	}

	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		//MoreEnergy.network.sendToServer(new GuiOpenMessage(MoreEnergy.ArmorID));
		if(!world.isRemote){
			FMLNetworkHandler.openGui(player, MoreEnergy.instance, MoreEnergy.ArmorID, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
		}

		
		return itemStack;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		if (itemStack.stackTagCompound != null) {
			dataList.add("Slot1: " + itemStack.getTagCompound().getString("Slot1"));
			dataList.add("Slot2: " + itemStack.getTagCompound().getString("Slot2"));
			dataList.add("Slot3: " + itemStack.getTagCompound().getString("Slot3"));
		} else {
			dataList.add("Slot1: None");
			dataList.add("Slot2: None");
			dataList.add("Slot3: None");
		}

	}

}
