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
 * @author picac
 */
public class CommandArg implements Command {
    private StackNumeri stack;

    public CommandArg(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() throws Exception{
        if(stack.isEmpty()){
            throw new Exception();
        }
        NumeroComplesso nc = stack.drop();
        double argomento = nc.argomento();
        stack.push(new NumeroComplesso(argomento,0));
    }
    
    @Override
    public String toString(){
        return "arg";
    }
}
