public class Indexes {
    public static void main(String[] args) {
        int j=1;
        for (int i=5; j<=10; j++) {
            int Result1= i+j;
            double Result2= (double)i/j;
            int Result3= i%j;
            System.out.println(i + "+" + j + "=" + Result1 + " " + i + "/" + j + "=" + String.format("%.2f", Result2) + " " + i + "%" + j + "=" + Result3);
        }
    }

   
}
