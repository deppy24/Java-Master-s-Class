package Lab3;

public class GameTalk {
    public static void main(String[] args) {
        CyclopeTalk cyclope1 = new CyclopeTalk();
        cyclope1.name = "John";
        CyclopeTalk.say("-Hello, i am "+ cyclope1.name);

        CyclopeTalk cyclope2 = new CyclopeTalk();
        cyclope2.name = "Mary";
        CyclopeTalk.say("-Hello, i am "+ cyclope2.name);
    }
}
