package xyz.shurlin.commend;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import static net.minecraft.server.command.CommandManager.argument;

public class Commands {
    public Commands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager.literal("shurlin")
                    .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2))
//                    .then(argument())
                        .executes(c -> {
                System.out.println("Called shurlin with no arguments");
                return 1;
            }));
        });
    }
}
