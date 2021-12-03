/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simfe
 */
public class CommandRapporto implements Command {

    private StackNumeri stack;

    public CommandRapporto(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() {
        NumeroComplesso nc = null;
        try {
            nc = stack.penultimo().rapporto(stack.drop());
        } catch (Exception ex) {
            Logger.getLogger(CommandSomma.class.getName()).log(Level.SEVERE, null, ex);
        }
        stack.drop();
        stack.push(nc);
    }
}
