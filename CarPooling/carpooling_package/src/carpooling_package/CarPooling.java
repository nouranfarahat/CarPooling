
package carpooling_package;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;


/**
 * Interface.
 * abstract function DisplayInformation to be implemented in other classes.
 */
interface Dispaly{
    // public abstract float Discount();
     public abstract void DispalyInformation();
}
/**
 *Using Factory design pattern.
 * It used to assign the parent to the right child type (Polymorphism).
 */
/*class PassengerFactory
{
    public Passenger createPassenger(int type)
    {
        switch(type)
        {
            case 2:
                return new Subscriber(); //a3ml hna eh?
            default:
                return new Unsubscriber();
        }
    }
}*/

class Passenger
{
    private int ID;
    private static int numberOfPassengers;
    //private Trip trip;
    private Car car;
    private ArrayList<Ticket> ticket;
    
    
    

    public Passenger(int ID) {
        this.ID = ID;
        numberOfPassengers++;
    }

    public Passenger(int ID, Car car) {
        this.ID = ID;
        this.car = car;
    }
    
    
    
   
   /* public void Search(String starLocation , String endLocation)
    {
        
    }*/
    public void Reserve(int carIndex)
    {
       Ticket t=new Ticket(this, carIndex);
        System.out.println(t.TicketPrice());
       //ticket.add(t);
    }
   /* public boolean passengerMode()
    {
        return false;
    }*/
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
 
    
            
}
class Subscriber extends Passenger
{
    private int age;
    private int password;
    private int numberOfTripsDone;
    public Subscriber(int age, int password, int ID) {
        super(ID);
        this.age = age;
        this.password = password;
        numberOfTripsDone=0;
    }
    
    
    
    
}
class Unsubscriber extends Passenger
{
    private int numberOfFreeTrip;

    public Unsubscriber(int ID) {
        super(ID);
        numberOfFreeTrip= 2;
    }
    public int getNumberOfFreeTrip () {
        return numberOfFreeTrip;
    }

    public void setNumberOfFreeTrip(int numberOfFreeTrip) {
        this.numberOfFreeTrip = numberOfFreeTrip;
    }
    
    
}
/*class PassengerFunctionalities
{
    private ArrayList<Route> route;

    public PassengerFunctionalities(ArrayList<Route> route) {
        this.route = route;
    }
    
    
    
    public int Search(String starLocation , String endLocation)
    {
        for(int i=0;i<route.size();i++)
        {
            if((route.get(i).getAssemblyLocation().equals(starLocation))&&(route.get(i).getDestinationLocation().equals(endLocation)))
                return i;
           
        }
        return -1;
    }
}*/
class Package
{
     protected int age;
    /**
     * calculated data member
     */
    protected int No_Of_Trips;
    protected int PackagePrice;

    public Package(int age, int No_Of_Trips, int PackagePrice) {
        this.age = age;
        this.No_Of_Trips = No_Of_Trips;
        this.PackagePrice = PackagePrice;
    }
}

class Car
{
    private int carCode;
    private int numberOfTripsPerDay;
    private Route route;
    private int maxCapacityPerTrip;
    private String driverName;
    private double Trip_Price;

    public Car(int carCode, int numberOfTripsPerDay, int maxCapacityPerTrip, String driverName, Route route, double Trip_Price) {
        this.carCode = carCode;
        this.numberOfTripsPerDay = numberOfTripsPerDay;
        this.route = route;
        this.maxCapacityPerTrip = maxCapacityPerTrip;
        this.driverName = driverName;
        this.Trip_Price = Trip_Price;
    }

    public double getTrip_Price() {
        return Trip_Price;
    }

    public void setTrip_Price(double Trip_Price) {
        this.Trip_Price = Trip_Price;
    }

    public int getCarCode() {
        return carCode;
    }

    public void setCarCode(int carCode) {
        this.carCode = carCode;
    }

    public int getNumberOfTripsPerDay() {
        return numberOfTripsPerDay;
    }

