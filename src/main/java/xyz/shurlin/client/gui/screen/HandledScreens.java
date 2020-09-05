package xyz.shurlin.client.gui.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import xyz.shurlin.client.gui.screen.worker.BreakerScreen;
import xyz.shurlin.screen.ScreenHandlerTypes;

@Environment(EnvType.CLIENT)
public class HandledScreens {
    public HandledScreens() {
        ScreenRegistry.register(ScreenHandlerTypes.BREAKER_SCREEN_HANDLER_TYPE, BreakerScreen::new);
        ScreenRegistry.register(ScreenHandlerTypes.BIGGER_CONTAINER_SCREEN_HANDLER_TYPE, BiggerContainerScreen::new);
    }
}
