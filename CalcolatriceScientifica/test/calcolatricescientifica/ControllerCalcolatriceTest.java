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
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

/**
 *
 * @author simfe
 */
public class ControllerCalcolatriceTest extends ApplicationTest {

    Parent mainNode;
    Stage stage;
    private Variabili variabili = new Variabili();

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
        NumeroComplesso n = new NumeroComplesso(4, 6);
        textField.setText("+");
        clickOn("#bottoneEsegui");
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);

        //test differenza
        n = new NumeroComplesso(3, 4);
        textField.setText("1+2j");
        clickOn("#bottoneEsegui");
        textField.setText("-");
        clickOn("#bottoneEsegui");
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);

        //test prodotto
        n = new NumeroComplesso(-2, 14);
        textField.setText("2+2j");
        clickOn("#bottoneEsegui");
        textField.setText("*");
        clickOn("#bottoneEsegui");
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);

        //test rapporto
        n = new NumeroComplesso(3, 4);
        textField.setText("2+2j");
        clickOn("#bottoneEsegui");
        textField.setText("/");
        clickOn("#bottoneEsegui");
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);

        //test radice
        n = new NumeroComplesso(2, 1);
        textField.setText("sqrt");
        clickOn("#bottoneEsegui");
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);

        //test inversione segno
        n = new NumeroComplesso(-2, -1);
        textField.setText("+-");
        clickOn("#bottoneEsegui");
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);

        //test drop
        textField.setText("drop");
        clickOn("#bottoneEsegui");
        assertEquals(0, listview.getItems().size());

        //test swap
        textField.setText("2+3j");
        clickOn("#bottoneEsegui");
        textField.setText("1+1j");
        clickOn("#bottoneEsegui");
        n = new NumeroComplesso(2, 3);
        NumeroComplesso n2 = new NumeroComplesso(1, 1);
        textField.setText("swap");
        clickOn("#bottoneEsegui");
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);
        assertEquals(n2.parteReale(), listview.getItems().get(1).parteReale(), 0.1);
        assertEquals(n2.parteImmaginaria(), listview.getItems().get(1).parteImmaginaria(), 0.1);

        //test dup
        textField.setText("dup");
        clickOn("#bottoneEsegui");
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);
        assertEquals(n.parteReale(), listview.getItems().get(1).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(1).parteImmaginaria(), 0.1);
        assertEquals(n2.parteReale(), listview.getItems().get(2).parteReale(), 0.1);
        assertEquals(n2.parteImmaginaria(), listview.getItems().get(2).parteImmaginaria(), 0.1);

        //test over
        textField.setText("over");
        clickOn("#bottoneEsegui");
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);
        assertEquals(n.parteReale(), listview.getItems().get(1).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(1).parteImmaginaria(), 0.1);
        assertEquals(n.parteReale(), listview.getItems().get(2).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(2).parteImmaginaria(), 0.1);

        //test clear
        textField.setText("clear");
        clickOn("#bottoneEsegui");
        assertEquals(0, listview.getItems().size());

        //test arg
        textField.setText("2+3j");
        clickOn("#bottoneEsegui");
        textField.setText("arg");
        clickOn("#bottoneEsegui");
        n = new NumeroComplesso(0.98279, 0);
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.00001);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.00001);
        
        //test exp
        textField.setText("clear");
        clickOn("#bottoneEsegui");
        textField.setText("2+3j");
        clickOn("#bottoneEsegui");
        textField.setText("exp");
        clickOn("#bottoneEsegui");
        n = new NumeroComplesso(-7.31511, 1.04274);
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.00001);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.00001);
        
        //test >x, <x
        textField.setText("clear");
        clickOn("#bottoneEsegui");
        n = new NumeroComplesso(2, 4);
        textField.setText("2+4j");
        clickOn("#bottoneEsegui");
        textField.setText(">a");
        clickOn("#bottoneEsegui");
        textField.setText("drop");
        clickOn("#bottoneEsegui");
        textField.setText("<a");
        clickOn("#bottoneEsegui");
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);

        //test +x
        textField.setText("clear");
        clickOn("#bottoneEsegui");
        textField.setText("2+2j");
        clickOn("#bottoneEsegui");
        textField.setText(">a");
        clickOn("#bottoneEsegui");
        textField.setText("4+3j");
        clickOn("#bottoneEsegui");
        textField.setText("+a");
        clickOn("#bottoneEsegui");
        textField.setText("<a");
        clickOn("#bottoneEsegui");
        n = new NumeroComplesso(6, 5);
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);

        //test -x
        textField.setText("clear");
        clickOn("#bottoneEsegui");
        textField.setText("2+2j");
        clickOn("#bottoneEsegui");
        textField.setText(">a");
        clickOn("#bottoneEsegui");
        textField.setText("4+3j");
        clickOn("#bottoneEsegui");
        textField.setText("-a");
        clickOn("#bottoneEsegui");
        textField.setText("<a");
        clickOn("#bottoneEsegui");
        n = new NumeroComplesso(-2, -1);
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);

        //test input non valido
        textField.setText("clear");
        clickOn("#bottoneEsegui");
        textField.setText("clear++");
        clickOn("#bottoneEsegui");
        verifyThat("Input non valido", NodeMatchers.isVisible());
        clickOn("OK");

        //test eccezioni
        textField.setText("clear");
        clickOn("#bottoneEsegui");

        textField.setText("+");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");

        textField.setText("-");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");

        textField.setText("*");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");

        textField.setText("/");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("sqrt");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("+-");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("drop");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("dup");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("swap");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("over");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText(">a");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("+a");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("-a");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("<d");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("arg");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("exp");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        
        textField.setText("1+4j");
        clickOn("#bottoneEsegui");
        
        textField.setText("+");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("-");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("*");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("/");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("over");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("swap");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("+d");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
        
        textField.setText("-d");
        clickOn("#bottoneEsegui");
        verifyThat("L'operazione non può essere eseguita", NodeMatchers.isVisible());
        clickOn("OK");
    }
    
    @Test
    public void testInserisciNuovaOperazione(){
        ListView<NumeroComplesso> listview = (ListView<NumeroComplesso>) mainNode.lookup("#stackCalcolatrice");
        TextField tfdInput = (TextField) mainNode.lookup("#casellaDiTesto");
        TextField tfdNomeOperazione = (TextField) mainNode.lookup("#tfdNomeOperazione");
        TextField tfdAzioniOperazione = (TextField) mainNode.lookup("#tfdAzioniOperazione");
        
        tfdNomeOperazione.setText("triplaSomma");
        tfdAzioniOperazione.setText("+ + +");
        clickOn("#bottoneNuovaOperazione");
        
        tfdInput.setText("1+1j");
        clickOn("#bottoneEsegui");
        tfdInput.setText("1+1j");
        clickOn("#bottoneEsegui");
        tfdInput.setText("1+1j");
        clickOn("#bottoneEsegui");
        tfdInput.setText("1+1j");
        clickOn("#bottoneEsegui");
        
        tfdInput.setText("triplaSomma");
        clickOn("#bottoneEsegui");
        NumeroComplesso n = new NumeroComplesso(4,4);
        
        assertEquals(n.parteReale(), listview.getItems().get(0).parteReale(), 0.1);
        assertEquals(n.parteImmaginaria(), listview.getItems().get(0).parteImmaginaria(), 0.1);
        
        tfdNomeOperazione.setText("Operazione");
        tfdAzioniOperazione.setText("+ tr -");
        clickOn("#bottoneNuovaOperazione");
        verifyThat("Input non valido", NodeMatchers.isVisible());
        clickOn("OK");
    }
    
    
}
