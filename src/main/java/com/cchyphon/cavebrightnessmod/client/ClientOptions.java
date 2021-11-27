package com.cchyphon.cavebrightnessmod.client;

import net.minecraft.client.MinecraftClient;

public class ClientOptions {
    public static MinecraftClient instance() {
        return MinecraftClient.getInstance();
    }
}
