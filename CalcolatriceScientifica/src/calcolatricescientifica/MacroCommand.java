/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package calcolatricescientifica;

import java.util.List;

/**
 *
 * @author simfe
 */
public interface MacroCommand extends Command{
    
    public void aggiungi(Command command);
    
    public void rimuovi(Command command);
    
}
