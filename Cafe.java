/* This is a stub for the Cafe class */
/**
 * subclass that creates cafes, sells coffee from a given cafe, and restocks a given cafe
 */
public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 20;
        this.nSugarPackets = 20;
        this.nCreams = 20;
        this.nCups = 20;
    }

    /**
     * sells coffee by removing the amount of ounces of coffee, number of sugar packets, and number of creams in the ordered cup from the inventory
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces - size > 0) {
            this.nCoffeeOunces -= size;
        } else {
            restock(20, 20, 20, 20);
            this.nCoffeeOunces -= size;
        }
        if (this.nSugarPackets - nSugarPackets > 0) {
            this.nSugarPackets -= nSugarPackets;
        } else {
            restock(20, 20, 20, 20);
            this.nSugarPackets -= nSugarPackets;
        }
        if (this.nCreams - nCreams > 0) {
            this.nCreams -= nCreams;
        } else {
            restock(20, 20, 20, 20);
            this.nCreams -= nCreams;
        }
        if (this.nCups - 1 > 0){
            this.nCups -= 1;
        } else{
            restock(20, 20, 20, 20);
            this.nCups -= 1;
        }
    }
    
    /**
     * restocks ounces of coffee, sugar packets, creams, and cups back to 20 each whenever one runs out
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = 20;
        this.nSugarPackets = 20;
        this.nCreams = 20;
        this.nCups = 20;
        System.out.println("You have just restocked the cafe!");
    } 

    /**
     * prints out info on a given cafe including, name, address, number of floors, and how much of each material is currently in stock.
     */
    public String toString(){
        String description3 = super.toString();
        description3 += " There are currently " + this.nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets 
        + " sugar packets, " + this.nCreams + " creams, and " + this.nCups + " cups in stock at this coffee.";
        return description3;
    }
    
    /**
     * main method of class that creates cafes and calls other class methods
     * @param args
     */
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "7 Neilson Drive", 2);
        System.out.println(compass);
        compass.sellCoffee(12, 1, 2);
        compass.sellCoffee(10, 0, 1);
        System.out.println(compass);
    }
    
}
