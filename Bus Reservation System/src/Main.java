import java.util.*;
import static java.lang.System.exit;
public class Main {
    public static void main(String[] args) {
        ArrayList<Bus>buses=new ArrayList<Bus>();
        ArrayList<Booking>bookings=new ArrayList<Booking>();
        buses.add(new Bus(1,true,2));
        buses.add(new Bus(2,false,1));
        buses.add(new Bus(3,true,1));

        Scanner s1=new Scanner(System.in);
        for(Bus b: buses){
            b.displayInfo();
        }
        while(true){
            System.out.println("1.Booking seats\n2.Exit");
            System.out.println("Enter your choice: ");
            int choice=s1.nextInt();
            switch(choice){
                case 1:{
                    Booking b=new Booking();
                    if(b.isAvailable(bookings,buses)){
                        bookings.add(b);
                        System.out.println("Your booking is confrimed");
                    }
                    else{
                        System.out.println("Bus is full.Try another bus or date");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Exting....Thank You");exit(0);
                }
            }
        }
    }
}