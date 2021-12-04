package calcolatricescientifica;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stack = new StackNumeri();

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
        operazioni.put("arg", new CommandSwap(stack));
        operazioni.put("exp", new CommandOver(stack));

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
                invoker.esegui(command);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Input non valido");
                alert.showAndWait();
            }
        } else {
            oStack.setAll(stack.convertiInLista());
        }

        operazioni.clear();
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
        operazioni.put("arg", new CommandSwap(stack));
        operazioni.put("exp", new CommandOver(stack));
        oStack.setAll(stack.convertiInLista());

        casellaDiTesto.clear();

    }

    public boolean inserisciNumero(String input) {
        String[] s = new String[2];
        s[0] = ""; //stringa che conterrà parte reale o immaginaria dell'input
        s[1] = ""; //stringa che conterrà parte immaginaria o reale dell'input
        int indice = 0;
        int j = 0;
        String inputFormattato = input.replaceAll("\\s+", "");
//formati della stringa nel caso in cui sia composta prima dalla parte reale e poi dalla parte immaginaria
        String formato1 = "[+-]?[0-9]+[/.]?[0-9]*[+-][0-9]+[/.]?[0-9]*[ji]"; //formato corretto
        String formatonot11 = "[+-]?[0-9]+[/.][+-][0-9]+[/.]?[0-9]*[ji]"; //formato errato
        String formatonot12 = "[+-]?[0-9]+[/.]?[0-9]*[+-][0-9]+[/.][ji]"; //formato errato
//formati della stringa nel caso in cui sia composta prima dalla parte immaginaria e poi dalla parte reale
        String formato2 = "[+-]?[0-9]+[/.]?[0-9]*[ji][+-][0-9]+[/.]?[0-9]*"; //formato corretto
        String formatonot21 = "[+-]?[0-9]+[/.][ji][+-][0-9]+[/.]?[0-9]*"; //formato errato
        String formatonot22 = "[+-]?[0-9]+[/.]?[0-9]*[ji][+-][0-9]+[/.]"; //formato errato
//formati della stringa nel caso in cui sia composta solo dalla parte reale
        String formato3 = "[+-]?[0-9]+[/.]?[0-9]*"; //formato corretto
        String formatonot31 = "[+-]?[0-9]+[/.]"; //formato errato
//formati della stringa nel caso in cui sia composta solo dalla parte immaginaria
        String formato4 = "[+-]?[0-9]+[/.]?[0-9]*[ji]"; //formato corretto
        String formatonot41 = "[+-]?[0-9]+[/.][ji]"; //formato errato

        if (inputFormattato.matches(formato1) && !inputFormattato.matches(formatonot11) && !inputFormattato.matches(formatonot12)) {
            if (inputFormattato.charAt(0) == '-') { //controllo se il primo carattere è un - e nel caso lo aggiungo alla prima stringa
                s[indice] = s[indice] + inputFormattato.charAt(0);
                j++;
            }
            if (inputFormattato.charAt(0) == '+') { //controllo se il primo carattere è un + e nel caso lo salto
                j++;
            }
            for (; j < inputFormattato.length(); j++) {
                char c = inputFormattato.charAt(j);
                if (c != '+' && c != '-' && c != 'j' && c != 'i') {
                    s[indice] = s[indice] + c;
                }
                if (c == '+' || c == '-') {
                    indice++; //se il carattere è un + o un -, passo a riempire l'altra stringa
                }
            }
            this.stack.push(new NumeroComplesso(Double.parseDouble(s[0]), Double.parseDouble(s[1]))); //inserimento all'interno dello stack
            return true;
        } else if (inputFormattato.matches(formato2) && !inputFormattato.matches(formatonot21) && !inputFormattato.matches(formatonot22)) {
            if (inputFormattato.charAt(0) == '-') {
                s[indice] = s[indice] + inputFormattato.charAt(0);
                j++;
            }
            if (inputFormattato.charAt(0) == '+') {
                j++;
            }
            for (; j < inputFormattato.length(); j++) {
                char c = inputFormattato.charAt(j);
                if (c != '+' && c != '-' && c != 'j' && c != 'i') {
                    s[indice] = s[indice] + c;
                }
                if (c == '+' || c == '-') {
                    indice++;
                }
            }
            this.stack.push(new NumeroComplesso(Double.parseDouble(s[1]), Double.parseDouble(s[0])));
            return true;
        } else if (inputFormattato.matches(formato3) && !inputFormattato.matches(formatonot31)) {
            this.stack.push(new NumeroComplesso(Double.parseDouble(inputFormattato), 0));
            return true;
        } else if (inputFormattato.matches(formato4) && !inputFormattato.matches(formatonot41) || inputFormattato.equals("+j") || inputFormattato.equals("-j")) {
            if (inputFormattato.equals("+j")) {
                inputFormattato = "1";
            } else if (inputFormattato.equals("-j")) {
                inputFormattato = "-1";
            } else {
                inputFormattato = inputFormattato.replace("j", "");
            }
            this.stack.push(new NumeroComplesso(0, Double.parseDouble(inputFormattato)));
            return true;
        }
        return false;
    }

    private Command nuovoCommand(String input) {
        if (operazioni.containsKey(input)) {
            return (Command) operazioni.get(input);
        } else {
            return null;
        }
    }

    @FXML
    private void inserisciNuovaOperazione(ActionEvent event) {
    }
}
