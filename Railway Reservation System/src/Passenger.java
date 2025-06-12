class Passenger {
    String name;
    int age;
    String gender;
    String berth;
    String ticketId;

    public Passenger(String name, int age, String gender, String berth, String ticketId){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.berth=berth;
        this.ticketId=ticketId;
    }

    public String toString(){
        return "Ticket Id: " + ticketId+ "Name: " + name + ", Age: " + age +", Gender: " + gender + ",Berth: " + berth;
    }

    public String get(String ticketId) {
        return ticketId;
    }

}
