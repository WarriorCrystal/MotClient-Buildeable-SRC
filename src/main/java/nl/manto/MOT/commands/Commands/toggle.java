/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.TextFormatting
 */
package nl.manto.MOT.commands.Commands;

import net.minecraft.util.text.TextFormatting;
import nl.manto.MOT.Managers.MessageManager;
import nl.manto.MOT.Module.Module;
import nl.manto.MOT.Mot;
import nl.manto.MOT.commands.Command;

public class toggle
extends Command {
    public toggle() {
        super("toggle", new String[]{"t", "toggle"});
    }

    @Override
    public void onCommand(String[] args) {
        if (args.length > 1) {
            try {
                for (Module m : Mot.moduleManager.getModules()) {
                    if (!m.getName().equalsIgnoreCase(args[1])) continue;
                    m.toggle();
                    if (m.isToggled()) {
                        MessageManager.sendMessagePrefix((Object)TextFormatting.AQUA + m.getName() + (Object)TextFormatting.WHITE + " is now " + (Object)TextFormatting.GREEN + "ON");
                        continue;
                    }
                    MessageManager.sendMessagePrefix((Object)TextFormatting.AQUA + m.getName() + (Object)TextFormatting.WHITE + " is now " + (Object)TextFormatting.RED + "OFF");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

