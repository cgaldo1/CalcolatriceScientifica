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
public class CommandOverTest {
    
    public CommandOverTest() {
    }

    /**
     * Test of esegui method, of class CommandOver.
     */
    @Test(expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri stack = new StackNumeri();
        CommandOver c = new CommandOver(stack);
        
        NumeroComplesso n = new NumeroComplesso(4,5);
        NumeroComplesso n1 = new NumeroComplesso(5,4);
        stack.push(n);
        stack.push(n1);
        int lun = stack.lenght();
        
        c.esegui();
        
        assertEquals(n.parteReale(), stack.top().parteReale(), 10e-15);
        assertEquals(n.parteImmaginaria(), stack.top().parteImmaginaria(), 10e-15);
        
        assertEquals(n1.parteReale(), stack.penultimo().parteReale(), 10e-15);
        assertEquals(n1.parteImmaginaria(), stack.penultimo().parteImmaginaria(), 10e-15);
        
        assertEquals(lun+1, stack.lenght());
        
        StackNumeri s = new StackNumeri();
        CommandOver co = new CommandOver(s);
        co.esegui();
    }
    
}
