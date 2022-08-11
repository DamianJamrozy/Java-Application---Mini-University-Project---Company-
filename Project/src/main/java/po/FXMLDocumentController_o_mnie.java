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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author damia
 */
public class FXMLDocumentController_o_mnie implements Initializable {

    @FXML
    private AnchorPane o_mnie;

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
        o_mnie.getChildren().setAll(pane);
    }
    @FXML
    public void open_home(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument.fxml"));
        o_mnie.getChildren().setAll(pane);
    }
    @FXML
    public void open_uslugi(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_uslugi.fxml"));
        o_mnie.getChildren().setAll(pane);
    }
    @FXML
    public void open_koszyk(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_koszyk.fxml"));
        o_mnie.getChildren().setAll(pane);
    }
    @FXML
    public void open_zaloguj(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_zaloguj.fxml"));
        o_mnie.getChildren().setAll(pane);
    }
    
}
