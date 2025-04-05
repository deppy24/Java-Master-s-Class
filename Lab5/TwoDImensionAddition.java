package Lab5;

public class TwoDImensionAddition {
    public static void main(String[] args) {
        int[][] a = new int[][]{{5, 10, 15}, {20, 25, 30}, {35, 40, 45}};
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The sum of the array is: " + sum);
    }
}
