# Project: Loot Generator REVISION

Authors: Drilon Qerimi

### What I needed to revise:
Grading comment:
For an E, fix the style violations (9). You can get a list of them with the command mvn checkstyle:check. Well done!

### CHANGELOG
Fixed all the checkstyle violations. They were mostly because of missing
javadocs for classes. Now checkstyle runs with 0 violations.

@zakrajsek:loot-generator$ mvn checkstyle:check
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< edu.grinnell.csc207:LootGenerator >------------------
[INFO] Building LootGenerator 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-checkstyle-plugin:3.6.0:check (default-cli) @ LootGenerator ---
[INFO] Starting audit...
Audit done.
[INFO] You have 0 Checkstyle violations.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.614 s


## Resources

*   (_TODO: fill in resources here!_)

* I used Java Version 23.0.2
* I used Visual Studio Code as an IDE
* I used the pages made by prof. Osera as reference
source: https://osera.cs.grinnell.edu/ttap/data-structures-labs/ 
source: https://osera.cs.grinnell.edu/ttap/data-structures
* https://docs.oracle.com/en/java/javase/23/docs/
* Forked repository from prof.Osera:
https://github.com/psosera/loot-generator
* Prof. Osera adviced me how to code getDrop() in LootGenerator.java through recursion or while loop
* Referenced code for how to read a file in java through this source:
https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
* Checked this source, to find out how to read file with strings separated by tab
https://stackoverflow.com/questions/19575308/read-a-file-separated-by-tab-and-put-the-words-in-an-arraylist
* Used this source to figure out how to get user input
https://www.w3schools.com/java/java_user_input.asp
* Used this source to figure out how to generate random numbers from a range of numbers
https://www.baeldung.com/java-generating-random-numbers-in-range
