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
public class CommandCosTest {
    
    public CommandCosTest() {
    }

    /**
     * Test of esegui method, of class CommandCos.
     */
    @Test (expected=Exception.class)
    public void testEsegui() throws Exception{
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        s.push(n);
        CommandCos c = new CommandCos(s);
        c.esegui();
        assertEquals(new NumeroComplesso(5.439580991019764,-8.429751080849945).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(5.439580991019764,-8.429751080849945).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);  
        s.drop();
        CommandCos k = new CommandCos(s);
        k.esegui();
            
    }
    
}
