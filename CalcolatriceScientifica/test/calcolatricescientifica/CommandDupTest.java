/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jessi
 */
public class CommandDupTest {
    
    public CommandDupTest() {
    }

    /**
     * Test of esegui method, of class CommandDup.
     */
    @Test(expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri stack = new StackNumeri();
        CommandDup c = new CommandDup(stack);
        
        NumeroComplesso n = new NumeroComplesso(4,5);
        NumeroComplesso n1 = new NumeroComplesso(5,4);
        stack.push(n);
        stack.push(n1);
        
        c.esegui();
        
        assertEquals(stack.top(), stack.penultimo());
        assertEquals(n1, stack.top());
        assertEquals(n1, stack.penultimo());
        
        StackNumeri s = new StackNumeri();
        CommandDup cd = new CommandDup(stack);
        
        cd.esegui();
    }
    
}
