/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.TextFormatting
 */
package nl.manto.MOT.commands.Commands;

import net.minecraft.util.text.TextFormatting;
import nl.manto.MOT.Managers.MessageManager;
import nl.manto.MOT.Mot;
import nl.manto.MOT.commands.Command;

public class calculate
extends Command {
    private static int product = 0;
    private static boolean done = false;

    public calculate() {
        super("calculate", new String[]{"c", "calculate"});
    }

    @Override
    public void onCommand(String[] args) {
        if (args[2].equals("+")) {
            product = Integer.parseInt(args[1]) + Integer.parseInt(args[3]);
            done = true;
        } else if (args[2].equals("-")) {
            product = Integer.parseInt(args[1]) - Integer.parseInt(args[3]);
            done = true;
        } else if (args[2].equals("*")) {
            product = Integer.parseInt(args[1]) * Integer.parseInt(args[3]);
            done = true;
        } else if (args[2].equals("/")) {
            product = Integer.parseInt(args[1]) / Integer.parseInt(args[3]);
            done = true;
        } else {
            MessageManager.sendMessagePrefix((Object)TextFormatting.RED + "Please do " + Mot.prefix + "help");
        }
        if (done) {
            MessageManager.sendMessagePrefix((Object)TextFormatting.GREEN + "The calculated product is :: " + product);
        }
    }
}

