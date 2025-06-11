import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
      FlightReservation system=new FlightReservation();
      Scanner s1= new Scanner(System.in);
      while(true){
          System.out.println("\n-----FLIGHT RESERVATION SYSTEM-----");
          System.out.println("1.  Book Ticket");
          System.out.println("2.  Cancel Ticket");
          System.out.println("3.  Print Flight Details");
          System.out.println("4.  Exit");
          System.out.println("Enter your choice: ");
          int choice =s1.nextInt();
          s1.nextLine();

          switch(choice){
              case 1: {
                  System.out.println("Enter flight name(Indigo/AirSpace): ");
                  String flightName = s1.nextLine();
                  if (system.flights.containsKey(flightName)) {
                      system.displayFlightDetails(flightName);
                      System.out.println("Enter passenger name: ");
                      String passengerName = s1.nextLine();
                      System.out.println("Enter age: ");
                      int age = s1.nextInt();
                      System.out.println("Enter seats: ");
                      int seats = s1.nextInt();
                      String bookingId = system.bookTickets(flightName, passengerName, age, seats);
                      if (bookingId != null) {
                          System.out.println("Booking successfully.Your Booking Id is: " + bookingId);
                      } else {
                          System.out.println("Invaild flight name");
                      }
                      break;
                  }
              }
              case 2:{
                  System.out.println("Enter flight name(Indigo/AirSpace): ");
                  String flightName = s1.nextLine();
                  System.out.println("Enter booking Id: ");
                  String bookingId=s1.nextLine();
                  system.cancelTicket(flightName,bookingId);
                  break;
              }
              case 3:{
                  System.out.println("Enter flight name(Indigo/AirSpace): ");
                  String flightName = s1.nextLine();
                  system.printFlightDetails(flightName);
                  break;
              }
              case 4:{
                  System.out.println("Exiting.....Thank You! ");
                  exit(0);
              }
              default:
                  System.out.println("Invalid.Try again. ");
          }
      }
    }
}