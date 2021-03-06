package project3gui;

import static project3gui.ProcessCommands.read;
import static project3gui.ProcessCommands.readFile;
import static project3gui.ProcessCommands.total;
import static project3gui.ProcessCommands.writeFile;
import java.util.ArrayList;

/**
 *
 * @author Miles Spence
 */
public class SysAdmin extends Login {

    public static ArrayList<Login> accounts = new ArrayList<>();
    private String username;

    public SysAdmin(String fName, String lName, String email, String username, String password) {
        super(username, password);
    }

    public static void addOfficeManager(String fName, String lName, String email, String username, String password) {
        OfficeManager o = new OfficeManager(fName, lName, email, username, password);
        accounts.add(o);
    }

    public static void addWHManager(String fName, String lName, String email, String username, String password) {
        WHManager w = new WHManager(fName, lName, email, username, password);
        accounts.add(w);
    }

    public static void addSalesAssociate(String fName, String lName, String email, String username, String password) {
        SalesAssociate a = new SalesAssociate(fName, lName, email, username, password);
        accounts.add(a);
    }

    public static void deleteAccount(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equals(username)) {
                accounts.remove(i);
            }
        }
    }

    @Override
    public void resetPassword(String email) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getEmail().equals(username)) {
                accounts.get(i).setPassword("password");
            }
        }
    }

    public static void addSalesVan(String filename) {
        ArrayList<BikePart> blank = new ArrayList<>();
        total = read(blank, total);
        writeFile(filename, blank);
        blank = readFile(filename);
        total = read(blank, total);

    }
}
