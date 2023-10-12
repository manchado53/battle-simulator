/*
 * Course: CS1011 - FIXME
 * Fall 2022
 * Lab 7 - Battle Simulator 3000
 * Name: FIXME
 * Created: FIXME
 */
package username;

import java.util.Scanner;

/**
 * BattleSim Driver for Battle Simulator 3000
 */
public class BattleSim {
    /**
     * Ten-sided die to be used for checking initiative by all classes
     */


    public static void main(String[] args) {
        // Local variables
        // Include any variable that will need to be accessed throughout the program here

        // sentinel value for the game loop
        boolean play = true;
        // String used to determine the winner of the epic battle
        String victor = "";
        // game loop
        do {
            // print the introduction and rules


            // initialize game
            // Initialize the Warrior and Mugwump classes, set the current victor to "none"
            Warrior warrior = null;
            Mugwump mugwump = null;
            Scanner in = null;


            // while neither combatant has lost all of their hit points, report status and battle!
            while (victor.equalsIgnoreCase("none")) {
                report(warrior, mugwump);
                victor = battle(warrior, mugwump, in);
            }
            // declare the winner


            // ask to play again

        } while(play);
        // Thank the user for playing your game

    }

    /**
     * This method displays the introduction to the game and gives a description of the rules.
     */
    private static void intro() {
        // Write a suitable introduction to your game

    }

    /**
     * This method handles the battle logic for the game.
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     * @return The name of the victor, or "none", if the battle is still raging on
     */
    private static String battle(Warrior warrior, Mugwump mugwump, Scanner in) {
        // determine who attacks first (Roll! For! Initiative!) and store the result

        // attack code
        // If the Warrior attacks first

        // Warrior attacks and assigns the resulting damage to the mugwump

        // Check if the Mugwump has been defeated
        // If not, Mugwump attacks!

        // Otherwise, the Warrior wins!

        // Otherwise the Mugwump is first
        // see above

        // If neither combatant is defeated, the battle rages on!
        return null;
    }

    /**
     * This method reports the status of the combatants
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     */
    private static void report(Warrior warrior, Mugwump mugwump) {
        // TODO
    }

    /**
     * This method asks the user what attack type they want to use and returns the result
     * @return 1 for sword, 2 for shield
     */
    private static int attackChoice(Scanner in) {
        // TODO
        return -1;
    }

    /**
     * Determines which combatant attacks first and returns the result. In the case of a tie,
     * re-roll.
     * @return 1 if the warrior goes first, 2 if the mugwump goes first
     */
    private static int initiative() {
        // roll for initiative for both combatants
        // until one initiative is greater than the other

        return -1;
    }

    /**
     * This method declares the victor of the epic battle
     * @param victor the name of the victor of the epic battle
     */
    private static void victory(String victor) {
        // TODO
    }

    /**
     * This method asks the user if they would like to play again
     * @param in Scanner
     * @return true if yes, false otherwise
     */
    private static boolean playAgain(Scanner in) {
        // TODO
        return false;
    }
}