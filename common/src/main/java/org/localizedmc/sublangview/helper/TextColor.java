package org.localizedmc.sublangview.helper;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public enum TextColor {
    WHITE("config.sublangview.option.color_white", Formatting.WHITE),
    BLACK("config.sublangview.option.color_black", Formatting.BLACK),
    YELLOW("config.sublangview.option.color_yellow", Formatting.YELLOW),
    GOLD("config.sublangview.option.color_gold", Formatting.GOLD),
    GRAY("config.sublangview.option.color_gray", Formatting.GRAY),
    DARK_GRAY("config.sublangview.option.color_dark_gray", Formatting.DARK_GRAY),
    BLUE("config.sublangview.option.color_blue", Formatting.BLUE),
    DARK_BLUE("config.sublangview.option.color_dark_blue", Formatting.DARK_BLUE),
    GREEN("config.sublangview.option.color_green", Formatting.GREEN),
    DARK_GREEN("config.sublangview.option.color_dark_green", Formatting.DARK_GREEN),
    AQUA("config.sublangview.option.color_aqua", Formatting.AQUA),
    DARK_AQUA("config.sublangview.option.color_dark_aqua", Formatting.DARK_AQUA),
    RED("config.sublangview.option.color_red", Formatting.RED),
    DARK_RED("config.sublangview.option.color_dark_red", Formatting.DARK_RED),
    LIGHT_PURPLE("config.sublangview.option.color_light_purple", Formatting.LIGHT_PURPLE),
    DARK_PURPLE("config.sublangview.option.color_dark_purple", Formatting.DARK_PURPLE);

    private final Text translatableText;
    private final Formatting textFormat;

    TextColor(String translationKey, Formatting textFormat) {
        this.translatableText = Text.translatable(translationKey);
        this.textFormat = textFormat;
    }

    public Formatting formatting() {
        return this.textFormat;
    }

    @Override
    public String toString() {
        return translatableText.getString();
    }
}
