/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

/**
 *
 * @author simfe
 */
public class CommandInserimentoNumero implements Command{

    private StackNumeri stack;
    private NumeroComplesso n;

    public CommandInserimentoNumero(StackNumeri stack, NumeroComplesso n) {
        this.stack=stack;
        this.n = n;
    }
    
    @Override
    public void esegui() {
        stack.push(n);
    }
    
}
