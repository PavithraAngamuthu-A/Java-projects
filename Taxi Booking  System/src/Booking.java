public class Booking {
    int bookingId,customerId,pickUpTime,dropTime,amount;
    char from,to;
    public Booking(int bookingId,int customerId,char from,char to,int pickUpTime,int dropTime,int amount){
        this.bookingId=bookingId;
        this.customerId=customerId;
        this.from=from;
        this.to=to;
        this.pickUpTime=pickUpTime;
        this.dropTime=dropTime;
        this.amount=amount;

    }
}
