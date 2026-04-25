package io.github.sayuzaur.honeybees.block;

import farn.farn_util.api.particle.ParticleAPI;
import io.github.sayuzaur.honeybees.events.init.ItemListener;
import io.github.sayuzaur.honeybees.particle.BeeFlyingAround;
import io.github.sayuzaur.honeybees.particle.BeeFlyingIn;
import io.github.sayuzaur.honeybees.particle.BeeFlyingOut;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.DirectionProperty;
import net.modificationstation.stationapi.api.state.property.IntProperty;
import net.modificationstation.stationapi.api.state.property.Properties;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.math.Direction;

import java.util.Random;

public class BeeHive extends TemplateBlock {
    public static final DirectionProperty HORIZONTAL_FACING;
    public static final IntProperty HONEY_LEVEL;
    public static final IntProperty POPULATION_LEVEL;

    static {
        HORIZONTAL_FACING = Properties.FACING;
        HONEY_LEVEL = Properties.HONEY_LEVEL;
        POPULATION_LEVEL = IntProperty.of("population_level", 0, 7);
    }

    public BeeHive(Identifier identifier) {
        super(identifier, Material.WOOD);
        this.setSoundGroup(WOOD_SOUND_GROUP);
        this.setTickRandomly(true);
        this.setHardness(2.0F);
        setDefaultState(getStateManager().getDefaultState().with(HORIZONTAL_FACING, Direction.NORTH).with(HONEY_LEVEL, 0).with(POPULATION_LEVEL, 0));
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, HONEY_LEVEL, POPULATION_LEVEL);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getStateManager().getDefaultState().with(HORIZONTAL_FACING,context.getHorizontalPlayerFacing()).with(HONEY_LEVEL, 0).with(POPULATION_LEVEL, 0);
    }

    int morningTime = 0;
    int afternoonTime = 5000;
    int eveningTime = 10000;
    int nightTime = 12000;
    int minLightLevel = 8;
    int honeyDropCount = 2;

    private boolean isMorning(World world) {
        long timeOfDay = world.getTime() % 24000L;
        return timeOfDay > morningTime && timeOfDay < afternoonTime;
    }
    private boolean isAfternoon(World world) {
        long timeOfDay = world.getTime() % 24000L;
        return timeOfDay > afternoonTime && timeOfDay < eveningTime;
    }
    private boolean isEvening(World world) {
        long timeOfDay = world.getTime() % 24000L;
        return timeOfDay > eveningTime && timeOfDay < nightTime;
    }
    private boolean isDay(World world) {
        long timeOfDay = world.getTime() % 24000L;
        return timeOfDay > morningTime && timeOfDay < nightTime;
    }
    private boolean isBright(World world, int x, int y, int z) {
        return world.getLightLevel(x, y, z) >= minLightLevel;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        //world.playSound(x, y, z, "peeparticle:beehive.bee_ambient_", 0.9F, 0.9F);
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        if (!world.isRemote) {
            BlockState current = world.getBlockState(x, y, z);
            int honey = current.get(HONEY_LEVEL);
            honey++;
            if (honey > 5) {
                honey = 0;

                ItemStack stack = new ItemStack(ItemListener.HONEY);
                ItemEntity itemEntity = new ItemEntity(world, x + 0.5f, y + 1.5f, z + 0.5f, stack);
                world.spawnEntity(itemEntity);
            }
            world.setBlockStateWithNotify(x, y, z, current.with(HONEY_LEVEL, honey));

            return true;
        }
        return false;
    }

    @Override
    public void dropStacks(World world, int x, int y, int z, int meta, float luck) {
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, int x, int y, int z, BlockState state, int meta) {
        if (!world.isRemote && player.inventory.getSelectedItem() != null && player.inventory.getSelectedItem().getItem() instanceof AxeItem) {
            this.dropStack(world, x, y, z, new ItemStack(this));
            honeyDropCount = 0;
        }
        dropStacks(world, x, y, z, state);

        super.afterBreak(world, player, x, y, z, state, meta);
    }

    public void dropStacks(World world, int x, int y, int z, BlockState state) {
        if (!world.isRemote) {
            int honey = state.get(HONEY_LEVEL);
            if (honey == 5) {
                honeyDropCount++;
            }
            if (honeyDropCount != 0) {
                for (int i = 0; i < honeyDropCount; i++) {
                    float varBase = 0.7F;
                    float varX = world.random.nextFloat() * varBase + (1.0F - varBase) * 0.5F;
                    float varY = world.random.nextFloat() * varBase + (1.0F - varBase) * 0.5F;
                    float varZ = world.random.nextFloat() * varBase + (1.0F - varBase) * 0.5F;

                    ItemEntity honeyItemEntity = new ItemEntity(world,((float)x + varX),((float)y + varY),((float)z + varZ), new ItemStack(ItemListener.HONEY));
                    honeyItemEntity.pickupDelay = 10;
                    world.spawnEntity(honeyItemEntity);
                }
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if (isDay(world)) {
            BlockState current = world.getBlockState(x, y, z);
            Direction direction = current.get(HORIZONTAL_FACING);
            String face = direction.toString();

            float varX = x;
            float varZ = z;
            float varY = y + 0.3F;
            int varX2 = x;
            int varZ2 = z;
            float varX3 = x;
            float varZ3 = z;
            float velocityX = 0.0F;
            float velocityZ = 0.0F;
            int rand = random.nextInt(6);

            switch (face) {
                case "south" -> {
                    varX = varX - 0.5F;
                    varX2 = varX2 - 1;
                    varX3 = varX3 - 3;
                    velocityX = velocityX - 1;
                }
                case "north" -> {
                    varX = varX + 0.5F;
                    varX2 = varX2 + 1;
                    varX3 = varX3 + 3;
                    velocityX = velocityX + 1;
                }
                case "west" -> {
                    varZ = varZ - 0.5F;
                    varZ2 = varZ2 - 1;
                    varZ3 = varZ3 - 3;
                    velocityZ = velocityZ - 1;
                }
                case "east" -> {
                    varZ = varZ + 0.5F;
                    varZ2 = varZ2 + 1;
                    varZ3 = varZ3 + 3;
                    velocityZ = velocityX + 1;
                }
            }
            if (isBright(world, varX2, y, varZ2)) {
                if (isMorning(world)) {
                    if (rand == 0) {
                        ParticleAPI.addParticle(new BeeFlyingAround(world, varX, varY, varZ, velocityX, 0, velocityZ));
                    } else if (rand <= 4) {
                        ParticleAPI.addParticle(new BeeFlyingOut(world, varX, varY, varZ, velocityX, 0, velocityZ));
                    }
                } else if (isAfternoon(world)) {
                    if (rand == 0) {
                        ParticleAPI.addParticle(new BeeFlyingAround(world, varX, varY, varZ, velocityX, 0, velocityZ));
                    } else if (rand == 1) {
                        ParticleAPI.addParticle(new BeeFlyingOut(world, varX, varY, varZ, velocityX, 0, velocityZ));
                    } else if (rand == 2 || rand == 3) {
                        ParticleAPI.addParticle(new BeeFlyingIn(world, varX3, varY, varZ3, velocityX, 0, velocityZ));
                    }
                } else if (isEvening(world)) {
                    if (rand <= 3) {
                        ParticleAPI.addParticle(new BeeFlyingIn(world, varX3, varY, varZ3, velocityX, 0, velocityZ));
                    }
                }
                world.playSound(x, y, z, "honeybees:beehive.bee_ambient", random.nextFloat() * 0.3F + 0.25F, random.nextFloat() * 0.3F + 0.8F);
                if (random.nextInt(15) == 0) {
                    world.playSound(x, y, z, "honeybees:beehive.bee_buzz", random.nextFloat() * 0.3F + 0.25F, random.nextFloat() * 0.3F + 0.8F);
                }
            }
        }
    }
}
