package Lab3;

public class Askisi8 {
    public static void main(String[] args) {
        String s="123";	//String to int
        int i=Integer.parseInt(s);
        //System.out.println(i*1000);
        if (Integer.MAX_VALUE/1000 > i) {
            System.out.println("Mikroteri");
        } else {
            System.out.println("Megalyteri");
        }
    }
}
