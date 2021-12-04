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
public class CommandExpTest {
    
    public CommandExpTest() {
    }

    /**
     * Test of esegui method, of class CommandExp.
     */
    @Test
    public void testEsegui() {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        s.push(n);
        CommandExp c = new CommandExp(s);
        c.esegui();
        assertEquals(new NumeroComplesso(-2.6910786138197937,0.383603953541131).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(-2.6910786138197937,0.383603953541131).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);        
    }
    
}
