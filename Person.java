/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author KinkyKat
 */
public class Person {
    String fName;
    String lName;
    String email;
    
    public Person(String fName,String lName, String email){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }
    
    public String getFName(){
        return fName;
    }
    public String getLName(){
        return lName;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setFName(String n){
        fName = n;
    }
    public void setLName(String n){
        lName = n;
    }
   
    public void setEmail(String e){
        email = e;
    }
}
