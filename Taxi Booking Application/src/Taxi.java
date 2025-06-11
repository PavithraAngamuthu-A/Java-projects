import java.util.*;
class Taxi{
    int id;
    char currentPoint='A';
    int totalEarnings=0;
    List<BookingTaxi>bookings=new ArrayList<>();

    public Taxi(int id){
        this.id=id;
    }
    public boolean isAvailable(int resquestTime){
        if(bookings.isEmpty()) return true;
        BookingTaxi lastBooking=bookings.get(bookings.size()-1);
        return lastBooking.dropTime<=resquestTime;
    }
    public int calculateEarnings(char from,char to){
        int distance=Math.abs(to-from)*15;
        return 100+(Math.max(0,distance-5)*10);
    }
    public void addBooking(BookingTaxi booking){
        bookings.add(booking);
        totalEarnings +=booking.amount;
        currentPoint=booking.to;
    }

}