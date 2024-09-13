package de.malfrador.meteor;

import de.malfrador.meteor.mixin.ClickSlotC2SPacketCodecAccessor;
import de.malfrador.meteor.modules.ItemInflater;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.item.ItemStack;
import net.minecraft.network.codec.PacketCodecs;

public class MeteorTesting extends MeteorAddon {
    public static final Category CATEGORY = new Category("Malfrador");

    @Override
    public void onInitialize() {
        // Modules
        Modules.get().add(new ItemInflater());

        // Mixins
        ClickSlotC2SPacketCodecAccessor.setStackCodecMixin(PacketCodecs.map(
            Int2ObjectOpenHashMap::new, PacketCodecs.SHORT.xmap(Short::intValue, Integer::shortValue), ItemStack.OPTIONAL_PACKET_CODEC, Integer.MAX_VALUE
        )); // We need to increase the size of the client codec, otherwise the client will just disconnect itself
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "de.malfrador.meteor";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("Malfrador", "meteortesting");
    }
}
