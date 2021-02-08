package xyz.shurlin.command;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;

public class Commands {
    public static void registerAll() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager.literal("shurlin")
                    .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2))
                        .executes(c -> {
                System.out.println("Called shurlin with no arguments");
                return 1;
            }));
        });
    }
}
