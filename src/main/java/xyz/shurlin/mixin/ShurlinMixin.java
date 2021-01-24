package xyz.shurlin.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//@Mixin(TitleScreen.class)
@Deprecated
public class ShurlinMixin {
    //@Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        System.out.println("Try something new in Shurlin!");
    }
}
