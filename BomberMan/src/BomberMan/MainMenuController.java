/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BomberMan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Win10
 */
public class MainMenuController implements Initializable {

    @FXML
    private Button newGame,highScores;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void NewGame(MouseEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("SelectLevel.fxml"));
        Scene s = new Scene(root);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();//lay thong tin cua so
        window.setScene(s);
        window.show();  
        s.getRoot().requestFocus();
    }
    @FXML
    private void enterNewGame(){
        newGame.setStyle("-fx-background-color: #321d04");
        newGame.setStyle("-fx-text-fill: red");
    }
    @FXML
    private void exitNewGame(){
        newGame.setStyle("-fx-background-color: #321d04");
        newGame.setStyle("-fx-text-fill: #ff8500d4");
    }
     @FXML
    private void enterHighScores(){
        highScores.setStyle("-fx-background-color: #faff00");
        highScores.setStyle("-fx-text-fill: red");
    }
    @FXML
    private void exitHighScores(){
        highScores.setStyle("-fx-background-color: #321d04");
        highScores.setStyle("-fx-text-fill: #ff8500d4");
    }
}
