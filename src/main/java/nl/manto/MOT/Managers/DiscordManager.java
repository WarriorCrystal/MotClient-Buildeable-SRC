//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package nl.manto.MOT.Managers;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;

public class DiscordManager {
    private static final Minecraft mc = Minecraft.getMinecraft();
    private static final DiscordRPC rpc = DiscordRPC.INSTANCE;
    public static DiscordRichPresence rp = new DiscordRichPresence();
    private static String details;
    private static String state;

    public static void start() {
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.disconnected = (var1, var2) -> System.out.println("Discord RPC disconnected, var1: " + var1 + ", var2: " + var2);
        rpc.Discord_Initialize("727936187926315079", handlers, true, "");
        DiscordManager.rp.startTimestamp = System.currentTimeMillis() / 1000L;
        DiscordManager.rp.details = "MOT ClientMOT On Topb2";
        DiscordManager.rp.state = "https://discord.gg/SF7SE2H";
        DiscordManager.rp.largeImageKey = "mot";
        DiscordManager.rp.largeImageText = "MOT Client727936187926315079b2";
        rpc.Discord_UpdatePresence(rp);
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    rpc.Discord_RunCallbacks();
                    details = "MOT Client b2";
                    state = "https://discord.gg/SF7SE2H";
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    Thread.sleep(5000L);
                }
                catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }, "Discord-RPC-Callback-Handler").start();
    }

    public static void Stop() {
        rpc.Discord_Shutdown();
    }
}

