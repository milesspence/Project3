/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author KinkyKat
 */
// will have the ablility to determine if a login is a warehouse manager, sales associate, system admin, and office manager
public class Accounts  {
    
    public static ArrayList<Login> accounts = new ArrayList<>();
    
    public String validate(String userName, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(userName) && accounts.get(i).getPassword().equals(password)) {
    }
  }
        return "Logged in";
}
    //Add instanceof in controller 

    public static void writeLoginFile(String filename, ArrayList<Login> accounts) {
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            for (Login l : accounts) {
                writer.println(l.toStringLogin()); // uses Login toStringLogin()
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("file error!");
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Login> readLoginFile(String fileName) {
        ArrayList<Login> retList = null;
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
                Login l = new Login(pv[0],pv[1]);
                retList.add(l);
            }
        } catch (FileNotFoundException e) {
            return null;
        }
        return retList;
    }
    
}
