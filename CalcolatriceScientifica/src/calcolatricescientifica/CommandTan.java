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
public class CommandTan implements Command{
    private StackNumeri stack;

    public CommandTan(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception(); //stack vuoto. Non si può effettuare l'operazione arcotangente.
        }
        NumeroComplesso n = stack.drop();
        stack.push(n.tan());

    }
    
}
