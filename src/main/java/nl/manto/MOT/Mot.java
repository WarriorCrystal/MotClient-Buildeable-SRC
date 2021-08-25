/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventHandler
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$KeyInputEvent
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.Display
 */
package nl.manto.MOT;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import nl.manto.MOT.Managers.SettingsManager;
import nl.manto.MOT.Module.Module;
import nl.manto.MOT.Module.ModuleManager;
import nl.manto.MOT.commands.CommandManager;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

@Mod(name="MOT Client", modid="mot", version="b2")
public class Mot {
    public static final String name = "MOT Client";
    public static final String currentvers = "b2";
    public static final String discordid = "727936187926315079";
    public static String prefix = ".";
    public static ModuleManager moduleManager = new ModuleManager();
    public static final SettingsManager SETTINGS_MANAGER = new SettingsManager();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Display.setTitle((String)"MOT Client b2");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
        moduleManager.loadModules();
        CommandManager.init();
        MinecraftForge.EVENT_BUS.register((Object)new CommandManager());
        MinecraftForge.EVENT_BUS.register((Object)this);
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        for (Module m : moduleManager.getModules()) {
            if (!Keyboard.isKeyDown((int)m.getKey())) continue;
            m.toggle();
        }
    }
}

