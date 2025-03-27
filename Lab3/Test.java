package Lab3;

public class Test {
    //Function
    double f(double x, double y){
        double value = 0;
        value = 2 * x + 4 * y;
        return value;
    }

    public static void main(String[] args) {
        Test object  = new Test();

        double output = object.f(1, 2);
        System.out.println("f = "+output);
    }


}
