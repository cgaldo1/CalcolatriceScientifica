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
public class CommandDropTest {
    
    public CommandDropTest() {
    }

    /**
     * Test of esegui method, of class CommandDrop.
     */
    @Test(expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri stack = new StackNumeri();
        CommandDrop c = new CommandDrop(stack);
        
        NumeroComplesso n = new NumeroComplesso(4,5);
        NumeroComplesso n1 = new NumeroComplesso(5,4);
        stack.push(n);
        stack.push(n1);
        
        c.esegui();
        assertEquals(n, stack.top());
        
        StackNumeri s = new StackNumeri();
        CommandDrop cd = new CommandDrop(s);
        cd.esegui();
    }
    
}
