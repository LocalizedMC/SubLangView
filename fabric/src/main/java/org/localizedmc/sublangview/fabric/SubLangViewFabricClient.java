package org.localizedmc.sublangview.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import org.localizedmc.sublangview.helper.DisplayHelper;

public final class SubLangViewFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            DisplayHelper.renderItemTooltip(list, itemStack);
        });
    }
}
