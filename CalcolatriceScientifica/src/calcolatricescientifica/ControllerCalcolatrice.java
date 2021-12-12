package calcolatricescientifica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.stage.FileChooser;
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

    private Map<String, Command> operazioniUtente;
    @FXML
    private TextField tfdNomeOperazione;
    @FXML
    private TextField tfdAzioniOperazione;

    private Variabili variabili;

    private StackVariabili stackVariabili;

    private char var;

    @FXML
    private Button BottoneEliminaOperazione;
    @FXML
    private Button bottoneModificaOperazione;
    @FXML
    private Button bottoneSalvaOperazioni;
    @FXML
    private Button bottoneCaricaOperazioni;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stack = new StackNumeri();
        variabili = new Variabili();
        stackVariabili = new StackVariabili();

        //popolo hash map con le operazioni di base della calcolatrice
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
        operazioni.put("pow", new CommandPow(stack));
        operazioni.put("atan", new CommandAtan(stack));
        operazioni.put("tan", new CommandTan(stack));
        operazioni.put("asin", new CommandAsin(stack));
        operazioni.put("acos", new CommandAcos(stack));
        operazioni.put("sin", new CommandSin(stack));
        operazioni.put("mod", new CommandModulo(stack));
        operazioni.put("log", new CommandLogaritmoNaturale(stack));
        operazioni.put("cos", new CommandCos(stack));
        operazioni.put("save", new CommandSalvaVariabili(stackVariabili, variabili));
        operazioni.put("restore", new CommandRipristinaVariabili(stackVariabili, variabili));

        operazioniUtente = new HashMap<>();

        oStack = FXCollections.observableArrayList();

        stackCalcolatrice.setItems(oStack);

    }

    @FXML
    private void esegui(ActionEvent event) {

        String input = casellaDiTesto.getText();
        NumeroComplesso n = NumeroComplesso.inserisciNumero(input);
        StackNumeri stackTemporaneo = new StackNumeri();
        stackTemporaneo.addAll(stack);

        Invoker invoker = new Invoker();
        if (n == null) {  //verifico se l'input è un numero o meno, se n è null allora non è un numero
            Command command = nuovoCommand(input);
            if (command != null) {  //verifico che l'input è un'operazione, altrimenti l'input viene considerato invalido
                try {
                    invoker.esegui(command);
                } catch (Exception e) {
                    stack.clear();
                    stack.addAll(stackTemporaneo);

                    Alert alert = new Alert(Alert.AlertType.ERROR, "L'operazione non può essere eseguita");
                    alert.showAndWait();

                }
            } else {
                stack.clear();
                stack.addAll(stackTemporaneo);

                Alert alert = new Alert(Alert.AlertType.ERROR, "Input non valido");
                alert.showAndWait();
            }
        } else {
            try {
                invoker.esegui(new CommandInserimentoNumero(stack, n));
            } catch (Exception ex) {
            }
            oStack.setAll(stack.convertiInLista());
        }

        //aggiorno i command cosicchè abbiano lo stack aggiornato
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
        operazioni.replace("pow", new CommandPow(stack));
        operazioni.replace("atan", new CommandAtan(stack));
        operazioni.replace("tan", new CommandTan(stack));
        operazioni.replace("asin", new CommandAsin(stack));
        operazioni.replace("acos", new CommandAcos(stack));
        operazioni.replace("sin", new CommandSin(stack));
        operazioni.replace("cos", new CommandCos(stack));
        operazioni.replace("mod", new CommandModulo(stack));
        operazioni.replace("log", new CommandLogaritmoNaturale(stack));
        operazioni.replace("save", new CommandSalvaVariabili(stackVariabili, variabili));
        operazioni.replace("restore", new CommandRipristinaVariabili(stackVariabili, variabili));
        oStack.setAll(stack.convertiInLista());

        casellaDiTesto.clear();

    }

    private Command nuovoCommand(String input) {
        //ritorno command operazione di base
        if (operazioni.containsKey(input)) {
            return (Command) operazioni.get(input);
        }
        //ritorno command operazione definita dall'utente
        if (operazioniUtente.containsKey(input)) {
            return (Command) operazioniUtente.get(input);
        }
        //ritorno command operazioni sulle variabili
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
        String nomeOperazione = tfdNomeOperazione.getText();
        String azioniOperazione = tfdAzioniOperazione.getText();
        String[] azioni = azioniOperazione.split(" ");
        OperazioneUtenteMacroCommand operazioneUtente = new OperazioneUtenteMacroCommand();

        //Controllo che l'operazione non sia stata già creata
        if (operazioniUtente.containsKey(nomeOperazione)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "L'operazione esiste gia");
            alert.showAndWait();
            return;
        }

        for (String string : azioni) {
            NumeroComplesso n = NumeroComplesso.inserisciNumero(string);
            if (n != null) {
                Command command = new CommandInserimentoNumero(stack, n);
                operazioneUtente.aggiungi(command);
            } else {
                Command command = nuovoCommand(string);
                if (command != null) {
                    operazioneUtente.aggiungi(command);
                } else {
                    tfdNomeOperazione.clear();
                    tfdAzioniOperazione.clear();
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Input non valido");
                    alert.showAndWait();
                    return;
                }
            }
        }

        operazioniUtente.put(nomeOperazione, operazioneUtente);
        tfdNomeOperazione.clear();
        tfdAzioniOperazione.clear();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Operazione creata");
        alert.showAndWait();

    }

    //metodo che dato il nome di un operazione, se presente la elimina 
    @FXML
    private void eliminaOperazione(ActionEvent event) {
        String nomeOperazione = tfdNomeOperazione.getText();
        Command c = operazioniUtente.remove(nomeOperazione);
        if (c != null) {
            tfdNomeOperazione.clear();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Operazione eliminata");
            alert.showAndWait();
        } else {
            tfdNomeOperazione.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Operazione non presente");
            alert.showAndWait();
        }
    }

    //metodo che permette di ridefinire la sequenza di azioni di un'operazione esistente
    @FXML
    private void modificaOperazione(ActionEvent event) {
        String nomeOperazione = tfdNomeOperazione.getText();
        String azioniOperazione = tfdAzioniOperazione.getText();
        String[] azioni = azioniOperazione.split(" ");
        OperazioneUtenteMacroCommand operazioneUtente = new OperazioneUtenteMacroCommand();

        //Controllo che l'operazione esista
        if (!operazioniUtente.containsKey(nomeOperazione)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "L'operazione non esiste");
            alert.showAndWait();
            return;
        }

        for (String string : azioni) {
            NumeroComplesso n = NumeroComplesso.inserisciNumero(string);
            if (n != null) {
                Command command = new CommandInserimentoNumero(stack, n);
                operazioneUtente.aggiungi(command);
            } else {
                Command command = nuovoCommand(string);
                if (command != null) {
                    operazioneUtente.aggiungi(command);
                } else {
                    tfdNomeOperazione.clear();
                    tfdAzioniOperazione.clear();
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Input non valido");
                    alert.showAndWait();
                    return;
                }
            }
        }

        operazioniUtente.replace(nomeOperazione, operazioneUtente);
        tfdNomeOperazione.clear();
        tfdAzioniOperazione.clear();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Operazione modificata");
        alert.showAndWait();
    }

    //metodo che consente di salvare su un file le operazioni definite dall'utente
    @FXML
    private void salvaOperazioni(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Salva operazioni");
        File file = fc.showSaveDialog(stackCalcolatrice.getScene().getWindow());

        if (file != null) {
            try ( PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {

                for (Map.Entry<String, Command> operazione : operazioniUtente.entrySet()) {
                    pw.write(operazione.getKey() + ":" + operazione.getValue().toString() + "\n");
                }

            } catch (IOException ex) {
                Logger.getLogger(ControllerCalcolatrice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Operazioni salvate");
        alert.showAndWait();
    }

    //metodo che consente di caricare da un file le operazioni precedentemente salvate
    @FXML
    private void caricaOperazioni(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Carica operazioni");
        File file = fc.showOpenDialog(stackCalcolatrice.getScene().getWindow());

        if (file != null) {
            try ( Scanner i = new Scanner(new BufferedReader(new FileReader(file)))) {

                i.useDelimiter(":|\\n");
                i.useLocale(Locale.US);
                while (i.hasNext()) {
                    String nomeOperazione = i.next();
                    operazioniUtente.put(nomeOperazione, null);
                    OperazioneUtenteMacroCommand operazioneUtente = new OperazioneUtenteMacroCommand();
                    String[] azioni = i.next().split(" ");
                    for (String string : azioni) {
                        NumeroComplesso n = NumeroComplesso.inserisciNumero(string);
                        if (n != null) {
                            Command command = new CommandInserimentoNumero(stack, n);
                            operazioneUtente.aggiungi(command);
                        } else {
                            Command command = nuovoCommand(string);
                            if (command != null) {
                                operazioneUtente.aggiungi(command);
                            } else {
                                tfdNomeOperazione.clear();
                                tfdAzioniOperazione.clear();
                                Alert alert = new Alert(Alert.AlertType.ERROR, "Errore nel caricamento delle operazioni");
                                alert.showAndWait();
                                return;
                            }
                        }
                    }
                    
                    operazioniUtente.replace(nomeOperazione, operazioneUtente);

                }

            } catch (IOException ex) {
                Logger.getLogger(ControllerCalcolatrice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Operazioni caricate");
        alert.showAndWait();
    }
    
    
}
