package tk.McViereck.BetterEnergy.Gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL41;

import tk.McViereck.BetterEnergy.Container.EnergyInfuserContainer;
import tk.McViereck.BetterEnergy.Container.EnergyStorageContainer;
import tk.McViereck.BetterEnergy.TileEntity.Machine.TileEntityEnergyInfuser;
import tk.McViereck.BetterEnergy.TileEntity.Machine.TileEntityEnergyStorage;

public class GuiEnergyInfuser extends GuiContainer{
	

	
	private final ResourceLocation res = new ResourceLocation("betterenergy:/textures/gui/EnergyInfuser.png");
	private TileEntityEnergyInfuser entity;
	
	
	
	public GuiEnergyInfuser(InventoryPlayer inv, TileEntityEnergyInfuser entity) {
		super(new EnergyInfuserContainer(inv, entity));
		this.entity = entity;
		this.xSize = 176;
		this.ySize = 187;
		
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		
		
 		int max = entity.getMaxEnergyStored(ForgeDirection.SOUTH);
		int current = entity.getEnergyStored(ForgeDirection.SOUTH);
		double height = current/(max/100)*0.9;
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(res);
		if(height == (int) height) {
			drawTexturedModalRect(158,  (int) (90-height+8), 177, 0, 9, (int) height);

		} else {
			drawTexturedModalRect(158,  (int) (90-height+8), 177, 0, 9, (int) height+1);

		}

		
			
			
		int k = (this.width - this.xSize) / 2; 
		int l = (this.height - this.ySize) / 2; 
	   
		if(x >= guiLeft+158 && x <= guiLeft+158+9) {
			if(y >= guiTop+8 && y <= guiTop+99) {
				List list = new ArrayList();
				list.add(current + " / " + max + " RF");
				
				String text = current + " / " + max + " RF";
				int chars = text.length();
				
				this.drawHoveringText(list, x-k-(chars*6), y-l, fontRendererObj);
			}
		}	
		
	
	}
	
	
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(res);
		int work = entity.getWork();
		
		drawTexturedModalRect(guiLeft+62, guiTop+26, 177, 145, 52, 52);
		drawTexturedModalRect(guiLeft+62, (int) (52-(work*0.43)+guiTop+27), 177, 92, 52, (int) (work*0.43));
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		

	}
	
}
