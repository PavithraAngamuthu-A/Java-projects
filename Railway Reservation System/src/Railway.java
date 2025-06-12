import java.util.*;
import java.util.stream.Stream;

public class Railway {
    static int totalSeats=3,totalRac=1,totalWait=1,confrimedSeats=3;
    static int upper=1;
    static int lower=1;
    static int middle=1;
    static int rac=1;
    static int wait=1;
    static int ticketCount=1;
    static List<Passenger>bookedList=new ArrayList<>();
    static Queue<Passenger>racList=new LinkedList<>();
    static Queue<Passenger>waitingList=new LinkedList<>();
    static Passenger passenger;
    public static void  bookTicket(String name,int age,String gender,String berth){
        String ticketId="T"+ticketCount++;
        Scanner s1=new Scanner(System.in);
        int n=0,m=1;
        while(n<m) {
            if (bookedList.size() < confrimedSeats) {
                if (berth.equalsIgnoreCase("upper")) {
                    if (upper != 0) {
                        upper--;
                        Passenger p = new Passenger(name, age, gender, berth, ticketId);
                        bookedList.add(p);
                        totalSeats--;
                        n=1;
                        System.out.println("Ticket Booked successfully. Seat No: " + p.ticketId);
                    } else {
                        System.out.println("There is no seats in upper.\nEnter another berth: ");
                        berth = s1.next();
                        n = 0;
                    }
                }
                if (berth.equalsIgnoreCase("middle")) {
                    if (middle != 0) {
                        middle--;
                        Passenger p = new Passenger(name, age, gender, berth, ticketId);
                        bookedList.add(p);
                        totalSeats--;
                        n=1;
                        System.out.println("Ticket Booked successfully. Seat No: " + p.ticketId);
                    } else {
                        System.out.println("There is no seats in middle.\nEnter another berth: ");
                        berth = s1.next();
                        n = 0;
                    }
                }
                if (berth.equalsIgnoreCase("lower")) {
                    if (lower != 0) {
                        lower--;
                        Passenger p = new Passenger(name, age, gender, berth, ticketId);
                        bookedList.add(p);totalSeats--;
                        n=1;
                        System.out.println("Ticket Booked successfully. Seat No: " + p.ticketId);
                    } else {
                        System.out.println("There is no seats in lower.\nEnter another berth: ");
                        berth = s1.next();
                        n = 0;
                    }
                }
            }
            else if (racList.size() < totalRac) {
                System.out.println("RAC seats only available.\nReady to book Enter 1: ");
                int ready=s1.nextInt();
                if(ready==1){
                    rac--;
                    Passenger p=new Passenger(name,age,gender,berth,ticketId);
                    racList.add(p);
                    System.out.println("Ticket Booked successfully in RAC. Seat No: "+ p.ticketId);break;
                }
            }
            else if (waitingList.size() < totalWait) {
                System.out.println("There are no seats available.\nEnter 1 to add waiting list: ");
                ticketId="W"+ticketCount;
                int ready=s1.nextInt();
                if(ready==1){
                    wait--;
                    Passenger p=new Passenger(name,age,gender,berth,ticketId);
                    waitingList.add(p);
                    System.out.println("Your are in waiting list");break;
                }
            }
            else{
                System.out.println("\nThere are no seats available.");break;
            }
        }
    }
    public static void displaySeats(){
        System.out.println("\n\n-----Available Seats-----");
        System.out.println();
        System.out.println("Available Seat in Lower Berth: " + lower);
        System.out.println("Available Seat in Middle Berth: " + middle);
        System.out.println("Available Seat in Upper Berth: " + upper);
        System.out.println("Available Seat in RAC Berth: " + rac);
        System.out.println("Waiting List: " + wait);
    }
    public static void cancelTicket(String ticketId){
        if(bookedList.isEmpty()){
            System.out.println("No Tickets to cancel.Seats are available.");return;
        }
        Optional<Passenger> passengerOpt = bookedList.stream().filter(p -> p.ticketId.equals(ticketId)).findFirst();
        if(passengerOpt.isPresent()){
            Passenger p = passengerOpt.get();
            bookedList.remove(p);
            System.out.println(ticketId + " ticket cancelled successfully.");

            if(!racList.isEmpty()) {
                Passenger racPassenger = racList.poll();
                bookedList.add(racPassenger);
                rac++;
                System.out.println("RAC passenger moved to confirmed\n" + racPassenger);

                if(!waitingList.isEmpty()) {
                    Passenger waitPassenger = waitingList.poll();
                    racList.add(waitPassenger);
                    wait++;rac--;
                    System.out.println("Waiting list passenger moved to RAC\n" + waitPassenger);
                }
            } else {
                totalSeats++;
            }
        } else {
            System.out.println("No ticket id available");
        }
    }
    public static void printBookedTickets(){
        if(bookedList.isEmpty()) System.out.println("No booked tickets");
        else{
            System.out.println("\n-----Confrimed Booked Tickets----- ");
            System.out.println();
            for(Passenger passenger : bookedList){
                System.out.println(passenger);
            }
            System.out.println("\n-----RAC-----");
            for(Passenger passenger : racList){
                System.out.println(passenger);
            }
            System.out.println("\n-----Waiting List-----");
            for(Passenger passenger : waitingList){
                System.out.println(passenger);
            }
        }
    }
    public static void printAvailableTickets(){
        System.out.println("\n-----Available Tickets----- ");
        System.out.println("Available Seats: " + totalSeats);
        System.out.println("Available RAC Seats: " + rac);
        System.out.println("Available Waiting List Seats: "+ wait);
    }

}




