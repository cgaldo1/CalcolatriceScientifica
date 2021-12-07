/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author simfe
 */
public class OperazioneUtenteMacroCommand implements MacroCommand{

    private List<Command> listaCommand;
    
    public OperazioneUtenteMacroCommand(){
        listaCommand = new ArrayList<>(); 
    }
    
    @Override
    public void aggiungi(Command command) {
        listaCommand.add(command);
    }

    @Override
    public void rimuovi(Command command) {
        listaCommand.remove(command);
    }

    @Override
    public void esegui() throws Exception{
        for(Command command : listaCommand){
            command.esegui();
        }
    }
    
    @Override
    public String toString(){
        String s="";
        int len = listaCommand.size();
        for(int i=0; i<len; i++){
            s=s+listaCommand.get(i).toString()+" ";
        }
        return s;
    }
    
}
