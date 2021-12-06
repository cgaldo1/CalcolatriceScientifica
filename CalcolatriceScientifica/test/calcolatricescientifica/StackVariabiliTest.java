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
     * Test of ripristina method, of class StackVariabili.
     */
    @Test(expected=Exception.class)
    public void testRipristinaVariabili() throws Exception {
        StackVariabili stack = new StackVariabili();
        Variabili v = new Variabili();
        NumeroComplesso n = new NumeroComplesso(1,5);
        NumeroComplesso n1 = new NumeroComplesso(16,-5);
        NumeroComplesso n2 = new NumeroComplesso(1,0);
        NumeroComplesso n3 = new NumeroComplesso(6,-3);
        
        v.inserisci(n, 0);
        v.inserisci(n1, 1);
        v.inserisci(n2, 2);
        v.inserisci(n3, 3);
        
        stack.inserisci(v);
        
        Variabili ripristino = new Variabili();
        
        ripristino = stack.ripristinaVariabili();
        
        assertEquals(n, ripristino.array[0]);
        assertEquals(n1, ripristino.array[1]);
        assertEquals(n2, ripristino.array[2]);
        assertEquals(n3, ripristino.array[3]);
        
        StackVariabili s = new StackVariabili();
        Variabili ripristino1 = new Variabili();
        ripristino1 = s.ripristinaVariabili();
    }
    
}
