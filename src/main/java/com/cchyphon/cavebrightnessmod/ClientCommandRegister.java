package com.cchyphon.cavebrightnessmod;

import com.cchyphon.cavebrightnessmod.commands.ClientCaveBrightnessCommand;
import com.cchyphon.cavebrightnessmod.commands.ClientDefaultBrightnessCommand;
import net.fabricmc.fabric.api.registry.CommandRegistry;

@SuppressWarnings("ALL")
public class ClientCommandRegister {
    public static void clientRegisterCommands() {
        CommandRegistry.INSTANCE.register(false, ClientDefaultBrightnessCommand::register);
        CommandRegistry.INSTANCE.register(false, ClientCaveBrightnessCommand::register);

    }
}
