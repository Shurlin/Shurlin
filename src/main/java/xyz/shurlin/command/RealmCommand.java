package xyz.shurlin.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

public class RealmCommand implements Command<Object> {
    @Override
    public int run(CommandContext<Object> context) throws CommandSyntaxException {

        return 0;
    }
}
