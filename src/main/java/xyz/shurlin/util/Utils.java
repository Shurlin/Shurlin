package xyz.shurlin.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import xyz.shurlin.Shurlin;
import xyz.shurlin.world.dimension.Dimensions;

import java.util.Random;
import java.util.Vector;


public class Utils {

    public static void createLightning(World world, BlockPos pos) {
        if (world instanceof ServerWorld) {
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(world);
            assert lightningEntity != null;
            lightningEntity.method_29495(Vec3d.ofBottomCenter(pos));
            world.spawnEntity(lightningEntity);
        }
    }

    public static double getDistanceBetweenBlocks(BlockPos pos1, BlockPos pos2) {
        return Math.sqrt(Math.pow(pos1.getX() - pos2.getX(), 2)
                + Math.pow(pos1.getY() - pos2.getY(), 2)
                + Math.pow(pos1.getZ() - pos2.getZ(), 2));
    }

    public static BlockPos[] poses_of_horizontal = new BlockPos[]{
            BlockPos.ORIGIN.north(),
            BlockPos.ORIGIN.west(),
            BlockPos.ORIGIN.south(),
            BlockPos.ORIGIN.east()
    };

    public static BlockPos[] poses_of_all_directions = new BlockPos[]{
            BlockPos.ORIGIN.north(),
            BlockPos.ORIGIN.north().west(),
            BlockPos.ORIGIN.north().east(),
            BlockPos.ORIGIN.north().up(),
            BlockPos.ORIGIN.north().down(),
            BlockPos.ORIGIN.north().west().up(),
            BlockPos.ORIGIN.north().west().down(),
            BlockPos.ORIGIN.north().east().up(),
            BlockPos.ORIGIN.north().east().down(),
            BlockPos.ORIGIN.south(),
            BlockPos.ORIGIN.south().west(),
            BlockPos.ORIGIN.south().east(),
            BlockPos.ORIGIN.south().up(),
            BlockPos.ORIGIN.south().down(),
            BlockPos.ORIGIN.south().west().up(),
            BlockPos.ORIGIN.south().west().down(),
            BlockPos.ORIGIN.south().east().up(),
            BlockPos.ORIGIN.south().east().down(),
            BlockPos.ORIGIN.west(),
            BlockPos.ORIGIN.west().north(),
            BlockPos.ORIGIN.west().south(),
            BlockPos.ORIGIN.west().up(),
            BlockPos.ORIGIN.west().down(),
            BlockPos.ORIGIN.east(),
            BlockPos.ORIGIN.east().north(),
            BlockPos.ORIGIN.east().south(),
            BlockPos.ORIGIN.east().up(),
            BlockPos.ORIGIN.east().down(),
            BlockPos.ORIGIN.up(),
            BlockPos.ORIGIN.up().north(),
            BlockPos.ORIGIN.up().south(),
            BlockPos.ORIGIN.up().west(),
            BlockPos.ORIGIN.up().east(),
            BlockPos.ORIGIN.down(),
            BlockPos.ORIGIN.down().north(),
            BlockPos.ORIGIN.down().south(),
            BlockPos.ORIGIN.down().west(),
            BlockPos.ORIGIN.down().east()};

    public static void breakBlocks(World world, BlockPos middlePos, int r) {
        Thread thread = new Thread(() -> {
            for (int i = middlePos.getX() - r; i <= middlePos.getX() + r; i++)
                for (int j = middlePos.getY() - r; j <= middlePos.getY() + r; j++)
                    for (int k = middlePos.getZ() - r; k <= middlePos.getZ() + r; k++) {
                        BlockPos pos = new BlockPos(i, j, k);
                        if (world.getBlockState(pos).getBlock() == Blocks.STONE)
                            world.breakBlock(pos, false);
                    }
        });
        thread.start();
    }

    public static boolean canDo(Object o1, Object o2){
        if(o1 instanceof ShurlinLevel && o2 instanceof ShurlinLevel)
            return ((ShurlinLevel) o1).getShurlinLevel() >= ((ShurlinLevel) o1).getShurlinLevel();
        return true;
    }

    public static final Identifier PACKET_ID_1 = new Identifier(Shurlin.MODID, "data_1");
    public static final Identifier OPEN_CUL = new Identifier(Shurlin.MODID, "key_open_cul");
    public static final Identifier INJECT_SPIRIT = new Identifier(Shurlin.MODID, "inject_spirit");

    public static void spawnItem(World world, BlockPos pos, Item item, int cnt){
        world.spawnEntity(new ItemEntity(world, pos.getX(),pos.getY(),pos.getZ(),new ItemStack(item, cnt)));
    }

    public static void setRandomBlock(World world, BlockPos middlePos, int r, BlockState state){
        Random random = new Random();
        world.setBlockState(middlePos.add(random.nextInt(r * 2 + 1) - r,
                random.nextInt(r * 2 + 1) - r,
                random.nextInt(r * 2 + 1) - r), state);
    }

    public static int getAllABS(int... ints){
        int res = 0;
        for(int i : ints)
            res += Math.abs(i);
        return res;
    }

    public static void joinHolyFarmerDimension(ServerWorld world, Entity entity){
        MinecraftServer minecraftServer = world.getServer();
        RegistryKey<World> key = world.getRegistryKey() == World.OVERWORLD ? Dimensions.HOLY_FARMER : World.OVERWORLD;
        ServerWorld serverWorld = minecraftServer.getWorld(key);
        if(serverWorld != null && !entity.hasVehicle()){
            BlockPos pos = serverWorld.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, entity.getBlockPos());
            entity.changeDimension(serverWorld);
            entity.setPos(pos.getX(), pos.getY(), pos.getZ());
        }
    }

    public static boolean isSealed(World world, BlockPos pos, BlockPos[] dirs, Block inside, Block seal, Vector<BlockPos> found){
//        System.out.println(pos);
        if(found.contains(pos))
            return true;
        BlockState block = world.getBlockState(pos);
        found.add(pos);
        if(block.isOf(inside)){
            for(BlockPos dir:dirs){
                if(!isSealed(world, pos.add(dir), dirs, inside, seal, found))
                    return false;
            }
        }else return block.isOf(seal);
        return true;
    }

}
