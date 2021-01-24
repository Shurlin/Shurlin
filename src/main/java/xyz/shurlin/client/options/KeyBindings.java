package xyz.shurlin.client.options;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.ClickEvent;
import org.lwjgl.glfw.GLFW;
import xyz.shurlin.util.Utils;

@Environment(EnvType.CLIENT)
public class KeyBindings {
    public static KeyBinding keyBinding_j;
    public static KeyBinding open_cul;
    public static KeyBinding inject_spirit;


    public static void registerAll() {
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
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
