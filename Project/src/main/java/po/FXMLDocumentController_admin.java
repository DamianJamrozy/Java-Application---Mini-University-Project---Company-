/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;

import Encje.Klient;
import Encje.Usluga;
import Encje.Zamowienie;
import Help.TableV;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author damia
 */

public class FXMLDocumentController_admin implements Initializable {
    
    baza db = new baza();
    
    final ObservableList<TableV> dane = FXCollections.observableArrayList();

    //Przyciski i ogólne
    @FXML
    private AnchorPane zaloguj;
    @FXML
    private ComboBox<Integer> id_zam_edit;
    @FXML
    private ComboBox<String> status;
    @FXML
    private ComboBox<Integer> id_zam_delete;

    
    
    // Uzupe³nienie statusu
    public void fillbox_stats() {
       status.getItems().clear();
       status.getItems().add("Oczekuje na kontakt");
       status.getItems().add("Oczekuje na wp³atê");
       status.getItems().add("Tworzenie");
       status.getItems().add("Testowanie");
       status.getItems().add("Zawieszone");
       status.getItems().add("Gotowe");
    }
    
    // Tabela
    @FXML
    private TableView<TableV> table;
    @FXML
    private TableColumn<?, ?> idZam1;
    @FXML
    private TableColumn<?, ?> grap1;
    @FXML
    private TableColumn<?, ?> web1;
    @FXML
    private TableColumn<?, ?> app1;
    @FXML
    private TableColumn<?, ?> cena1;
    @FXML
    private TableColumn<?, ?> imie1;
    @FXML
    private TableColumn<?, ?> nazwisko1;
    @FXML
    private TableColumn<?, ?> tel1;
    @FXML
    private TableColumn<?, ?> email1;
    @FXML
    private TableColumn<?, ?> statustab1;
    
    
    // Uzupe³nienei tabeli
    public void fillTable(){
        idZam1.setCellValueFactory(new PropertyValueFactory("id_zam1"));
        grap1.setCellValueFactory(new PropertyValueFactory("graf1"));
        web1.setCellValueFactory(new PropertyValueFactory("web1"));
        app1.setCellValueFactory(new PropertyValueFactory("app1"));
        cena1.setCellValueFactory(new PropertyValueFactory("cena1"));
        imie1.setCellValueFactory(new PropertyValueFactory("imie1"));
        nazwisko1.setCellValueFactory(new PropertyValueFactory("nazwisko1"));
        tel1.setCellValueFactory(new PropertyValueFactory("tel1"));
        email1.setCellValueFactory(new PropertyValueFactory("email1"));
        statustab1.setCellValueFactory(new PropertyValueFactory("status1"));
    }
    
    // Uzupe³nienie tabeli
    public void setTable(){
       table.getItems().clear();

       List<Object[]> arr = db.SelectToTable();

       for(Object[] ar: arr){
           dane.add(new TableV(Arrays.asList(ar).get(0).toString(),Arrays.asList(ar).get(1).toString(),Arrays.asList(ar).get(2).toString(),Arrays.asList(ar).get(3).toString(),Arrays.asList(ar).get(4).toString(),Arrays.asList(ar).get(5).toString(),Arrays.asList(ar).get(6).toString(),Arrays.asList(ar).get(7).toString(),Arrays.asList(ar).get(8).toString(),Arrays.asList(ar).get(9).toString()));
       }
       arr.clear();
       table.setItems(dane);

   }

    

    // Uzupe³nienie id_zamówienia - edycja
    public void fillComboBox1(){
        id_zam_edit.getItems().clear();

        List<Integer> arr = db.getId();

        for (int i = 0; i < arr.size(); i++) {
            id_zam_edit.getItems().addAll(arr.get(i));
        }

    }

    // Uzupe³nienie id_zamówienia - anulowanie
    public void fillComboBox2(){
        id_zam_delete.getItems().clear();

        List<Integer> arr = db.getId();

        for (int i = 0; i < arr.size(); i++) {
            id_zam_delete.getItems().addAll(arr.get(i));
        }

    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        db.connectToDb();
        fillbox_stats();
        fillComboBox1();
        fillComboBox2();
        fillTable();
        setTable();
        
    }    
    
 
    //Edytowanie zamówienia
    public void change(ActionEvent event) throws IOException {
        int id_edit = id_zam_edit.getValue();
        String stats = status.getValue();
        
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Jesteœ pewny , ¿e chcesz zmieniæ satus zamówienia o id "+id_edit+" na "+stats+"?", ButtonType.YES, ButtonType.NO);
                alert.setTitle("Potwierdzenie zmiany statusu");
                alert.setHeaderText(null);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                    Alert alertend = new Alert(Alert.AlertType.INFORMATION);
                    alertend.setTitle("Potwierdzenie");
                    alertend.setHeaderText("Edytowano.");
                    alertend.setContentText("Status wybranego zamówienia zosta³o zmienione na."+stats+".");
                    alertend.showAndWait();
                   
                    db.Edit(id_edit,stats);
                    setTable();
                    
                }
        
    }
    
    // Usuwanie zamówienia
    public void del(){
        int id_del = id_zam_delete.getValue();
        
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Jesteœ pewny , ¿e chcesz anulowaæ zamówienie o id "+id_del+"?", ButtonType.YES, ButtonType.NO);
                alert.setTitle("Potwierdzenie usuwania");
                alert.setHeaderText(null);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                    Alert alertend = new Alert(Alert.AlertType.INFORMATION);
                    alertend.setTitle("Potwierdzenie");
                    alertend.setHeaderText("Anulowano.");
                    alertend.setContentText("Wybrane zamówienie zosta³o anulowane.");
                    alertend.showAndWait();
                   
                    db.Delete(id_del);
                    setTable();
                    
                }
    }
    
}
