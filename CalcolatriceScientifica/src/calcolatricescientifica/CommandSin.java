/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

/**
 *
 * @author simfe
 */
public class CommandSin implements Command {

    private StackNumeri stack;

    public CommandSin(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception(); //stack vuoto. Non si può effettuare l'operazione seno.
        }
        NumeroComplesso n = stack.drop();
        stack.push(n.seno());

    }

    @Override
    public String toString() {
        return "sin";
    }
}
