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
import javafx.scene.image.Image;
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
        stage.getIcons().add(new Image(CalcolatriceScientifica.class.getResourceAsStream( "calcolatrice.png" )));
        stage.setScene(scene);
        stage.setTitle("Calcolatrice scientifica");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    
}
