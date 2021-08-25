//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

/*
 * Decompiled with CFR 0.150.
 */
package nl.manto.MOT.Module.Modules;

import nl.manto.MOT.Module.Category;
import nl.manto.MOT.Module.Module;

public class StrafeOp
extends Module {
    public StrafeOp() {
        super("StrafeOp", Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if (this.mc.player != null && this.isToggled()) {
            if (this.mc.player.isInWater() || this.mc.player.isInLava()) {
                this.mc.player.motionY = 0.1;
            } else if (this.mc.player.onGround) {
                this.mc.player.jump();
            }
        }
    }
}

