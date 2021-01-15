package gui;

import static gui.ProcessCommands.readFile;
import static gui.ProcessCommands.writeFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @author Miles Spence
 */
public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void stop() {
        writeFile("warehouseDB.txt", ProcessCommands.IDS);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SysAdmin admin = new SysAdmin(" "," ","","admin","minda");
     
        launch(args);
    
    }
}
