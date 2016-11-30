package com.mrtrollnugnug.experienceore;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

import static com.mrtrollnugnug.experienceore.ExperienceOre.MODID;

public class BlockExperienceOre extends Block {

	public BlockExperienceOre() {
		super(Material.IRON);
		setCreativeTab(CreativeTabs.MATERIALS);
		setSoundType(SoundType.STONE);
		setUnlocalizedName(MODID + ".experience_ore");
		setRegistryName(MODID, "experience_ore");
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this).setRegistryName(getRegistryName()));
		ExperienceOre.PROXY.registerWithMapper(this);
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		return (new Random().nextInt(3) * 3) * fortune;
	}
}