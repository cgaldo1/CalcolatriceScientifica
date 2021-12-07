/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jessi
 */
public class CommandSommaVariabili implements Command{

    private Variabili v;
    private char x;
    private StackNumeri stack;

    public CommandSommaVariabili(Variabili v, char x, StackNumeri stack) {
        this.v = v;
        this.x = x;
        this.stack = stack;
    }
    
    @Override
    public void esegui() throws Exception{
        v.sommaVariabile(stack, x);
    }
    
    @Override
    public String toString(){
        return "+"+x;
    }
    
}
