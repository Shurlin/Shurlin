package xyz.shurlin.item;

public class ExtractantItem extends BasicItem {
    private int extractant;

    public ExtractantItem(int extractant) {
        this.extractant = extractant;
    }

    public int getExtractant() {
        return extractant;
    }
}
