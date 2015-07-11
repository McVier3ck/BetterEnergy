package tk.McViereck.BetterEnergy;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import tk.McViereck.BetterEnergy.Block.BlockRegistry;
import tk.McViereck.BetterEnergy.Crafting.BetterEnergyCrafting;
import tk.McViereck.BetterEnergy.Gui.GuiHandler;
import tk.McViereck.BetterEnergy.Item.ItemRegistry;
import tk.McViereck.BetterEnergy.Nei.BetterEnergyNEIConfig;
import tk.McViereck.BetterEnergy.Proxy.BetterEnergyServerProxy;
import tk.McViereck.BetterEnergy.TileEntity.TileEntityRegistry;
import tk.McViereck.BetterEnergy.World.OreGeneration;
import codechicken.nei.api.API;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid="BetterEnergy", name="BetterEnergy", version = "1.0.0")
public class BetterEnergy {
		
		public static final String VERSION = "1.0.0";
	
		@Instance(value="BetterEnergy")
		public static BetterEnergy instance;
		
		@SidedProxy(clientSide="tk.McViereck.BetterEnergy.Proxy.BetterEnergyClientProxy", serverSide="tk.McViereck.BetterEnergy.Proxy.BetterEnergyClientProxy")
		public static BetterEnergyServerProxy proxy;
	
		public static final int EnergyStorageID = 0;
		public static final int EnergyInfuserID = 1;
		
		
		public static CreativeTabs tabBetterEnergy = new CreativeTabs("BetterEnergyTab") {
			
			
			
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				
				return ItemRegistry.Redshard;
			}
			
			 @Override
			  @SideOnly(Side.CLIENT)
			  public String getTabLabel() {
			    return "BetterEnergy";
			  }

			  @Override
			  @SideOnly(Side.CLIENT)
			  public String getTranslatedTabLabel() {
			    return "BetterEnergy";
			  }
		};
		
		
		
		@EventHandler
		public void preInit(FMLPreInitializationEvent event) {
			BlockRegistry.Create();
			BlockRegistry.Registry();
			
			TileEntityRegistry.Create();
			TileEntityRegistry.Registry();
			
			ItemRegistry.Create();
			ItemRegistry.Registry();
			
			GameRegistry.registerWorldGenerator(new OreGeneration(), 1);
			
			proxy.registerRenderers();
			
			FMLCommonHandler.instance().bus().register(BetterEnergyNEIConfig.class);
			
		}
		
		@EventHandler
		public void load(FMLInitializationEvent event) {
			BetterEnergyCrafting.vanillacrafting();
			BetterEnergyCrafting.infusercrafting();
			
			new GuiHandler();
			
			NEI();
			
		}
		
		@EventHandler
		public void postInit(FMLPostInitializationEvent event) {
			BlockRegistry.Language();
			ItemRegistry.Language();
			TileEntityRegistry.Language();
			
			
		}
		
		public void NEI() {

			API.registerRecipeHandler(new EnergyInfuserRecipeHandler());
			API.registerUsageHandler(new EnergyInfuserRecipeHandler());
		}

}
	

