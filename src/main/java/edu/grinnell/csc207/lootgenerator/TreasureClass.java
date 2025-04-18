package edu.grinnell.csc207.lootgenerator;

import java.util.List;

public class TreasureClass {
    private String name;
    private List<String> items;

    /**
     * Constructor for TreasureClass
     * 
     * @param name  Name of Treasure class
     * @param items Item options to be dropped
     */
    public TreasureClass(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }

    /**
     * Returns name of treasure class.
     * 
     * @return string
     */
    public String getName() {
        return name;
    }

    /**
     * Returns list of possible items to be dropped.
     * One of these will be randomly selected when generating loot.
     * 
     * @return list of strings
     */
    public List<String> getItems() {
        return items;
    }

}
