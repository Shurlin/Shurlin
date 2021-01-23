package xyz.shurlin.linkage;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@FunctionalInterface
@Environment(EnvType.CLIENT)
public interface ShurlinLinkageApiClient {
    void initClient();
}
