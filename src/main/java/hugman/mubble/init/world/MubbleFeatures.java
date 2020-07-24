package hugman.mubble.init.world;

import hugman.mubble.Mubble;
import hugman.mubble.object.world.gen.feature.EndBoulderFeature;
import hugman.mubble.object.world.gen.feature.HugeNetherMushroomFeature;
import hugman.mubble.object.world.gen.feature.HugeNetherMushroomFeatureConfig;
import hugman.mubble.object.world.gen.feature.TallHugeFungusFeature;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;

public class MubbleFeatures {
	public static final Feature<HugeFungusFeatureConfig> TALL_HUGE_FUNGI = register("tall_huge_fungus", new TallHugeFungusFeature(HugeFungusFeatureConfig.CODEC));
	public static final Feature<HugeNetherMushroomFeatureConfig> HUGE_NETHER_MUSHROOM = register("huge_nether_mushroom", new HugeNetherMushroomFeature(HugeNetherMushroomFeatureConfig.CODEC));
	public static final Feature<SingleStateFeatureConfig> ENDER_BOULDER = register("ender_boulder", new EndBoulderFeature(SingleStateFeatureConfig.CODEC));

	private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
		return Registry.register(Registry.FEATURE, new Identifier(Mubble.MOD_ID, name), feature);
	}
}
