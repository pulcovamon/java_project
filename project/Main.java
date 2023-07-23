package project;

public class Main {
    
    public static void main(String[] args) {
        Monster snake = new Monster("Snake", 50, Dice.D8, 2);

        for (int i = 0; i < 3; i++) {
            if (snake.attack(15)) {
                snake.damage();
            }
        }
    }

}
