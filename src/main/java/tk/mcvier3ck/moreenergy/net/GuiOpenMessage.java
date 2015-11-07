package tk.mcvier3ck.moreenergy.net;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import tk.mcvier3ck.moreenergy.MoreEnergy;

public class GuiOpenMessage implements IMessage{

	private int id;

    public GuiOpenMessage() { }

    public GuiOpenMessage(int id) {
        this.id = id;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    	id = ByteBufUtils.readVarInt(buf, 4);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeVarInt(buf, id, 4);
    }

    public static class Handler implements IMessageHandler<GuiOpenMessage, IMessage> {
        
        @Override
        public IMessage onMessage(GuiOpenMessage message, MessageContext ctx) {
        	EntityPlayerMP player = ctx.getServerHandler().playerEntity;
           FMLNetworkHandler.openGui(player, MoreEnergy.instance, message.id, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
            return null;
        }

       
    }

}
