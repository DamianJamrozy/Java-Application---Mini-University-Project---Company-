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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author damia
 */
public class FXMLDocumentController_uslugi implements Initializable {

    @FXML
    private AnchorPane uslugi;

    @FXML
    private ImageView o_mnie;

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
        uslugi.getChildren().setAll(pane);
    }
    @FXML
    public void open_home(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument.fxml"));
        uslugi.getChildren().setAll(pane);
    }
    @FXML
    public void open_uslugi(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_uslugi.fxml"));
        uslugi.getChildren().setAll(pane);
    }
    @FXML
    public void open_koszyk(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_koszyk.fxml"));
        uslugi.getChildren().setAll(pane);
    }
    @FXML
    public void open_zaloguj(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_zaloguj.fxml"));
        uslugi.getChildren().setAll(pane);
    }
    
}
