package xyz.shurlin.client.gui.screen.worker;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.shurlin.Shurlin;
import xyz.shurlin.screen.worker.AbstractWorkerScreenHandler;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public abstract class AbstractWorkerScreen<T extends AbstractWorkerScreenHandler> extends HandledScreen<T> {
    private final Identifier TEXTURE;
    protected int progressLength;

    public AbstractWorkerScreen(T handler, PlayerInventory inventory, Text title, String name) {
        super(handler, inventory, title);
        TEXTURE = new Identifier(Shurlin.MODID, "textures/gui/" + name + ".png");
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.drawBackground(matrices,delta,mouseX,mouseY);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        Objects.requireNonNull(this.client).getTextureManager().bindTexture(TEXTURE);
        this.drawTexture(matrices, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }
}
