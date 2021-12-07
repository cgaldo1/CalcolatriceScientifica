/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

/**
 *
 * @author carmi
 */
public class CommandSalvaVariabili implements Command{

    private StackVariabili s;
    private Variabili v;

    public CommandSalvaVariabili(StackVariabili s, Variabili v) {
        this.s = s;
        this.v = v;
    }
    
    @Override
    public void esegui(){
        s.salvaVariabili(v);
        
    }
    
    @Override
    public String toString(){
        return "save";
    }
    
}
