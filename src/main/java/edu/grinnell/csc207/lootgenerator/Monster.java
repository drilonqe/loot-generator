package edu.grinnell.csc207.lootgenerator;

/**
 * Class for monsters in Diablo game, and their treasure class.
 */
public class Monster {
    private String name;
    private String type;
    private int level;
    private String treasureClass;

    /**
     * Constructs a Monster with all relevant fields from the monstats.txt file.
     *
     * @param name          The name of the monster
     * @param type          The monster's type
     * @param level         The monster's level
     * @param treasureClass The name of the monster's treasure class
     */
    public Monster(String name, String type, int level, String treasureClass) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.treasureClass = treasureClass;
    }

    /**
     * returns name of monster
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * returns type of monster
     * 
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * returns treasure class of monster
     * 
     * @return String
     */
    public String getTreasureClass() {
        return treasureClass;
    }

    /**
     * returns level of monster
     * 
     * @return int
     */
    public int getLevel() {
        return level;
    }
}
