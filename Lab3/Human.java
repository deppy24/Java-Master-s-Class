package Lab3;
public class Human {
    String name;
    int height;

    static int numberOfEyes;

    void shoot(int angle){
        System.out.println("I am"+" "+ name + " and i shoot at" +" "+ angle + " degrees");
    }

    static void whatAmI(){
        System.out.println("I am a human");
    }
    
}
