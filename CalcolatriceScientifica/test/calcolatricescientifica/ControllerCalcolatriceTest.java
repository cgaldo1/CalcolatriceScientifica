/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

import com.sun.javaws.Main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.testfx.framework.junit.ApplicationTest;

/**
 *
 * @author simfe
 */
public class ControllerCalcolatriceTest extends ApplicationTest {

    Parent mainNode;
    Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("FXMLCalcolatrice.fxml"));
        mainNode = (AnchorPane) loader.load();
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void testEsegui() {

        //javaFX operations should go here
        ListView<NumeroComplesso> listview = (ListView<NumeroComplesso>) mainNode.lookup("#stackCalcolatrice");
        TextField textField = (TextField) mainNode.lookup("#casellaDiTesto");
        StackNumeri stackAppoggio = new StackNumeri();

        textField.setText("3+5j");

        StackNumeri stack = new StackNumeri();

        stack.push(new NumeroComplesso(3, 5));
        clickOn("#bottoneEsegui");
        assertEquals(listview.getItems().toString(), stack.toString());

        stack.push(new NumeroComplesso(1, 1));
        textField.setText("1+1j");
        clickOn("#bottoneEsegui");
        for (int i = 1; i >= 0; i--) {
            stackAppoggio.push(listview.getItems().get(i));
        }
        assertEquals(stackAppoggio.toString(), stack.toString());

        //test somma
        stack.push(new NumeroComplesso(4, 6));
        textField.setText("+");
        clickOn("#bottoneEsegui");
        stackAppoggio.push(listview.getItems().get(0));
        assertEquals(stackAppoggio.toString(), stack.toString());

        //test differenza
        stack.push(new NumeroComplesso(-3, -5));
        textField.setText("-");
        clickOn("#bottoneEsegui");
        stackAppoggio.push(listview.getItems().get(0));
        assertEquals(stackAppoggio.toString(), stack.toString());

        //test prodotto
        stack.push(new NumeroComplesso(18, -38));
        textField.setText("*");
        clickOn("#bottoneEsegui");
        stackAppoggio.push(listview.getItems().get(0));
        assertEquals(stackAppoggio.toString(), stack.toString());

        //test rapporto
        stack.push(new NumeroComplesso(0.07692307692307691, -0.11538461538461536));
        textField.setText("/");
        clickOn("#bottoneEsegui");
        stackAppoggio.push(listview.getItems().get(0));
        assertEquals(stackAppoggio.toString(), stack.toString());

        //test radice
        stack.push(new NumeroComplesso(0.3283276762469044, -0.17571563978944835));
        textField.setText("sqrt");
        clickOn("#bottoneEsegui");
        stackAppoggio.push(listview.getItems().get(0));
        assertEquals(stackAppoggio.toString(), stack.toString());

        //test inversione segno
        stack.push(new NumeroComplesso(-0.3283276762469044, +0.17571563978944835));
        textField.setText("+-");
        clickOn("#bottoneEsegui");
        stackAppoggio.push(listview.getItems().get(0));
        assertEquals(stackAppoggio.toString(), stack.toString());
        
        //test drop
        stack.drop();
        textField.setText("drop");
        clickOn("#bottoneEsegui");
        stackAppoggio.clear();
        for(int i=6; i>=0;i--){
            stackAppoggio.push(listview.getItems().get(i));
        }
        assertEquals(stackAppoggio.toString(), stack.toString());
        
        //test swap
        try {
            stack.swap();
        } catch (Exception ex) {
            Logger.getLogger(ControllerCalcolatriceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        textField.setText("swap");
        clickOn("#bottoneEsegui");
        stackAppoggio.clear();
        for(int i=6; i>=0;i--){
            stackAppoggio.push(listview.getItems().get(i));
        }
        assertEquals(stackAppoggio.toString(), stack.toString());
        
        //test dup
        try {
            stack.dup();
        } catch (Exception ex) {
            Logger.getLogger(ControllerCalcolatriceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        textField.setText("dup");
        clickOn("#bottoneEsegui");
        stackAppoggio.clear();
        for(int i=7; i>=0;i--){
            stackAppoggio.push(listview.getItems().get(i));
        }
        assertEquals(stackAppoggio.toString(), stack.toString());
        
        //test over
        try {
            stack.over();
        } catch (Exception ex) {
            Logger.getLogger(ControllerCalcolatriceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        textField.setText("over");
        clickOn("#bottoneEsegui");
        stackAppoggio.clear();
        for(int i=8; i>=0;i--){
            stackAppoggio.push(listview.getItems().get(i));
        }
        assertEquals(stackAppoggio.toString(), stack.toString());
        

        //test clear
        try {
            stack.clear();
        } catch (Exception ex) {
            Logger.getLogger(ControllerCalcolatriceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        textField.setText("clear");
        clickOn("#bottoneEsegui");
        assertEquals(listview.getItems().toString(), stack.toString());
        
        //test input non valido
        stack.push(new NumeroComplesso(1,1));
        textField.setText("1+1j");
        clickOn("#bottoneEsegui");
        textField.setText("clear++");
        clickOn("#bottoneEsegui");
        stackAppoggio.clear();
        assertEquals(listview.getItems().toString(), stack.toString());
        
    }

}
