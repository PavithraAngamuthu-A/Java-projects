import java.util.ArrayList;
import java.util.List;

public class Taxi {
    int id;
    char currentPoint='A';int totalEarnings=0;
    List<Booking>bookings= new ArrayList<Booking>();


    public Taxi(int id){
        this.id=id;
    }
    public boolean isavailable(int pickUpTime){
        if(bookings.isEmpty()) return true;
        Booking lastBooking=bookings.get(bookings.size()-1);
        return lastBooking.dropTime<=pickUpTime;
    }
    public static int calculateEarnings(int from,int to){
        int distance=Math.abs(from-to)*15;
        return 100+(Math.max(0,distance-5)*10);
    }
    public void addBooking(Booking booking){
        bookings.add(booking);
        totalEarnings +=booking.amount;
        currentPoint=booking.to;
    }

    public boolean check(int deleteId) {
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            if (booking.customerId == deleteId) {
                totalEarnings-=booking.amount;
                bookings.remove(i);  // Remove by index
                return true;
            }
        }
        return false;
    }

}
