package xyz.shurlin.item;

import xyz.shurlin.util.ElementPropertyType;

public class SpiritItem extends BasicItem{
    private final ElementPropertyType elementPropertyType;
    private final int spirit_consistence;

    public SpiritItem(ElementPropertyType elementPropertyType, int spirit_consistence) {
        this.elementPropertyType = elementPropertyType;
        this.spirit_consistence = spirit_consistence;
    }

    public ElementPropertyType getElementPropertyType() {
        return elementPropertyType;
    }

    public int getSpirit_consistence() {
        return spirit_consistence;
    }
}
