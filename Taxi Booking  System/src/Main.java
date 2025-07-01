import java.util.*;
import static java.lang.System.exit;
public class Main {
    static List<Taxi> taxis = new ArrayList<>();
    static Scanner s1 = new Scanner(System.in);
    static int customerCount = 1;

    public static void main(String[] args) {
        System.out.println("Enter num of taxi: ");
        int n = s1.nextInt();
        intializeTaxi(n);
        while (true) {
            System.out.println("Enter 1.Booking Taxi\n2.Cancel Booking\n3.Print Details\n4.Driver details\n5.exit");
            int choice = s1.nextInt();
            switch (choice) {
                case 1: {
                    bookTaxi();
                    break;
                }
                case 2: {
                    cancelTaxi();
                    break;
                }
                case 3: {
                    printDetails();
                    break;
                }
                case 4: {
                    TaxiDriver.driverDetails();
                    break;
                }
                case 5: {
                    System.out.println("Thank You");
                    exit(0);
                }
                default:
                    System.out.println("Invalid Try again");
            }
        }
    }

    public static void intializeTaxi(int n) {
        for (int i = 0; i < n; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public static void bookTaxi() {
        int customerId = customerCount++;
        System.out.println("Enter Pickup point: ");
        char pickUp = s1.next().toUpperCase().charAt(0);
        System.out.println("Enter drop point: ");
        char drop = s1.next().toUpperCase().charAt(0);
        System.out.println("Enter pickup time: ");
        int pickUpTime = s1.nextInt();
        Taxi selectedTaxi = null;
        int miniDistance = Integer.MAX_VALUE;
        for (Taxi taxi : taxis) {
            if (taxi.isavailable(pickUpTime)) {
                int distance = Math.abs(taxi.currentPoint - pickUp);
                if (distance < miniDistance || distance == miniDistance && taxi.totalEarnings < selectedTaxi.totalEarnings) {
                    selectedTaxi = taxi;
                    miniDistance = distance;
                }
            }
        }
        if (selectedTaxi == null) {
            System.out.println("Booking are full,try after fer hours");
            return;
        }
        int dropTime = pickUpTime + Math.abs(drop - pickUp);
        int amount = selectedTaxi.calculateEarnings(pickUp, drop);
        int bookingId = selectedTaxi.bookings.size() + 1;

        Booking bookings = new Booking(bookingId, customerId, pickUp, drop, pickUpTime, dropTime, amount);
        selectedTaxi.addBooking(bookings);
        System.out.println("Taxi " + (selectedTaxi.id + 1) + " is booked" + "Your Id is " + customerId);

    }

    public static void cancelTaxi() {
        System.out.println("Enter customer Id: ");
        boolean found = false;
        int deleteId = s1.nextInt();
        for (Taxi taxi : taxis) {
            if (taxi.check(deleteId)) {
                System.out.println("Your booking is canceled");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Invalid customerId. try again");
        }
    }/*public boolean check(int deleteId) {
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.customerId == deleteId) {
                iterator.remove();  // Safe removal
                return true;
            }
        }
        return false;
    }*/

    public static void printDetails() {
        for (Taxi taxi : taxis) {
            if (taxi.bookings.isEmpty()) {
                continue;
            }
            System.out.println("Taxi " + (taxi.id + 1) + " Total Earnings: Rs. " + taxi.totalEarnings + "\n");
            System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s%n", "BookingId", "CustomerId", "From", "To", "Pick Up Time", "Drop Time", "Amount");
            for (Booking booking : taxi.bookings) {
                System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s%n", booking.bookingId, booking.customerId, booking.from, booking.to, booking.pickUpTime, booking.dropTime, booking.amount);
            }
            System.out.println();
        }
    }
}


