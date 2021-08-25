/*
 * Decompiled with CFR 0.150.
 */
package nl.manto.MOT.commands;

public class Command {
    private String command;
    private String[] usage;

    public Command(String name, String[] usage) {
        this.command = name;
        this.usage = usage;
    }

    public void onCommand(String[] args) {
    }

    public String getCommand() {
        return this.command;
    }
}

