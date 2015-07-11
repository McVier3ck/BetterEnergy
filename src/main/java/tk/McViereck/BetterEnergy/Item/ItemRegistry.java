package tk.McViereck.BetterEnergy.Item;

import tk.McViereck.BetterEnergy.Block.BasicBlock;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemRegistry {
	
	public static Item Redshard;
	public static Item Greenshard;
	public static Item Blueshard;
	public static Item Yellowshard;
	
	public static Item RedIngot;
	public static Item GreenIngot;
	public static Item BlueIngot;
	public static Item YellowIngot;
	
	public static Item RedDiamond;
	public static Item GreenDiamond;
	public static Item BlueDiamond;
	public static Item YellowDiamond;
	

	public static void Create() {
		Redshard = new BasicItem().setUnlocalizedName("RedEnergyShard").setTextureName("betterenergy:Redshard");
		Greenshard = new BasicItem().setUnlocalizedName("GreenEnergyShard").setTextureName("betterenergy:Greenshard");
		Blueshard = new BasicItem().setUnlocalizedName("BlueEnergyShard").setTextureName("betterenergy:Blueshard");
		Yellowshard = new BasicItem().setUnlocalizedName("YellowEnergyShard").setTextureName("betterenergy:Yellowshard");
		
		RedIngot = new BasicItem().setUnlocalizedName("RedEnergyIngot").setTextureName("betterenergy:Redenergyingot");
		GreenIngot = new BasicItem().setUnlocalizedName("GreenEnergyIngot").setTextureName("betterenergy:Greenenergyingot");
		BlueIngot = new BasicItem().setUnlocalizedName("BlueEnergyIngot").setTextureName("betterenergy:Blueenergyingot");
		YellowIngot = new BasicItem().setUnlocalizedName("YellowEnergyIngot").setTextureName("betterenergy:Yellowenergyingot");
		
		RedDiamond = new BasicItem().setUnlocalizedName("RedEnergyDiamond").setTextureName("betterenergy:Redenergydiamond");
		GreenDiamond = new BasicItem().setUnlocalizedName("GreenEnergyDiamond").setTextureName("betterenergy:Greenenergydiamond");
		BlueDiamond = new BasicItem().setUnlocalizedName("BlueEnergyDiamond").setTextureName("betterenergy:Blueenergydiamond");
		YellowDiamond = new BasicItem().setUnlocalizedName("YellowEnergyDiamond").setTextureName("betterenergy:Yellowenergydiamond");
		
	}
	
	
	public static void Registry() {
		GameRegistry.registerItem(Redshard, "RedShard");
		GameRegistry.registerItem(Greenshard, "GreenShard");
		GameRegistry.registerItem(Blueshard, "BlueShard");
		GameRegistry.registerItem(Yellowshard, "YellowShard");
		
		GameRegistry.registerItem(RedIngot, "RedIngot");
		GameRegistry.registerItem(GreenIngot, "GreenIngot");
		GameRegistry.registerItem(BlueIngot, "BlueIngot");
		GameRegistry.registerItem(YellowIngot, "YellowIngot");
		
		GameRegistry.registerItem(RedDiamond, "RedDiamond");
		GameRegistry.registerItem(GreenDiamond, "GreenDiamond");
		GameRegistry.registerItem(BlueDiamond, "BlueDiamond");
		GameRegistry.registerItem(YellowDiamond, "YellowDiamond");
		
	}
	
	public static void Language() {
		LanguageRegistry.addName(Redshard, "Red Energy Shard");
		LanguageRegistry.addName(Greenshard, "Green Energy Shard");
		LanguageRegistry.addName(Blueshard, "Blue Energy Shard");
		LanguageRegistry.addName(Yellowshard, "Yellow Energy Shard");
		
		LanguageRegistry.addName(RedIngot, "Red Energy Ingot");
		LanguageRegistry.addName(GreenIngot, "Green Energy Ingot");
		LanguageRegistry.addName(BlueIngot, "Blue Energy Ingot");
		LanguageRegistry.addName(YellowIngot, "Yellow Energy Ingot");
		
		LanguageRegistry.addName(RedDiamond, "Red Energy Diamond");
		LanguageRegistry.addName(GreenDiamond, "Green Energy Diamond");
		LanguageRegistry.addName(BlueDiamond, "Blue Energy Diamond");
		LanguageRegistry.addName(YellowDiamond, "Yellow Energy Diamond");
		
	}
	
	
	
	
}
