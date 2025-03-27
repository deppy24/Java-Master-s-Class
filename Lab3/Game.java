package Lab3;

public class Game {
    public static void main(String[] args) {
        Human human1;
        human1 = new Human();
        human1.name = "John";
        human1.height = 7;

        Human human2 = new Human();
        human2.name = "Mary";
        human2.height = 10;

        Ufo ufol = new Ufo();
        ufol.color = "red";
        ufol.size = 10;
        
        Ufo ufo2 = new Ufo();
        ufo2.color = "blue";
        ufo2.size = 20;

        human1.shoot(40);
        Human.whatAmI();
    }
}
