class Bus {
    private int busNo;
    private boolean ac;
    private static int capacity;

    public Bus(int busNo,boolean ac,int cap){
        this.busNo=busNo;
        this.ac=ac;
        this.capacity=cap;
    }
    public static int getCapacity(){
        return capacity;
    }
    public void setCapacity(int cap){
        capacity=cap;
    }
    public boolean isAc(){
        return ac;
    }
    public void  setAc(boolean val){
        ac=val;
    }
    public int getBusNo(){
        return busNo;
    }
    public void displayInfo(){
        System.out.println("Bus No: " + busNo + " Ac: " + ac + " Total Capacity : "+ capacity );
    }

}
