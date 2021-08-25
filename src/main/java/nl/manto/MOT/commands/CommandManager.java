/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.ClientChatEvent
 *  net.minecraftforge.fml.common.eventhandler.EventPriority
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package nl.manto.MOT.commands;

import java.util.HashSet;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nl.manto.MOT.Mot;
import nl.manto.MOT.commands.Command;
import nl.manto.MOT.commands.Commands.bind;
import nl.manto.MOT.commands.Commands.calculate;
import nl.manto.MOT.commands.Commands.toggle;

public class CommandManager {
    public static HashSet<Command> commands = new HashSet();

    public static void init() {
        commands.clear();
        commands.add(new calculate());
        commands.add(new toggle());
        commands.add(new bind());
    }

    @SubscribeEvent(priority=EventPriority.HIGHEST)
    public void chatEvent(ClientChatEvent event) {
        String[] args = event.getMessage().split(" ");
        if (event.getMessage().startsWith(Mot.prefix)) {
            event.setCanceled(true);
            for (Command c : commands) {
                if (!args[0].equalsIgnoreCase(Mot.prefix + c.getCommand())) continue;
                c.onCommand(args);
            }
        }
    }
}

