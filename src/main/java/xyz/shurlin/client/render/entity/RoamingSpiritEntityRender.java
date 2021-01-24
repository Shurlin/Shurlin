package xyz.shurlin.client.render.entity;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import xyz.shurlin.client.render.entity.model.RoamingSpiritEntityModel;
import xyz.shurlin.entity.passive.RoamingSpiritEntity;

public class RoamingSpiritEntityRender extends MobEntityRenderer<RoamingSpiritEntity, RoamingSpiritEntityModel> {

    public RoamingSpiritEntityRender(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new RoamingSpiritEntityModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(RoamingSpiritEntity entity) {
        return null;//TODO
    }
}
