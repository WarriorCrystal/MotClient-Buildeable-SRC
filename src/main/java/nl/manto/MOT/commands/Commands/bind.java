/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package nl.manto.MOT.commands.Commands;

import nl.manto.MOT.Managers.MessageManager;
import nl.manto.MOT.Module.Module;
import nl.manto.MOT.Mot;
import nl.manto.MOT.commands.Command;
import org.lwjgl.input.Keyboard;

public class bind
extends Command {
    public bind() {
        super("bind", new String[]{"t", "toggle"});
    }

    @Override
    public void onCommand(String[] args) {
        if (args.length > 2) {
            try {
                for (Module m : Mot.moduleManager.getModules()) {
                    if (!m.getName().equalsIgnoreCase(args[1])) continue;
                    Mot.SETTINGS_MANAGER.updateSettings();
                    try {
                        m.settings.setSetting("keybind", String.valueOf(Keyboard.getKeyIndex((String)args[2].toUpperCase())));
                        MessageManager.sendMessagePrefix(m.getName() + " is now binded to " + args[2].toUpperCase() + "(" + Keyboard.getKeyIndex((String)(args[2].toUpperCase() + "")) + ")");
                    }
                    catch (Exception e) {
                        MessageManager.sendMessagePrefix(m.getName() + "something went wrong");
                        e.printStackTrace();
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

