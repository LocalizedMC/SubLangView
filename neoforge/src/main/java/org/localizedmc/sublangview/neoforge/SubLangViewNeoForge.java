package org.localizedmc.sublangview.neoforge;

import me.shedaniel.autoconfig.AutoConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import org.localizedmc.sublangview.ModConfig;
import org.localizedmc.sublangview.SubLangView;
import org.localizedmc.sublangview.helper.DisplayHelper;

@Mod(value = SubLangView.MOD_ID, dist = Dist.CLIENT)
public final class SubLangViewNeoForge {
    public SubLangViewNeoForge(ModContainer modContainer) {
        if (FMLLoader.getDist().isClient()) {
            modContainer.registerExtensionPoint(IConfigScreenFactory.class, (container, screen) -> AutoConfig.getConfigScreen(ModConfig.class, screen).get());

            NeoForge.EVENT_BUS.addListener(ItemTooltipEvent.class, event -> {
                DisplayHelper.renderItemTooltip(event.getToolTip(), event.getItemStack());
            });
        }
    }
}