    public void setNumberOfTripsPerDay(int numberOfTripsPerDay) {
        this.numberOfTripsPerDay = numberOfTripsPerDay;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getMaxCapacityPerTrip() {
        return maxCapacityPerTrip;
    }

    public void setMaxCapacityPerTrip(int maxCapacityPerTrip) {
        this.maxCapacityPerTrip = maxCapacityPerTrip;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    
    
}
class Ticket
{
    private double ticketPrice;
    private ArrayList<Car> car;
    private Passenger passenger;
    private final int Taxes=5;
    private int carIndex;
    //private Trip trip;

    public Ticket(Passenger passenger, int carIndex) { //lazm hna adelo arryList kman
        this.passenger = passenger;
        this.carIndex = carIndex;
    }

   

    

    
    
    public double TicketPrice()
    {
        
        if(passenger instanceof Subscriber)
        {
            ticketPrice= car.get(carIndex).getTrip_Price()*((double)50/100)+Taxes;
        }
        else if(passenger instanceof Unsubscriber)
        {
            Unsubscriber un=new Unsubscriber(passenger.getID());//a3ml hna el id ezay
            
        if(un.getNumberOfFreeTrip()>0)
        {
            ticketPrice=car.get(carIndex).getTrip_Price()*((double)50/100)+Taxes;
            un.setNumberOfFreeTrip(un.getNumberOfFreeTrip()-1);
        }
        else
            ticketPrice=car.get(carIndex).getTrip_Price()+Taxes;
        }
         return ticketPrice;
    }
    
    
}
class Route
{
    private String assemblyLocation;
    private String destinationLocation;

    public Route(String assemblyLocation, String destinationLocation) {
        this.assemblyLocation = assemblyLocation;
        this.destinationLocation = destinationLocation;
    }
    
    

    public String getAssemblyLocation() {
        return assemblyLocation;
    }

    public void setAssemblyLocation(String assemblyLocation) {
        this.assemblyLocation = assemblyLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }
 }
class Discount
{
    
}
class Trip
{
    private String review;
    private Car car;
    private ArrayList<Passenger> passengerList;
    
    public void Updates()
    {
        
    }
    
    
}
class InvalidDataException extends Exception
{

    InvalidDataException(String string) {
        super(string);
    
    
}
}
class IntegerCheck
{
    boolean numberOrNot(String input)
{
	try
	{
		Integer.parseInt(input);
	}
	catch(NumberFormatException ex)
	{
		return false;
	}
	return true;
}
}

public class CarPooling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Car> car=new ArrayList<>();
        ArrayList<Route> route=new ArrayList<>();
        Passenger []passengers=new Passenger[1000]; 
        
        Subscriber p=new Subscriber(5, 55, 0);
        Scanner scan =new Scanner(System.in);
        
        Route r1=new Route("AbassAl-akaad", "Al-doki");
        Car c1=new Car(125, 1, 4, "Hassan",r1,25);
        Route r2=new Route("6october", "Al-mokatam");
        Car c2=new Car(245, 2, 0, "Ali",r2,35);
        Route r3=new Route("Al-shrouk", "Ramses");
        Car c3=new Car(789, 1, 2, "Ahmed",r3,15);
        
        route.add(r1);
        route.add(r2);
        route.add(r3);
        
        car.add(c1);
        car.add(c2);
        car.add(c3);
        
        int finalIndex=0;
        
        System.out.println("1 To Search.");
        int choice=scan.nextInt();
        if(choice==1)
        {
            System.out.println("Enter location: ");
            String from=scan.next();
            from.replaceAll(" ","");
            System.out.println("Enter destination: ");
            String to=scan.next();
            to.replaceAll(" ","");
            boolean flag=false;
            int index=0;
            for(int i=0;i<route.size();i++)
            {
                if(((route.get(i).getAssemblyLocation().equals(from))&&(route.get(i).getDestinationLocation().equals(to)))&&(car.get(i).getMaxCapacityPerTrip()>0))
                {
                    index=i;
                    flag=true;
                    break;
                }
                          
            }
            int var=1;
            Vector<Integer> carIndex = new Vector<>(); 
            
            if(flag==true)
            {
                System.out.println("From "+car.get(index).getRoute().getAssemblyLocation() +" to "+car.get(index).getRoute().getDestinationLocation()
                +"\tavailable seats: "+car.get(index).getMaxCapacityPerTrip()+"\tTrip Price: "); //carCode
                carIndex.add(index);
                finalIndex=index;
                
            }
            else
            {
               for(int j=0;j<car.size();j++)
               {
                   
                   if(car.get(j).getMaxCapacityPerTrip()>0)
                   {
                     System.out.println(var+" From "+car.get(j).getRoute().getAssemblyLocation()
                      +" to "+car.get(j).getRoute().getDestinationLocation()+"         available seats: "+car.get(j).getMaxCapacityPerTrip());
                     carIndex.add(var-1, j);
                     var++;
                     
                   }
            }
                System.out.println("Choose your car ");
               int carChoice=scan.nextInt();
               finalIndex=carIndex.get(carChoice-1);
                       
        }
            //System.out.println(carIndex[0]+" "+carIndex[1]);
        
    }
        //p.Reserve(finalIndex);
        
        
        
        
    
}
}
