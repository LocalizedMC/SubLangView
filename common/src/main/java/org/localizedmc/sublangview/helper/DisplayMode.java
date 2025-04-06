package org.localizedmc.sublangview.helper;

import net.minecraft.text.Text;

public class DisplayMode {
    public enum Tooltip {
        ORIGINAL("config.sublangview.option.original"),
        TRANSLATION_KEY("config.sublangview.option.translation_key"),
        ALL("config.sublangview.option.all"),
        OFF("config.sublangview.option.off");

        final Text translatableText;

        Tooltip(String translationKey) {
            this.translatableText = Text.translatable(translationKey);
        }

        @Override
        public String toString() {
            return translatableText.getString();
        }
    }

    public enum Advancement {
        ORIGINAL("config.sublangview.option.original"),
        TRANSLATION_KEY("config.sublangview.option.translation_key"),
        ALL("config.sublangview.option.all"),
        OFF("config.sublangview.option.off");

        final Text translatableText;

        Advancement(String translatableKey) {
            this.translatableText = Text.translatable(translatableKey);
        }

        @Override
        public String toString() {
            return translatableText.getString();
        }
    }
}
