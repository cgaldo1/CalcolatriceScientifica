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
public class CommandAtanTest {
    
    public CommandAtanTest() {
    }

    /**
     * Test of esegui method, of class CommandAtan.
     */
    @Test (expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        s.push(n);
        CommandAtan c = new CommandAtan(s);
        c.esegui();
        assertEquals(new NumeroComplesso(1.4614618538579256,0.30594385790552897).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(1.4614618538579256,0.30594385790552897).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);  
        s.drop();
        CommandAtan k = new CommandAtan(s);
        k.esegui();
    }
    
}
