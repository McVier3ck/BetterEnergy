package tk.McViereck.BetterEnergy.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import tk.McViereck.BetterEnergy.Container.EnergyStorageContainer;
import tk.McViereck.BetterEnergy.TileEntity.Machine.TileEntityEnergyStorage;

public class GuiEnergyStorage extends GuiContainer{
	

	
	private final ResourceLocation res = new ResourceLocation("betterenergy:/textures/gui/EnergyStorage.png");
	private TileEntityEnergyStorage entity;
	
	int max = 1000;
	int current = 100;
	
	public GuiEnergyStorage(InventoryPlayer inv, TileEntityEnergyStorage entity) {
		super(new EnergyStorageContainer(inv, entity));
		this.entity = entity;
		this.xSize = 176;
		this.ySize = 166;
		
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {

		fontRendererObj.drawString(current + " / " + max + " RF", (int) (88-(Math.log10(current)+2*18)), 48, 4210752);
		//entity.powerHandler.setEnergyStored(entity.powerHandler.getEnergyStored());
	}
	
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(res);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		drawTexturedModalRect(guiLeft+24, guiTop+32, 0, 166,(int) ((int) current/(max/100)*1.26), 14);
		
		System.out.println(entity.powerHandler.getEnergyStored() + " " + 
		entity.powerHandler.getMaxEnergyStored() + " " + 
		entity.powerHandler.getMaxExtract() + " " + 
		entity.powerHandler.getMaxReceive() + " ");
	}
	
}
