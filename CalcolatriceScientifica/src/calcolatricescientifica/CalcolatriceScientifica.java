/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package calcolatricescientifica;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.Global.Infinity;

/**
 *
 * @author simfe
 */
public class CalcolatriceScientifica extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCalcolatrice.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        launch(args);
        
       /* StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,2);
        NumeroComplesso n1 = new NumeroComplesso(2,2);
        NumeroComplesso n2 = new NumeroComplesso(4,2);
        s.push(n);
        s.push(n1);
        s.push(n2);
        ArrayVariabili arr = new ArrayVariabili();
        arr.inserisci(n, arr.indice('a'));
        arr.inserisci(n1, arr.indice('c'));
        arr.inserisci(n2, arr.indice('f'));
        arr.stampa();
        arr.inserisciInStack(s, 'f');
        System.out.println(s.toString());
        arr.sommaVariabile(s, 'f');
        arr.stampa();
        arr.sottrazioneVariabile(s, 'a');
        arr.stampa();*/
    }
    
}
