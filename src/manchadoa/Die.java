package manchadoa;

import java.util.Random;

public class Die {
    private int numSides;
    private int currentValue;
    private Random generator = new Random();
    public Die(int numSides){
        final int automaticAdjust = 6;
        if (numSides >=2 && numSides<=100) {
            this.numSides = numSides;
            roll();
        } else {
            this.numSides = automaticAdjust;
            roll();
        }
    }

    public int getCurrentValue() {
        return this.currentValue;
    }
    public void roll(){
        this.currentValue = generator.nextInt(numSides)+1; //
    }
}
