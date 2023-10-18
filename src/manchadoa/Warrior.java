package manchadoa;

public class Warrior {
    private int hitPoints;
    private Die d20;
    private Die d10;
    private Die d8;
    private Die d4;
    public Warrior(){
        final int sideHitAttack = 20;
        final int sideHitPoints = 10;
        final int sideDamageSword = 8;
        final int sideDamageShield = 4;

        this.d20 = new Die(sideHitAttack);
        this.d10 = new Die(sideHitPoints);
        this.d8 = new Die(sideDamageSword);
        this.d4 = new Die(sideDamageShield);
        this.hitPoints = setInitialHitPoints();
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public void takeDamage(int damage){
        this.hitPoints -= damage;
    }
    public int attack(int type){
        if (type==1){
            final int checkHitSword = 12;
            final int timesRollSword = 2;
            int damage=0;
            d20.roll();
            System.out.println("You use your Trusty Sword!!");
            if (this.d20.getCurrentValue()>=checkHitSword) {
                for (int i = 0; i<timesRollSword; i++){
                     damage += this.d8.getCurrentValue();
                     this.d8.roll();
                }
                System.out.println("You hit that monster making "+ damage + " damage!!");
                return damage;
            }else{
                System.out.println("But you miss the creature");
                return 0;
            }
        } else if (type==2) {
            final int hitShield = 6;
            d20.roll();
            System.out.println("You use your Shield of Light!!");
            if (this.d20.getCurrentValue() >= hitShield) {
                this.d4.roll();
                int damage = this.d4.getCurrentValue();
                System.out.println("You hit that monster causing " + damage + " damage");
                return damage;
            }else {
                System.out.println("But you miss the creature");
                return 0;
            }
        }else{
            return 0;

        }
    }
    private int setInitialHitPoints(){
        final int timesRollHP = 4;
        for (int i = 0; i<timesRollHP; i++){
            this.d10.roll();
            this.hitPoints += d10.getCurrentValue();
        }
        return this.hitPoints;
    }
}
