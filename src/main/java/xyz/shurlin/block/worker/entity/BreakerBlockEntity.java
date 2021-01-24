package xyz.shurlin.block.worker.entity;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import xyz.shurlin.block.entity.BlockEntityTypes;
import xyz.shurlin.recipe.RecipeTypes;
import xyz.shurlin.screen.worker.BreakerScreenHandler;

public class BreakerBlockEntity extends AbstractWorkerBlockEntity {

    public BreakerBlockEntity(int level) {
        super(BlockEntityTypes.BREAKER_BLOCK_ENTITY, "breaker", level, RecipeTypes.BREAKING);
    }

    public BreakerBlockEntity(){
        this(0);
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new BreakerScreenHandler(syncId,this, playerInventory,this.propertyDelegate,world,this);
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
                        return BreakerBlockEntity.this.workTime;
                    case 1:
                        return BreakerBlockEntity.this.workTimeTotal;
                    default:
                        return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0:
                        BreakerBlockEntity.this.workTime = value;
                    case 1:
                        BreakerBlockEntity.this.workTimeTotal = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void tick() {
        if (this.world != null && !this.world.isClient) {
            ItemStack input = this.inventory.get(0);
            if(!input.isEmpty()){
                Recipe<?> recipe = this.world.getRecipeManager().getFirstMatch(this.recipeType, this, this.world).orElse(null);
                if(this.canAcceptRecipeOutput(recipe)){
                    if(!isWorking() || this.workTimeTotal <= 0)
                        this.workTimeTotal = this.getWorkTimeTotal();
                    ++this.workTime;
                    if(this.workTime == this.workTimeTotal){
                        this.workTime = 0;
                        this.craftRecipe(recipe);
                    }
                }
            }else {
                this.workTime = 0;
                this.workTimeTotal = 0;
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


}
