package project;

public class Monster {
    public String name;
    public int current_hp;
    private boolean living = true;
    Roll attack_roll = new Roll(Dice.D20, 1);
    Roll damage_roll;

    public Monster(String name, int max_hp, Dice damage_dice, int number_of_dice) {
        this.name = name;
        this.current_hp = max_hp;
        this.damage_roll = new Roll(damage_dice, number_of_dice);
    }

    public void demage(int minus_hp) {
        this.current_hp -= minus_hp;

        if (this.current_hp <= 0) {
            this.living = false;
            this.current_hp = 0;
        }
    }

    public boolean isLiving() {
        return this.living;
    }

    public boolean attack(int target_ac) {
        int current_roll = this.attack_roll.useRoll();

        if (current_roll > target_ac) {
            System.out.println("Success");
            return true;
        } else {
            System.out.println("Failure");
            return false;
        }
    }

    public int damage() {
        int amount =  this.damage_roll.useRoll();
        System.out.println(amount);
        return amount;
    }
}
