package org.localizedmc.sublangview;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import org.localizedmc.sublangview.helper.DisplayMode;
import org.localizedmc.sublangview.helper.TextColor;

@Config(name = SubLangView.MOD_ID)
public class ModConfig implements ConfigData {
    public String subLanguageCode = "en_us";

    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public TextColor textColor = TextColor.GRAY;

    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public DisplayMode.Tooltip itemTooltipDisplayMode = DisplayMode.Tooltip.ALL;
}
