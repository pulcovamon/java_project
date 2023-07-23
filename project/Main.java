package project;

public class Main {
    
    public static void main(String[] args) {
        Monster snake = new Monster(
                                    "Snake",
                                    50,
                                    5,
                                    Dice.D8, 
                                    2,
                                    4
                                    );

        for (int i = 0; i < 3; i++) {
            if (snake.attack(15)) {
                snake.dealDamage();
            }
        }
    }
}
