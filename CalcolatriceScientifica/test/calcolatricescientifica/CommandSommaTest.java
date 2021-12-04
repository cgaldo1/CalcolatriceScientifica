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
public class CommandSommaTest {
    
    public CommandSommaTest() {
    }

    /**
     * Test of esegui method, of class CommandSomma.
     */
    @Test
    public void testEsegui() {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        NumeroComplesso n0 = new NumeroComplesso(1,3);
        s.push(n);
        s.push(n0);
        CommandSomma c = new CommandSomma(s);
        c.esegui();
        assertEquals(new NumeroComplesso(2.0,6.0).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(2.0,6.0).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);        
    }
    
}
