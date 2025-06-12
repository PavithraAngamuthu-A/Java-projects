import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner s1=new Scanner(System.in);
        System.out.println("-----RAILWAY RESERVATION SYSTEM-----");
        while(true){
            Railway.displaySeats();
            System.out.println("1.book Tickets \n2. Cancel Tickets \n3. Booked Tickets \n4.Available Tickets \n5.Exit");
            System.out.println("Enter your choice: ");
            int choice=s1.nextInt();
            switch(choice){
                case 1:{
                    System.out.print("Enter Name: ");
                    String name = s1.next();
                    System.out.print("Enter Age: ");
                    int age = s1.nextInt();
                    System.out.print("Enter Gender: ");
                    String gender = s1.next();
                    System.out.println("Enter Berth Preference(lower/middle/upper): ");
                    String berth=s1.next();
                    Railway.bookTicket(name, age, gender,berth);
                    break;
                }
                case 2:{
                    System.out.println("Enter ticket Id: ");
                    String delTicketId=s1.next();
                    Railway.cancelTicket(delTicketId);break;
                }
                case 3:{
                    Railway.printBookedTickets();break;
                }
                case 4:{
                    Railway.printAvailableTickets();break;
                }
                case 5:{
                    System.out.println("Exiting....Thank You!");
                    exit(0);
                }
                default:{
                    System.out.println("Invalid.Try again");
                }
            }
        }
    }
}