package hugman.mubble.init;

import hugman.mubble.Mubble;
import hugman.mubble.init.data.MubbleFoods;
import hugman.mubble.init.data.MubbleItemTiers;
import hugman.mubble.objects.item.AxeItem;
import hugman.mubble.objects.item.HoeItem;
import hugman.mubble.objects.item.PickaxeItem;
import hugman.mubble.objects.item.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class MubbleItems {
	/* MUBBLE */
	public static final Item WHEAT_FLOUR = register("wheat_flour", new Item(new Item.Settings().group(ItemGroup.FOOD)));
	public static final Item TOMATO = register("tomato", new BlockItem(MubbleBlocks.TOMATOES, new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.TOMATO)));
	public static final Item SALAD = register("salad", new BlockItem(MubbleBlocks.SALAD, new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.SALAD)));
	public static final Item CHEESE = register("cheese", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.CHEESE)));
	public static final Item BANANA = register("banana", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.BANANA)));
	public static final Item APRICOT = register("apricot", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.APRICOT)));
	public static final Item MANGO = register("mango", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.MANGO)));
	public static final Item BLUEBERRIES = register("blueberries", new BlockItem(MubbleBlocks.BLUEBERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.BLUEBERRIES)));
	public static final Item DUCK = register("duck", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.DUCK)));
	public static final Item COOKED_DUCK = register("cooked_duck", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.COOKED_DUCK)));
	public static final Item CARAMEL_CUBE = register("caramel_cube", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.CARAMEL_CUBE)));
	public static final Item BAGUETTE = register("baguette", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.BAGUETTE)));
	public static final Item BURGER = register("burger", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.BURGER)));
	public static final Item CREPE = register("crepe", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.CREPE)));
	public static final Item SUGAR_CREPE = register("sugar_crepe", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.SUGAR_CREPE)));
	public static final Item CHOCOLATE_CREPE = register("chocolate_crepe", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.CHOCOLATE_CREPE)));
	public static final Item CARAMEL_CREPE = register("caramel_crepe", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.CARAMEL_CREPE)));
	public static final Item HONEY_CREPE = register("honey_crepe", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.HONEY_CREPE)));
	public static final Item SWEET_BERRY_CREPE = register("sweet_berry_crepe", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.SWEET_BERRY_CREPE)));
	public static final Item BLUEBERRY_CREPE = register("blueberry_crepe", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.BLUEBERRY_CREPE)));
	public static final Item CANDY_CANE = register("candy_cane", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.CANDY_CANE)));
	public static final Item SMALL_BULB = register("small_bulb", new SmallBulbItem(new Item.Settings().group(ItemGroup.MATERIALS)));
	public static final Item JINGLE_BELLS = register("jingle_bells", new ShakeInstrumentItem(new Item.Settings().group(MubbleTabs.INSTRUMENTS).maxCount(1), MubbleSounds.ITEM_JINGLE_BELLS_USE));
	public static final Item VANADIUM = register("vanadium", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
	public static final Item BISMUTH_DUST = register("bismuth_dust", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
	public static final Item CRYSTALLIZED_BISMUTH = register("crystallized_bismuth", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
	public static final Item BISMUTH_SWORD = register("bismuth_sword", new SwordItem(MubbleItemTiers.BISMUTH, 4, -2.4F, new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item BISMUTH_SHOVEL = register("bismuth_shovel", new ShovelItem(MubbleItemTiers.BISMUTH, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS)));
	public static final Item BISMUTH_PICKAXE = register("bismuth_pickaxe", new PickaxeItem(MubbleItemTiers.BISMUTH, 1, -2.4F, new Item.Settings().group(ItemGroup.TOOLS)));
	public static final Item BISMUTH_AXE = register("bismuth_axe", new AxeItem(MubbleItemTiers.BISMUTH, 4.5F, -2.5F, new Item.Settings().group(ItemGroup.TOOLS)));
	public static final Item BISMUTH_HOE = register("bismuth_hoe", new HoeItem(MubbleItemTiers.BISMUTH, -1, 0.0F, new Item.Settings().group(ItemGroup.TOOLS)));
	public static final Item PERMAFROST_BRICK = register("permafrost_brick", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
	public static final Item BANDAGE = register("bandage", new BandageItem(new Item.Settings().group(ItemGroup.MISC).maxCount(16)));
	public static final Item TOTEM_OF_ASCENDING = register("totem_of_ascending", new TotemOfAscendingItem(new Item.Settings().group(ItemGroup.COMBAT).maxCount(1).rarity(Rarity.UNCOMMON)));

	/* SUPER MARIO */
	public static final Item SUPER_MUSHROOM = register("super_mushroom", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.SUPER_MUSHROOM)));
	public static final Item PEACH = register("peach", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MubbleFoods.PEACH)));
	public static final Item FIREBALL = register("fireball", new FireballItem(new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item ICEBALL = register("iceball", new IceballItem(new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item CAPE_FEATHER = register("cape_feather", new CapeFeatherItem(new Item.Settings().group(ItemGroup.TRANSPORTATION)));
	public static final Item SUPER_CAPE_FEATHER = register("super_cape_feather", new CapeFeatherItem(new Item.Settings().group(ItemGroup.TRANSPORTATION).maxCount(1).rarity(Rarity.EPIC)));
	public static final Item SUPER_STAR = register("super_star", new SuperStarItem(new Item.Settings().group(ItemGroup.MISC).maxCount(1).rarity(Rarity.RARE).food(MubbleFoods.SUPER_STAR)));
	public static final Item YELLOW_COIN = register("yellow_coin", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
	public static final Item RED_COIN = register("red_coin", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
	public static final Item BLUE_COIN = register("blue_coin", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
	public static final Item SMB_KEY = register("smb_key", new KeyItem(new Item.Settings().group(ItemGroup.MATERIALS), MubbleBlocks.SMB_KEY_DOOR));
	public static final Item SMB3_KEY = register("smb3_key", new KeyItem(new Item.Settings().group(ItemGroup.MATERIALS), MubbleBlocks.SMB3_KEY_DOOR));
	public static final Item SMW_KEY = register("smw_key", new KeyItem(new Item.Settings().group(ItemGroup.MATERIALS), MubbleBlocks.SMW_KEY_DOOR));
	public static final Item NSMBU_KEY = register("nsmbu_key", new KeyItem(new Item.Settings().group(ItemGroup.MATERIALS), MubbleBlocks.NSMBU_KEY_DOOR));

	/* KIRBY */
	public static final Item KIRBY_BALL = register("kirby_ball", new KirbyBallItem(new Item.Settings().group(ItemGroup.COMBAT)));

	/* FIRE EMBLEM */
	//public static final Item AYMR = register("aymr", new AymrItem(new Item.Settings().group(ItemGroup.COMBAT)));

	/* SUPER SMASH BROS. */
	public static final Item SMASH_BALL = register("smash_ball", new SmashBallItem(new Item.Settings().group(ItemGroup.COMBAT).maxCount(1).rarity(Rarity.RARE)));

	/* STAR WARS */
	public static final Item WHITE_LIGHTSABER = register("white_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item LIGHT_GRAY_LIGHTSABER = register("light_gray_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item GRAY_LIGHTSABER = register("gray_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item BLACK_LIGHTSABER = register("black_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item BROWN_LIGHTSABER = register("brown_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item RED_LIGHTSABER = register("red_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item ORANGE_LIGHTSABER = register("orange_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item YELLOW_LIGHTSABER = register("yellow_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item LIME_LIGHTSABER = register("lime_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item GREEN_LIGHTSABER = register("green_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item CYAN_LIGHTSABER = register("cyan_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item LIGHT_BLUE_LIGHTSABER = register("light_blue_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item BLUE_LIGHTSABER = register("blue_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item PURPLE_LIGHTSABER = register("purple_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item MAGENTA_LIGHTSABER = register("magenta_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
	public static final Item PINK_LIGHTSABER = register("pink_lightsaber", new LightsaberItem(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));

	/* SPECIAL */
	public static final Item DUCK_SPAWN_EGG = register("duck_spawn_egg", new SpawnEggItem(MubbleEntities.DUCK, 10592673, 15904341, new Item.Settings().group(ItemGroup.MISC)));
	public static final Item ZOMBIE_COWMAN_SPAWN_EGG = register("zombie_cowman_spawn_egg", new SpawnEggItem(MubbleEntities.ZOMBIE_COWMAN, 2957585, 5009705, new Item.Settings().group(ItemGroup.MISC)));

	public static final Item TOAD_SPAWN_EGG = register("toad_spawn_egg", new SpawnEggItem(MubbleEntities.TOAD, 14671839, 16722728, new Item.Settings().group(ItemGroup.MISC)));
	public static final Item CHINCHO_SPAWN_EGG = register("chincho_spawn_egg", new SpawnEggItem(MubbleEntities.CHINCHO, 7527671, 4903, new Item.Settings().group(ItemGroup.MISC)));
	public static final Item GOOMBA_SPAWN_EGG = register("goomba_spawn_egg", new SpawnEggItem(MubbleEntities.GOOMBA, 10839375, 12097909, new Item.Settings().group(ItemGroup.MISC)));

	private static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(Mubble.MOD_ID, name), item);
	}
}