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
public class CommandTanTest {
    
    public CommandTanTest() {
    }

    /**
     * Test of esegui method, of class CommandTan.
     */
    @Test (expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        s.push(n);
        CommandTan c = new CommandTan(s);
        c.esegui();
        assertEquals(new NumeroComplesso(0.004517137276658316,1.0020549882458116).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(0.004517137276658316,1.0020549882458116).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);  
        s.drop();
        CommandTan k = new CommandTan(s);
        k.esegui();
    }
    
}
