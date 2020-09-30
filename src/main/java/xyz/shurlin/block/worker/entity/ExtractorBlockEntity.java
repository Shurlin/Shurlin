package xyz.shurlin.block.worker.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.Recipe;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import xyz.shurlin.block.entity.BlockEntityTypes;
import xyz.shurlin.item.ExtractantItem;
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
        if (this.world != null && !this.world.isClient) {
            ItemStack input = this.inventory.get(0);
            ItemStack extractantStack = this.inventory.get(1);
            if(this.cur_extractant == 0 && !extractantStack.isEmpty()){
                Item extractant = extractantStack.getItem();
                if(extractant instanceof ExtractantItem){
                    ExtractantItem extractantItem = (ExtractantItem) extractant;
                    this.extractant = extractantItem.getExtractant();
                    this.cur_extractant = this.extractant;
                    extractantStack.decrement(1);
                }
            }
            if(!input.isEmpty()){
                Recipe<?> recipe = (Recipe) this.world.getRecipeManager().getFirstMatch(this.recipeType, this, this.world).orElse(null);
                if(this.canAcceptRecipeOutput(recipe) && this.cur_extractant > 0){
                    if(!isWorking())
                        this.workTimeTotal = this.getWorkTimeTotal();
                    ++this.workTime;
                    if(this.workTime == this.workTimeTotal){
                        this.workTime = 0;
                        --this.cur_extractant;
                        this.craftRecipe(recipe);
                    }
                }
            }else {
                this.workTime = 0;
            }
        }
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.cur_extractant = tag.getShort("Cur_extractant");
        this.extractant = tag.getShort("Extractant");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        tag.putShort("Cur_extractant",(short) this.cur_extractant);
        tag.putShort("Extractant",(short) this.extractant);
        return super.toTag(tag);
    }

    @Override
    public int size() {
        return 3;
    }

//    private Item getInput(){
//        return this.inventory.get(0).getItem();
//    }


    @Override
    protected int getOutputSlot() {
        return 2;
    }
}
