/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

import java.util.EmptyStackException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author picac
 */
public class CommandRadiceTest {
    
    public CommandRadiceTest() {
    }

    /**
     * Test of esegui method, of class CommandRadice.
     */
    @Test(expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        s.push(n);
        CommandRadice c = new CommandRadice(s);
        c.esegui();
        assertEquals(new NumeroComplesso(1.4426152744526828,1.0397782600555705).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(1.4426152744526828,1.0397782600555705).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);  
        s.drop();
        CommandRadice k = new CommandRadice(s);
        k.esegui();
    }
    
}
