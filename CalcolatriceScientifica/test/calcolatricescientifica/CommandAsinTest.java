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
 * @author picac
 */
public class CommandAsinTest {
    
    public CommandAsinTest() {
    }

    /**
     * Test of esegui method, of class CommandAsin.
     */
    @Test (expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        s.push(n);
        CommandAsin c = new CommandAsin(s);
        c.esegui();
        assertEquals(new NumeroComplesso(0.3076036495307112,1.8641615441578803).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(0.3076036495307112,1.8641615441578803).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);  
        s.drop();
        CommandAsin k = new CommandAsin(s);
        k.esegui();
    }
    
}
