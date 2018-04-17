/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;

/**
 *
 * @author KinkyKat
 */

// not sure if this should extends WareHouse or not
public class AllWareHouses extends WareHouse {
    ArrayList<WareHouse> warehouses;


// has similar methods as the warehouse class does with the bikepart class

    public AllWareHouses(String name, ArrayList<BikePart> whDB) {
        super(name, whDB);
    }

    public WareHouse findWareHouse(String name) {
       for(WareHouse w: warehouses) {
           if (w.getWareHouseName().equals(name)) {
               return w;
           }
       }
       return null;
   }
    
}

