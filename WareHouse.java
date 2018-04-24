package project3gui;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Miles Spence
 */
public class WareHouse implements Serializable{
   public ArrayList<BikePart> whDB;
   public String name;
   private String filename;
   /**
    * 
    * @param name name of the warehouse
    */
   public WareHouse(String name, String filename) {
      this.name = name;
      this.filename = filename;
      this.whDB = new ArrayList<>();
   }
   
   public WareHouse(String name, ArrayList<BikePart> whDB) {
       this.name = name;
   }
   
/**
 * 
 * @return returns the arraylist warehouse has
 */
   public ArrayList<BikePart> getAL() {
       return whDB;
   }
   
   public void addBikePart(BikePart bp) {
       whDB.add(bp);
   }
   
   public BikePart findByName(String name) {
       for(BikePart bp: whDB) {
           if (bp.getName().equals(name)) {
               return bp;
           }
       }
       return null;
   }
   
   public String getWareHouseName(){
       return name;
   }
   
}
