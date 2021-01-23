package xyz.shurlin.linkage;

import net.fabricmc.loader.api.FabricLoader;

public class Linkage {
    public static void init() {
        FabricLoader.getInstance().getEntrypoints("shurlin", ShurlinLinkageApi.class).forEach(ShurlinLinkageApi::init);
    }
}
