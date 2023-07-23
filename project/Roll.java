package project;
import java.util.Random;

public class Roll {

    private class RandomRoll {
        Random rand = new Random();
        int max;
        int number;

        public RandomRoll(int max, int number) {
            this.max = max;
            this.number = number;
        }

        public int getRoll() {
            return this.number * (this.rand.nextInt(this.max)+1);
        }
    }

    RandomRoll my_roll;
    Dice type;

    public Roll(Dice type, int number) {
        int max = type.getValue();
        this.my_roll = new RandomRoll(max, number);
    }

    public int useRoll() {
        return my_roll.getRoll();
    }
    
}
