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
public class CommandLogaritmoNaturaleTest {
    
    public CommandLogaritmoNaturaleTest() {
    }

    /**
     * Test of esegui method, of class CommandLogaritmoNaturale.
     */
    @Test (expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        s.push(n);
        CommandLogaritmoNaturale c = new CommandLogaritmoNaturale(s);
        c.esegui();
        assertEquals(new NumeroComplesso(1.151292546497023,1.2490457723982544).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(1.151292546497023,1.2490457723982544).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);  
        s.drop();
        CommandLogaritmoNaturale k = new CommandLogaritmoNaturale(s);
        k.esegui();
    }

    /**
     * Test of toString method, of class CommandLogaritmoNaturale.
     */
    @Test
    public void testToString() {
    }
    
}
