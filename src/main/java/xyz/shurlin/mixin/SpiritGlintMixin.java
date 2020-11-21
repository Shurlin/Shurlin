package xyz.shurlin.mixin;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.shurlin.client.render.ShurlinRenderLayer;
import xyz.shurlin.item.BasicWeaponItem;

@Mixin(ItemRenderer.class)
public abstract class SpiritGlintMixin {
    @Redirect(at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/render/item/ItemRenderer;method_29711(Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/render/RenderLayer;ZZ)Lnet/minecraft/client/render/VertexConsumer;"),
            method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V")
    private VertexConsumer renderItem(VertexConsumerProvider vertexConsumerProvider, RenderLayer renderLayer, boolean bl, boolean bl2, ItemStack stack) {
        return (stack.getItem() instanceof BasicWeaponItem && ((BasicWeaponItem)stack.getItem()).isWithSpirit())?
        ShurlinRenderLayer.getGlint(vertexConsumerProvider, renderLayer):
        ItemRenderer.method_29711(vertexConsumerProvider, renderLayer, bl, bl2);
    }

}
