package edu.grinnell.csc207.lootgenerator;

public class Affix {
    private String name;
    private String mod1code;
    private int minVal;
    private int maxVal;

    /**
     * Constructor for affixes
     * 
     * @param name     Name of affix (Pre / Suff)
     * @param mod1code Stat what it modifies
     * @param minVal   minimum value
     * @param maxVal   maximum value
     */
    public Affix(String name, String mod1code, int minVal, int maxVal) {
        this.name = name;
        this.mod1code = mod1code;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }

    /**
     * Returns affix name
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns stat what it modifies
     * 
     * @return String
     */
    public String getmod() {
        return mod1code;
    }

    /**
     * Returns minimum value for stat it modifies
     * 
     * @return int
     */
    public int getMin() {
        return minVal;
    }

    /**
     * Returns maximum value for stat it modifies
     * 
     * @return int
     */
    public int getMax() {
        return maxVal;
    }
}
