package gui;

import java.io.Serializable;

/**
 * 
 *  BikePart is a class that contains information on bicycle parts
 *  and can store the information in an array, and print it. 
 *  @author Miles Spence 
 */
public class BikePart implements Serializable {
    /**
     * 
     * partName      The name of the part.
     * partNum       The (ten digit) number associated with the part.
     * listPrice     The price of the part when not on sale.
     * salesPrice    The price of the part when on sale.
     * onSale        Signifies if the part is on sale or not.
     * quantity      The number of bikeparts.
     */
   private String partName;
   private int partNum;
   private double listPrice;
   private double salesPrice;
   private boolean onSale;
   private int quantity;
   /**
    * default constructor
    */
   public BikePart() {
   
   }
   
    /**
     * 
     * constructor BikePart     This is where the information is stored.
     * @param partName
     * @param partNum
     * @param listPrice
     * @param salesPrice
     * @param onSale
     * @param quantity
     */
   public BikePart(String partName, int partNum, double listPrice, double salesPrice, boolean onSale, int quantity) {
      this.partName = partName;
      this.partNum = partNum;
      this.listPrice = listPrice;
      this.salesPrice = salesPrice;
      this.onSale = onSale;
      this.quantity = quantity;
   }
   
   public BikePart(String partName, int quantity){
       this.partName= partName;
       this.quantity = quantity;
   }
   
   /**
    * 
    * @return listPrice  Gets the list price and returns it. It is only needed for printLines.
    */
   public double getPrice() {
      return listPrice;
   }
   
   /**
    * 
    * @return Gets the correct price, factoring whether or not the bikepart is on sale
    */
   public double getRightPrice() {
       if(onSale) {
           return salesPrice;
       }
       else {
           return listPrice;
       }
   }
   
   /**
    * 
    * @return returns the number of the part.
    */
   public int getNum() {
       return partNum;
   }
   
   /**
    * 
    * @return returns whether sale is true or false
    */
   public boolean isOnSale() {
      return onSale;
   }
   
   /**
    * 
    * @return returns the salesPrice
    */
   public double getSalesPrice() {
      return salesPrice;
   }
   
   /**
    * 
    * @param onSale input from user which sets a bikeparts sale to true or false
    */
   public void setOnSale(boolean onSale) {
      this.onSale = onSale;
   }
   
   /**
    * 
    * @param salesPrice input from user which sets the salesPrice
    */
   public void setSalesPrice(double salesPrice) {
      this.salesPrice = salesPrice;
   }
   
   /**
    * 
    * @param listPrice input from user which sets the listPrice
    */
   public void setPrice(double listPrice) {
      this.listPrice = listPrice;
   }
   
   /**
    * 
    * @return returns the name of the part
    */
   public String getName() {
       return partName;
   }
   
   /**
    * 
    * @return returns the quantity of the part
    */
   public int getQuantity() {
       return quantity;
   }
   
   /**
    * 
    * @param quantity this sets the quantity equal to the argument
    */
   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }
   
   /**
    * 
    * @return returns string of whether object is on sale or not
    */
   public String getSale(){
       if(onSale){
           return "on sale";
       }
       else{
           return "not on sale";
       }
   }
   
    /**
     * 
     * @return mod     This is used to print out the actual information and not the location of the data.
     */
   public String toString() {
      String mod = "\n" + partName + ", " + partNum + ", " + listPrice + ", " + salesPrice + ", " + onSale + ", " + quantity;
      return mod;
   }
   
   /**
    * 
    * @return prints a toString for writing to files
    */
      public String toStringWrite() {
      String mod = "" + partName + "," + partNum + "," + listPrice + "," + salesPrice + "," + onSale + "," + quantity;
      return mod;
   }

    public void setName(String partName) {
        this.partName = partName;
    }

}
