package xyz.shurlin.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import xyz.shurlin.Shurlin;
import xyz.shurlin.cultivation.screen.CultivationScreenHandler;
import xyz.shurlin.screen.worker.BreakerScreenHandler;
import xyz.shurlin.screen.worker.CollectorScreenHandler;
import xyz.shurlin.screen.worker.ConcentratorScreenHandler;
import xyz.shurlin.screen.worker.ExtractorScreenHandler;

public class ScreenHandlerTypes {
    public static void load() {
    }

    public static final ScreenHandlerType<BreakerScreenHandler> BREAKER_SCREEN_HANDLER_TYPE = register("breaker",
            BreakerScreenHandler::new);

    public static final ScreenHandlerType<CollectorScreenHandler> COLLECTOR_SCREEN_HANDLER_TYPE = register("collector",
            CollectorScreenHandler::new);

    public static final ScreenHandlerType<ConcentratorScreenHandler> CONCENTRATOR_SCREEN_HANDLER_TYPE = register("concentrator",
            ConcentratorScreenHandler::new);

    public static final ScreenHandlerType<ExtractorScreenHandler> EXTRACTOR_SCREEN_HANDLER_TYPE = register("extractor",
            ExtractorScreenHandler::new);

    public static final ScreenHandlerType<BiggerContainerScreenHandler> BIGGER_CONTAINER_SCREEN_HANDLER_TYPE = register("bigger_container",
            BiggerContainerScreenHandler::new);

    public static final ScreenHandlerType<CultivationScreenHandler> CULTIVATION_SCREEN_HANDLER_TYPE = register("cultivation_ui",
            CultivationScreenHandler::new);

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String registryName, ScreenHandlerRegistry.SimpleClientHandlerFactory<T> entry){
            return ScreenHandlerRegistry.registerSimple(new Identifier(Shurlin.MODID, registryName), entry);
    }
}
