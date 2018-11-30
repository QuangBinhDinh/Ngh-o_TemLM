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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Win10
 */
public class SelectLevelController implements Initializable {

    @FXML
    private Rectangle Rect1,Rect2,Rect3;
    @FXML
    private Label Label1,Label2,Label3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void Level1(MouseEvent e) throws IOException{
        FXMLDocumentController.setLevel(0);
        FXMLDocumentController.setLvTime(300);
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));//lay thong tin file fxml
        Scene s = new Scene(root);//tao moi scene theo thong tin file fxml
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();//lay thong tin cua so
        window.setScene(s);//dat sence vao trong cua so
        window.show(); 
        s.getRoot().requestFocus();
    }
    @FXML
    private void Level2(MouseEvent e) throws IOException{
        FXMLDocumentController.setLevel(1);
        FXMLDocumentController.setLvTime(240);
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));//lay thong tin file fxml
        Scene s = new Scene(root);//tao moi scene theo thong tin file fxml
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();//lay thong tin cua so
        window.setScene(s);//dat sence vao trong cua so
        window.show(); 
        s.getRoot().requestFocus();
    }
    @FXML
    private void Level3(MouseEvent e) throws IOException{
        FXMLDocumentController.setLevel(2);
        FXMLDocumentController.setLvTime(210);
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));//lay thong tin file fxml
        Scene s = new Scene(root);//tao moi scene theo thong tin file fxml
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();//lay thong tin cua so
        window.setScene(s);//dat sence vao trong cua so
        window.show(); 
        s.getRoot().requestFocus();
    }
    @FXML
    private void enterLv1(){
        Rect1.setVisible(true);
        Label1.setStyle("-fx-text-fill: #f600ff");
    }
    @FXML
    private void exitLv1(){
        Rect1.setVisible(false);
        Label1.setStyle("-fx-text-fill: #d3f018");
    }
    @FXML
    private void enterLv2(){
        Rect2.setVisible(true);
        Label2.setStyle("-fx-text-fill: #f600ff");
    }
    @FXML
    private void exitLv2(){
        Rect2.setVisible(false);
        Label2.setStyle("-fx-text-fill: #d3f018");
    }
    @FXML
    private void enterLv3(){
        Rect3.setVisible(true);
        Label3.setStyle("-fx-text-fill: #f600ff");
    }
    @FXML
    private void exitLv3(){
        Rect3.setVisible(false);
        Label3.setStyle("-fx-text-fill: #d3f018");
    }
}
