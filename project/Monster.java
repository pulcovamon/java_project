package project;

public class Monster {
    public String name;
    public int current_hp;
    private boolean living = true;
    private int attack_bonus;
    Roll attack_roll = new Roll(Dice.D20, 1);
    Roll damage_roll;
    private int damage_bonus;
    private boolean critical = false;

    public Monster(
                    String name,
                    int max_hp,
                    int attack_bonus,
                    Dice damage_dice,
                    int number_of_dice,
                    int damage_bonus
                    ) {
        this.name = name;
        this.current_hp = max_hp;
        this.attack_bonus = attack_bonus;
        this.damage_roll = new Roll(damage_dice, number_of_dice);
        this.damage_bonus = damage_bonus;
    }

    public void getDamage(int minus_hp) {
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
        int amount = current_roll + this.attack_bonus;

        if (current_roll == 20) {
            this.critical = true;
            System.out.println("Critical success! " + current_roll + "+" + this.attack_bonus);
            return true;
        } else if (amount > target_ac) {
            System.out.println("Success! " + current_roll + "+" + this.attack_bonus);
            return true;
        } else {
            System.out.println("Failure! " + current_roll + "+" + this.attack_bonus);
            return false;
        }
    }

    public int dealDamage() {
        int amount;
        if (this.critical) {
            amount = this.damage_bonus;
            for (int i = 0; i < 2; i++) {
                amount += this.damage_roll.useRoll();
            }
            this.critical = false;
        } else {
            amount =  this.damage_roll.useRoll() + this.damage_bonus;
        }
        System.out.println("Dealing " + amount + " damage");
        return amount;
    }
}
