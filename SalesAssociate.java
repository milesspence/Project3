/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author KinkyKat
 */
public class SalesAssociate extends Login {
    
    public SalesAssociate(String fName, String lName, String email, String username, String password) {
        super(username, password);
    }
    ArrayList<Invoice> invoices = new ArrayList<>();
    Invoice i;
    
    public void createInvoice(String customer,Date d,String empRecieved,BikePart b, String salesAssociate){
        i = new Invoice(customer,d,empRecieved,b,salesAssociate);
        invoices.add(i);
    }
    
    
    
}
