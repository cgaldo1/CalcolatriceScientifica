/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

/**
 *
 * @author simfe
 */
public class CommandDup implements Command{
    private StackNumeri stack;

    public CommandDup(StackNumeri stack) {
        this.stack = stack;
    }

    @Override
    public void esegui() {
        stack.dup();
    }
}