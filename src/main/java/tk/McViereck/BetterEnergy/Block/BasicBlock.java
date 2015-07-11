package tk.McViereck.BetterEnergy.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import tk.McViereck.BetterEnergy.BetterEnergy;

public class BasicBlock extends Block{
	
	protected BasicBlock(Material material) {
		super(material);
		setHardness(5.0F);
		setResistance(2.0F);
		setStepSound(soundTypeStone);
		setCreativeTab(BetterEnergy.tabBetterEnergy);

		setHarvestLevel("pickaxe", 2);
		setHarvestLevel("pickaxe", 1, 0);
		setHarvestLevel("pickaxe", 1, 1);
		setHarvestLevel("pickaxe", 3, 3);
		setHarvestLevel("pickaxe", 3, 6);
		
		
	}
	
	

}
