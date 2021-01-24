package xyz.shurlin.client.gui.screen.worker;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import xyz.shurlin.screen.worker.ExtractorScreenHandler;

@Environment(EnvType.CLIENT)
public class ExtractorScreen extends AbstractWorkerScreen<ExtractorScreenHandler> {
    private final int maxExtractant;

    public ExtractorScreen(ExtractorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory,title, handler.getName());
        this.progressLength = 22;
        maxExtractant = 64;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        super.drawBackground(matrices, delta, mouseX, mouseY);
        int i = this.x;
        int j = this.y;
        float k = this.handler.getWorkProgress();
        float extractant = this.handler.getExtractant();
        int len = (int) Math.ceil(extractant / maxExtractant * 18 - 0.01);
        this.drawTexture(matrices, i + 63, j + 60, 176, 0, (int) (k * this.progressLength +1), 13);
        this.drawTexture(matrices, i + 76, j + 46, 176, 13, len, 8);
    }
}
