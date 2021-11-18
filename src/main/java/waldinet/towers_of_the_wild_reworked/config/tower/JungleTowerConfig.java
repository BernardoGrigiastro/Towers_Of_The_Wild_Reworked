package waldinet.towers_of_the_wild_reworked.config.tower;

import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.text.TranslatableText;
import waldinet.towers_of_the_wild_reworked.config.ConfigManager;

public class JungleTowerConfig
{
    private boolean enabled = true;
    private int rarity = 40;

    public static SubCategoryBuilder getConfigBuilder(ConfigEntryBuilder entry)
    {
        SubCategoryBuilder subCategory = entry.startSubCategory(new TranslatableText("Jungle Tower"));
        // Enable Tower
        subCategory.add(
            entry.startBooleanToggle(new TranslatableText("Enabled"), ConfigManager.getInstance().getConfig().jungleTower.enabled)
                .setDefaultValue(true)
                .setSaveConsumer(newValue -> ConfigManager.getInstance().getConfig().jungleTower.enabled = newValue)
                .build()
        );

        // Rarity
        subCategory.add(
            entry.startIntSlider(new TranslatableText("Rarity"), ConfigManager.getInstance().getConfig().jungleTower.rarity, 3, 200)
                .setTooltip(new TranslatableText("How rarely this tower type will spawn (low: common, high: rare)"))
                .setDefaultValue(40)
                .setSaveConsumer(newValue -> ConfigManager.getInstance().getConfig().jungleTower.rarity = newValue)
                .build()
        );

        return subCategory;
    }
}
