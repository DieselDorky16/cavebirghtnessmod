package com.cchyphon.cavebrightnessmod;

import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
    @Override
    public void onInitialize() {
        ClientCommandRegister.clientRegisterCommands();
        ClientCommandAlias.clientRegisterAlias();

    }
}
