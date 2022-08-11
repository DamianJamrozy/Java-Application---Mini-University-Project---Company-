/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;

import Encje.Klient;
import Encje.Usluga;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author damia
 */



public class FXMLDocumentController_koszyk implements Initializable {
    
    baza db = new baza();
    
    @FXML
    private AnchorPane koszyk;
    
    
    @FXML
    private TextField imie;
    @FXML
    private TextField nazwisko;
    @FXML
    private TextField telefon;
    @FXML
    private TextField email;
    
    @FXML
     private ComboBox<String> graf;

    public void fillbox1() {
        graf.getItems().clear();
        graf.getItems().add("1-3");
        graf.getItems().add("4-7");
        graf.getItems().add("8-10");
        graf.getItems().add("WiÍcej");
    }
    @FXML
    private CheckBox g1;
    @FXML
    private CheckBox g2;
    @FXML
    private CheckBox g3;
    @FXML
    private CheckBox g4;
  
    
    @FXML
     private ComboBox<String> sido;

    public void fillbox2() {
        sido.getItems().clear();
        sido.getItems().add("WizytÛwka");
        sido.getItems().add("Blog");
        sido.getItems().add("Sklep");
        sido.getItems().add("Inna");
    }
    
    @FXML
     private ComboBox<String> sids;

    public void fillbox3() {
        sids.getItems().clear();
        sids.getItems().add("One Page Side");
        sids.getItems().add("1-3");
        sids.getItems().add("4-7");
        sids.getItems().add("8-10");
        sids.getItems().add("WiÍcej");
    }
    @FXML
    private CheckBox s1;
    @FXML
    private CheckBox s2;
    @FXML
    private CheckBox s3;
    @FXML
    private CheckBox s4;
  
    
    @FXML
     private ComboBox<String> appm;

    public void fillbox4() {
        appm.getItems().clear();
        appm.getItems().add("One Page App");
        appm.getItems().add("1-3");
        appm.getItems().add("4-7");
        appm.getItems().add("8-10");
        appm.getItems().add("WiÍcej");
    }
    @FXML
    private CheckBox m1;
    @FXML
    private CheckBox m2;
    @FXML
    private CheckBox m3;
    @FXML
    private CheckBox m4;
  
    double suma1;
    double suma2;
    double suma3;
    double rabat;
    double przed_rabatem;
    double kwota_rabatu;
    double po_rabacie;
   
