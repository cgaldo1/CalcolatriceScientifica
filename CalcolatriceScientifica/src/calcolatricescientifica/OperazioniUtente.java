/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author simfe
 */
public class OperazioniUtente {
    private Map<String, List<String>> operazioni;
    
    public OperazioniUtente(){
        operazioni=new HashMap<>();
    }
    
    public void esegui(Command command){
        command.esegui();
    }
    
    public void salva(String nome, List<String> listaOperazioni){
        operazioni.put(nome, listaOperazioni);
    }
}
