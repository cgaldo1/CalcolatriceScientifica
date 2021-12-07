/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

/**
 *
 * @author picac
 */
public class CommandExp implements Command{
    private StackNumeri stack;

    public CommandExp(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() throws Exception{
        if(stack.isEmpty()){
            throw new Exception();
        }
        NumeroComplesso nc = stack.drop();
        stack.push(nc.esponenziale());
    }
    
    @Override
    public String toString(){
        return "exp";
    }
    
}
