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
    public static void main(String[] args) {
        launch(args);
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso s = new NumeroComplesso(2,1);
        NumeroComplesso s1 = new NumeroComplesso(0,0);
        NumeroComplesso l = s.rapporto(s1);
        System.out.println(l);
    }
    
}
