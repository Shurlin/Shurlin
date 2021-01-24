package xyz.shurlin.linkage;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;

public class Linkage {
    public static void init() {
        FabricLoader.getInstance().getEntrypoints("shurlin", ShurlinLinkageApi.class).forEach(ShurlinLinkageApi::init);
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        FabricLoader.getInstance().getEntrypoints("shurlin.client", ShurlinLinkageApiClient.class).forEach(ShurlinLinkageApiClient::initClient);
    }
}
