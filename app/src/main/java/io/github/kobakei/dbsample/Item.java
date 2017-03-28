package io.github.kobakei.dbsample;

/**
 * Created by keisukekobayashi on 2017/03/18.
 */

final public class Item {

    public final String name;

    private Item(String name) {
        this.name = name;
    }

    static Item create(int number) {
        return new Item("Item " + number);
    }
}

