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

    public StackNumeri() {
        stack = new Stack<>();
    }
    
    public void push(NumeroComplesso n){
        stack.push(n);
    }
        
    public NumeroComplesso top(){
        return stack.peek();
    }
    
    public void isEmpty(){
        stack.isEmpty();
    }
    
    public int lenght(){
        return stack.size()-1;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
    
    public void clear(){
        stack.clear();
    }
    
    public NumeroComplesso drop(){
        return stack.pop();
    }
    
    public void dup(){
        this.push(this.top());
    }
    
    public void swap() throws Exception{
        this.isEmpty();
        if(stack.size() < 2) throw new Exception();
        NumeroComplesso ultimoel = this.drop();
        NumeroComplesso penultimoel = this.drop();
        this.push(ultimoel);
        this.push(penultimoel);
    }
    
    public void over(){
        NumeroComplesso ultimoel = this.drop();
        NumeroComplesso penultimoel = this.top();
        this.push(ultimoel);
        this.push(penultimoel);
    }

}
