/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3gui;

import java.util.ArrayList;

/**
 *
 * @author KinkyKat
 */
public class Login implements Interface {
    String fName;
    String lName;
    String email;
    String username;
    String password;
    WHManager wh;
    SalesAssociate sa;
    OfficeManager om;
    SysAdmin sysAdmin;
    public Login(String username, String password){
        this.username = username;
        this.password = password;
       // this.person = person;
    }
    public Login(String fName,String lName,String email,String username, String password){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    ArrayList<Login> accounts;
    @Override
    public String getName(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setUserName(String u){
        username = u;
    }
    
    public void setPassword(String p){
        password = p;
    }
    

    public String toStringLogin(){
        String s = fName + "," + lName + "," + email + "," + username + "," + password;
        return s;
    }
    
        public void resetPassword(String username){
         for(int i = 0;i < accounts.size(); i ++){
            if(accounts.get(i).getName().equals(username)){
                accounts.get(i).setPassword("password");
            }
         }   
    }
        
  public WHManager getWHManager(){
      return wh;
  }
  public SysAdmin getSysAdmin(){
      return sysAdmin;
  }
  public OfficeManager getOfficeManager(){
      return om;
  }
  public SalesAssociate getSalesAssociate(){
      return sa;
  }
}
