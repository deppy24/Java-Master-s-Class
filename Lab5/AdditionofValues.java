package Lab5;

public class AdditionofValues {
    public static void main(String[] args) {
        int[] a = new int[]{5, 10, 15, 20, 25};
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("The sum of the array is: " + sum);
    }
}
