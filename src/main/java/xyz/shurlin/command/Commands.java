package xyz.shurlin.command;

import com.mojang.brigadier.Command;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import xyz.shurlin.cultivation.CultivationManager;

import static net.minecraft.server.command.CommandManager.literal;

public class Commands {
    public static void registerAll() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager.literal("shurlin")
                    .then(literal("check_realm"))
                    .executes(c -> {
                        c.getSource().sendFeedback(
                                CultivationManager.INSTANCE.getCultivationRealmByEntity(c.getSource().getPlayer()).getDescribeText(),
                                false);
                        return Command.SINGLE_SUCCESS;
                    }));
        });
    }
}
//                    .then(argument("targets", EntityArgumentType.players())
