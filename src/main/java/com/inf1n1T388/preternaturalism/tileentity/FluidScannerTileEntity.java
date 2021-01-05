package com.inf1n1T388.preternaturalism.tileentity;

import com.inf1n1T388.preternaturalism.Preternaturalism;
import com.inf1n1T388.preternaturalism.init.FluidInit;
import com.inf1n1T388.preternaturalism.init.ModTileEntityTypes;
import com.inf1n1T388.preternaturalism.objects.blockproperties.FluidType;
import com.inf1n1T388.preternaturalism.objects.blocks.FluidScanner;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nullable;

public class FluidScannerTileEntity extends TileEntity implements ITickableTileEntity {
    public FluidScanner block;

    public FluidScannerTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public FluidScannerTileEntity(){
        this(ModTileEntityTypes.FLUID_SCANNER.get());
    }

    @Override
    public void tick() {
        update();
    }

    private FluidState getIFluidState(){
        return world.getFluidState(this.pos.add(0, -1, 0));
    }

    private void update(){
        //Preternaturalism.LOGGER.info(this.getBlockState().getProperties().toArray()[0] + ", " + this.getBlockState().getProperties().toArray()[1] + ", " + this.getBlockState().getProperties().toArray()[2]);
        /*if(world != null && !world.isRemote()) {
            Fluid fluid = getIFluidState().getFluid();
            if (fluid == Fluids.WATER) {
                world.setBlockState(this.pos, block.getThisState(this).with(block.FLUID_TYPE, FluidType.WATER));
            } else if (fluid == Fluids.LAVA) {
                world.setBlockState(this.pos, block.getThisState(this).with(block.FLUID_TYPE, FluidType.LAVA));
            } else if (fluid == FluidInit.CONTAMINATED_WATER_FLUID.get()) {
                world.setBlockState(this.pos, block.getThisState(this).with(block.FLUID_TYPE, FluidType.CONTAMINATED_WATER));
            } else if (fluid == FluidInit.SULFUR_LIQUID_FLUID.get()) {
                world.setBlockState(this.pos, block.getThisState(this).with(block.FLUID_TYPE, FluidType.SULFUR_LIQUID));
            } else if (fluid == FluidInit.SULFUR_GAS_FLUID.get()) {
                world.setBlockState(this.pos, block.getThisState(this).with(block.FLUID_TYPE, FluidType.SULFUR_GAS));
            } else {
                world.setBlockState(this.pos, block.getThisState(this).with(block.FLUID_TYPE, FluidType.NONE));
            }
        }*/
    }
}
