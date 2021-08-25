//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

/*
 * Decompiled with CFR 0.150.
 */
package nl.manto.MOT.Module.Modules;

import nl.manto.MOT.Module.Category;
import nl.manto.MOT.Module.Module;

public class Fullbright
extends Module {
    public Fullbright() {
        super("Fullbright", Category.RENDER);
    }

    @Override
    public void selfSettings() {
        this.settings.addSetting("hoi", "hoi2");
    }

    @Override
    public void onEnable() {
        if (this.mc.player != null) {
            this.mc.gameSettings.gammaSetting = 100.0f;
        }
    }

    @Override
    public void onDisable() {
        if (this.mc.player != null) {
            this.mc.gameSettings.gammaSetting = -100.0f;
        }
    }
}

