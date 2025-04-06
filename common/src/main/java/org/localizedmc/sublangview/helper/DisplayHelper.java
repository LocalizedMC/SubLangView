package org.localizedmc.sublangview.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.List;
import java.util.Objects;

public class DisplayHelper {
    public static void renderItemTooltip(List<Text> list, ItemStack itemStack) {
        switch (Objects.requireNonNull(ConfigHelper.getConfig().itemTooltipDisplayMode)) {
            case ALL -> {
                list.add(TranslationHelper.getOriginalText(TranslationHelper.Item.getOriginalText(itemStack).getString()));
                list.add(TranslationHelper.getTranslationKeyText(TranslationHelper.Item.getTranslationKey(itemStack).getString()));
                list.add(TranslationHelper.getNamespaceText(TranslationHelper.Item.getNamespace(itemStack)));
            }
            case ORIGINAL -> {
                list.add(TranslationHelper.getOriginalText(TranslationHelper.Item.getOriginalText(itemStack).getString()));
                list.add(TranslationHelper.getNamespaceText(TranslationHelper.Item.getNamespace(itemStack)));
            }
            case TRANSLATION_KEY -> {
                list.add(TranslationHelper.getTranslationKeyText(itemStack.getItem().getTranslationKey()));
                list.add(TranslationHelper.getNamespaceText(TranslationHelper.Item.getNamespace(itemStack)));
            }
            case OFF -> {
                list.add(TranslationHelper.getNamespaceText(TranslationHelper.Item.getNamespace(itemStack)));
            }
        }
    }
}
