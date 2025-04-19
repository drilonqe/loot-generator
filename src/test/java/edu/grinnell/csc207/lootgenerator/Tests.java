package edu.grinnell.csc207.lootgenerator;

import static edu.grinnell.csc207.lootgenerator.LootGenerator.randomElement;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class Tests {
    /**
     * Checks if stats generated are within range
     * 
     * @throws IOException
     */
    @Test
    public void statsWithinRange() throws IOException {
        Map<String, Armor> armorData = LootData.getArmor("data/small/armor.txt");
        Armor a = armorData.get("Leather Armor");
        Random r = new Random();

        int def1 = r.nextInt(a.getMax() - a.getMin() + 1) + a.getMin();
        int def2 = r.nextInt(a.getMax() - a.getMin() + 1) + a.getMin();
        int def3 = r.nextInt(a.getMax() - a.getMin() + 1) + a.getMin();

        assertTrue(def1 >= a.getMin() && def1 <= a.getMax());
        assertTrue(def2 >= a.getMin() && def2 <= a.getMax());
        assertTrue(def3 >= a.getMin() && def3 <= a.getMax());
    }

    /**
     * Tests if randomElement truly gets something random from the list,
     */
    @Test
    public void randomElementTest() {
        List<String> items = List.of("A", "B", "C");
        String result = randomElement(items, new Random());
        assertTrue(items.contains(result));
        // make sure what we get will be of the list
    }

    /**
     * Test to see if getDrop returns a base item as final value
     * 
     * @throws IOException
     */
    @Test
    public void testGetDrop() throws IOException {
        Map<String, TreasureClass> tcData = LootData.getTreasure("data/large/TreasureClassEx.txt");
        Random r = new Random();
        // Chose Act 1 Cast A, because it will return another TC, so we want to check if
        // our getDrop successfully reaches the base item.
        String drop = LootGenerator.getDrop("Act 1 Cast A", tcData, r);
        assertFalse(tcData.containsKey(drop)); // drop should not be a treasure class
    }
}
