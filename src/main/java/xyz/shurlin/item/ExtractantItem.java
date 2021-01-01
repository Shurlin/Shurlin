package xyz.shurlin.item;

public class ExtractantItem extends BasicItem {
    private final int extractant;

    public ExtractantItem(int extractant) {
        this.extractant = extractant;
    }

    public int getExtractant() {
        return extractant;
    }
}
