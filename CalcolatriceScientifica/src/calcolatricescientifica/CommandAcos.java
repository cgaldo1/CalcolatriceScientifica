/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

/**
 *
 * @author Francesco
 */
public class CommandAcos implements Command{
    private StackNumeri stack;

    public CommandAcos(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception(); //stack vuoto. Non si può effettuare l'operazione arcotangente.
        }
        NumeroComplesso n = stack.drop();
        stack.push(n.acos());

    }
    
    @Override
    public String toString(){
        return "acos";
    }
    
    
}
