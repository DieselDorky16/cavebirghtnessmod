package com.cchyphon.cavebrightnessmod.client;

import com.cchyphon.cavebrightnessmod.util.keybindHelper.KeybindFullbrightHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class MainClientEntrypoint  implements ClientModInitializer {
    private static KeyBinding fullbrightKeybind;
    @Override
    public void onInitializeClient() {
       fullbrightKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.cbclient.fullbright", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_G, // The keycode of the key
                "keybind.category.cbclient.client_modifications" // The translation key of the keybinding's category.
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (fullbrightKeybind.isPressed()) {
                    KeybindFullbrightHelper.onFullbrightToggle();
                    fullbrightKeybind.setPressed(false);

            }
        });
    }
}
