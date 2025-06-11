class Passenger {
    private String bookingId;
    private String name;
    private int age;
    private int seatBooked;

    public Passenger(String bookingId,String name,int age,int seatbooked){
        this.bookingId=bookingId;
        this.name=name;
        this.age=age;
        this.seatBooked=seatbooked;
    }
    public String getBookingId(){
        return bookingId;
    }
    public int getSeatBooked(){
        return seatBooked;
    }


    public String toString(){
        return "Passenger{bookingId= " + bookingId +  ", name= " + name + ",age= " +  age + ", seatsbooked= " + seatBooked + "}";
    }
}
