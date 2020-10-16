package xyz.shurlin.item;

import xyz.shurlin.spirit.ElementPropertyType;

public class SpiritItem extends BasicItem{
    private final ElementPropertyType elementPropertyType;
    private final double spiritConsistence;

    public SpiritItem(ElementPropertyType elementPropertyType, double spiritConsistence) {
        this.elementPropertyType = elementPropertyType;
        this.spiritConsistence = spiritConsistence;
    }

    public ElementPropertyType getElementPropertyType() {
        return elementPropertyType;
    }

    public double getSpiritConsistence() {
        return spiritConsistence;
    }
}
