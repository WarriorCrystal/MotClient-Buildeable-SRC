//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 */
package nl.manto.MOT.Managers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class MessageManager {
    public static String prefix = (Object)TextFormatting.GRAY + "[" + (Object)TextFormatting.RED + "MOT Client" + (Object)TextFormatting.GRAY + "]";
    private static final EntityPlayerSP player = Minecraft.getMinecraft().player;

    public static void sendRawMessage(String message) {
        player.sendMessage((ITextComponent)new TextComponentString(message));
    }

    public static void sendMessagePrefix(String message) {
        MessageManager.sendRawMessage(prefix + " " + message);
    }
}

