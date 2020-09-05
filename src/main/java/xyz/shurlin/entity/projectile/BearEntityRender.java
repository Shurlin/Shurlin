package xyz.shurlin.entity.projectile;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.util.Identifier;
import xyz.shurlin.Shurlin;

@Environment(EnvType.CLIENT)
public class BearEntityRender extends ProjectileEntityRenderer<HolyPearArrowEntity> {
    private static final Identifier TEXTURE = new Identifier(Shurlin.MODID,"textures/item/bean.png");

    private BearEntityRender(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    public BearEntityRender(EntityRenderDispatcher entityRenderDispatcher, EntityRendererRegistry.Context context) {
        this(entityRenderDispatcher);

    }

    @Override
    public Identifier getTexture(HolyPearArrowEntity entity) {
        return TEXTURE;
    }
}
