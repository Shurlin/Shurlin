package xyz.shurlin.block.worker.entity;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import xyz.shurlin.block.entity.BlockEntityTypes;
import xyz.shurlin.recipe.RecipeTypes;
import xyz.shurlin.screen.worker.CollectorScreenHandler;
import xyz.shurlin.util.Collectable;

public class CollectorBlockEntity extends AbstractWorkerBlockEntity {
    private int consistence;

    public CollectorBlockEntity(int level) {
        super(BlockEntityTypes.COLLECTOR_BLOCK_ENTITY, "collector", level, RecipeTypes.BREAKING);
    }

    public CollectorBlockEntity(){
        this(0);
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new CollectorScreenHandler(syncId,this, playerInventory,this.propertyDelegate, world,this);
    }

    @Override
    public float getShurlinLevel() {
        return this.level * 10.0f;
    }

    @Override
    protected PropertyDelegate getPropertyDelegate() {
        return new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case 0:
                        return CollectorBlockEntity.this.workTime;
                    case 1:
                        return CollectorBlockEntity.this.workTimeTotal;
                    case 2:
                        return CollectorBlockEntity.this.consistence;
                    default:
                        return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0:
                        CollectorBlockEntity.this.workTime = value;
                    case 1:
                        CollectorBlockEntity.this.workTimeTotal = value;
                    case 2:
                        CollectorBlockEntity.this.consistence = value;
                }
            }

            @Override
            public int size() {
                return 3;
            }
        };
    }

    @Override
    public void tick() {//TODO
        if(this.world != null && !this.world.isClient){
            ItemStack input = this.inventory.get(0);
            if(!input.isEmpty()){
                Item collection = input.getItem();
                if(collection instanceof Collectable){
                    Collectable collectable = ((Collectable) collection);
                    this.consistence = collectable.getConsistence(this.world, this.pos);
                    if(!isWorking())
                        this.workTimeTotal = collectable.getTime();
                    ++this.workTime;
                    if(this.workTime == this.workTimeTotal){
                        this.workTime = 0;
                        this.craftRecipe(collection);
                    }
                }
            }else{
                this.workTime = 0;
            }
        }
    }

    @Override
    public int size() {
        return 2;
    }

//    private Item getInput(){
//        return this.inventory.get(0).getItem();
//    }

    private void craftRecipe(Item collection) {
        ItemStack input = this.inventory.get(0);
        ItemStack output = this.inventory.get(1);
        if (output.isEmpty()) {
            this.inventory.set(1, input.copy());
        } else if (output.getItem() == input.getItem()) {
            output.increment(1);
        }else return;

        input.decrement(1);
    }


}
