/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

import java.util.Stack;

/**
 *
 * @author jessi
 */
public class StackNumeri {
    private Stack<NumeroComplesso> stack;
    private int indice;

    public StackNumeri() {
        stack = new Stack<NumeroComplesso>();
    }
    
    public void inserimento(NumeroComplesso n){
        stack.push(n);
    }
    
   
    
}
