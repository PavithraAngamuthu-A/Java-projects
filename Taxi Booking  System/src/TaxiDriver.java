import java.util.*;
public class TaxiDriver {
    static class Driver{
        String name;
        long phone;

        Driver(String name,long phone){
            this.name=name;
            this.phone=phone;
        }
    }
    public static void driverDetails() {
        Scanner s1 = new Scanner(System.in);
        Map<String, Driver> driver = new LinkedHashMap<>();
        driver.put("taxi 1", new Driver("Ramesh", 9943799100L));
        driver.put("taxi 2", new Driver("Karthik", 8809916720L));
        driver.put("taxi 3", new Driver("Ganesh", 9975846123L));
        driver.put("taxi 4", new Driver("Ram", 6375499011L));

        for (String taxiId : driver.keySet()) {
            Driver d = driver.get(taxiId);
            System.out.println(taxiId + " Driver Name: " + d.name + " , Phn no: " + d.phone);
        }
        System.out.print("Enter taxi Id (e.g., taxi 1): ");
        String input = s1.nextLine().toLowerCase();

        if (driver.containsKey(input)) {
            Driver d = driver.get(input);
            System.out.println("Driver Name: " + d.name);
            System.out.println("Phone no: " + d.phone);
        } else {
            System.out.println("Invalid taxi ID entered.");
        }
    }
}
