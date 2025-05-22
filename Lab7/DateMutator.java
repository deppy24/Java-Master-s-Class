package Lab7;

public class DateMutator {
    private int day=1;
    private int month=1;
    private int year=2000;

    public DateMutator(int d, int m, int y) {
        setDate(d, m, y);
    }

    public DateMutator(int y){
        this(1,1,y);
    }
    public void setDay(int d){
        if(d>0 && d<=31){
            day=d;
        }
    }

    public void setMonth(int m){
        if(m>0 && m<=12){
            month=m;
        }
    }
    public void setYear(int y){
        if (y>0 && y<3000){
            year=y;
        }
    }
    public void setDate(int d, int m, int y){
        setDay(d);
        setMonth(m);
        setYear(y);

    }

    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
}

