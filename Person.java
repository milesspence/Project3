package project3gui;

/**
 *
 * @author Miles Spence
 */
public class Person implements Interface {
    String fName;
    String lName;
    String email;
    
    public Person(String fName,String lName, String email){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }
    @Override
    public String getName(){
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
