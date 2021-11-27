package com.cchyphon.cavebrightnessmod.util.keybindHelper;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.option.GameOptions;

public class KeybindFullbrightHelper {
    private static MinecraftClient mc = null;
    private static double initialgamma = -1;
    private static double maxgamma = 14.0F % 28.0F + 1.0F;

    public static void onFullbrightToggle() {
        if (mc == null) {
            mc = MinecraftClient.getInstance();
        }

        if (mc.currentScreen instanceof ChatScreen) {
            return;
        }

        GameOptions settings = mc.options;
        if (initialgamma < 0) {
            if (settings.gamma >= 1.0F) {
                initialgamma = 1.0F;
                settings.gamma = 1.0F;
            }
            else {
                initialgamma = settings.gamma;
            }
        }

        boolean gomax = false;
        if (settings.gamma != initialgamma && settings.gamma != maxgamma) {
            initialgamma = settings.gamma;
            gomax = true;
        }

        if (settings.gamma == initialgamma || gomax) {
            settings.gamma = maxgamma;
        }
        else {
            settings.gamma = initialgamma;
        }
    }
}
