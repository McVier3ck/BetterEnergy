package tk.mcvier3ck.moreenergy.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import tk.mcvier3ck.moreenergy.container.EnergyStorageContainer;
import tk.mcvier3ck.moreenergy.tileentity.machine.MachineEnergyStorageLow;

public class GuiEnergyStorage extends GuiContainer {

	private final ResourceLocation res = new ResourceLocation("MoreEnergy:/textures/gui/EnergyStorage.png");
	private MachineEnergyStorageLow entity;

	public GuiEnergyStorage(InventoryPlayer inv, MachineEnergyStorageLow entity) {
		super(new EnergyStorageContainer(inv, entity));
		this.entity = entity;
		this.xSize = 176;
		this.ySize = 166;

	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {

		int max = entity.getMaxEnergyStored(ForgeDirection.SOUTH);
		int current = entity.getEnergyStored(ForgeDirection.SOUTH);
		if (current == 0) {
			fontRendererObj.drawString("0 / 0" + " RF", 74, 48, 4210752);
		} else {
			fontRendererObj.drawString(current + " / " + max + " RF", (int) (88 - (Math.log10(current) + 2 * 18)), 48,
					4210752);
		}

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(res);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		int max = entity.getMaxEnergyStored(ForgeDirection.SOUTH);
		int current = entity.getEnergyStored(ForgeDirection.SOUTH);
		double lenght = Math.round(current / (max / 100) * 1.24);

		drawTexturedModalRect(guiLeft + 25, guiTop + 33, 0, 168, (int) lenght, 12);

	}

}
