/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

/**
 *
 * @author simfe
 */
public class CommandEseguiOperazione implements Command{

    private GestoreInput gestore;
    private String input;
    private StackNumeri stack;

    public CommandEseguiOperazione(String input, StackNumeri stack) {
        this.input = input;
        this.stack = stack;
        gestore = new GestoreInput();
    }
    
    
    @Override
    public void esegui() {
       
    }
    
}
