package xyz.shurlin.entity.projectile;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import xyz.shurlin.Shurlin;

@Environment(EnvType.CLIENT)
public class BeanEntityRender extends ProjectileEntityRenderer<BeanEntity> {
    private static final Identifier TEXTURE = new Identifier(Shurlin.MODID,"textures/item/bean.png");

    private BeanEntityRender(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(BeanEntity entity) {
        return TEXTURE;
    }

    public BeanEntityRender(EntityRenderDispatcher entityRenderDispatcher, EntityRendererRegistry.Context context) {
        this(entityRenderDispatcher);
    }
}
