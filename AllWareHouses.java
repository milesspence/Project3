package project3gui;


import java.util.ArrayList;

/**
 *
 * @author Miles Spence
 */

public class AllWareHouses extends WareHouse {
    ArrayList<WareHouse> warehouses;


// has similar methods as the warehouse class does with the bikepart class

    public AllWareHouses(String name, ArrayList<BikePart> whDB) {
        super(name, whDB);
    }

    public WareHouse findWareHouse(String name) {
       for(int i = 0; i < warehouses.size(); i ++) {
           if (warehouses.get(i).getWareHouseName().equals(name)) {
             WareHouse p = warehouses.get(i);  
             return p;
           }
       }
        return null;
    }
    
    public BikePart findBPNameByWarehouse(String warehouseName, String bpName) {
       for(WareHouse W : warehouses){
        for(BikePart bp: whDB) {
           if (bp.getName().equals(name)) {
               return bp;
           }
        }
}
        return null;
    }
}
