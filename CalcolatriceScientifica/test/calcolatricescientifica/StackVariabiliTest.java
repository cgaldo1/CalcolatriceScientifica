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
     * Test of salvaVariabili method, of class StackVariabili.
     */
    @Test
    public void testSalvaVariabili() throws Exception{
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
        
        stack.salvaVariabili(v);
        
        Variabili ripristino = new Variabili();
        
        ripristino = stack.ripristinaVariabili();
        
        assertEquals(n, ripristino.getArray()[0]);
        assertEquals(n1, ripristino.getArray()[1]);
        assertEquals(n2, ripristino.getArray()[2]);
        assertEquals(n3, ripristino.getArray()[3]);

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
        
        stack.salvaVariabili(v);
        
        Variabili ripristino = new Variabili();
        
        ripristino = stack.ripristinaVariabili();
        
        assertEquals(n, ripristino.getArray()[0]);
        assertEquals(n1, ripristino.getArray()[1]);
        assertEquals(n2, ripristino.getArray()[2]);
        assertEquals(n3, ripristino.getArray()[3]);
        
        StackVariabili s = new StackVariabili();
        Variabili ripristino1 = new Variabili();
        ripristino1 = s.ripristinaVariabili();
    }
    
}
