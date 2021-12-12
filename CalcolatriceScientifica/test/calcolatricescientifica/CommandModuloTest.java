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
public class CommandModuloTest {
    
    public CommandModuloTest() {
    }

    /**
     * Test of esegui method, of class CommandModulo.
     */
    @Test (expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        s.push(n);
        CommandModulo c = new CommandModulo(s);
        c.esegui();
        assertEquals(new NumeroComplesso(3.1622776601683795,0).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(3.1622776601683795,0).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);  
        s.drop();
        CommandModulo k = new CommandModulo(s);
        k.esegui();
    }

    /**
     * Test of toString method, of class CommandModulo.
     */
    @Test
    public void testToString() {
    }
    
}
