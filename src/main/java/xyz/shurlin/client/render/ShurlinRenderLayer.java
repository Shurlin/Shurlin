package xyz.shurlin.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import net.minecraft.util.Identifier;
import xyz.shurlin.Shurlin;

@Environment(EnvType.CLIENT)
public class ShurlinRenderLayer extends RenderPhase {
    private static final Identifier WITH_SPIRIT_ITEM_GLINT = new Identifier(Shurlin.MODID, "textures/misc/with_spirit_item_glint.png");

    private static final RenderLayer SPIRIT_GLINT =
            RenderLayer.of("spirit_glint",
                    VertexFormats.POSITION_TEXTURE, 7, 256,
                    RenderLayer.MultiPhaseParameters.builder().texture(new Texture(WITH_SPIRIT_ITEM_GLINT, true, false))
                            .writeMaskState(COLOR_MASK).cull(DISABLE_CULLING).depthTest(EQUAL_DEPTH_TEST)
                            .transparency(GLINT_TRANSPARENCY).target(ITEM_TARGET).texturing(GLINT_TEXTURING).build(false));

    public ShurlinRenderLayer(String name, Runnable beginAction, Runnable endAction) {
        super(name, beginAction, endAction);
    }

    public static VertexConsumer getGlint(VertexConsumerProvider vertexConsumerProvider, RenderLayer renderLayer) {
        return VertexConsumers.dual(vertexConsumerProvider.getBuffer(SPIRIT_GLINT), vertexConsumerProvider.getBuffer(renderLayer));
    }
}
