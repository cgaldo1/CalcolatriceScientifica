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
public class CommandCos implements Command{
    
    private StackNumeri stack;

    public CommandCos(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception(); //stack vuoto. Non si può effettuare l'operazione coseno.
        }
        NumeroComplesso n = stack.drop();
        stack.push(n.coseno());

    }
    
    @Override
    public String toString(){
        return "cos";
    }
    
}
