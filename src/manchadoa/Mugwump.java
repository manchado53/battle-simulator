/*
 * Course: CS1011 - 111
 * Fall 2022
 * Lab 7 - Battle Simulator 3000
 * Name: Adrian Manchado
 * Created: 10/17/23
 */
package manchadoa;

public class Mugwump {
    // add methods here
    private int hitPoints;
    private int maxHitPoints;
    private Die d100;
    private Die d20;
    private Die d10;
    private Die d6;
    public Mugwump(){
        final int probabilityAI = 100;
        final int sideHitAttack = 20;
        final int sideHitPoints = 10;
        final int sideAttack = 6;

        this.d100 = new Die(probabilityAI);
        this.d20 = new Die(sideHitAttack);
        this.d10 = new Die(sideHitPoints);
        this.d6 = new Die(sideAttack);
        this.hitPoints = setInitialHitPoints();
        this.maxHitPoints = this.hitPoints;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    private int setInitialHitPoints(){
        final int timesRollHP = 6;
        for (int i = 0; i<timesRollHP; i++){
            this.d10.roll();
            this.hitPoints += d10.getCurrentValue();
        }
        return this.hitPoints; // Why do we give value back??????
    }
    /**
     * This method substract damage from warrior from HP Mugwump
     */
    public void takeDamage(int damage){
        this.hitPoints -= damage;
    }
    /**
     * This method handles the attack logic
     * @return the amount of damage an attack has caused, 0 if the attack misses or
     *         a negative amount of damage if the Mugwump heals itself
     */
    public int attack() {
        final int Razor = 1;
        final int Fangs = 2;
        final int Lick = 3;
        int ai = this.ai();
        // get attack type from ai
        if (ai == Razor){
            final int checkHitRazor = 13;
            final int timesRollRazor = 2;
            int damage = 0;
            d20.roll();
            System.out.println("The Mugwump uses Razor-Sharp Claws hit");
            if (d20.getCurrentValue() >= checkHitRazor){
                for (int i = 0; i<timesRollRazor; i++){
                    this.d6.roll();
                    damage += this.d6.getCurrentValue();
                }
                System.out.println("He hits you making " + damage + " damage!!");
                return damage;
            } else {
                System.out.println("But he misses!!!");
                return 0;
            }
        } else if (ai == Fangs) {
            final int timesRollFang = 3;
            final int checkHitFang = 16;
            int damage = 0;
            System.out.println("The Mugwump uses Fangs of Death hit");
            d20.roll();
            if (d20.getCurrentValue()>=checkHitFang){
                for (int i = 0; i<timesRollFang; i++){
                    this.d6.roll();
                    damage += this.d6.getCurrentValue();
                }
                System.out.println("He hits you making " + damage + " damage!!");
                return damage;
            }else {
                System.out.println("But he misses!!!");
                return 0;
            }
        }else if (ai == Lick){
            d6.roll();
            int count =0;
            System.out.println("The Mugwump lick their wounds and heal themself!");
            while (hitPoints < maxHitPoints && d6.getCurrentValue()>count){
                this.hitPoints += 1;
                count++;
            }
            System.out.println("He recovers " + count + " HP");
            return 0;
        }else {
            System.out.println("ERRORRR");
            return 0;
        }
        // roll attack die

        // determine results of attack

        // return the damage

    }

    /**
     * This method determines what action the Mugwump performs
     * @return 1 for a Claw attack, 2 for a Bite, and 3 if the Mugwump licks its wounds
     */
    private int ai() {
        d100.roll();
        final int chanceRazor = 60;
        final int chanceFangs = 85;
        final int chanceLick = 100;
        if (d100.getCurrentValue() <= chanceRazor){
            return 1;
        } else if (d100.getCurrentValue() <= chanceFangs){
            return 2;
        } else if (d100.getCurrentValue() <=chanceLick){
            return 3;
        } else {
            System.out.println("ERROR AIII");
            return 0;
        }
    }
}
