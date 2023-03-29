/* This is a stub for the House class */
import java.util.ArrayList; 

/**
 * subclass that creates house-type buildings where people are allowed to move in and out of
 */
public class House extends Building{

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  
  
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }
/**
 * Accessor for hasDiningRoom
 * @return whether or not the house has a dining room (true/false)
 */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Accessor for nResidents
   * @return number of residents in house
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * method for moving in someone into a given house after checking they don't already live there
   * @param name
   */
  public void moveIn(String name) {
    // check if this.residents contains name
    // if so: throw exception
    // append name to this.residents
    if (this.residents.contains(name)) {
      throw new RuntimeException(name + " is already a resident of this house.");
    }
    // if we're good to go, add to roster
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + ". Go say hello!");
  }

  /**
   * method for moving out someone from a given house after checking they are currently living there
   * @param name
   * @return name of a person who has moved out of the house
   */
  public String moveOut(String name) {
    //check if this.residents contains name
    // if not throw exception
    // if so: remove name from this.residents
    if (this.residents.contains(name)) {
      this.residents.remove(name);
      System.out.println(name + " has just moved out of " + this.name + ".");
      return name;
    } else {
      throw new RuntimeException(name + " is not a resident of this house.");
    }
  }

  /**
   * Checks list of residents of a house to see if a person lives there
   * @param person
   * @return true if a resident is a resident of a given house
   */
  public boolean isResident(String person) {
    if (this.residents.contains(person)) {
      System.out.println(person + " is a resident of this house.");
    } else {
      System.out.println(person + " is not a resident of this house.");
    }
    return this.residents.contains(person);
  }

  /**
   * prints out a description of the house including name, address, number of floors, how many people live there, and if the house hs a dining room
   */
  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.residents.size() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += " does not have";
    }
    description += " an active dining room.";
    return description;
  }
  
  /**
   * main method that forms houses and calls other methods in class
   * @param args
   */
  public static void main(String[] args) {
    House morrow = new House("Morrow", "The Quad", 4, false);
    morrow.moveIn("Jordan");
    morrow.moveIn("Julia");
    System.out.println(morrow);
    morrow.moveOut("Jordan");
    House king = new House("King", "The Quad", 3, true);
    System.out.println(morrow);
    System.out.println(king);
    morrow.isResident("Jordan");
    morrow.isResident("Julia");

  }

}