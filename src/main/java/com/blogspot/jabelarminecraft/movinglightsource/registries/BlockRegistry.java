package com.blogspot.jabelarminecraft.movinglightsource.registries;

import java.util.HashSet;
import java.util.Set;

import com.blogspot.jabelarminecraft.movinglightsource.MainMod;
import com.blogspot.jabelarminecraft.movinglightsource.blocks.BlockMovingLightSource;
import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(MainMod.MODID)
public class BlockRegistry {
//	public static class ArmorMaterials {
//		public static final BlockArmor.ArmorMaterial ARMOUR_MATERIAL_REPLACEMENT = EnumHelper.addArmorMaterial(Constants.RESOURCE_PREFIX + "replacement", Constants.RESOURCE_PREFIX + "replacement", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.Block_ARMOR_EQUIP_CHAIN, (float) 0);
//	}
//
//	public static class ToolMaterials {
//		public static final Block.ToolMaterial TOOL_MATERIAL_GLOWSTONE = EnumHelper.addToolMaterial("glowstone", 1, 5, 0.5f, 1.0f, 10);
//	}

    // instantiate blocks
	public final static BlockMovingLightSource MOVING_LIGHT_SOURCE = new BlockMovingLightSource("movinglightsource");
	public final static BlockMovingLightSource MOVING_LIGHT_SOURCE_15 = new BlockMovingLightSource("movinglightsource_15", 1.0F);
	public final static BlockMovingLightSource MOVING_LIGHT_SOURCE_14 = new BlockMovingLightSource("movinglightsource_14", 14.0F / 15.0F);
	public final static BlockMovingLightSource MOVING_LIGHT_SOURCE_13 = new BlockMovingLightSource("movinglightsource_13", 13.0F / 15.0F);
	public final static BlockMovingLightSource MOVING_LIGHT_SOURCE_12 = new BlockMovingLightSource("movinglightsource_12", 12.0F / 15.0F);
	public final static BlockMovingLightSource MOVING_LIGHT_SOURCE_11 = new BlockMovingLightSource("movinglightsource_11", 11.0F / 15.0F);
	public final static BlockMovingLightSource MOVING_LIGHT_SOURCE_9 = new BlockMovingLightSource("movinglightsource_9", 9.0F / 15.0F);
	public final static BlockMovingLightSource MOVING_LIGHT_SOURCE_7 = new BlockMovingLightSource("movinglightsource_7", 7.0F / 15.0F);

	/**
	 * Initialize this mod's {@link Block}s with any post-registration data.
	 */
	private static void initialize() 
	{
	}

	@Mod.EventBusSubscriber(modid = MainMod.MODID)
	public static class RegistrationHandler 
	{
		public static final Set<Block> SET_BLOCKS = new HashSet<>();
		public static final Set<Item> SET_ITEM_BLOCKS = new HashSet<>();

		/**
		 * Register this mod's {@link Block}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onEvent(final RegistryEvent.Register<Block> event) 
		{
			final Block[] arrayBlocks = {
					MOVING_LIGHT_SOURCE,
					MOVING_LIGHT_SOURCE_15,
					MOVING_LIGHT_SOURCE_14,
					MOVING_LIGHT_SOURCE_13,
					MOVING_LIGHT_SOURCE_12,
					MOVING_LIGHT_SOURCE_11,
					MOVING_LIGHT_SOURCE_9,
					MOVING_LIGHT_SOURCE_7
			};

			final IForgeRegistry<Block> registry = event.getRegistry();

			for (final Block block : arrayBlocks) {
				registry.register(block);
				SET_BLOCKS.add(block);
				// DEBUG
				System.out.println("Registering block: "+block.getRegistryName());
			}

			initialize();
			
			BlockMovingLightSource.initMapLightSources();
		}

		/**
		 * Register this mod's {@link ItemBlock}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) 
		{
			final ItemBlock[] items = {
					new ItemBlock(MOVING_LIGHT_SOURCE),
					new ItemBlock(MOVING_LIGHT_SOURCE_15),
					new ItemBlock(MOVING_LIGHT_SOURCE_14),
					new ItemBlock(MOVING_LIGHT_SOURCE_13),
					new ItemBlock(MOVING_LIGHT_SOURCE_12),
					new ItemBlock(MOVING_LIGHT_SOURCE_11),
					new ItemBlock(MOVING_LIGHT_SOURCE_9),
					new ItemBlock(MOVING_LIGHT_SOURCE_7),
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final ItemBlock item : items) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				SET_ITEM_BLOCKS.add(item);
				// DEBUG
				System.out.println("Registering Item Block for "+registryName);			}
		}		
	}	
}
