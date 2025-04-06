package org.localizedmc.sublangview.helper;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import org.localizedmc.sublangview.ModConfig;

public class ConfigHelper {
    private static ModConfig modConfigs;

    public static ModConfig getConfig() {
        if (modConfigs == null) {
            AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
            modConfigs = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        }
        return modConfigs;
    }
}
