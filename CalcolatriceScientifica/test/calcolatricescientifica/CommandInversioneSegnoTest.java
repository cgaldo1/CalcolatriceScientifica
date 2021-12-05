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
public class CommandInversioneSegnoTest {
    
    public CommandInversioneSegnoTest() {
    }

    /**
     * Test of esegui method, of class CommandInversioneSegno.
     */
    @Test(expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(1,3);
        s.push(n);
        CommandInversioneSegno c = new CommandInversioneSegno(s);
        c.esegui();
        assertEquals(new NumeroComplesso(-1.0,-3.0).parteReale(),s.top().parteReale(),10e-15);
        assertEquals(new NumeroComplesso(-1.0,-3.0).parteImmaginaria(),s.top().parteImmaginaria(),10e-15);  
        s.drop();
        CommandInversioneSegno k = new CommandInversioneSegno(s);
        k.esegui();
    }
    
}
