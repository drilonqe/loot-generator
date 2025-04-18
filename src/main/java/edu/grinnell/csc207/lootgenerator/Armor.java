package edu.grinnell.csc207.lootgenerator;

public class Armor {
    private String name;
    private int minVal;
    private int maxVal;

    /**
     * Constructor for armor
     *
     * @param name name of armor
     * @param minVal minimum value of armor
     * @param maxVal maximum value of armor
     */
    public Armor(String name, int minVal, int maxVal) {
        this.name = name;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }

    /**
     * Returns name of armor item
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns minimum value for armor
     * @return int
     */
    public int getMin() {
        return minVal;
    }

    /**
     * Returns maximum value for armor
     * @return int
     */
    public int getMax() {
        return maxVal;
    }

}
