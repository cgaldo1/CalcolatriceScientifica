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
    
    public void salvaVariabili(Variabili v){
        this.stackVariabili.push(v);
    }
    
}
