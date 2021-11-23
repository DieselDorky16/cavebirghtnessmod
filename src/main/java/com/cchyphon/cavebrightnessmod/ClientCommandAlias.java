package com.cchyphon.cavebrightnessmod;

import com.cchyphon.cavebrightnessmod.commands.ClientDefaultBrightnessCommand;
import com.cchyphon.cavebrightnessmod.commands.alias.ClientCBCommand;
import com.cchyphon.cavebrightnessmod.commands.alias.ClientDBCommand;
import net.fabricmc.fabric.api.registry.CommandRegistry;

@SuppressWarnings("ALL")
public class ClientCommandAlias {
    public static void clientRegisterAlias() {
        CommandRegistry.INSTANCE.register(false, ClientDBCommand::register);
        CommandRegistry.INSTANCE.register(false, ClientCBCommand::register);

    }
}
