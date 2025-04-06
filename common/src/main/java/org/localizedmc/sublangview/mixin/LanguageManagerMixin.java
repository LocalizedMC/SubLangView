package org.localizedmc.sublangview.mixin;

import com.google.common.collect.Lists;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.resource.language.LanguageManager;
import net.minecraft.client.resource.language.TranslationStorage;
import net.minecraft.resource.ResourceManager;
import org.localizedmc.sublangview.SubLangView;
import org.localizedmc.sublangview.helper.ConfigHelper;
import org.localizedmc.sublangview.helper.TranslationHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(LanguageManager.class)
public abstract class LanguageManagerMixin {
    @Inject(
            method = "reload(Lnet/minecraft/resource/ResourceManager;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/resource/language/TranslationStorage;load(Lnet/minecraft/resource/ResourceManager;Ljava/util/List;Z)Lnet/minecraft/client/resource/language/TranslationStorage;"
            )
    )
    private void init(ResourceManager manager, CallbackInfo ci, @Local List<String> list) {
        try {
            String sublanguage = ConfigHelper.getConfig().subLanguageCode;
            list.add(1, sublanguage);
            TranslationHelper.subTranslationStorage = TranslationStorage.load(manager, Lists.newArrayList(sublanguage), false);
            SubLangView.LOGGER.info("Translation objects for the sub language have been loaded.");
        } catch (Exception exception) {
            SubLangView.LOGGER.error(new RuntimeException("Unknown sub language:" + ConfigHelper.getConfig().subLanguageCode, exception).getMessage());
        }
    }
}
