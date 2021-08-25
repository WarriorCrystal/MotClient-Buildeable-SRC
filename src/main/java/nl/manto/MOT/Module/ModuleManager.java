/*
 * Decompiled with CFR 0.150.
 */
package nl.manto.MOT.Module;

import java.util.ArrayList;
import nl.manto.MOT.Module.Module;
import nl.manto.MOT.Module.Modules.Arraylist;
import nl.manto.MOT.Module.Modules.DiscordRPC;
import nl.manto.MOT.Module.Modules.Fullbright;
import nl.manto.MOT.Module.Modules.StrafeOp;
import nl.manto.MOT.Module.Modules.Zoom;
import nl.manto.MOT.Mot;

public class ModuleManager {
    private ArrayList<Module> modules = new ArrayList();

    public ModuleManager() {
        this.modules.add(new Zoom());
        this.modules.add(new StrafeOp());
        this.modules.add(new DiscordRPC());
        this.modules.add(new Fullbright());
        this.modules.add(new Arraylist());
    }

    public ArrayList<Module> getModules() {
        return this.modules;
    }

    public Module getModuleByName(String name) {
        return this.modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public void loadModules() {
        Mot.SETTINGS_MANAGER.loadSettings();
        for (Module m : Mot.moduleManager.getModules()) {
            if (!((Boolean)m.settings.getSetting("enabled")).booleanValue()) continue;
            m.toggle();
        }
    }
}

