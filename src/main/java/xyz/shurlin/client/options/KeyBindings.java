package xyz.shurlin.client.options;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import org.lwjgl.glfw.GLFW;
import xyz.shurlin.block.HolyPearAltarBlock;
import xyz.shurlin.item.HolyPearWandItem;
import xyz.shurlin.item.Items;
import xyz.shurlin.util.Utils;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public class KeyBindings {
    public static KeyBinding keyBinding_j;
    public static KeyBinding open_cul;
    public static KeyBinding inject_spirit;


    public KeyBindings() {
        ClientTickCallback.EVENT.register(minecraftClient -> {
            if(open_cul.isPressed()) {
                PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
                ClientSidePacketRegistry.INSTANCE.sendToServer(Utils.OPEN_CUL, passedData);
            }
        });
    }

    static{
        keyBinding_j = new KeyBinding(
                "key.shurlin.1",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                "category.shurlin.test1"
        );
        open_cul = new KeyBinding(
                "key.shurlin.open_cul",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                "category.shurlin.open_cul"
        );
        inject_spirit = new KeyBinding(
                "key.shurlin.inject_spirit",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_I,
                "category.shurlin.inject_spirit"
        );
    }

}
