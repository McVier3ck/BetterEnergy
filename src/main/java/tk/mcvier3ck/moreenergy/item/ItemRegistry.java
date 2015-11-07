package tk.mcvier3ck.moreenergy.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class ItemRegistry {

	public static Item RedShard;
	public static Item GreenShard;
	public static Item BlueShard;
	public static Item YellowShard;

	public static Item RedIngot;
	public static Item GreenIngot;
	public static Item BlueIngot;
	public static Item YellowIngot;

	public static Item RedDiamond;
	public static Item GreenDiamond;
	public static Item BlueDiamond;
	public static Item YellowDiamond;

	public static Item EmptyCrystal;
	public static Item SpeedCrystal;
	public static Item NightVisionCrystal;
	public static Item ArmorUpgrade1;
	public static Item ArmorUpgrade2;
	public static Item ArmorUpgrade3;

	public static Item RedChestplate;
	public static Item RedHelmet;
	public static Item RedBoots;
	public static Item RedLeggings;

	public static Item BlueChestplate;
	public static Item BlueHelmet;
	public static Item BlueBoots;
	public static Item BlueLeggings;

	public static Item GreenChestplate;
	public static Item GreenHelmet;
	public static Item GreenBoots;
	public static Item GreenLeggings;

	public static Item YellowChestplate;
	public static Item YellowHelmet;
	public static Item YellowBoots;
	public static Item YellowLeggings;

	public static ArmorMaterial ENERGYDIAMOND_ARMOR = EnumHelper.addArmorMaterial("ENERGYDIAMOND_ARMOR", 37,
			new int[] { 4, 9, 7, 4 }, 23);
	public static ArmorMaterial ENERGYINGOT_ARMOR = EnumHelper.addArmorMaterial("ENERGYINGOT_ARMOR", 21,
			new int[] { 3, 7, 6, 3 }, 18);
	public static ArmorMaterial DEFAULT_ARMOR = EnumHelper.addArmorMaterial("DEFAULT_ARMOR", 2,
			new int[] { 0, 1, 1, 0 }, 2);

	public static void Create() {
		//@f:off
		RedShard = new BasicItem().setUnlocalizedName("RedEnergyShard").setTextureName("MoreEnergy:RedShard");
		GreenShard = new BasicItem().setUnlocalizedName("GreenEnergyShard").setTextureName("MoreEnergy:GreenShard");
		BlueShard = new BasicItem().setUnlocalizedName("BlueEnergyShard").setTextureName("MoreEnergy:BlueShard");
		YellowShard = new BasicItem().setUnlocalizedName("YellowEnergyShard").setTextureName("MoreEnergy:YellowShard");

		RedIngot = new BasicItem().setUnlocalizedName("RedEnergyIngot").setTextureName("MoreEnergy:RedenErgyIngot");
		GreenIngot = new BasicItem().setUnlocalizedName("GreenEnergyIngot").setTextureName("MoreEnergy:GreenEnergyIngot");
		BlueIngot = new BasicItem().setUnlocalizedName("BlueEnergyIngot").setTextureName("MoreEnergy:BlueEnergyIngot");
		YellowIngot = new BasicItem().setUnlocalizedName("YellowEnergyIngot").setTextureName("MoreEnergy:YellowEnergyIngot");

		EmptyCrystal = new BasicItem().setUnlocalizedName("EmptyCrystal").setTextureName("MoreEnergy:EmptyCrystal");
		SpeedCrystal = new ArmorUpgrade().setUnlocalizedName("SpeedCrystal").setTextureName("MoreEnergy:SpeedCrystal");
		NightVisionCrystal = new ArmorUpgrade().setUnlocalizedName("NightVisionCrystal").setTextureName("MoreEnergy:NightVisionCrystal");
		ArmorUpgrade1 = new ArmorUpgradeLevel().setUnlocalizedName("ArmorUpgrade1").setTextureName("MoreEnergy:ArmorUpgrade");
		ArmorUpgrade2 = new ArmorUpgradeLevel().setUnlocalizedName("ArmorUpgrade2").setTextureName("MoreEnergy:ArmorUpgrade");
		ArmorUpgrade3 = new ArmorUpgradeLevel().setUnlocalizedName("ArmorUpgrade3").setTextureName("MoreEnergy:ArmorUpgrade");
		

		RedDiamond = new BasicItem().setUnlocalizedName("RedEnergyDiamond").setTextureName("MoreEnergy:RedenErgyDiamond");
		GreenDiamond = new BasicItem().setUnlocalizedName("GreenEnergyDiamond").setTextureName("MoreEnergy:GreenEnergyDiamond");
		BlueDiamond = new BasicItem().setUnlocalizedName("BlueEnergyDiamond").setTextureName("MoreEnergy:BlueEnergyDiamond");
		YellowDiamond = new BasicItem().setUnlocalizedName("YellowEnergyDiamond").setTextureName("MoreEnergy:YellowEnergyDiamond");

		
		RedHelmet = new UpgradeAbleArmor(DEFAULT_ARMOR, "RedArmor", 0).setUnlocalizedName("RedBoots").setTextureName("MoreEnergy:RedHelmet");
		RedChestplate = new UpgradeAbleArmor(DEFAULT_ARMOR, "RedArmor", 1).setUnlocalizedName("RedBoots").setTextureName("MoreEnergy:RedChestplate");
		RedLeggings = new UpgradeAbleArmor(DEFAULT_ARMOR, "RedArmor", 2).setUnlocalizedName("RedBoots").setTextureName("MoreEnergy:RedLeggings");
		RedBoots = new UpgradeAbleArmor(DEFAULT_ARMOR, "RedArmor", 3).setUnlocalizedName("RedBoots").setTextureName("MoreEnergy:RedBoots");
		
		BlueHelmet = new UpgradeAbleArmor(DEFAULT_ARMOR, "BlueArmor", 0).setUnlocalizedName("BlueBoots").setTextureName("MoreEnergy:BlueHelmet");
		BlueChestplate = new UpgradeAbleArmor(DEFAULT_ARMOR, "BlueArmor", 1).setUnlocalizedName("BlueBoots").setTextureName("MoreEnergy:BlueChestplate");
		BlueLeggings = new UpgradeAbleArmor(DEFAULT_ARMOR, "BlueArmor", 2).setUnlocalizedName("BlueBoots").setTextureName("MoreEnergy:BlueLeggings");
		BlueBoots = new UpgradeAbleArmor(DEFAULT_ARMOR, "BlueArmor", 3).setUnlocalizedName("BlueBoots").setTextureName("MoreEnergy:BlueBoots");
		
		GreenHelmet = new UpgradeAbleArmor(DEFAULT_ARMOR, "GreenArmor", 0).setUnlocalizedName("GreenBoots").setTextureName("MoreEnergy:GreenHelmet");
		GreenChestplate = new UpgradeAbleArmor(DEFAULT_ARMOR, "GreenArmor", 1).setUnlocalizedName("GreenBoots").setTextureName("MoreEnergy:GreenChestplate");
		GreenLeggings = new UpgradeAbleArmor(DEFAULT_ARMOR, "GreenArmor", 2).setUnlocalizedName("GreenBoots").setTextureName("MoreEnergy:GreenLeggings");
		GreenBoots = new UpgradeAbleArmor(DEFAULT_ARMOR, "GreenArmor", 3).setUnlocalizedName("GreenBoots").setTextureName("MoreEnergy:GreenBoots");
		
		YellowHelmet = new UpgradeAbleArmor(DEFAULT_ARMOR, "YellowArmor", 0).setUnlocalizedName("YellowBoots").setTextureName("MoreEnergy:YellowHelmet");
		YellowChestplate = new UpgradeAbleArmor(DEFAULT_ARMOR, "YellowArmor", 1).setUnlocalizedName("YellowBoots").setTextureName("MoreEnergy:YellowChestplate");
		YellowLeggings = new UpgradeAbleArmor(DEFAULT_ARMOR, "YellowArmor", 2).setUnlocalizedName("YellowBoots").setTextureName("MoreEnergy:YellowLeggings");
		YellowBoots = new UpgradeAbleArmor(DEFAULT_ARMOR, "YellowArmor", 3).setUnlocalizedName("YellowBoots").setTextureName("MoreEnergy:YellowBoots");
		
		
		//@f:on
	}

	public static void Registry() {
		GameRegistry.registerItem(RedShard, "RedShard");
		GameRegistry.registerItem(RedIngot, "RedIngot");
		GameRegistry.registerItem(RedDiamond, "RedDiamond");

		GameRegistry.registerItem(BlueShard, "BlueShard");
		GameRegistry.registerItem(BlueIngot, "BlueIngot");
		GameRegistry.registerItem(BlueDiamond, "BlueDiamond");

		GameRegistry.registerItem(GreenShard, "GreenShard");
		GameRegistry.registerItem(GreenIngot, "GreenIngot");
		GameRegistry.registerItem(GreenDiamond, "GreenDiamond");

		GameRegistry.registerItem(YellowShard, "YellowShard");
		GameRegistry.registerItem(YellowIngot, "YellowIngot");
		GameRegistry.registerItem(YellowDiamond, "YellowDiamond");

		GameRegistry.registerItem(EmptyCrystal, "EmptyCrystal");
		GameRegistry.registerItem(SpeedCrystal, "SpeedCrystal");
		GameRegistry.registerItem(NightVisionCrystal, "NightVisionCrystal");
		GameRegistry.registerItem(ArmorUpgrade1, "ArmorUpgrade1");
		GameRegistry.registerItem(ArmorUpgrade2, "ArmorUpgrade2");
		GameRegistry.registerItem(ArmorUpgrade3, "ArmorUpgrade3");

		GameRegistry.registerItem(RedHelmet, "RedHelmet");
		GameRegistry.registerItem(RedChestplate, "RedChestplate");
		GameRegistry.registerItem(RedLeggings, "RedLeggings");
		GameRegistry.registerItem(RedBoots, "RedBoots");

		GameRegistry.registerItem(BlueHelmet, "BlueHelmet");
		GameRegistry.registerItem(BlueChestplate, "BlueChestplate");
		GameRegistry.registerItem(BlueLeggings, "BlueLeggings");
		GameRegistry.registerItem(BlueBoots, "BlueBoots");

		GameRegistry.registerItem(GreenHelmet, "GreenHelmet");
		GameRegistry.registerItem(GreenChestplate, "GreenChestplate");
		GameRegistry.registerItem(GreenLeggings, "GreenLeggings");
		GameRegistry.registerItem(GreenBoots, "GreenBoots");

		GameRegistry.registerItem(YellowHelmet, "YellowHelmet");
		GameRegistry.registerItem(YellowChestplate, "YellowChestplate");
		GameRegistry.registerItem(YellowLeggings, "YellowLeggings");
		GameRegistry.registerItem(YellowBoots, "YellowBoots");

		OreDictionary.registerOre("ingotEnergy", RedIngot);
		OreDictionary.registerOre("ingotEnergy", GreenIngot);
		OreDictionary.registerOre("ingotEnergy", RedIngot);
		OreDictionary.registerOre("ingotEnergy", YellowIngot);

		OreDictionary.registerOre("diamondEnergy", RedDiamond);
		OreDictionary.registerOre("diamondEnergy", GreenDiamond);
		OreDictionary.registerOre("diamondEnergy", BlueDiamond);
		OreDictionary.registerOre("diamondEnergy", YellowDiamond);
	}

}
