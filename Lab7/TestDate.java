package Lab7;

public class TestDate {
    public static void main(String[] args) {
        DateMutator x = new DateMutator(1, 2, 2023);
        x.setDay(15);
        x.setMonth(15);
        x.setYear(2025);
        System.out.println("The date is: " + x.getDay() + "/" + x.getMonth() + "/" + x.getYear());
    }
}
