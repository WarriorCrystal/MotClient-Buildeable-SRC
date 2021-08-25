/*
 * Decompiled with CFR 0.150.
 */
package nl.manto.MOT.Module.Modules;

import nl.manto.MOT.Managers.DiscordManager;
import nl.manto.MOT.Module.Category;
import nl.manto.MOT.Module.Module;

public class DiscordRPC
extends Module {
    public DiscordRPC() {
        super("DiscordRPC", Category.MISC);
    }

    @Override
    public void selfSettings() {
        this.settings.addSetting("cheese", true);
    }

    @Override
    public void onEnable() {
        DiscordManager.start();
    }

    @Override
    public void onDisable() {
        DiscordManager.Stop();
    }
}

