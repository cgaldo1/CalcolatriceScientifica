/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author picac
 */
public class CommandProdottoTest {
    
    public CommandProdottoTest() {
    }

    /**
     * Test of esegui method, of class CommandProdotto.
     */
    @Test
    public void testEsegui() {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        NumeroComplesso n0 = new NumeroComplesso(1,3);
        s.push(n);
        s.push(n0);
        CommandProdotto c = new CommandProdotto(s);
        assertEquals(new NumeroComplesso(-8.0,6.0).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(-8.0,6.0).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);
    }
    
}
