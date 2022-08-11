/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author damia
 */
public class FXMLDocumentController_zaloguj implements Initializable {

    @FXML
    private AnchorPane zaloguj;

    @FXML
    private ImageView o_mnie;
    
    @FXML
    private TextField login;
    
    @FXML
    private PasswordField password;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void open_o_mnie(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_o_mnie.fxml"));
        zaloguj.getChildren().setAll(pane);
    }
    @FXML
    public void open_home(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument.fxml"));
        zaloguj.getChildren().setAll(pane);
    }
    @FXML
    public void open_uslugi(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_uslugi.fxml"));
        zaloguj.getChildren().setAll(pane);
    }
    @FXML
    public void open_koszyk(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_koszyk.fxml"));
        zaloguj.getChildren().setAll(pane);
    }
    @FXML
    public void open_zaloguj(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_zaloguj.fxml"));
        zaloguj.getChildren().setAll(pane);
    }
    
    
    //Logowanie
    @FXML
    public void log_me(ActionEvent event) throws IOException {
        
        String loginn = login.getText();
        String passwd = password.getText();
        
        if(loginn.equals("admin") && passwd.equals("admin")){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/FXMLDocument_admin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Admin Panel");
            stage.setScene(scene);
            stage.show();
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("B³¹d logowania");
                alert.setHeaderText(null);
                alert.setContentText("Wprowadzono nieprawid³owy login lub has³o. \nProszê o sprawdzenie poprawnoœci wpisanych danych i spróbowanie ponownie. ");
                alert.showAndWait();
                System.out.println(loginn);
                System.out.println(passwd);
        }
    }
    
   
    
}
