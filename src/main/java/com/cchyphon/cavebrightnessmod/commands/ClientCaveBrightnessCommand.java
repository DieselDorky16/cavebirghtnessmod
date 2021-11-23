package com.cchyphon.cavebrightnessmod.commands;

import com.cchyphon.cavebrightnessmod.commands.values.BrightnessValues;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

@SuppressWarnings("ALL")
public class ClientCaveBrightnessCommand {

    public ClientCaveBrightnessCommand() {
    }

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) CommandManager.literal("cavebrightness").requires((serverCommandSource) -> {
            return serverCommandSource.hasPermissionLevel(0);
        })).then(CommandManager.literal("low").executes((commandContext) -> {
            return low((ServerCommandSource)commandContext.getSource(), BrightnessValues.LOW);
        }))).then(CommandManager.literal("medium").executes((commandContext) -> {
            return medium((ServerCommandSource)commandContext.getSource(), BrightnessValues.MEDIUM);
        })).then(CommandManager.literal("high").executes((commandContext) -> {
            return high((ServerCommandSource)commandContext.getSource(), BrightnessValues.HIGH);
        })).then(CommandManager.literal("max").executes((commandContext) -> {
            return max((ServerCommandSource)commandContext.getSource(), BrightnessValues.MAX);
        })));
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) CommandManager.literal("cb").requires((serverCommandSource) -> {
            return serverCommandSource.hasPermissionLevel(0);
        })).then(CommandManager.literal("low").executes((commandContext) -> {
            return low((ServerCommandSource)commandContext.getSource(), BrightnessValues.LOW);
        }))).then(CommandManager.literal("medium").executes((commandContext) -> {
            return medium((ServerCommandSource)commandContext.getSource(), BrightnessValues.MEDIUM);
        })).then(CommandManager.literal("high").executes((commandContext) -> {
            return high((ServerCommandSource)commandContext.getSource(), BrightnessValues.HIGH);
        })).then(CommandManager.literal("max").executes((commandContext) -> {
            return max((ServerCommandSource)commandContext.getSource(), BrightnessValues.MAX);
        })));
    }


    public static int low(ServerCommandSource source, float strength) {
        MinecraftClient.getInstance().options.gamma = (double)strength;
        MinecraftClient.getInstance().options.write();
        source.sendFeedback(new LiteralText("§4§l[CB CLIENT]§r Brightness set to 150%"), false);
        return 1;
    }

    public static int medium(ServerCommandSource source, float strength) {
        MinecraftClient.getInstance().options.gamma = (double)strength;
        MinecraftClient.getInstance().options.write();
        source.sendFeedback(new LiteralText("§4§l[CB CLIENT]§r Brightness set to 300%"), false);
        return 1;
    }

    public static int high(ServerCommandSource source, float strength) {
        MinecraftClient.getInstance().options.gamma = (double)strength;
        MinecraftClient.getInstance().options.write();
        source.sendFeedback(new LiteralText("§4§l[CB CLIENT]§r Brightness set to 450%"), false);
        return 1;
    }
    public static int max(ServerCommandSource source, float strength) {
        MinecraftClient.getInstance().options.gamma = (double)strength;
        MinecraftClient.getInstance().options.write();
        source.sendFeedback(new LiteralText("§4§l[CB CLIENT]§r Brightness set to 600%"), false);
        return 1;
    }
}
