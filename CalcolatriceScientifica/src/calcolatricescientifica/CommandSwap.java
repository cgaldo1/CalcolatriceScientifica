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
public class CommandSwap implements Command{
    private StackNumeri stack;

    public CommandSwap(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() throws Exception{
        if(stack.lenght()<=1){
            throw new Exception();
        }
        stack.swap();
        
    }
    
    @Override
    public String toString(){
        return "swap";
    }
}
