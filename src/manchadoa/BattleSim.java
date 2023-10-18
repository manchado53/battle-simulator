/*
 * Course: CS1011 - 111
 * Fall 2022
 * Lab 7 - Battle Simulator 3000
 * Name: Adrian Manchado
 * Created: 10/17/23
 */
package manchadoa;

import java.util.Scanner;

/**
 * BattleSim Driver for Battle Simulator 3000
 */
public class BattleSim {
    /**
     * Ten-sided die to be used for checking initiative by all classes
     */
    public static final Die INITIARIVE_DIE = new Die(10);
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
            intro();
            // initialize game
            // Initialize the Warrior and Mugwump classes, set the current victor to "none"
            Warrior warrior = new Warrior();
            Mugwump mugwump = new Mugwump();
            victor = "none";
            Scanner in = new Scanner(System.in);


            // while neither combatant has lost all of their hit points, report status and battle!
            while (victor.equalsIgnoreCase("none")) {
                report(warrior, mugwump);
                victor = battle(warrior, mugwump, in);
            }
            // declare the winner
            victory(victor);

            // ask to play again
            play = playAgain(in);
        } while(play);
        // Thank the user for playing your game
        System.out.println("Thank you for playing the Battle Simulator Game!!");
    }

    /**
     * This method displays the introduction to the game and gives a description of the rules.
     */
    private static void intro() {
        // Write a suitable introduction to your game
        System.out.println("Welcome to Battle Simulator 3000! The world's more low tech battle simulator!\n" +
                "You are a Valiant Warrior defending your humble village from an evil Mugwump! Fight bravely, \n" +
                "or the citizens of your town will be the Mugwump's dinner!\n" +
                "\n" +
                "You have your Trusty Sword, which deals decent damage, but can be tough to hit with sometimes. \n" +
                "You also have your Shield of Light, which is not as strong as your sword, but is easier to deal \n" +
                "damage with.\n" +
                "\n" +
                "Let the epic battle begin!");
    }

    /**
     * This method handles the battle logic for the game.
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     * @return The name of the victor, or "none", if the battle is still raging on
     */
    private static String battle(Warrior warrior, Mugwump mugwump, Scanner in) {
        // determine who attacks first (Roll! For! Initiative!) and store the result
        int attackFirst = initiative();
        if (attackFirst == 1){
            System.out.println("You attack first");
            int damageAttackWarrior = warrior.attack(attackChoice(in));
            mugwump.takeDamage(damageAttackWarrior);
            if (mugwump.getHitPoints()<=0){
                return "Warrior";
            }else {
                int damageAttackMugwump = mugwump.attack();
                warrior.takeDamage(damageAttackMugwump);
                if (warrior.getHitPoints()<=0){
                    return "Mugwump";
                }
            }
        } else if (attackFirst == 2) {
            System.out.println("The Mugwump attack first");
            int damageAttackMugwump = mugwump.attack();
            warrior.takeDamage(damageAttackMugwump);
            if (warrior.getHitPoints()<=0){
                return "Mugwump";
            }else {
                int damageAttackWarrior = warrior.attack(attackChoice(in));
                mugwump.takeDamage(damageAttackWarrior);
                if (mugwump.getHitPoints()<=0){
                    return "Warrior";
                }
            }
        }else{
            return "none";
        }

        // attack code
        // If the Warrior attacks first

        // Warrior attacks and assigns the resulting damage to the mugwump

        // Check if the Mugwump has been defeated
        // If not, Mugwump attacks!

        // Otherwise, the Warrior wins!

        // Otherwise the Mugwump is first
        // see above

        // If neither combatant is defeated, the battle rages on!
        return "none";
    }

    /**
     * This method reports the status of the combatants
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     */
    private static void report(Warrior warrior, Mugwump mugwump) {
        System.out.println("\nWarrior HP: " + warrior.getHitPoints());
        System.out.println("Mugwump HP: " + mugwump.getHitPoints() + "\n");

    }

    /**
     * This method asks the user what attack type they want to use and returns the result
     * @return 1 for sword, 2 for shield
     */
    private static int attackChoice(Scanner in) {
        System.out.print("How would you like to attack?\n" +
                "1. Your Trusty Sword\n" +
                "2. Your Shield of Light\n" +
                "Enter choice: ");
        String choiceAttack = in.nextLine();
        if (choiceAttack.equalsIgnoreCase("1")){
            return 1;
        } else if (choiceAttack.equalsIgnoreCase("2")) {
            return 2;
        }else {
            return 0;
        }
    }

    /**
     * Determines which combatant attacks first and returns the result. In the case of a tie,
     * re-roll.
     * @return 1 if the warrior goes first, 2 if the mugwump goes first
     */
    private static int initiative() {
        // roll for initiative for both combatants
        // until one initiative is greater than the other
        boolean controler = true;
        while (controler){
            INITIARIVE_DIE.roll();
            int warriorInitDie = INITIARIVE_DIE.getCurrentValue();
            INITIARIVE_DIE.roll();
            int mugwumpInitDie = INITIARIVE_DIE.getCurrentValue();
            if (warriorInitDie > mugwumpInitDie){
                controler = false;
                return 1;
            } else if (warriorInitDie < mugwumpInitDie) {
                controler = false;
                return 2;
            } else if (warriorInitDie == mugwumpInitDie) {
                System.out.println("Tie!!! Re-roll dices");
                continue;
            }
        }
        return 0;
    }

    /**
     * This method declares the victor of the epic battle
     * @param victor the name of the victor of the epic battle
     */
    private static void victory(String victor) {
        if (victor.equalsIgnoreCase("Warrior")){
            System.out.println("\nThe citizens cheer and invite you back to town for a " +
                    "feast as thanks for saving their lives (again)!\n");
        } else if (victor.equalsIgnoreCase("Mugwump")) {
            System.out.println("\nNOOO!! The citizens are mocked by the evil Mugwump.");
        }
    }

    /**
     * This method asks the user if they would like to play again
     * @param in Scanner
     * @return true if yes, false otherwise
     */
    private static boolean playAgain(Scanner in) {
        System.out.println("Do you want to play again?(yes/no) ");
        String x = in.nextLine();
        if (x.equalsIgnoreCase("y") || x.equalsIgnoreCase("yes")){
            return true;
        }else {
            return false;
        }
    }
}