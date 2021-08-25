//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent
 */
package nl.manto.MOT.Module;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import nl.manto.MOT.Managers.Settings;
import nl.manto.MOT.Module.Category;
import nl.manto.MOT.Mot;

public class Module {
    protected Minecraft mc = Minecraft.getMinecraft();
    private String name;
    private String displayName;
    private Category category;
    private boolean toggled;
    public Settings settings = new Settings();

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
        this.toggled = false;
    }

    public void registerSettings() {
        this.settings.addSetting("enabled", false);
        this.settings.addSetting("keybind", String.valueOf(0));
        this.selfSettings();
        Mot.SETTINGS_MANAGER.updateSettings();
    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister((Object)this);
    }

    @SubscribeEvent
    public void gameTickEvent(TickEvent event) {
        if (this.isToggled()) {
            this.onUpdate();
        }
        this.onUpdate();
    }

    public void setSettings(Settings newSettings) {
        this.settings = newSettings;
    }

    public void onUpdate() {
    }

    public void selfSettings() {
    }

    public void onToggle() {
    }

    public void toggle() {
        this.toggled = !this.toggled;
        this.onToggle();
        if (this.toggled) {
            this.onEnable();
            this.settings.setSetting("enabled", true);
            Mot.SETTINGS_MANAGER.updateSettings();
        } else {
            this.onDisable();
            this.settings.setSetting("enabled", false);
            Mot.SETTINGS_MANAGER.updateSettings();
        }
    }

    public Integer getKey() {
        return Integer.parseInt(this.settings.getSetting("keybind").toString());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isToggled() {
        return this.toggled;
    }

    public String getDisplayName() {
        return this.displayName == null ? this.name : this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setup() {
    }
}

