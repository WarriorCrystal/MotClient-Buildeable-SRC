/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.reflect.TypeToken
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 */
package nl.manto.MOT.Managers;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import nl.manto.MOT.Managers.Settings;
import nl.manto.MOT.Module.Module;
import nl.manto.MOT.Mot;

public class SettingsManager {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    File configFile = new File("motconf.json");

    public Map<String, Settings> readSettings() {
        Map<String, Settings> settingsArray = new HashMap<String, Settings>();
        if (this.configFile.exists() && this.configFile.isFile()) {
            try {
                settingsArray = (Map)this.gson.fromJson((Reader)new FileReader(this.configFile), new TypeToken<Map<String, Settings>>(){}.getType());
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileWriter fw = new FileWriter(this.configFile);
                this.gson.toJson(settingsArray, (Appendable)fw);
                fw.flush();
                fw.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return settingsArray;
    }

    public void writeSettings(Map<String, Settings> settingsArray) {
        try {
            FileWriter fw = new FileWriter(this.configFile);
            this.gson.toJson(settingsArray, (Appendable)fw);
            fw.flush();
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateSettings() {
        HashMap<String, Settings> settingsArray = new HashMap<String, Settings>();
        for (Module module : Mot.moduleManager.getModules()) {
            settingsArray.put(module.getName(), module.settings);
        }
        this.writeSettings(settingsArray);
    }

    public void loadSettings() {
        Map<String, Settings> settingsArray = this.readSettings();
        for (Module module : Mot.moduleManager.getModules()) {
            String moduleName = module.getName();
            try {
                if (settingsArray.containsKey(moduleName)) {
                    module.setSettings(settingsArray.get(moduleName));
                    continue;
                }
                module.registerSettings();
            }
            catch (NullPointerException npe) {
                module.registerSettings();
            }
        }
        this.updateSettings();
    }
}

