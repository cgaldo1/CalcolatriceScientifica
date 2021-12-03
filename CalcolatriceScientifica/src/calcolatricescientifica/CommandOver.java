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
public class CommandOver implements Command{
    private StackNumeri stack;

    public CommandOver(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() {
        try {
            stack.over();
        } catch (Exception ex) {
            Logger.getLogger(CommandOver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
