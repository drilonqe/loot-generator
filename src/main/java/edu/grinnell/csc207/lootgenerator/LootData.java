package edu.grinnell.csc207.lootgenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// CITATION:

// used to check how to read file string separated by tab:
// https://stackoverflow.com/questions/19575308/read-a-file-separated-by-tab-and-put-the-words-in-an-arraylist

// used this source to check how to read textfile in java.
// https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

public class LootData {

    /**
     * Returns data collected from file for monsters.
     * 
     * @param file File with String
     * @return a list containing monster data
     * @throws IOException
     */
    public static List<Monster> getMonster(String file) throws IOException {
        List<Monster> monsters = new ArrayList<>();

        BufferedReader bufRead = new BufferedReader(new FileReader(file));

        String line;
        while ((line = bufRead.readLine()) != null) {
            String[] words = line.split("\t");

            String name = words[0];
            String type = words[1];
            int level = Integer.parseInt(words[2]);
            String treasureClass = words[3];

            monsters.add(new Monster(name, type, level, treasureClass));
        }
        bufRead.close();
        return monsters;
    }

    /**
     * Returns data collected from file for TC. It contains the name, and the items
     * to drop.
     * 
     * @param file File with String
     * @return map TC name and items to drop
     * @throws IOException
     */
    public static Map<String, TreasureClass> getTreasure(String file) throws IOException {
        Map<String, TreasureClass> treasure = new HashMap<>();

        BufferedReader bufRead = new BufferedReader(new FileReader(file));

        String line;
        while ((line = bufRead.readLine()) != null) {
            String[] words = line.split("\t");
            String name = words[0];
            List<String> items = new ArrayList<>();
            items.add(words[1]);
            items.add(words[2]);
            items.add(words[3]);

            treasure.put(name, new TreasureClass(name, items));
        }
        bufRead.close();
        return treasure;
    }

    /**
     * Returns data collected from file for armor. It contains the name
     * and values that armor can have.
     * 
     * @param file File with String
     * @return MAP armor and its values
     * @throws IOException
     */
    public static Map<String, Armor> getArmor(String file) throws IOException {
        Map<String, Armor> armor = new HashMap<>();

        BufferedReader bufRead = new BufferedReader(new FileReader(file));

        String line;
        while ((line = bufRead.readLine()) != null) {
            String[] words = line.split("\t");
            String name = words[0];
            int min = Integer.parseInt(words[1]);
            int max = Integer.parseInt(words[2]);

            armor.put(name, new Armor(name, min, max));
        }
        bufRead.close();
        return armor;
    }

    /**
     * Return data from Affixes. Will be placed as Prefix.
     * 
     * @param file File with String
     * @return List of Affixes
     * @throws IOException
     */
    public static List<Affix> getPrefix(String file) throws IOException {
        List<Affix> prefixes = new ArrayList<>();
        BufferedReader bufRead = new BufferedReader(new FileReader(file));

        String line;
        while ((line = bufRead.readLine()) != null) {
            String[] words = line.split("\t");
            String name = words[0];
            String modifiedStat = words[1];
            int min = Integer.parseInt(words[2]);
            int max = Integer.parseInt(words[3]);

            prefixes.add(new Affix(name, modifiedStat, min, max));
        }
        bufRead.close();
        return prefixes;
    }

    /**
     * Return data from Affixes. Will be placed as Suffix.
     * 
     * @param file File with String
     * @return List of Affixes
     * @throws IOException
     */
    public static List<Affix> getSuffix(String file) throws IOException {
        List<Affix> suffixes = new ArrayList<>();
        BufferedReader bufRead = new BufferedReader(new FileReader(file));

        String line;
        while ((line = bufRead.readLine()) != null) {
            String[] words = line.split("\t");
            String name = words[0];
            String modifiedStat = words[1];
            int min = Integer.parseInt(words[2]);
            int max = Integer.parseInt(words[3]);

            suffixes.add(new Affix(name, modifiedStat, min, max));
        }
        bufRead.close();
        return suffixes;
    }
}
