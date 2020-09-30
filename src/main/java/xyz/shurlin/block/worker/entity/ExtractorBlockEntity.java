package xyz.shurlin.block.worker.entity;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import xyz.shurlin.block.entity.BlockEntityTypes;
import xyz.shurlin.recipe.RecipeTypes;
import xyz.shurlin.screen.worker.BreakerScreenHandler;
import xyz.shurlin.screen.worker.ExtractorScreenHandler;

public class ExtractorBlockEntity extends AbstractWorkerBlockEntity {
    private int extractant;
    private int cur_extractant;

    public ExtractorBlockEntity(int level) {
        super(BlockEntityTypes.EXTRACTOR_BLOCK_ENTITY, "extractor", level, RecipeTypes.BREAKING);//TODO
    }

    public ExtractorBlockEntity(){
        this(0);
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new ExtractorScreenHandler(syncId,this, playerInventory,this.propertyDelegate,world,this);
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
                        return ExtractorBlockEntity.this.workTime;
                    case 1:
                        return ExtractorBlockEntity.this.workTimeTotal;
                    case 2:
                        return ExtractorBlockEntity.this.cur_extractant;
                    case 3:
                        return ExtractorBlockEntity.this.extractant;
                    default:
                        return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0:
                        ExtractorBlockEntity.this.workTime = value;
                    case 1:
                        ExtractorBlockEntity.this.workTimeTotal = value;
                    case 2:
                        ExtractorBlockEntity.this.cur_extractant = value;
                    case 3:
                        ExtractorBlockEntity.this.extractant = value;
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    @Override
    public void tick() {//TODO
        this.extractant = 33;
//        if (this.world != null && !this.world.isClient) {
//            ItemStack input = this.inventory.get(0);
//            if(!input.isEmpty()){
//                Recipe<?> recipe = (Recipe) this.world.getRecipeManager().getFirstMatch(this.recipeType, this, this.world).orElse(null);
//                if(this.canAcceptRecipeOutput(recipe)){
//                    if(!isWorking())
//                        this.workTimeTotal = this.getWorkTimeTotal();
//                    ++this.workTime;
//                    if(this.workTime == this.workTimeTotal){
//                        this.workTime = 0;
//                        this.craftRecipe(recipe);
//                    }
//                }
//            }else {
//                this.workTime = 0;
//            }
//        }
    }

    @Override
    public int size() {
        return 3;
    }

//    private Item getInput(){
//        return this.inventory.get(0).getItem();
//    }


}
