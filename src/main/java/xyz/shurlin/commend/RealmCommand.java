package xyz.shurlin.commend;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.CommandManager;

public class RealmCommand implements Command<Object> {
    @Override
    public int run(CommandContext<Object> context) throws CommandSyntaxException {

        return 0;
    }
}
