package Lab7;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time(int hour) {
        this(hour, 0, 0);
    }
  public String toString(){
        String s;
        s = hour + ":" + minute + ":" + second;
        return s;
    }
    public void setHour(int hour) {
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        } else {
            System.out.println("Invalid hour. Must be between 0 and 23.");
        }
    }
    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        } else {
            System.out.println("Invalid minute. Must be between 0 and 59.");
        }
    }
    public void setSecond(int second) {
        if (second >= 0 && second < 60) {
            this.second = second;
        } else {
            System.out.println("Invalid second. Must be between 0 and 59.");
        }
    }
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public int getSecond() {
        return second;
    }
    public boolean equals(Time other) {
        return (hour == other.hour && minute == other.minute && second == other.second);
    }

    public static void main(String[] args) {
        Time t1 = new Time(12, 30, 45);
        System.out.println(t1);
        Time t3 = new Time(12);
        System.out.println(t3);
        t3.setMinute(400);// Invalid minute
        Time t2 = new Time(12, 30, 47);
        System.out.println(t2);
        boolean b = t1.equals(t2);
        System.out.println("Are the two times equal? " + b);
  }
}
