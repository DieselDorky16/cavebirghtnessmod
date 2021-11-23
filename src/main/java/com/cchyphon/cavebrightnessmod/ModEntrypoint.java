package com.cchyphon.cavebrightnessmod;

import net.fabricmc.api.ModInitializer;

public class ModEntrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        ClientCommandRegister.clientRegisterCommands();

    }
}
