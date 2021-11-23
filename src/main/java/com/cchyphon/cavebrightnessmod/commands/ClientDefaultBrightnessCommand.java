package com.cchyphon.cavebrightnessmod.commands;

import com.cchyphon.cavebrightnessmod.commands.values.BrightnessValues;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

@SuppressWarnings("ALL")
public class ClientDefaultBrightnessCommand {

    public ClientDefaultBrightnessCommand() {
    }

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) CommandManager.literal("defaultbrightness").requires((serverCommandSource) -> {
            return serverCommandSource.hasPermissionLevel(0);
        })).then(CommandManager.literal("moody").executes((commandContext) -> {
            return moody((ServerCommandSource)commandContext.getSource(), BrightnessValues.Vanilla.MOODY);
        }))).then(CommandManager.literal("default").executes((commandContext) -> {
            return _default((ServerCommandSource)commandContext.getSource(), BrightnessValues.Vanilla.DEFAULT);
        })).then(CommandManager.literal("bright").executes((commandContext) -> {
            return bright((ServerCommandSource)commandContext.getSource(), BrightnessValues.Vanilla.BRIGHT);
        })));
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) CommandManager.literal("db").requires((serverCommandSource) -> {
            return serverCommandSource.hasPermissionLevel(0);
        })).then(CommandManager.literal("moody").executes((commandContext) -> {
            return moody((ServerCommandSource)commandContext.getSource(), BrightnessValues.Vanilla.MOODY);
        }))).then(CommandManager.literal("default").executes((commandContext) -> {
            return _default((ServerCommandSource)commandContext.getSource(), BrightnessValues.Vanilla.DEFAULT);
        })).then(CommandManager.literal("bright").executes((commandContext) -> {
            return bright((ServerCommandSource)commandContext.getSource(), BrightnessValues.Vanilla.BRIGHT);
        })));
    }

    public static int moody(ServerCommandSource source, float strength) {
        MinecraftClient.getInstance().options.gamma = (double)strength;
        MinecraftClient.getInstance().options.write();
        source.sendFeedback(new LiteralText("§4§l[CB CLIENT]§r Brightness set to Moody"), false);
        return 1;
    }

    public static int _default(ServerCommandSource source, float strength) {
        MinecraftClient.getInstance().options.gamma = (double)strength;
        MinecraftClient.getInstance().options.write();
        source.sendFeedback(new LiteralText("§4§l[CB CLIENT]§r Brightness set to Default"), false);
        return 1;
    }

    public static int bright(ServerCommandSource source, float strength) {
        MinecraftClient.getInstance().options.gamma = (double)strength;
        MinecraftClient.getInstance().options.write();
        source.sendFeedback(new LiteralText("§4§l[CB CLIENT]§r Brightness set to Bright"), false);
        return 1;
    }
}
