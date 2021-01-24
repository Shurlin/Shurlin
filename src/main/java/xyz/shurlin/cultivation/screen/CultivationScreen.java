package xyz.shurlin.cultivation.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import xyz.shurlin.Shurlin;
import xyz.shurlin.cultivation.CultivationRealm;
import xyz.shurlin.cultivation.SpiritMeridians;
import xyz.shurlin.cultivation.SpiritPropertyType;

import java.util.Objects;

import static net.minecraft.util.math.MathHelper.abs;
import static net.minecraft.util.math.MathHelper.floor;

@Environment(EnvType.CLIENT)
public class CultivationScreen extends HandledScreen<CultivationScreenHandler> {
    private final Identifier TEXTURE = new Identifier(Shurlin.MODID, "textures/gui/cultivation_ui.png");
    private final CultivationRealm realm = handler.realm;
    private final Object2ObjectArrayMap<SpiritPropertyType, SpiritMeridians> meridians = realm.getMeridians();
    private static final int COLOR = 4210752;

    public CultivationScreen(CultivationScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 256;
        this.backgroundHeight = 200;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        Objects.requireNonNull(this.client).getTextureManager().bindTexture(TEXTURE);
        this.drawTexture(matrices, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);
        for (SpiritPropertyType type : SpiritPropertyType.GROUPS) {
            SpiritMeridians meridians = this.meridians.get(type);
            this.draw(matrices, type, meridians);
        }
    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        this.textRenderer.draw(matrices, this.title, (float) this.titleX, (float) this.titleY, COLOR);
        for (SpiritPropertyType type : SpiritPropertyType.GROUPS) {
//            SpiritMeridians meridians = this.meridians.get(type);
//            this.drawText(matrices, type, meridians);
            this.drawText(matrices, type);
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.drawBackground(matrices, delta, mouseX, mouseY);
        super.render(matrices, mouseX, mouseY, delta);
    }

    private void draw(MatrixStack matrices, SpiritPropertyType type, SpiritMeridians meridians) {
        int id = type.getId() - 1;
        boolean lr = id / 6 == 0;
        int order = id % 6;
        int height = 5;
        int width = 61;
        int x = this.x + (lr ? 18 : 177) + floor(abs((float) order - 2.5f)) * 12 * (lr ? 1 : -1);
        int y = this.y + 71 + order * 22 + (order > 2 ? 1 : 0);
        int u = lr ? 0 : width;
        int v = 200 + order * height;
        double percentage1 = meridians.getCurSpirit() / meridians.getMaxSpirit();
        double percentage2 = meridians.getCurEx() / meridians.getMaxEx();
        this.drawTexture(matrices, x, y, u, v, (int) (width * percentage1), height);
        this.drawTexture(matrices, x, y + 6, 122, 200, (int) (width * percentage2), height);
    }

    private void drawText(MatrixStack matrices, SpiritPropertyType type){
        int id = type.getId() - 1;
        boolean lr = id / 6 == 0;
        int order = id % 6;
        int x = this.x + (lr ? 18 : 177) + floor(abs((float) order - 2.5f)) * 12 * (lr ? 1 : -1);
        int y = this.y + 62 + order * 22 + (order > 2 ? 1 : 0);
        this.textRenderer.draw(matrices, new TranslatableText(type.getTranslation()), x, y, COLOR);
    }


}
