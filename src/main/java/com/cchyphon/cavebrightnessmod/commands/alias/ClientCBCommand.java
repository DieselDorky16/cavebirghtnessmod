package com.cchyphon.cavebrightnessmod.commands.alias;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

@SuppressWarnings("ALL")
public class ClientCBCommand {

    public ClientCBCommand() {
    }

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) CommandManager.literal("cb").requires((serverCommandSource) -> {
            return serverCommandSource.hasPermissionLevel(0);
        })).then(CommandManager.literal("low").executes((commandContext) -> {
            return low((ServerCommandSource)commandContext.getSource(), 1.5F);
        }))).then(CommandManager.literal("medium").executes((commandContext) -> {
            return medium((ServerCommandSource)commandContext.getSource(), 3.0F);
        })).then(CommandManager.literal("high").executes((commandContext) -> {
            return high((ServerCommandSource)commandContext.getSource(), 4.5F);
        })).then(CommandManager.literal("max").executes((commandContext) -> {
            return max((ServerCommandSource)commandContext.getSource(), 6.0F);
        })));
    }

    public static int low(ServerCommandSource source, float strength) {
        MinecraftClient.getInstance().options.gamma = (double)strength;
        MinecraftClient.getInstance().options.write();
        source.sendFeedback(new LiteralText("§9§l[CB CLIENT]§r Brightness set to 150%"), false);
        return 1;
    }

    public static int medium(ServerCommandSource source, float strength) {
        MinecraftClient.getInstance().options.gamma = (double)strength;
        MinecraftClient.getInstance().options.write();
        source.sendFeedback(new LiteralText("§9§l[CB CLIENT]§r Brightness set to 300%"), false);
        return 1;
    }

    public static int high(ServerCommandSource source, float strength) {
        MinecraftClient.getInstance().options.gamma = (double)strength;
        MinecraftClient.getInstance().options.write();
        source.sendFeedback(new LiteralText("§9§l[CB CLIENT]§r Brightness set to 450%"), false);
        return 1;
    }
    public static int max(ServerCommandSource source, float strength) {
        MinecraftClient.getInstance().options.gamma = (double)strength;
        MinecraftClient.getInstance().options.write();
        source.sendFeedback(new LiteralText("§9§l[CB CLIENT]§r Brightness set to 600%"), false);
        return 1;
    }
}
