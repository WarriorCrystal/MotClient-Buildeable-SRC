//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

/*
 * Decompiled with CFR 0.150.
 */
package nl.manto.MOT.Module.Modules;

import nl.manto.MOT.Module.Category;
import nl.manto.MOT.Module.Module;

public class Zoom
extends Module {
    float cachedFov;

    public Zoom() {
        super("Zoom", Category.RENDER);
        this.cachedFov = this.mc.gameSettings.fovSetting;
    }

    @Override
    public void onEnable() {
        if (this.mc.player != null) {
            this.mc.gameSettings.fovSetting = 15.0f;
        }
    }

    public void onDissable() {
        if (this.mc.player != null) {
            this.mc.gameSettings.fovSetting = this.cachedFov;
        }
    }
}

