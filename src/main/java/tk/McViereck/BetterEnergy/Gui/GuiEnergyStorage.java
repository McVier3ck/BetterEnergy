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
	
	
	public GuiEnergyStorage(InventoryPlayer inv, TileEntityEnergyStorage entity) {
		super(new EnergyStorageContainer(inv, entity));
		this.entity = entity;
		this.xSize = 176;
		this.ySize = 166;
		
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {

		int max = entity.getMaxEnergyStored(ForgeDirection.SOUTH);
		int current = entity.getEnergyStored(ForgeDirection.SOUTH);
		
		fontRendererObj.drawString(current + " / " + max + " RF", (int) (88-(Math.log10(current)+2*18)), 48, 4210752);
		
	}
	
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(res);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		
		
 		int max = entity.getMaxEnergyStored(ForgeDirection.SOUTH);
		int current = entity.getEnergyStored(ForgeDirection.SOUTH);
		
		drawTexturedModalRect(guiLeft+25, guiTop+33, 0, 168, (int) (1.24*(100/max*current)), 12);
		
		
	}
	
}
