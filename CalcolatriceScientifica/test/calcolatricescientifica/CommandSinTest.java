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
public class CommandSinTest {
    
    public CommandSinTest() {
    }

    /**
     * Test of esegui method, of class CommandSin.
     */
    @Test (expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        s.push(n);
        CommandSin c = new CommandSin(s);
        c.esegui();
        assertEquals(new NumeroComplesso(8.471645454300148,5.412680923178193).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(8.471645454300148,5.412680923178193).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);  
        s.drop();
        CommandSin k = new CommandSin(s);
        k.esegui();
    }

    /**
     * Test of toString method, of class CommandSin.
     */
    @Test
    public void testToString() {
    }
    
}
