/*
 * Decompiled with CFR 0.150.
 */
package nl.manto.MOT.Managers;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    public Map<String, Object> settings = new HashMap<String, Object>();

    public Object addSetting(String settingName, Object defaultValue) {
        return this.settings.put(settingName, defaultValue);
    }

    public void setSetting(String settingName, Object newValue) {
        this.settings.replace(settingName, newValue);
    }

    public Object getSetting(String settingName) {
        return this.settings.get(settingName);
    }
}

