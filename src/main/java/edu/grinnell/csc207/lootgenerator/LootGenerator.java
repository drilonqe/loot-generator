package edu.grinnell.csc207.lootgenerator;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

// CITATION :
// used this source to get how to scan from user input
// https://www.w3schools.com/java/java_user_input.asp

// used this source for generating random numbers in a range
// https://www.baeldung.com/java-generating-random-numbers-in-range

public class LootGenerator {
    /** The path to the dataset (ither the small or large set). */
    // private static final String DATA_SET = "data/small";
    private static final String DATA_SET = "data/large";

    public static void main(String[] args) throws IOException {
        System.out.println("This program kills monsters and generates loot!");

        // load all data for drops
        List<Monster> monstersData = LootData.getMonster(DATA_SET + "/monstats.txt");
        Map<String, TreasureClass> tcData = LootData.getTreasure(DATA_SET + "/TreasureClassEx.txt");
        Map<String, Armor> armorData = LootData.getArmor(DATA_SET + "/armor.txt");
        List<Affix> prefixesData = LootData.getPrefix(DATA_SET + "/MagicPrefix.txt");
        List<Affix> suffixesData = LootData.getSuffix(DATA_SET + "/MagicSuffix.txt");

        Random r = new Random(); // random generator
        Scanner s = new Scanner(System.in); // for input
        boolean running = true;

        while (running) {
            // picks a random monster to slay
            Monster monster = randomElement(monstersData, r);
            System.out.println("\nFighting " + monster.getName());
            System.out.println("You have slain " + monster.getName() + "!");
            System.out.println(monster.getName() + " dropped:\n");

            // get base item
            String itemName = getDrop(monster.getTreasureClass(), tcData, r);

            // get armor stats
            Armor armor = armorData.get(itemName);
            int defense = r.nextInt(armor.getMax() - armor.getMin() + 1) + armor.getMin();

            StringBuilder buf = new StringBuilder();

            // 50/50 change of getting a prefix
            if (r.nextInt(2) == 1) {
                Affix prefix = randomElement(prefixesData, r);
                itemName = prefix.getName() + " " + itemName; // add prefix before item name
                int value = r.nextInt(prefix.getMax() - prefix.getMin() + 1) + prefix.getMin();
                buf.append(value).append(" ").append(prefix.getmod()).append("\n");
            }

            // 50/50 change of getting a suffix
            if (r.nextInt(2) == 1) {
                Affix suffix = randomElement(suffixesData, r);
                itemName = itemName + " " + suffix.getName(); // add suffix after item name
                int value = r.nextInt(suffix.getMax() - suffix.getMin() + 1) + suffix.getMin();
                buf.append(value).append(" ").append(suffix.getmod()).append("\n");
            }

            System.out.println(itemName);
            System.out.println("Defense: " + defense);
            System.out.print(buf.toString());
        
            System.out.print("\nFight again [y/n]? ");
            String input = s.nextLine().toLowerCase();
            while (!input.equals("n") && !input.equals("y")) {
                System.out.print("\nFight again [y/n]? ");
                input = s.nextLine().toLowerCase();
            }
            running = input.equals("y");
            
        }
    }

    public static String getDrop(String tcname, Map<String, TreasureClass> tcdata, Random r) {
        TreasureClass cur = tcdata.get(tcname);
        String drop = randomElement(cur.getItems(), r);

        if (tcdata.containsKey(drop)) {
            return getDrop(drop, tcdata, r); // if it returns another tc, recurse
        } else {
            return drop;
        }
    }
    
    public static <T> T randomElement(List<T> list, Random r) {
        return list.get(r.nextInt(list.size()));
    }
}
