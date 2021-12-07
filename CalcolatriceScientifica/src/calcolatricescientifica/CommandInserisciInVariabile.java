/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

/**
 *
 * @author jessi
 */
public class CommandInserisciInVariabile implements Command{

    private Variabili v;
    private char x;
    private StackNumeri stack;

    public CommandInserisciInVariabile(Variabili v, char x, StackNumeri stack) {
        this.v = v;
        this.stack = stack;
        this.x = x;
    }
    
    @Override
    public void esegui() throws Exception{
        if(stack.isEmpty()){
            throw new Exception();
        }
        v.inserisciInVariabile(stack, x);
    }
    
    @Override
    public String toString(){
        return ">"+x;
    }
    
}
