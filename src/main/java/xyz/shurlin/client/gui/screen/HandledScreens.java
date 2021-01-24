package xyz.shurlin.client.gui.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import xyz.shurlin.client.gui.screen.worker.BreakerScreen;
import xyz.shurlin.client.gui.screen.worker.CollectorScreen;
import xyz.shurlin.client.gui.screen.worker.ConcentratorScreen;
import xyz.shurlin.client.gui.screen.worker.ExtractorScreen;
import xyz.shurlin.cultivation.screen.CultivationScreen;
import xyz.shurlin.screen.ScreenHandlerTypes;

@Environment(EnvType.CLIENT)
public class HandledScreens {
    public static void registerAll() {
        ScreenRegistry.register(ScreenHandlerTypes.BREAKER_SCREEN_HANDLER_TYPE, BreakerScreen::new);
        ScreenRegistry.register(ScreenHandlerTypes.COLLECTOR_SCREEN_HANDLER_TYPE, CollectorScreen::new);
        ScreenRegistry.register(ScreenHandlerTypes.CONCENTRATOR_SCREEN_HANDLER_TYPE, ConcentratorScreen::new);
        ScreenRegistry.register(ScreenHandlerTypes.EXTRACTOR_SCREEN_HANDLER_TYPE, ExtractorScreen::new);
        ScreenRegistry.register(ScreenHandlerTypes.BIGGER_CONTAINER_SCREEN_HANDLER_TYPE, BiggerContainerScreen::new);
        ScreenRegistry.register(ScreenHandlerTypes.CULTIVATION_SCREEN_HANDLER_TYPE, CultivationScreen::new);
    }
}
