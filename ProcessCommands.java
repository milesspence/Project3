package project3gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * v3.3
 *
 * @author Miles Spence
 */
public class ProcessCommands {

    public static ArrayList<BikePart> IDS = new ArrayList<>();
    public static ArrayList<WareHouse> IDSWH = new ArrayList<>();
    public static ArrayList<BikePart> total = new ArrayList<>();
    private static ArrayList<BikePart> first = new ArrayList<>();

    /**
     *
     * @param command
     * @param param
     * @return
     */
    public static String doCommand(String command, String param) {
        switch (command) {
            case "read":
                return doRead(param);
            case "display":
                return doDisplay(param);
            case "enter":
                return doEnter(param);
            case "sortname":
                return doSortName(param);
            case "sortnumber":
                return doSortNumber(param);
            default:
                return "invalid command";
        }
    }

    /**
     *
     * @param command
     * @param param1
     * @param param2
     * @return
     */
    public static String doCommand2(String command, String param1, String param2) {
        switch (command) {
            case "sell":
                return doSell(Integer.parseInt(param1), param2);
            case "add":
                return doAdd(param1, param2);
            case "move":
                return doMove(param1, param2);
            default:
                return "invalid command";
        }
    }

    /**
     *
     * @param where
     * @return
     */
    public static String doSortNumber(String where) {
        if (where.equalsIgnoreCase("Total")) {
            total = read(IDS, total);
            sortNumber(total);
        } else if (where.equalsIgnoreCase("main") || where.equalsIgnoreCase("main warehouse")) {
            sortNumber(IDS);
        } else {
            ArrayList<BikePart> read = readFile(where);
            sortNumber(read);
        }
        return "parts sorted";
    }

    /**
     *
     * @param where
     * @return
     */
    public static String doSortName(String where) {
        if (where.equalsIgnoreCase("total")) {
            sortName(total);
        } else if (where.equalsIgnoreCase("main") || where.equalsIgnoreCase("main warehouse")) {
            sortName(IDS);
        } else {
            ArrayList<BikePart> read = readFile(where);
            sortName(read);
        }
        return "parts sorted";
    }

    /**
     *
     * @param bpn
     * @param whn
     * @return
     */
    public static String doSell(int bpn, String whn) {
        ArrayList<Date> d = new ArrayList<>();
        Date date = new Date();
        BikePart name = new BikePart("miles", 108, 48.15, 16.23, true, 42);
        if (whn.equalsIgnoreCase("main") || whn.equalsIgnoreCase("main warehouse")) {
            for (int i = 0; i < IDS.size(); i++) {
                if (IDS.get(i).getNum() == bpn) {
                    BikePart model = IDS.get(i);
                    model.setQuantity(model.getQuantity() - 1);
                    IDS.set(i, model);
                    name.setName(IDS.get(i).getName());
                    name.setPrice(IDS.get(i).getRightPrice());
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
                    name.setName(read.get(i).getName());
                    name.setPrice(read.get(i).getRightPrice());
                }
            }
        }
        d.add(date);
        return "" + name.getName() + ", " + name.getPrice() + "\nThe time BikePart was sold: \n" + date.toString();
    }

    /**
     *
     * @param line
     * @return
     */
    public static String doEnter(String line) {
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
        return "part entered";
    }

    /**
     *
     * @param name
     * @return
     */
    public static String doDisplay(String name) {
        for (int i = 0; i < IDS.size(); i++) {
            if (IDS.get(i).getName().equals(name)) {
                return IDS.get(i).getName() + " " + IDS.get(i).getRightPrice();
            }
        }
        return "part not found";
    }

    /**
     *
     * @param filename
     * @return
     */
    public static String doRead(String filename) {
        ArrayList<BikePart> inventory = readFile(filename);
        if (inventory == null) {
            return "file not found";
        }
        if (IDS.isEmpty()) {
            IDS = inventory;
        } else {
            read(inventory, IDS);
        }
        return "file processed";
    }

