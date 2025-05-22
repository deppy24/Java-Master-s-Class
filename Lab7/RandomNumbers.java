package Lab7;

public class RandomNumbers {
    private void giveRnadom(int []table){
        for (int i = 0; i < table.length; i++) {
            table[i] = (int) (Math.random() * 100); // Random value between 0 and 100
        }
    }
    private void printTable(int []table){
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []table = new int[20];
        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.giveRnadom(table);
        randomNumbers.printTable(table);
    }
}
