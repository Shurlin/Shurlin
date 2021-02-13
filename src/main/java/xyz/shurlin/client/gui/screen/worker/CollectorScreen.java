package xyz.shurlin.client.gui.screen.worker;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import xyz.shurlin.screen.worker.CollectorScreenHandler;

@Environment(EnvType.CLIENT)
public class CollectorScreen extends AbstractWorkerScreen<CollectorScreenHandler> {
    protected final int consistenceHeightTotal = 50;

    public CollectorScreen(CollectorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory,title, handler.getName());
        this.progressLength = 46;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        super.drawBackground(matrices, delta, mouseX, mouseY);
        int i = this.x;
        int j = this.y;
        float k = this.handler.getWorkProgress();
        float consistence = this.handler.getConsistence();
        int consistenceHeight = (int) (consistence * this.consistenceHeightTotal);
        this.drawTexture(matrices, i + 46, j + 35, 176, 0, (int) (k * this.progressLength +1), 17);
        this.drawTexture(matrices, i + 144, j + 13 + (consistenceHeightTotal - consistenceHeight), 176, 17 + (consistenceHeightTotal - consistenceHeight), 20, consistenceHeight);
    }
}
