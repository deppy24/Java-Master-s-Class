package Lab3;

public class CyclopeTalk {
    String name;
    int height;

    static int numberOfEyes=1;

    void shoot(int angle){
        System.out.println("I am"+" "+ name + " and i shoot at" +" "+ angle + " degrees");
    }

    static void whatAmI(){
        System.out.println("I am a human");
    }
    
    static void say(String message){
        System.out.println(message);
    }
}
