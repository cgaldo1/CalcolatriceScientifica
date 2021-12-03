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
 * @author jessi
 */
public class StackVariabiliTest {
    
    public StackVariabiliTest() {
    }

    /**
     * Test of inserisci method, of class StackVariabili.
     */
    @Test
    public void testInserisci() {
        StackVariabili sv = new StackVariabili();
        Variabili v = new Variabili();
        NumeroComplesso n = new NumeroComplesso(3,6);
        NumeroComplesso n1 = new NumeroComplesso(37,61);
        v.inserisci(n, 0);
        v.inserisci(n1, 1);
        sv.inserisci(v);
        
        assertEquals(n, sv.getArray().array[0]);
        assertEquals(n1, sv.getArray().array[1]);
    }

    /**
     * Test of salvaVariabili method, of class StackVariabili.
     */
    @Test
    public void testSalvaVariabili() {
    }

    /**
     * Test of restore method, of class StackVariabili.
     */
    @Test
    public void testRestore() throws Exception {
    }
    
}
