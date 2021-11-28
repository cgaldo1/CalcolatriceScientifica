/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package calcolatricescientifica;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author simfe
 */
public class ControllerCalcolatrice implements Initializable {

    @FXML
    private TextField casellaDiTesto;
    @FXML
    private ListView<NumeroComplesso> stackCalcolatrice;

    private ObservableList<NumeroComplesso> oStack;

    private StackNumeri stack;
    @FXML
    private Button bottoneEsegui;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stack = new StackNumeri();
        oStack = FXCollections.observableArrayList();

        stackCalcolatrice.setItems(oStack);
        // TODO
    }

    @FXML
    private void esegui(ActionEvent event) {
        String input = casellaDiTesto.getText();
        GestoreInput gestore = new GestoreInput();

        //stack.push(new NumeroComplesso(3,3));
        //stack.push(new NumeroComplesso(1,1));
        StackNumeri nuovoStack = gestore.controlloSeNumero(input, stack);
        if (nuovoStack == null) {
            try {
                nuovoStack = gestore.controllaSeOperazione(input, stack);
                if (nuovoStack == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Input non valido");
                    
                    alert.showAndWait();
                } else {
                    stack = nuovoStack;
                    oStack.setAll(stack.convertiInLista());
                }
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Non è possibile eseguire l'operazione");
                alert.showAndWait();
            }
        } else {
            stack = nuovoStack;
            oStack.setAll(stack.convertiInLista());
        }
        casellaDiTesto.clear();
    }

}
