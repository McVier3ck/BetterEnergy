package tk.McViereck.BetterEnergy.Block;

import java.util.Random;

import tk.McViereck.BetterEnergy.BetterEnergy;
import tk.McViereck.BetterEnergy.Item.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class EnergyOreBasic extends Block{

	protected EnergyOreBasic(Material material) {
		super(material);
		setHardness(5.0F);
		setResistance(2.0F);
		setStepSound(soundTypeStone);
		setCreativeTab(BetterEnergy.tabBetterEnergy);
		setLightLevel(0.3F);

		setHarvestLevel("pickaxe", 2);
		setHarvestLevel("pickaxe", 1, 0);
		setHarvestLevel("pickaxe", 1, 1);
		setHarvestLevel("pickaxe", 3, 6);
		setHarvestLevel("pickaxe", 3, 12);
	}
	
	public Item getItemDropped(int metadata, Random random, int fortune)
    {
        return this == BlockRegistry.RedOre ? ItemRegistry.Redshard : 
        	(this == BlockRegistry.GreenOre ? ItemRegistry.Greenshard : 
        	(this == BlockRegistry.BlueOre ? ItemRegistry.Blueshard : 
        	(this == BlockRegistry.YellowOre ? ItemRegistry.Yellowshard : 
            Item.getItemFromBlock(this))));
    }
	
	private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
    {
            int j1 = 0;
            
            j1 = MathHelper.getRandomIntegerInRange(rand, 2, 5);
         
            return j1;
        
    }
    
    public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_)
    {
        if (p_149679_1_ > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, p_149679_2_, p_149679_1_))
        {
            int j = p_149679_2_.nextInt(p_149679_1_ + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(p_149679_2_) * (j + 1);
        }
        else
        {
            return this.quantityDropped(p_149679_2_);
        }
    }

}
