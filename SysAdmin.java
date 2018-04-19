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
public class SysAdmin extends Login {
    
    public SysAdmin(String username, String password, Person person) {
        super(username, password, person);
    }
    Person Josh = new Person("Josh",54050255,"jophus@aim.com");
    SysAdmin JoshAdmin = new SysAdmin("abc","123",Josh);
    
    public OfficeManager addOfficeManager(String username, String password, Person p){
        OfficeManager o = new OfficeManager(username,password,p);
        return o;
    }
    
    public WHManager addWHManager(String username, String password, Person p){
        WHManager w = new WHManager(username,password,p);
        return w;
    }
    public SalesAssociate addSalesAssociate(String username, String password, Person p){
        SalesAssociate a = new SalesAssociate(username,password,p);
        return a;
    }
}
