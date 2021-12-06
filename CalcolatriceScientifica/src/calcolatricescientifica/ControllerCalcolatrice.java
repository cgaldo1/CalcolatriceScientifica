package calcolatricescientifica;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    @FXML
    private Button bottoneNuovaOperazione;

    private Map<String, Command> operazioni;
    @FXML
    private TextField tfdNomeOperazione;
    @FXML
    private TextField tfdAzioniOperazione;

    private Variabili variabili;

    private char var;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stack = new StackNumeri();
        variabili = new Variabili();

        operazioni = new HashMap<>();
        operazioni.put("+", new CommandSomma(stack));
        operazioni.put("-", new CommandSottrazione(stack));
        operazioni.put("*", new CommandProdotto(stack));
        operazioni.put("/", new CommandRapporto(stack));
        operazioni.put("sqrt", new CommandRadice(stack));
        operazioni.put("+-", new CommandInversioneSegno(stack));
        operazioni.put("drop", new CommandDrop(stack));
        operazioni.put("dup", new CommandDup(stack));
        operazioni.put("clear", new CommandClear(stack));
        operazioni.put("swap", new CommandSwap(stack));
        operazioni.put("over", new CommandOver(stack));
        operazioni.put("arg", new CommandArg(stack));
        operazioni.put("exp", new CommandExp(stack));

        oStack = FXCollections.observableArrayList();

        stackCalcolatrice.setItems(oStack);

    }

    @FXML
    private void esegui(ActionEvent event) {

        String input = casellaDiTesto.getText();
        if (inserisciNumero(input) == false) {
            Invoker invoker = new Invoker();
            Command command = nuovoCommand(input);
            if (command != null) {
                try {
                    invoker.esegui(command);
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "L'operazione non può essere eseguita");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Input non valido");
                alert.showAndWait();
            }
        } else {
            oStack.setAll(stack.convertiInLista());
        }

        operazioni.replace("+", new CommandSomma(stack));
        operazioni.replace("-", new CommandSottrazione(stack));
        operazioni.replace("*", new CommandProdotto(stack));
        operazioni.replace("/", new CommandRapporto(stack));
        operazioni.replace("sqrt", new CommandRadice(stack));
        operazioni.replace("+-", new CommandInversioneSegno(stack));
        operazioni.replace("drop", new CommandDrop(stack));
        operazioni.replace("dup", new CommandDup(stack));
        operazioni.replace("clear", new CommandClear(stack));
        operazioni.replace("swap", new CommandSwap(stack));
        operazioni.replace("over", new CommandOver(stack));
        operazioni.replace("arg", new CommandArg(stack));
        operazioni.replace("exp", new CommandExp(stack));
        oStack.setAll(stack.convertiInLista());

        casellaDiTesto.clear();

    }

    private Command nuovoCommand(String input) {
        if (operazioni.containsKey(input)) {
            return (Command) operazioni.get(input);
        }
        if (input.length() == 2 && input.charAt(0) == '>' && input.charAt(1) >= 'a' && input.charAt(1) <= 'z') {
            return new CommandInserisciInVariabile(variabili, input.charAt(1), stack);
        }
        if (input.length() == 2 && input.charAt(0) == '<' && input.charAt(1) >= 'a' && input.charAt(1) <= 'z') {
            return new CommandInserisciInStack(variabili, input.charAt(1), stack);
        }
        if (input.length() == 2 && input.charAt(0) == '+' && input.charAt(1) >= 'a' && input.charAt(1) <= 'z') {
            return new CommandSommaVariabili(variabili, input.charAt(1), stack);
        }
        if (input.length() == 2 && input.charAt(0) == '-' && input.charAt(1) >= 'a' && input.charAt(1) <= 'z') {
            return new CommandSottrazioneVariabili(variabili, input.charAt(1), stack);
        }
        return null;
    }

    @FXML
    private void inserisciNuovaOperazione(ActionEvent event) {
        String azioniOperazione = tfdAzioniOperazione.getText();
        String[] azioni = azioniOperazione.split(" ");
        OperazioneUtenteMacroCommand operazioneUtente = new OperazioneUtenteMacroCommand();

        for (String string : azioni) {
            Command command = nuovoCommand(string);
            if (command != null) {
                operazioneUtente.aggiungi(command);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Input non valido");
                alert.showAndWait();
                break;
            }
        }

        operazioni.put(tfdNomeOperazione.getText(), operazioneUtente);
    }
}
