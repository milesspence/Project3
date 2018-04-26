/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static project3gui.Accounts.writeLoginFile;
import static project3gui.ProcessCommands.IDSWH;
import static project3gui.ProcessCommands.readFile;
import static project3gui.ProcessCommands.writeFile;

/**
 *
 * @author KinkyKat
 */
public class Project3gui extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        SysAdmin admin = new SysAdmin("admin","admin","admin","admin","minda");
       // SalesAssociate thomas = new SalesAssociate("thomas","password");
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
       writeFile("warehouseDB.txt", ProcessCommands.IDS);
       writeLoginFile("Accounts.txt", SysAdmin.accounts);
    }
    
    

    
    public static void main(String[] args) {
        SysAdmin admin = new SysAdmin("admin","admin","admin","admin","minda");
        //SalesAssociate thomas = new SalesAssociate("thomas","password");
        IDSWH.add(new WareHouse("mainwh", "mainwh.txt"));
        ProcessCommands.IDS = readFile("warehouseDB.txt");
        launch(args);
    
    }
}