    @FXML
    private Label cena1;
    @FXML
    private Label cena2;
    @FXML
    private Label cena3;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        db.connectToDb();
        fillbox1();
        fillbox2();
        fillbox3();
        fillbox4();
    }    

    @FXML
    public void open_o_mnie(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_o_mnie.fxml"));
        koszyk.getChildren().setAll(pane);
    }
    @FXML
    public void open_home(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument.fxml"));
        koszyk.getChildren().setAll(pane);
    }
    @FXML
    public void open_uslugi(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_uslugi.fxml"));
        koszyk.getChildren().setAll(pane);
    }
    @FXML
    public void open_koszyk(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_koszyk.fxml"));
        koszyk.getChildren().setAll(pane);
    }
    @FXML
    public void open_zaloguj(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXMLDocument_zaloguj.fxml"));
        koszyk.getChildren().setAll(pane);
    }
    
    
    //Grafika Komputerowa
    @FXML
    public void sum1(ActionEvent event) throws IOException {
        String grafika = graf.getValue();
        suma1 = 0;
        System.out.println(grafika);
        
        if(grafika.equals("1-3")){
            suma1=200;
        }
        else if(grafika.equals("4-7")){
            suma1=400;
        }
        else if(grafika.equals("8-10")){
            suma1=600;
        }
        else if(grafika.equals("WiÍcej")){
            suma1=900;
        }
        else{
            suma1=0;
        }
        System.out.println(suma1);
        
        
        if(g1.isSelected()){
            suma1+=50;
        }
        if(g2.isSelected()){
            suma1+=500;
        }
        if(g3.isSelected()){
            suma1+=50;
        }
        if(g4.isSelected()){
            suma1+=100;
        }
        System.out.println(suma1);
        
        String nazwa1 = ""+suma1;
        
        cena1.setText(nazwa1);
     
        
    }
    // Strona Internetowa
    @FXML
    public void sum2(ActionEvent event) throws IOException {
        String web1 = sido.getValue();
        String web2 = sids.getValue();
        suma2 = 0;
        
        // Typ Strony
        System.out.println(web1);
        
        if(web1.equals("WizytÛwka")){
            suma2=800;
        }
        else if(web1.equals("Blog")){
            suma2=1000;
        }
        else if(web1.equals("Sklep")){
            suma2=1500;
        }
        else if(web1.equals("Inna")){
            suma2=2000;
        }
        else{
            suma2=0;
        }
        System.out.println(suma2);
        
        
        // Ilo≈õƒá Podstron
        System.out.println(web2);
        
        if(web2.equals("One Page Side")){
            suma2+=0;
        }
        else if(web2.equals("1-3")){
            suma2+=50;
        }
        else if(web2.equals("4-7")){
            suma2+=150;
        }
        else if(web2.equals("8-10")){
            suma2+=300;
        }
        else if(web2.equals("WiÍcej")){
            suma2+=700;
        }
        else{
            suma2=0;
        }
        System.out.println(suma2);
        
        if(s1.isSelected()){
            suma2+=400;
        }
        if(s2.isSelected()){
            suma2+=50;
        }
        if(s3.isSelected()){
            suma2+=1000;
        }
        if(s4.isSelected()){
            suma2+=500;
        }
        System.out.println(suma2);
        
        String nazwa2 = ""+suma2;
        
        cena2.setText(nazwa2);
        
    }
    //Aplikacja Mobilna
    @FXML
    public void sum3(ActionEvent event) throws IOException {
        String mobile = appm.getValue();
        suma3 = 0;
        
        if(mobile.equals("One Page App")){
            suma3=5000;
        }
        else if(mobile.equals("1-3")){
            suma3=5500;
        }
        else if(mobile.equals("4-7")){
            suma3=8000;
        }
        else if(mobile.equals("8-10")){
            suma3=10000;
        }
        else if(mobile.equals("WiÍcej")){
            suma3=20000;
        }
        else{
            suma3=0;
        }
        System.out.println(suma3);
        
        
        if(m1.isSelected()){
            suma3+=8000;
        }
        if(m2.isSelected()){
            suma3+=10000;
        }
        if(m3.isSelected()){
            suma3+=1500;
        }
        if(m4.isSelected()){
            suma3+=3000;
        }
        System.out.println(suma3);
        
        String nazwa3 = ""+suma3;
        
        cena3.setText(nazwa3);
    }
    
    
        
    @FXML
    public void submit(ActionEvent event) throws IOException {
        rabat=0;
        przed_rabatem=0;
        kwota_rabatu=0;   
        po_rabacie=0;
        if(suma1>0){
            rabat+=0.10;
        }
        if(suma2>0){
            rabat+=0.10;
        }
        if(suma3>0){
            rabat+=0.10;
        }
        rabat-=0.10; // Rabat w %
        przed_rabatem=suma1+suma2+suma3; //Suma przed rabatem
        kwota_rabatu=przed_rabatem*rabat; //Kwota udzielonego rabatu
        po_rabacie=przed_rabatem-kwota_rabatu; // Suma do zap≥aty
        System.out.println("Rabat wynius≥Ç "+rabat*100+"%.");
        System.out.println("Przed rabatem do zap≥aty "+przed_rabatem+" PLN.");
        System.out.println("Po rabacie do zap≥aty "+po_rabacie+" PLN.");
        
        
        // Pobieram wartoúci
        String imie_klienta = imie.getText();
        String nazwisko_klienta = nazwisko.getText();
        String telefon_klienta = telefon.getText();
        String email_klienta = email.getText();
        
        // Walidacja wstÍpna nr. telefonu
        telefon.focusedProperty().addListener((arg1, oldValue1, newValue1) -> {
        if (!newValue1) {
            if(!telefon.getText().matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")){
                telefon.setText("");
                Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("B£•D");
                alert1.setHeaderText(null);
                alert1.setContentText("Wprowadzono nieprawid≥owy format numeru telefonu");

                alert1.showAndWait();
            }
        }

        });
        // Walidacja wstÍpna imienia
        imie.focusedProperty().addListener((arg2, oldValue2, newValue2) -> {
        if (!newValue2) {
            if(!imie.getText().matches("[a-zA-ZπÊÍ≥ÒÛúüø• £—”åèØ]+")){
                imie.setText("");
                Alert alert2 = new Alert(AlertType.INFORMATION);
                alert2.setTitle("B£•D");
                alert2.setHeaderText(null);
                alert2.setContentText("Wprowadzono nieprawid≥owy format imienia");

                alert2.showAndWait();
            }
        }

        });
        // Walidacja wstÍpna nazwiska
        nazwisko.focusedProperty().addListener((arg3, oldValue3, newValue3) -> {
        if (!newValue3) {
            if(!nazwisko.getText().matches("[a-zA-ZπÊÍ≥ÒÛúüø• £—”åèØ]+")){
                nazwisko.setText("");
                Alert alert3 = new Alert(AlertType.INFORMATION);
                alert3.setTitle("B£•D");
                alert3.setHeaderText(null);
                alert3.setContentText("Wprowadzono nieprawid≥owy format nazwiska");

                alert3.showAndWait();
            }
        }

        });
         // Walidacja wstÍpna e-maila
        email.focusedProperty().addListener((arg4, oldValue4, newValue4) -> {
        if (!newValue4) {
            if(!email.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")){
                email.setText("");
                Alert alert4 = new Alert(AlertType.INFORMATION);
                alert4.setTitle("B£•D");
                alert4.setHeaderText(null);
                alert4.setContentText("Wprowadzono nieprawid≥owy format adresu e-mail");

                alert4.showAndWait();
            }
        }

        });
        
        
        //Sprawdzanie czy dane zosta≥y wpisane oraz sprawdzamy jeszcze raz ich poprawnoúÊ - jak wszystko ok to dodajemy do bazy danych
        if(imie_klienta.equals("")){
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("B£•D");
                alert.setHeaderText("Brak imienia!");
                alert.setContentText("Aby z≥oøyÊ zamÛwienie uzupe≥nij wymagane pola.");
                alert.showAndWait();
        }
        else if(!imie.getText().matches("[a-zA-ZπÊÍ≥ÒÛúüø• £—”åèØ]+")){
            imie.setText("");
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("B£•D");
                alert.setHeaderText("Niepoprawny format imienia!");
                alert.setContentText("Aby z≥oøyÊ zamÛwienie uzupe≥nij wymagane pola.");
                alert.showAndWait();
        }
        else if(nazwisko_klienta.equals("")){
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("B£•D");
                alert.setHeaderText("Brak nazwiska!");
                alert.setContentText("Aby z≥oøyÊ zamÛwienie uzupe≥nij wymagane pola.");
                alert.showAndWait();
        }
        else if(!nazwisko.getText().matches("[a-zA-ZπÊÍ≥ÒÛúüø• £—”åèØ]+")){
            nazwisko.setText("");
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("B£•D");
                alert.setHeaderText("Niepoprawny format nazwiska!");
                alert.setContentText("Aby z≥oøyÊ zamÛwienie uzupe≥nij wymagane pola.");
                alert.showAndWait();
        }
        else if(telefon_klienta.equals("")){
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("B£•D");
                alert.setHeaderText("Brak numeru telefonu!");
                alert.setContentText("Aby z≥oøyÊ zamÛwienie uzupe≥nij wymagane pola.");
                alert.showAndWait();
        }
        else if(!telefon.getText().matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")){
            telefon.setText("");
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("B£•D");
                alert.setHeaderText("Niepoprawny format numeru telefonu!");
                alert.setContentText("Aby z≥oøyÊ zamÛwienie uzupe≥nij wymagane pola.\nNumer telefonu powinien sk≥adaÊ siÍ z 9 cyfr.");
                alert.showAndWait();
        }
        else if(email_klienta.equals("")){
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("B£•D");
                alert.setHeaderText("Brak emaila!");
                alert.setContentText("Aby z≥oøyÊ zamÛwienie uzupe≥nij wymagane pola.");
                alert.showAndWait();
        }
        else if(!email.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")){
            email.setText("");
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("B£•D");
                alert.setHeaderText("Niepoprawny format adresu email!");
                alert.setContentText("Aby z≥oøyÊ zamÛwienie uzupe≥nij wymagane pola.\nPrzyk≥adowy email: example@email.pl");
                alert.showAndWait();
        }
        else{
            if(rabat<0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Twoje zamÛwienie jest puste...\nDodaj coÊ do zamÛwienia, a nastÍpnie potwierdü je w celu przejúcia dalej.", ButtonType.YES, ButtonType.NO);
                alert.setTitle("Pusty koszyk");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
            else{
                int i=(int)(rabat*100);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Jesteú pewny , øe chcesz dokonaÊ wstÍpnego zamÛwienia?\nPrzy tym zamÛwieniu otrzymasz rabat w wysokoúci "+i+"%.\nPo rabacie do zap≥aty "+po_rabacie+" PLN.", ButtonType.YES, ButtonType.NO);
                alert.setTitle("Potwierdzenie");
                alert.setHeaderText(null);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                    Usluga us = db.InsertUsl(suma1, suma2, suma3, po_rabacie);
                    Klient kl = db.InsertOs(imie_klienta, nazwisko_klienta, email_klienta, Integer.parseInt(telefon_klienta), us.getIdUslugi());
                    db.InsertZam(kl.getIdKlienta(), us.getIdUslugi(), (int)(rabat*100));
                    Alert alertend = new Alert(AlertType.INFORMATION);
                    alertend.setTitle("Potwierdzenie");
                    alertend.setHeaderText("Gratulacje!");
                    alertend.setContentText("Z≥oøy≥eú/aú wstÍpne zamÛwienie na nasze us≥ugi.\nNied≥ugo ktoú z naszej firmy skontaktuje siÍ z Tobπ w celu ustalenia szczegÛ≥Ûw.");
                    alertend.showAndWait();
                   
                }
            }
        }
    }
}
