import java.util.*;
public class TaxiBooking {
    static List<Taxi>taxis=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    static  int customerCount=1;
    public static void main(String[]args){
        System.out.println("Enter number of taxis: ");
        int numTaxi=sc.nextInt();
        initializeTaxis(numTaxi);
        while(true){
            System.out.println("\n1.BookingTaxi\n2.Display Taxi Details\n3.Exit");
            System.out.println("Enter the choice: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    bookTaxi();break;
                case 2:
                    displayTaxiDetails();
                    break;
                case 3:
                    System.out.println("Exiting.....");
                    return;
                default:
                    System.out.println("Invalid....    Try again");
            }
        }
    }
    public static void initializeTaxis(int n){
        for(int i=0;i<n;i++){
            taxis.add(new Taxi(i));
        }
    }
    public static void bookTaxi(){
        int customerId=customerCount++;
        System.out.println("Enter the Pickup Point (A - F): ");
        char pickup=sc.next().toUpperCase().charAt(0);
        System.out.println("Enter the Drop Point (A - F): ");
        char drop=sc.next().toUpperCase().charAt(0);
        System.out.println("Enter Pickup Time(in hours): ");
        int pickupTime=sc.nextInt();

        Taxi selectedTaxi=null;
        int miniDistance=Integer.MAX_VALUE;
        for(Taxi taxi:taxis) {
            if (taxi.isAvailable(pickupTime)) {
                int distance = Math.abs(taxi.currentPoint - pickup);
                if (distance < miniDistance || (distance == miniDistance && taxi.totalEarnings < selectedTaxi.totalEarnings)) {
                    selectedTaxi = taxi;
                    miniDistance = distance;
                }
            }
        }
            if(selectedTaxi==null){
                System.out.println("Booking is rejected. No taxi is available");return;
            }
            int dropTime=pickupTime+Math.abs(drop-pickup);
            int amount=selectedTaxi.calculateEarnings(pickup,drop);
            int bookingId= selectedTaxi.bookings.size()+1;

            BookingTaxi booking=new BookingTaxi(bookingId,customerId,pickup,drop,pickupTime,dropTime,amount);
            selectedTaxi.addBooking(booking);
            System.out.println("Taxi "+ selectedTaxi.id+" is allocated");

    }
    public static void displayTaxiDetails(){
        for(Taxi taxi:taxis){
            System.out.println("Taxi "+ taxi.id +" Total Earnings: Rs. " + taxi.totalEarnings);
            System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s%n","BookingID","CustomerID","From","To","PickupTime","DropTime","Amount");
            for(BookingTaxi booking :taxi.bookings){
                System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s%n",booking.bookingId,booking.customerId,booking.from,booking.to,booking.pickupTime,booking.dropTime,booking.amount);
            }

        }
    }

}
