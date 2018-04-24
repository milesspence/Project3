package project3gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static project3gui.ProcessCommands.IDS;
import static project3gui.ProcessCommands.read;
import static project3gui.ProcessCommands.readFile;
import static project3gui.ProcessCommands.total;
import static project3gui.ProcessCommands.writeFile;
import static project3gui.SysAdmin.accounts;
import static project3gui.SysAdmin.addOfficeManager;
import static project3gui.Invoices.invoices;
import static project3gui.ProcessCommands.IDS;
import static project3gui.ProcessCommands.readFile;
import static project3gui.ProcessCommands.readFileVan;
import static project3gui.ProcessCommands.writeFile;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Tab loginTab;

    @FXML
    private TextField loginUsername;

    @FXML
    private TextField loginPassword;

    @FXML
    private TextArea sysOutput;

    @FXML
    private TextField sysFirstName;

    @FXML
    private TextField sysLastName;

    @FXML
    private TextField sysEmail;

    @FXML
    private TextField sysUsername;

    @FXML
    private TextField sysPassword;

    @FXML
    private TextField sysVanName;

    @FXML
    private Button sysAddVan;

    @FXML
    private Tab officeManagerTab;

    @FXML
    private TextArea officeOutput;

    @FXML
    private TextField officePartName;

    @FXML
    private TextField officePartNumber;

    @FXML
    private TextField officeHowManyParts;

    @FXML
    private TextField officeEnterAssociate;

    @FXML
    private TextField officeEnterAssociateDates;

    @FXML
    private TextField officeEnterCustomer;

    @FXML
    private TextField officeEnterCustomerDates;

    @FXML
    private TextField officePayName;

    @FXML
    private TextField officeStartEnd;

    @FXML
    private Tab warehouseManagerTab;

    @FXML
    private TextArea wareOutput;

    @FXML
    private TextField wareAddFile;

    @FXML
    private TextField wareByName;

    @FXML
    private TextField wareByNumber;

    @FXML
    private Tab salesAssociateTab;

    @FXML
    private TextField salesVanName;

    @FXML
    private TextField salesInvFIle;

    @FXML
    private TextArea salesPartsTooAddList;

    @FXML
    private TextField salesPartnameQuantity;

    @FXML
    private TextArea salesPartsList;

    @FXML
    private TextField salesIInvName;

    @FXML
    private Tab passwordResetTab;

    @FXML
    private TextField passwordEmail;

    @FXML
    private TextField passwordNewPass;

    @FXML
    private TextArea passOutput;

    @FXML
    private Tab sysAdminTab;

    @FXML
    private TextArea loginTextArea;

    @FXML
    private TextArea salesAssociateOutput;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginTab.setDisable(false);
        sysAdminTab.setDisable(false);
        officeManagerTab.setDisable(false);
        warehouseManagerTab.setDisable(false);
        passwordResetTab.setDisable(false);
        salesAssociateTab.setDisable(false);
    }

    @FXML
    void loginLogin(ActionEvent event) {
        String userName = loginUsername.getText();
        String password = loginPassword.getText();
        Login l = new Login(userName, password);
        ArrayList<Login> accounts = new ArrayList<>();
        SysAdmin admin = new SysAdmin("admin", "minda");
        SysAdmin.accounts.add(admin);
        if (l instanceof SysAdmin) {
            loginTab.setDisable(true);
        }
        sysAdminTab.setDisable(false);
        officeManagerTab.setDisable(true);
        warehouseManagerTab.setDisable(true);
        passwordResetTab.setDisable(false);
        salesAssociateTab.setDisable(true);
        OfficeManager miles = new OfficeManager("miles", "miles", "miles", "miles", "pass1");
        SysAdmin.accounts.add(miles);
        if (l instanceof OfficeManager) {
            loginTab.setDisable(true);
        }
        sysAdminTab.setDisable(true);
        officeManagerTab.setDisable(false);
        warehouseManagerTab.setDisable(true);
        passwordResetTab.setDisable(false);
        salesAssociateTab.setDisable(true);

        WHManager josh = new WHManager("josh", "josh", "josh", "josh", "pass2");
        SysAdmin.accounts.add(josh);
        if (l instanceof WHManager) {
            loginTab.setDisable(true);
        }
        sysAdminTab.setDisable(true);
        officeManagerTab.setDisable(true);
        warehouseManagerTab.setDisable(false);
        passwordResetTab.setDisable(false);
        salesAssociateTab.setDisable(true);

//        SalesAssociate thomas = new SalesAssociate("thomas","thomas","thomas","thomas","pass3");
//        SysAdmin.accounts.add(thomas);
//           if(l instanceof SalesAssociate)
//        loginTab.setDisable(true);
//        sysAdminTab.setDisable(true);
//        officeManagerTab.setDisable(true);
//        warehouseManagerTab.setDisable(true);
//        passwordResetTab.setDisable(false);
//        salesAssociateTab.setDisable(false);
//            
    }

    @FXML
    void officeFindLow(ActionEvent event) {

    }

    @FXML
    void officeFindPart(ActionEvent event) {
        String partName = officePartName.getText();
        String partNum = officePartNumber.getText();
        for (int i = 0; i < IDS.size(); i++) {
            if (IDS.get(i).getName().equals(partName) || Integer.toString(IDS.get(i).getNum()).equals(partNum)) {
                officeOutput.setText(IDS.get(i).getName() + " " + IDS.get(i).getRightPrice());
            }
        }
    }

    @FXML
    void officeManagerLogout(ActionEvent event) {
        loginTab.setDisable(false);
        sysAdminTab.setDisable(true);
        officeManagerTab.setDisable(true);
        warehouseManagerTab.setDisable(true);
        passwordResetTab.setDisable(true);
        salesAssociateTab.setDisable(true);
    }

    @FXML
    void officeOrderParts(ActionEvent event) {

    }

    @FXML
    void officePayAssociate(ActionEvent event) {

    }

    @FXML
    void officeViewAssociateInvoice(ActionEvent event) {
        String salesAssociate = officeEnterAssociate.getText();
        String range = officeEnterAssociateDates.getText();
        String result = range.substring(0, 9) + range.substring(11);
        String[] pv = result.split("/");

        Date start = new Date();
        Date end = new Date();
        start.setDate(Integer.parseInt(pv[0]));
        start.setMonth(Integer.parseInt(pv[1]));
        start.setYear(Integer.parseInt(pv[2]));

        end.setDate(Integer.parseInt(pv[3]));
        end.setMonth(Integer.parseInt(pv[4]));
        end.setYear(Integer.parseInt(pv[5]));
        ArrayList<Invoice> officeInvoices = new ArrayList<>();
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getSA().equals(salesAssociate) && (invoices.get(i).getDate().before(end) && invoices.get(i).getDate().after(start))) {
                officeOutput.setText(invoices.get(i).toString());
            }
        }
    }

    @FXML
    void officeViewCustomerInvoice(ActionEvent event) {
        String customer = officeEnterCustomer.getText();
        String range = officeEnterCustomerDates.getText();
        String result = range.substring(0, 9) + range.substring(11);
        String[] pv = result.split("/");

        Date start = new Date();
        Date end = new Date();
        start.setDate(Integer.parseInt(pv[0]));
        start.setMonth(Integer.parseInt(pv[1]));
        start.setYear(Integer.parseInt(pv[2]));

        end.setDate(Integer.parseInt(pv[3]));
        end.setMonth(Integer.parseInt(pv[4]));
        end.setYear(Integer.parseInt(pv[5]));
        ArrayList<Invoice> officeInvoices = new ArrayList<>();
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getSA().equals(customer) && (invoices.get(i).getDate().before(end) && invoices.get(i).getDate().after(start))) {
                officeOutput.setText(invoices.get(i).toString());
            }
        }
    }

    @FXML
    void passLogOut(ActionEvent event) {
        loginTab.setDisable(false);
        sysAdminTab.setDisable(true);
        officeManagerTab.setDisable(true);
        warehouseManagerTab.setDisable(true);
        passwordResetTab.setDisable(true);
        salesAssociateTab.setDisable(true);
    }

    @FXML
    void passResetPass(ActionEvent event) {

    }

    @FXML
    void salesAddPartToSell(ActionEvent event) {
        String[] info = salesPartnameQuantity.getText().split(",");
        BikePart bp = new BikePart(info[0], Integer.parseInt(info[1]));
        ArrayList<BikePart> names = readFile("warehouseDB.txt");
        for (int i = 0; i < names.size(); i++) {
//            System.out.println(b.getName() + " " + bp.getName());
            if (bp.getName().equals(names.get(i).getName())) {
                salesPartsTooAddList.setText(bp.getName() + " " + bp.getQuantity());
            } else {
                salesPartsTooAddList.setText("Non-existent in main warehouse");
            }
        }
    }

    @FXML
    void salesAddParts(ActionEvent event) {
        //salesAssociateOutput.setText("test");
        String source = salesVanName.getText();
        String choice = salesInvFIle.getText();

        ArrayList<String> words = readFileVan(source); //every word in filename
        ArrayList<String> names = new ArrayList<>(); // only the names of parts
        for (int i = 2; i < words.size(); i = i + 2) {
            names.add(words.get(i));
        }

        ArrayList<Integer> quantities = new ArrayList<>(); // only the quantities of parts
        for (int i = 3; i < words.size(); i = i + 2) {
            quantities.add(Integer.parseInt(words.get(i)));
        }

        ArrayList<BikePart> second = readFile(words.get(1) + ".txt"); //arraylist that you write to
        ArrayList<BikePart> first = new ArrayList<>();
        first = readFile(words.get(0) + ".txt");   //arraylist that you get parts from
        ArrayList<BikePart> help = readFile(words.get(0) + ".txt");
        int count = 0;
        int counter = 0;
        if (choice.equalsIgnoreCase("yes1") || choice.equalsIgnoreCase("y1")/* && second.isEmpty()*/) {
            count = 0;
            counter = 0;
            for (int i = 0; i < names.size(); i++) {
                for (int j = 0; j < first.size(); j++) {
                    if (names.get(i).equals(first.get(j).getName())) {
                        count++;
                        second.add(first.get(j));
                        second.get(count - 1).setQuantity(quantities.get(count - 1));
                    }
                }
            }
            for (int i = 0; i < names.size(); i++) {
                for (int j = 0; j < IDS.size(); j++) {
                    if (names.get(i).equals(IDS.get(j).getName())) {
                        counter++;
                        IDS.get(j).setQuantity(IDS.get(j).getQuantity() - quantities.get(counter - 1)); //important
                    }
                }
            }
            writeFile(words.get(0) + ".txt", first);
            writeFile(words.get(1) + ".txt", second);
        } else if (choice.equalsIgnoreCase("yes2") || choice.equalsIgnoreCase("y2")/* && !second.isEmpty()*/) {
            count = 0;
            counter = 0;
            for (int i = 0; i < names.size(); i++) {
                for (int j = 0; j < first.size(); j++) {
                    if (names.get(i).equals(first.get(j).getName())) {
                        count++;
                        second.get(count - 1).setQuantity(second.get(count - 1).getQuantity() + quantities.get(count - 1));
                    }
                }
            }
            for (int i = 0; i < names.size(); i++) {
                for (int j = 0; j < IDS.size(); j++) {
                    if (names.get(i).equals(IDS.get(j).getName())) {
                        counter++;
                        IDS.get(j).setQuantity(IDS.get(j).getQuantity() - quantities.get(counter - 1)); //important
                    }
                }
            }
            writeFile(words.get(0) + ".txt", first);
            writeFile(words.get(1) + ".txt", second);
        } else if (choice.equalsIgnoreCase("no1") || choice.equalsIgnoreCase("n1")/* && second.isEmpty()*/) {
            count = 0;
            counter = 0;
            ArrayList<Integer> save = new ArrayList<>();
            for (int i = 0; i < names.size(); i++) {
                for (int j = 0; j < help.size(); j++) {
                    if (names.get(i).equals(help.get(j).getName())) {
                        count++;
                        save.add(help.get(j).getQuantity());
                        second.add(help.get(j));
                        second.get(count - 1).setQuantity(quantities.get(count - 1));
                    }
                }
            }
            writeFile(words.get(1) + ".txt", second);
            for (int i = 0; i < names.size(); i++) {
                for (int j = 0; j < help.size(); j++) {
                    if (names.get(i).equals(help.get(j).getName())) {
                        counter++;
                        help.get(j).setQuantity(save.get(counter - 1) - quantities.get(counter - 1)); //important
                    }
                }
            }
            writeFile(words.get(0) + ".txt", help);
        } else if (choice.equalsIgnoreCase("no2") || choice.equalsIgnoreCase("n2")/* && second.isEmpty()*/) {
            count = 0;
            counter = 0;
            ArrayList<Integer> save = new ArrayList<>();
            for (int i = 0; i < names.size(); i++) {
                for (int j = 0; j < help.size(); j++) {
                    if (names.get(i).equals(help.get(j).getName())) {
                        count++;
                        save.add(help.get(j).getQuantity());
                        second.get(count - 1).setQuantity(second.get(count - 1).getQuantity() + quantities.get(count - 1));
                    }
                }
            }
            writeFile(words.get(1) + ".txt", second);
            for (int i = 0; i < names.size(); i++) {
                for (int j = 0; j < help.size(); j++) {
                    if (names.get(i).equals(help.get(j).getName())) {
                        counter++;
                        help.get(j).setQuantity(save.get(counter - 1) - quantities.get(counter - 1)); //important
                    }
                }
            }
            writeFile(words.get(0) + ".txt", help);
        }
        if (count > 0) {
            salesAssociateOutput.setText("part(s) moved");
        } else {
            salesAssociateOutput.setText("part moved");
        }
    }

    @FXML
    void salesAssociateLogout(ActionEvent event) {
        loginTab.setDisable(false);
        sysAdminTab.setDisable(true);
        officeManagerTab.setDisable(true);
        warehouseManagerTab.setDisable(true);
        passwordResetTab.setDisable(true);
        salesAssociateTab.setDisable(true);
    }

    @FXML
    void salesClearPart(ActionEvent event) {

    }

    @FXML
    void salesSellPart(ActionEvent event) {

    }

    @FXML
    void salesShowParts(ActionEvent event) {
        String fileName = salesIInvName.getText();
        ArrayList<BikePart> parts = readFile(fileName);
        for (BikePart bp : parts) {
            salesPartsList.setText(bp.getName() + " " + bp.getRightPrice() + "\n");
            System.out.println(bp.getName() + bp.getRightPrice());
        }
    }

    @FXML
    void sysAddOfficemanager(ActionEvent event) {
        String fName = sysFirstName.getText();
        String lName = sysLastName.getText();
        String email = sysEmail.getText();
        String username = sysUsername.getText();
        String password = sysPassword.getText();
        addOfficeManager(fName, lName, email, username, password);
        sysOutput.setText("Office Manager Created");
    }

    @FXML
    void sysAddSalesAssociate(ActionEvent event) {
        String fName = sysFirstName.getText();
        String lName = sysLastName.getText();
        String email = sysEmail.getText();
        String username = sysUsername.getText();
        String password = sysPassword.getText();
        SysAdmin.addSalesAssociate(fName, lName, email, username, password);
        sysOutput.setText("Sales Associated Created");
    }

    @FXML
    void sysAddWarehouseManager(ActionEvent event) {
        String fName = sysFirstName.getText();
        String lName = sysLastName.getText();
        String email = sysEmail.getText();
        String username = sysUsername.getText();
        String password = sysPassword.getText();
        SysAdmin.addWHManager(fName, lName, email, username, password);
        sysOutput.setText("WareHouse Manager Created");
    }

    @FXML
    void sysLogout(ActionEvent event) {
        loginTab.setDisable(false);
        sysAdminTab.setDisable(true);
        officeManagerTab.setDisable(true);
        warehouseManagerTab.setDisable(true);
        passwordResetTab.setDisable(true);
        salesAssociateTab.setDisable(true);
    }

    @FXML
    void sysAddVan(ActionEvent event) {
        String filename = sysVanName.getText();
        SysAdmin.addSalesVan(filename);
        ArrayList<BikePart> blank = new ArrayList<>();
        total = read(blank, total);
        writeFile(filename, blank);
        blank = readFile(filename);
        total = read(blank, total);
    }

    @FXML
    void wareAddFile(ActionEvent event) {
        String fileName = wareAddFile.getText();
        WHManager.update(fileName);
        wareOutput.setText("Warehouse updated");
    }

    @FXML
    void wareFindPart(ActionEvent event) {
        String partName = wareByName.getText();
        String partNum = wareByNumber.getText();
        for (int i = 0; i < IDS.size(); i++) {
            if (IDS.get(i).getName().equals(partName) || Integer.toString(IDS.get(i).getNum()).equals(partNum)) {
                wareOutput.setText(IDS.get(i).getName() + " " + IDS.get(i).getRightPrice());
            }
        }
    }

    @FXML
    void warehouseManagerLogout(ActionEvent event) {
        loginTab.setDisable(false);
        sysAdminTab.setDisable(true);
        officeManagerTab.setDisable(true);
        warehouseManagerTab.setDisable(true);
        passwordResetTab.setDisable(true);
        salesAssociateTab.setDisable(true);
    }

}
