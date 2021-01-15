package project3gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Miles Spence
 */
public class Invoices {

    public static ArrayList<Invoice> invoices = new ArrayList<>();

    // gonna be able to grab invoices
    public void findInvoice(String salesAssociate, Date start, Date end) {
        ArrayList<Invoice> officeInvoices = null;
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
}
