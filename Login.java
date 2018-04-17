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
public class Login {
    String username;
    String password;
    Person person;
    
    public Login(String username, String password, Person person){
        this.username = username;
        this.password = password;
        this.person = person;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public Person getPerson(){
        return person;
    }
    
    public void setUsername(String u){
        username = u;
    }
    
    public void setPassword(String p){
        password = p;
    }
    
    public void setPerson(Person p){
        person = p;
    }
}
