package org.localizedmc.sublangview.helper;

import net.minecraft.client.resource.language.TranslationStorage;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;

public class TranslationHelper {
    public static TranslationStorage subTranslationStorage;

    public static boolean isMissingSubTranslation(String key) {
        return subTranslationStorage == null || !subTranslationStorage.hasTranslation(key);
    }

    public static Text getOriginalText(String originalText) {
        return Text.translatable("gui.sublangview.original", ConfigHelper.getConfig().subLanguageCode, originalText).formatted(ConfigHelper.getConfig().textColor.formatting());
    }

    public static Text getTranslationKeyText(String translationKey) {
        return Text.translatable("gui.sublangview.translation_key", translationKey).formatted(ConfigHelper.getConfig().textColor.formatting());
    }

    public static Text getNamespaceText(String namespace) {
        return Text.translatable("gui.sublangview.namespace", namespace).formatted(ConfigHelper.getConfig().textColor.formatting());
    }

    public static class Item {
        public static Text getOriginalText(ItemStack itemStack) {
            if (!isMissingSubTranslation(itemStack.getItem().getTranslationKey()) && !itemStack.hasChangedComponent(DataComponentTypes.CUSTOM_NAME)) {
                Text name = itemStack.getName();
                String subName = subTranslationStorage.get(itemStack.getItem().getTranslationKey());
                if (!subName.equals(name.getString()) && !subName.equals(itemStack.getItem().getTranslationKey())) {
                    return Text.literal(subName);
                }
            }
            return itemStack.getName();
        }

        public static Text getTranslationKey(ItemStack itemStack) {
            if (!itemStack.hasChangedComponent(DataComponentTypes.CUSTOM_NAME)) {
                String translationKey = itemStack.getItem().getTranslationKey();
                return Text.literal(translationKey);
            }
            return Text.literal(itemStack.getItem().getTranslationKey());
        }

        public static String getNamespace(ItemStack itemStack) {
            return Registries.ITEM.getId(itemStack.getItem()).getNamespace();
        }
    }

    public static class Advancement {
        public static Text getTitleOriginalText(Text titleText) {
            if (titleText instanceof TranslatableTextContent content) {
                if (!isMissingSubTranslation(content.getKey())) {
                    String originalText = subTranslationStorage.get(content.getKey());
                    if (!originalText.equals(titleText.getString()) && !originalText.equals(content.getKey())) {
                        return Text.literal(originalText);
                    }
                }
            }

            return titleText;
        }

        public static Text getTitleTranslationKey(Text titleText) {
            if (titleText instanceof TranslatableTextContent content) {
                return Text.literal(content.getKey());
            }

            return titleText;
        }

        public static Text getDescOriginalText(Text descText) {
            if (descText instanceof TranslatableTextContent content) {
                if (!isMissingSubTranslation(content.getKey())) {
                    String originalText = subTranslationStorage.get(content.getKey());
                    if (!originalText.equals(descText.getString()) && !originalText.equals(content.getKey())) {
                        return Text.literal(originalText);
                    }
                }
            }

            return descText;
        }

        public static Text getDescTranslationKey(Text descText) {
            if (descText instanceof TranslatableTextContent content) {
                return Text.literal(content.getKey());
            }

            return descText;
        }
    }
}
