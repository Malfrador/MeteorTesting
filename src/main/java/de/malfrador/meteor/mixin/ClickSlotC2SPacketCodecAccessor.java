package de.malfrador.meteor.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;


@Mixin(ClickSlotC2SPacket.class)
public interface ClickSlotC2SPacketCodecAccessor {
    @Accessor("STACK_MAP_CODEC") @Mutable
    public static void setStackCodecMixin(PacketCodec<RegistryByteBuf, Int2ObjectMap<ItemStack>> codec) {
        throw new AssertionError();
    }
}

