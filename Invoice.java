package project3gui;


import java.util.Date;

/**
 *
 * @author Miles Spence
 */

public class Invoice {
    String customer;
    Date d;
    String empRecieved;
    BikePart b;
    double totCost;
    String salesAssociate;
    
    
    public Invoice(String customer,Date d,String emRecieved,BikePart b, String salesAssociate){
        this.customer = customer;
        this.d = d;
        this.empRecieved = empRecieved;
        this.b = b;
        totCost = getTotalCost(b);
        this.salesAssociate = salesAssociate;
    }
    
    public String getCustomer(){
    return customer;
    }
    
    public Date getDate(){
        return d;
    }
    
    public String getEmpRecieved(){
        return empRecieved;
    }
    
    public BikePart getPart(){
        return b;
    }
    
    public double getTotCost(){
        return totCost;
    }
    
    public String getSA(){
        return salesAssociate;
    }
    
    public double getTotalCost(BikePart b){
        double totalCost = 0.0;
        return totalCost = b.getQuantity() * b.getRightPrice();
        }
    public String toString(){
        return customer + "$" + d + "," + empRecieved + "," + b + "," + salesAssociate + "," + totCost;
    }
    
}
