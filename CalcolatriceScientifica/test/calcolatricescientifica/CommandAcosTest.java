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
public class CommandAcosTest {
    
    public CommandAcosTest() {
    }

    /**
     * Test of esegui method, of class CommandAcos.
     */
    @Test (expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        s.push(n);
        CommandAcos c = new CommandAcos(s);
        c.esegui();
        assertEquals(new NumeroComplesso(0.6103804074854946,-0.3783741018950697).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(0.6103804074854946,-0.3783741018950697).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);  
        s.drop();
        CommandAcos k = new CommandAcos(s);
        k.esegui();
    }
    
}
