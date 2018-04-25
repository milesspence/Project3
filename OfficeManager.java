/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.ProcessCommands.IDS;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author KinkyKat
 */
public class OfficeManager extends Login {
    String username;
    String password;
    String fName;
    String lName;
    String email;
    ArrayList<Login> invoices;
    public OfficeManager(String fName, String lName, String email, String username, String password) {
        super(username, password);
    }
    
        public String examineByPartName(String name) {
        for (int i = 0; i < IDS.size(); i++) {
            if (IDS.get(i).getName().equals(name)) {
                return IDS.get(i).getName() + " " + IDS.get(i).getRightPrice();
            }
        }
        return "part not found";
    }    
    
    public String examineByPartNum(int partNum) {
        for (int i = 0; i < IDS.size(); i++) {
            if (IDS.get(i).getNum() == (partNum)) {
                return IDS.get(i).getName() + " " + IDS.get(i).getRightPrice();
            }
        }
        return "part not found";
    }
    
    public String checkParts(ArrayList<BikePart> IDS){
        String c = "";
        for(int i = 0; i < IDS.size(); i ++) {
            if(IDS.get(i).getQuantity() < 5) {
              return IDS.get(i).toString();
    }
        }
        return "Parts to be ordered";
    }
    
  }
