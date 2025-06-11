import java.util.*;

class Flight {
    private String flightName;
    private int availableSeats;
    private int ticketPrice;
    private Map<String,Passenger>bookings;
    private int bookingCount;

    public Flight(String flightName){
        this.flightName=flightName;
        this.availableSeats=50;
        this.ticketPrice=5000;
        this.bookings=new HashMap<>();
        this. bookingCount=0;
    }
    public String bookTickets(String passengerName,int age,int seats){
        if(seats<=availableSeats){
            bookingCount++;
            String bookingId="T"+bookingCount;
            Passenger passenger=new Passenger(bookingId,passengerName,age,seats);
            bookings.put(bookingId,passenger);
            availableSeats-=seats;
            ticketPrice+=200*seats;
            return bookingId;
        }
        else {
            System.out.println("Booking failed.Seats are not available");return null;
        }
    }
    public boolean cancelBooking(String bookingId){
        Passenger passenger = bookings.get(bookingId);
        if(passenger!=null){
            int seats= passenger.getSeatBooked();
            availableSeats+=seats;
            ticketPrice-=200*seats;
            bookings.remove(bookingId);
            System.out.println("Booking canceled");
            return true;
        }
        else{
            System.out.println("No booking Id available");
            return false;
        }
    }
    public void displayDetails(){
        System.out.println("Flight: " + flightName);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Ticket Price: " + ticketPrice);
    }
    public void printDetails(){
        System.out.println("Flight: " + flightName);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Ticket Price: " + ticketPrice);
        System.out.println("Passengers: ");
        for(Passenger passenger: bookings.values()){
            System.out.println(passenger);
        }
    }
}
