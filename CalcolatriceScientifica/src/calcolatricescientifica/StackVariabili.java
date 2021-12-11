/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

import java.util.Stack;

/**
 *
 * @author carmi
 */
public class StackVariabili {
    private Stack<Variabili> stackVariabili;

    public StackVariabili() {
        stackVariabili = new Stack<>();
    }
    
    public Variabili getArray(){
        return stackVariabili.peek();
    }
    
    //metodo che salva il contenuto delle variabili all'interno dello stack
    public void salvaVariabili(Variabili v){
        Variabili v1 = new Variabili(v);        
        this.stackVariabili.push(v1);
    }
    
    //metodo che recupera dallo stack l'ultimo contenuto delle variabili memorizzato e lo ritorna
    public Variabili ripristinaVariabili() throws Exception{
        if(stackVariabili.isEmpty()) throw new Exception();
        Variabili top= stackVariabili.pop();
        return top;
    }
}
