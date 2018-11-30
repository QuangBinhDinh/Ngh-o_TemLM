/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BomberMan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Win10
 */
public class mainRun extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLDocumentController.setLvTime(300);
        FXMLDocumentController.setLevel(0);
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
      
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getRoot().requestFocus();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
