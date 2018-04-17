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
    String name;
    int phNum;
    String email;
    
    public Person(String name, int phNum, String email){
        this.name = name;
        this.phNum = phNum;
        this.email = email;
    }
    
    public String getName(){
        return name;
    }
    
    public int getphNum(){
        return phNum;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public void setphNum(int x){
        phNum = x;
    }
    
    public void setEmail(String e){
        email = e;
    }
}
