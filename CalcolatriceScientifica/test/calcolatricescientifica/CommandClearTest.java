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
public class CommandClearTest {
    
    public CommandClearTest() {
    }

    /**
     * Test of esegui method, of class CommandClear.
     */
    @Test
    public void testEsegui() throws Exception {
        StackNumeri stack = new StackNumeri();
        CommandClear c = new CommandClear(stack);
        
        NumeroComplesso n = new NumeroComplesso(4,5);
        NumeroComplesso n1 = new NumeroComplesso(5,4);
        stack.push(n);
        stack.push(n1);
        
        c.esegui();
        
        assertEquals(0, stack.lenght());
        
    }
    
}
