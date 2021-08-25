//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package nl.manto.MOT.Module.Modules;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nl.manto.MOT.Module.Category;
import nl.manto.MOT.Module.Module;
import nl.manto.MOT.Mot;

public class Arraylist
extends Module {
    public Arraylist() {
        super("arraylist", Category.RENDER);
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
        if (this.isToggled() && event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            float currY = this.mc.fontRenderer.FONT_HEIGHT + 5;
            for (Module m : Mot.moduleManager.getModules()) {
                if (!m.isToggled()) continue;
                this.mc.fontRenderer.drawStringWithShadow(m.getName(), 5.0f, currY + 1.0f, -1);
                currY += (float)this.mc.fontRenderer.FONT_HEIGHT;
            }
        }
    }
}

