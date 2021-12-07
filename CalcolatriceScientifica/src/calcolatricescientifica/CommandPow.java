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
public class CommandPow implements Command{

    private StackNumeri stack;

    public CommandPow(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() throws Exception{
        if(stack.isEmpty()){
            throw new Exception(); //stack vuoto. Mancano sia la base che l'esponente;
        }
        NumeroComplesso esponente = stack.drop();
        if(esponente.parteImmaginaria() != 0){
            throw new Exception();
        }
        if(stack.isEmpty()){
            throw new Exception(); //manca la base a cui elevare l'esponente
        }
        NumeroComplesso base = stack.drop();
        stack.push(base.potenza(esponente));
    }
    
}
