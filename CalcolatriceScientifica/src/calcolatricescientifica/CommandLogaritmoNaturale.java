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
public class CommandLogaritmoNaturale implements Command {
    
    private StackNumeri stack;

    public CommandLogaritmoNaturale(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception(); //stack vuoto. Non si può effettuare l'operazione logaritmo naturale.
        }
        NumeroComplesso n = stack.drop();
        stack.push(n.logaritmonaturale());

    }
    
    @Override
    public String toString(){
        return "log";
    }
    
}
