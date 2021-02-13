package xyz.shurlin.mixin;

//@Mixin(ItemRenderer.class)
//@Environment(EnvType.CLIENT)
//public abstract class SpiritGlintMixin {
//    @Redirect(at = @At(value = "INVOKE",
//            target = "Lnet/minecraft/client/render/item/ItemRenderer;getDirectItemGlintConsumer(Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/render/RenderLayer;ZZ)Lnet/minecraft/client/render/VertexConsumer;"),
//            method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V")
//    private VertexConsumer renderItem(VertexConsumerProvider vertexConsumerProvider, RenderLayer renderLayer, boolean bl, boolean bl2, ItemStack stack) {
//        return (stack.getItem() instanceof BasicWeaponItem && ((BasicWeaponItem)stack.getItem()).isWithSpirit())?
//        ShurlinRenderLayer.getGlint(vertexConsumerProvider, renderLayer):
//        ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, renderLayer, bl, bl2);
//    }
//
//}
