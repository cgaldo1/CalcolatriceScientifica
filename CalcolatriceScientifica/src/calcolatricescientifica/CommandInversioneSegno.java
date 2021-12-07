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
public class CommandInversioneSegno implements Command {

    private StackNumeri stack;

    public CommandInversioneSegno(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() throws Exception{
        if(stack.lenght()==0){
            throw new Exception();
        }
        NumeroComplesso nc = null;
        nc = stack.drop().inversioneSegno();
        stack.push(nc);
    }
    
    @Override
    public String toString(){
        return "+-";
    }
}
