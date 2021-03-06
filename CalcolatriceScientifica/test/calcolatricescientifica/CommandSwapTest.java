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
public class CommandSwapTest {
    
    public CommandSwapTest() {
    }

    /**
     * Test of esegui method, of class CommandSwap.
     */
    @Test(expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri stack = new StackNumeri();
        CommandSwap c = new CommandSwap(stack);
        
        NumeroComplesso n = new NumeroComplesso(4,5);
        NumeroComplesso n1 = new NumeroComplesso(5,4);
        stack.push(n);
        stack.push(n1);
        
        c.esegui();
        
        assertEquals(n1.parteReale(), stack.penultimo().parteReale(), 10e-15);
        assertEquals(n1.parteImmaginaria(), stack.penultimo().parteImmaginaria(), 10e-15);
        
        assertEquals(n.parteReale(), stack.top().parteReale(), 10e-15);
        assertEquals(n.parteImmaginaria(), stack.top().parteImmaginaria(), 10e-15);
        
        StackNumeri s = new StackNumeri();
        CommandSwap cs = new CommandSwap(s);
        cs.esegui();
        
    }
    
}
