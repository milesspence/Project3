package project3gui;

import java.util.ArrayList;
import java.util.Scanner;
import static project3gui.ProcessCommands.printMessage;
import static project3gui.ProcessCommands.read;
import static project3gui.ProcessCommands.readFile;
import static project3gui.ProcessCommands.readFileVan;
import static project3gui.ProcessCommands.sortName;
import static project3gui.ProcessCommands.sortNumber;
import static project3gui.ProcessCommands.writeFile;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * This program runs the BikePart and receives the information about the
 * BikeParts from the user.
 *
 * @author Miles Spence
 */
public class Main implements Serializable {

    public static void main(String[] args) {
        ArrayList<BikePart> IDS = readFile("warehouseDB.txt");
        Scanner scan = new Scanner(System.in);
        printMessage();
        String choice;
        choice = scan.nextLine();
        ArrayList<BikePart> total = new ArrayList<>();
        while (!choice.equalsIgnoreCase("quit") || !choice.equalsIgnoreCase("q")) {
            if (choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r")) {
                System.out.println("Enter file name which contains the inventory: ");
                ArrayList<BikePart> inventory = readFile(scan.nextLine());
                if (IDS.isEmpty()) {
                    IDS = inventory;
                } else {
                    read(inventory, IDS);
                }
                writeFile("warehouseDB.txt", IDS);
                printMessage();
                choice = scan.nextLine();
            } else if (choice.equalsIgnoreCase("enter") || choice.equalsIgnoreCase("e")) { //dont change
                System.out.println("Enter new BikePart: ");
                String line = scan.nextLine();
                String regExp = ",";
                String[] pv = line.split(regExp);
                BikePart bp = new BikePart(pv[0],
                        Integer.parseInt(pv[1]),
                        Double.parseDouble(pv[2]),
                        Double.parseDouble(pv[3]),
                        Boolean.parseBoolean(pv[4]),
                        Integer.parseInt(pv[5]));
                boolean contains = false;
                for (int i = 0; i < IDS.size(); i++) {
                    if (IDS.get(i).getName().contains(bp.getName())) {
                        contains = true;
                    }
                }
                if (contains == true) {
                    for (int i = 0; i < IDS.size(); i++) {
                        if (IDS.get(i).getName().contains(bp.getName())) {
                            IDS.get(i).setQuantity(IDS.get(i).getQuantity() + Integer.parseInt(pv[5]));
                        }
                    }
                } else {
                    IDS.add(bp);
                }
                printMessage();
                choice = scan.nextLine();
            } else if (choice.equalsIgnoreCase("sell") || choice.equalsIgnoreCase("s")) {
                Date date = new Date();
                System.out.println("Enter BikePart number: ");
                int bpn = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter from which warehouse to sell: ");
                String whn = scan.nextLine();
                boolean error = true;
                if (whn.equalsIgnoreCase("main") || whn.equalsIgnoreCase("main warehouse")) {
                    for (int i = 0; i < IDS.size(); i++) {
                        if (IDS.get(i).getNum() == bpn) {
                            BikePart model = IDS.get(i);
                            model.setQuantity(model.getQuantity() - 1);
                            IDS.set(i, model);
                            System.out.println(IDS.get(i).getName() + " " + IDS.get(i).getRightPrice() + " " + IDS.get(i).getSale() + "\nThe time BikePart was sold: " + date.toString());
                            error = false;
                        }
                    }
                } else {
                    ArrayList<BikePart> read = readFile(whn);
                    for (int i = 0; i < read.size(); i++) {
                        if (read.get(i).getNum() == bpn) {
                            BikePart model = read.get(i);
                            model.setQuantity(model.getQuantity() - 1);
                            read.set(i, model);
                            writeFile(whn, read);
                            System.out.println(read.get(i).getName() + " " + read.get(i).getRightPrice() + " " + read.get(i).getSale() + "\nThe time BikePart was sold: " + date.toString());
                            error = false;

                        }
                    }
                }

                if (error) {
                    System.out.println("This is an error message");
                }
                printMessage();
                choice = scan.nextLine();
            } else if (choice.equalsIgnoreCase("display") || choice.equalsIgnoreCase("d")) { //dont change
                System.out.println("Which part would you like to display?");
                String name = scan.nextLine();
                boolean error = true;
                for (int i = 0; i < IDS.size(); i++) {
                    if (IDS.get(i).getName().equals(name)) {
                        System.out.println(IDS.get(i).getName() + " " + IDS.get(i).getRightPrice());
                        error = false;
                    }
                }
                if (error) {
                    System.out.println("This is an error message");
                }
                printMessage();
                choice = scan.nextLine();
            } else if (choice.equalsIgnoreCase("sortname") || choice.equalsIgnoreCase("sna")) {
                System.out.println("Enter from where you want to sort (total, main warehouse, or sales van): ");
                String where = scan.nextLine();
                if (where.equalsIgnoreCase("total")) {
                    //for(int i = 0; i < IDS.size(); i++) {
                    //total.add(IDS.get(i));
                    //}
                    //total = read(IDS, total);
                    //ArrayList<BikePart> temp = read(IDS, total);
                    sortName(total);
                } else if (where.equalsIgnoreCase("main") || where.equalsIgnoreCase("main warehouse")) {
                    sortName(IDS);
                } else {
                    ArrayList<BikePart> read = readFile(where);
                    sortName(read);
                }
                printMessage();
                choice = scan.nextLine();
            } else if (choice.equalsIgnoreCase("sortnumber") || choice.equalsIgnoreCase("snu")) {
                System.out.println("Enter from where you want to sort (total, main warehouse, or sales van): ");
                String where = scan.nextLine();
                if (where.equalsIgnoreCase("Total")) {
                    total = read(IDS, total);
                    sortNumber(total);
                } else if (where.equalsIgnoreCase("main") || where.equalsIgnoreCase("main warehouse")) {
                    sortNumber(IDS);
                } else {
                    ArrayList<BikePart> read = readFile(where);
                    sortNumber(read);
                }
                printMessage();
                choice = scan.nextLine();
            } else if (choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("add van") || choice.equalsIgnoreCase("a")) {
                System.out.println("Create a new warehouse (yes?): ");
                String choose = scan.nextLine();
                if (choose.equalsIgnoreCase("yes") || choose.equalsIgnoreCase("y")) {
                    System.out.println("Enter warehouse name: ");
                    String welp = scan.nextLine();
                    ArrayList<BikePart> blank = new ArrayList<>();
                    total = read(blank, total);
                    writeFile(welp, blank);
                } else {
                    System.out.println("Enter warehouse name: ");
                    String welp = scan.nextLine();
                    ArrayList<BikePart> blank = readFile(welp);
                    total = read(blank, total);
                }
                //for(int i = 0; i < blank.size(); i++) {
                //total.add(blank.get(i));
                //}
                printMessage();
                choice = scan.nextLine();
            } else if (choice.equalsIgnoreCase("move") || choice.equalsIgnoreCase("m")) {
                System.out.println("Enter file name: ");
                String source = scan.nextLine();
                //System.out.println("Is it a transfer among vans?");
                //String answer = scan.nextLine();
                ArrayList<String> words = readFileVan(source); //each index is every word in filename
                ArrayList<String> help = readFileVan(source);
                ArrayList<String> names = new ArrayList<>(); // only the names of parts
                for (int i = 2; i < words.size(); i = i + 2) {
                    names.add(words.get(i));
                }

                ArrayList<String> quantities = new ArrayList<>(); // only the quantities of parts
                for (int i = 3; i < words.size(); i = i + 2) {
                    quantities.add(words.get(i));
                }

                ArrayList<BikePart> second = readFile(words.get(1) + ".txt"); //arraylist that you write to
                ArrayList<BikePart> main = readFile(words.get(0) + ".txt");   //arraylist that you get parts from
                ArrayList<BikePart> test = readFile(help.get(0) + ".txt");
                //if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                int count = 0;
                for (int i = 0; i < names.size(); i++) {
                    for (int j = 0; j < main.size(); j++) {
                        if (names.get(i).equals(main.get(j).getName())) {
                            second.add(main.get(j));
                            count++;
                            second.get(count - 1).setQuantity(Integer.parseInt(quantities.get(count - 1)));
                            test.get(j).setQuantity(test.get(j).getQuantity() - Integer.parseInt(quantities.get(count - 1)));
                        }
                    }
                }
                writeFile(help.get(0) + ".txt", test);
                //if (second.isEmpty()) {
                //writeFile(words.get(1) + ".txt", second);
                //} else {
                //second = read(main, second);
                writeFile(help.get(1) + ".txt", second);
                //}
                //}
                printMessage();
                choice = scan.nextLine();
            } else {
                writeFile("warehouseDB.txt", IDS);
                System.exit(0);
            }
        }
    }
    
}
