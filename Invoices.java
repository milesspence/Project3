/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author KinkyKat
 */
public class Invoices {

    public static ArrayList<Invoice> invoices = new ArrayList<>();

    // gonna be able to grab invoices
    public void findInvoice(String salesAssociate, Date start, Date end) {
        ArrayList<Invoice> officeInvoices = new ArrayList<>();
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getSA().equals(salesAssociate) && (invoices.get(i).getDate().before(end) && invoices.get(i).getDate().after(start))) {
                officeInvoices.add(invoices.get(i));
            }
        }
    }

    public static void writeFile(String filename, ArrayList<Invoice> invoices) {
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            for (Invoice inv : invoices) {
                writer.println(inv.toString()); // uses invoice toString()
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("file error!");
            e.printStackTrace();
        }
    }
    public void findCommision(String salesAssociate, Date start, Date end){
            ArrayList<Invoice> salesAssociateInvoices = new ArrayList<>();
            for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getSA().equals(salesAssociate) && (invoices.get(i).getDate().before(end) && invoices.get(i).getDate().after(start))) {
                salesAssociateInvoices.add(invoices.get(i));
            for(Invoice invoice : salesAssociateInvoices){
                double payToSalesAss = invoice.getTotCost() * .15;
                System.out.println("Pay " + payToSalesAss + "to the sales associate: " + invoice.getSA());
                }
            }
        }
    }
    
}
