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
public class CommandRapportoTest {
    
    public CommandRapportoTest() {
    }

    /**
     * Test of esegui method, of class CommandRapporto.
     */
    @Test
    public void testEsegui() {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(2,2);
        NumeroComplesso n0 = new NumeroComplesso(5,3);
        s.push(n);
        s.push(n0);
        CommandRapporto c = new CommandRapporto(s);
        c.esegui();
        assertEquals(new NumeroComplesso(0.47058823529411764,0.11764705882352941).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(0.47058823529411764,0.11764705882352941).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);
    }
    
}
