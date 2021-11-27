/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author jessi
 */
public class StackNumeri {
    private Stack<NumeroComplesso> stack;

    public StackNumeri() {
        stack = new Stack<>();
    }
    
    public void push(NumeroComplesso n){
        stack.push(n);
    }
        
    public NumeroComplesso top(){
        return stack.peek();
    }
    
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    
    public int lenght(){
        return stack.size()-1;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
    
    //Metodo che rimuove tutti gli elementi dallo stack
    public void clear(){
        stack.clear();
    }
    
    //metodo che rimuove elemento in cima allo stack (il top)
    public NumeroComplesso drop(){
        return stack.pop();
    }
    
    //metodo che duplica l'ultimo elemento dello stack
    public void dup(){
        this.push(this.top());
    }
    
    //metodo che scambia gli ultimi due elementi dello stack
    public void swap() throws Exception{
        this.isEmpty();
        if(stack.size() < 2) throw new Exception();
        NumeroComplesso ultimoel = this.drop();
        NumeroComplesso penultimoel = this.drop();
        this.push(ultimoel);
        this.push(penultimoel);
    }
    
    //metodo che inserisce in cima allo stack una copia del penultimo elemento 
    public void over() throws Exception{
        this.isEmpty();
        if(stack.size() < 2) throw new Exception();
        NumeroComplesso ultimoel = this.drop();
        NumeroComplesso penultimoel = this.top();
        this.push(ultimoel);
        this.push(penultimoel);
    }

    public NumeroComplesso penultimo() throws Exception{
        this.swap();
        NumeroComplesso penultimoel = this.top();
        this.swap();
        return penultimoel;
    }
            
    public List<NumeroComplesso> convertiInLista(){
        List<NumeroComplesso> lista = new ArrayList<>();
        Stack<NumeroComplesso> stackTemporaneo = new Stack<>();
        NumeroComplesso nc = null;
        int lunghezzaStack = stack.size();
        for(int i =0; i<lunghezzaStack; i++){
            nc=stack.pop();
            stackTemporaneo.push(nc);
            lista.add(nc);
        }
        int lunghezzaStackTemp = stackTemporaneo.size();
        for(int i=0; i<lunghezzaStackTemp; i++){
            nc = stackTemporaneo.pop();
            stack.push(nc);
        }
        return lista;
    }
    
}
