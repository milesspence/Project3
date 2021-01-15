package project3gui;

import static project3gui.ProcessCommands.IDS;
import java.util.ArrayList;


/**
 *
 * @author Miles Spence
 */
public class OfficeManager extends Login {
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String email;
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
