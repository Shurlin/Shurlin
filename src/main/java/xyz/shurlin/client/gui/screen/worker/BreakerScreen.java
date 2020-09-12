package xyz.shurlin.client.gui.screen.worker;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import xyz.shurlin.screen.worker.BreakerScreenHandler;

@Environment(EnvType.CLIENT)
public class BreakerScreen extends AbstractWorkerScreen<BreakerScreenHandler> {

    public BreakerScreen(BreakerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory,title, handler.getName());
        this.progressLength = 22;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        super.drawBackground(matrices, delta, mouseX, mouseY);
        int i = this.x;
        int j = this.y;
        float k = this.handler.getWorkProgress();
        this.drawTexture(matrices, i + 79, j + 34, 176, 0, (int) (k * this.progressLength +1), 16);
    }
}
