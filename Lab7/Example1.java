
package Lab7;

class Example1{
    int day,month,year;

    Example1(int day,int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    Example1(int yz){
        this(1,1,yz);
    }
    public String toString(){
        String s;
        s=day+"/"+month+"/"+year;
        return s;
    }
    public boolean equals(Example1 other){
        boolean b=false;
        if (day==other.day && month==other.month && year==other.year){
            b=true;
        }
        return b;
    }
    public static void main(String[] args) {
        Example1 y = new Example1(12,3,2024);
        System.out.println(y);
        Example1 z = new Example1(12,3,2024);
        System.out.println(z);
        boolean b = y.equals(z);
        System.out.println("Are the two dates equal? " + b);
        //System.out.println("Are the two dates equal? " + y.equals(y));
        Example1 x = new Example1(2024);
        System.out.println(x);

       
    }
}