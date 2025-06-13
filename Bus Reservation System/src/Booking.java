import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
class Booking {
    String passengerName;
    int busNo;
    Date date;
    Booking(){
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter Passenger Name:");
        passengerName=s1.nextLine();
        System.out.println("Enter Bus No: ");
        busNo=s1.nextInt();
        System.out.println("Enter Date(dd-mm-yyyy): ");
        String dateIn=s1.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yy");
        try{
            date=dateFormat.parse(dateIn);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity=0;
        for(Bus bus : buses){
            if (bus.getBusNo() == busNo) {
                capacity = Bus.getCapacity();
            }
        }
        int booked=0;
        for(Booking b: bookings){
            if(b.busNo==busNo && b.date.equals(date)){
                booked++;
            }
        }
        return booked < capacity ?true:false;
    }
}
