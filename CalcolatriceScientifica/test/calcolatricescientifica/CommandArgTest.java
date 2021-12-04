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
public class CommandArgTest {
    
    public CommandArgTest() {
    }

    /**
     * Test of esegui method, of class CommandArg.
     */
    @Test
    public void testEsegui() {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(0,3);
        s.push(n);
        CommandArg c = new CommandArg(s);
        c.esegui();
        assertEquals(new NumeroComplesso(1.5707963267948966,0.0).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(1.5707963267948966,0.0).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);
    }
    
}