    /**
     *
     * @param fileName
     * @return
     */
    public static ArrayList<BikePart> readFile(String fileName) {
        ArrayList<BikePart> retList = null;
        if (fileName == null || fileName.equals("")) {
            return retList;
        }
        File file = new File(fileName);
        try {
            retList = new ArrayList<>();
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String regExp = ",";
                String[] pv = line.split(regExp);
                BikePart bp = new BikePart(pv[0],
                        Integer.parseInt(pv[1]),
                        Double.parseDouble(pv[2]),
                        Double.parseDouble(pv[3]),
                        Boolean.parseBoolean(pv[4]),
                        Integer.parseInt(pv[5]));
                retList.add(bp);
            }
        } catch (FileNotFoundException e) {
            return null;
        }
        return retList;
    }

    /**
     *
     * @param fileName the name of the file you want to read from
     * @return returns an arraylist of strings that are every word from the move
     * document
     */
    public static ArrayList<String> readFileVan(String fileName) {
        ArrayList<String> retList = new ArrayList<>();
        if (fileName == null || fileName.equals("")) {
            return retList;
        }
        File file = new File(fileName);
        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String[] parts = read.nextLine().split(",");
                String part1 = parts[0];
                String part2 = parts[1];
                retList.add(part1);
                retList.add(part2);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
        return retList;
    }

    /**
     *
     * @param filename name of where the bikepart Array will be printed
     * @param bpArray the bikepart array that is printed to a given file
     */
    public static void writeFile(String filename, ArrayList<BikePart> bpArray) {
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            for (BikePart bp : bpArray) {
                writer.println(bp.toStringWrite()); // uses BikePart toString()
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("file error!");
            e.printStackTrace();
        }
    }

    public static void printMessage() {
        System.out.println();
        System.out.println("Please select your option from the following menu:\n"
                + "Read: Read an inventory delivery file\n"
                + "Enter: Enter a part\n"
                + "Sell: Sell a part\n"
                + "Display: Display a part\n"
                + "SortName: Sort parts by part name\n"
                + "SortNumber: Sort parts by part number\n"
                + "Add: Add a sales van, which will act as a warehouse\n"
                + "Move: Move inventory between two warehouses\n"
                + "Quit: End the program\n"
                + "Enter your choice: ");
    }

    /**
     *
     * @param sort this is the arraylist which you want to sort by alphabetical
     * order
     */
    public static void sortName(ArrayList<BikePart> sort) {
        for (int i = 1; i < sort.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (sort.get(i).getName().compareTo(sort.get(j).getName()) < 0) {
                    sort.add(j, sort.remove(i));
                }
            }
        }
        System.out.println(sort);
    }

    /**
     *
     * @param sort this is the arraylist which you want to sort by numerical
     * order
     */
    public static void sortNumber(ArrayList<BikePart> sort) {
        for (int i = 1; i < sort.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (sort.get(i).getNum() < sort.get(j).getNum()) {
                    sort.add(j, sort.remove(i));
                }
            }
        }
        System.out.println(sort);
    }

    /**
     *
     * @param inventory the arraylist you are comparing and adding from
     * @param total the arraylist you are editing and adding to
     * @return an arraylist of the two parameters combined
     */
    public static ArrayList<BikePart> read(ArrayList<BikePart> inventory, ArrayList<BikePart> total) {
        ArrayList<BikePart> returnable = new ArrayList<>();
        returnable = total;
        ArrayList<BikePart> helper = inventory;
        ArrayList<BikePart> test = new ArrayList<>();
        for (int i = 0; i < helper.size(); i++) {
            for (int j = 0; j < returnable.size(); j++) {
                if (returnable.get(j).getName().equals(helper.get(i).getName())) {
                    test.add(helper.get(i));
                    returnable.get(j).setPrice(helper.get(i).getPrice());
                    returnable.get(j).setSalesPrice(helper.get(i).getSalesPrice());
                    returnable.get(j).setOnSale(helper.get(i).isOnSale());
                    returnable.get(j).setQuantity(returnable.get(j).getQuantity() + helper.get(i).getQuantity());
                }
            }
        }
        for (int i = 0; i < helper.size(); i++) {
            for (int j = 0; j < test.size(); j++) {
                if (test.get(j).getName().equals(helper.get(i).getName())) {
                    helper.remove(helper.get(i));
                }
            }
        }
        for (int j = 0; j < helper.size(); j++) {
            total.add(helper.get(j));
        }
        return returnable;
    }

    /**
     *
     * @param choose
     * @param welp
     * @return
     */
    private static String doAdd(String choose, String welp) {
        if (choose.equalsIgnoreCase("yes") || choose.equalsIgnoreCase("new")) {
            ArrayList<BikePart> blank = new ArrayList<>();
            total = read(blank, total);
            writeFile(welp, blank);
        } else {
            ArrayList<BikePart> blank = readFile(welp);
            total = read(blank, total);
        }
        return "warehouse added";
    }

    /**
     *
     * @param source
     * @param choice
     * @return
     */
    private static String doMove(String source, String choice) {
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
            return "parts moved";
        } else {
            return "part moved";
        }
    }
}
