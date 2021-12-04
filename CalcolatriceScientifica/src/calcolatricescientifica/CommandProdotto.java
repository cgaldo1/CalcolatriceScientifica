/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simfe
 */
public class CommandProdotto implements Command {

    private StackNumeri stack;

    public CommandProdotto(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() throws Exception {
        if(stack.lenght()<=1){
            throw new Exception();
        }
        NumeroComplesso nc = null;
        nc = stack.penultimo().prodotto(stack.drop());
        stack.drop();
        stack.push(nc);
    }
}
