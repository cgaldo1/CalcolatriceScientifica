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
public class VariabiliTest {
    
    public VariabiliTest() {
    }

    /**
     * Test of indice method, of class Variabili.
     */
    @Test
    public void testIndice() {
        Variabili v = new Variabili();
        assertEquals(0, v.indice('a'));
        assertEquals(1, v.indice('b'));
        assertEquals(2, v.indice('c'));
        assertEquals(3, v.indice('d'));
        assertEquals(4, v.indice('e'));
        assertEquals(5, v.indice('f'));
        assertEquals(6, v.indice('g'));
        assertEquals(7, v.indice('h'));
        assertEquals(8, v.indice('i'));
        assertEquals(9, v.indice('j'));
        assertEquals(10, v.indice('k'));
        assertEquals(11, v.indice('l'));
        assertEquals(12, v.indice('m'));
        assertEquals(13, v.indice('n'));
        assertEquals(14, v.indice('o'));
        assertEquals(15, v.indice('p'));
        assertEquals(16, v.indice('q'));
        assertEquals(17, v.indice('r'));
        assertEquals(18, v.indice('s'));
        assertEquals(19, v.indice('t'));
        assertEquals(20, v.indice('u'));
        assertEquals(21, v.indice('v'));
        assertEquals(22, v.indice('w'));
        assertEquals(23, v.indice('x'));
        assertEquals(24, v.indice('y'));
        assertEquals(25, v.indice('z'));
    }

    /**
     * Test of inserisci method, of class Variabili.
     */
    @Test
    public void testInserisci() {
        Variabili v = new Variabili();
        NumeroComplesso n = new NumeroComplesso(3,5);
        v.inserisci(n, 0);
        assertEquals(n, v.array[0]);
        NumeroComplesso n1 = new NumeroComplesso(7,-9);
        v.inserisci(n1, 1);
        assertEquals(n1, v.array[1]);
    }

    /**
     * Test of isEmpty method, of class Variabili.
     */
    @Test
    public void testIsEmpty() {
        Variabili v = new Variabili();
        assertTrue(v.isEmpty());
        NumeroComplesso n = new NumeroComplesso(3,5);
        v.inserisci(n, 0);
        assertFalse(v.isEmpty());
    }

    /**
     * Test of stampa method, of class Variabili.
     */
    @Test
    public void testStampa() {
    }

    /**
     * Test of getNumero method, of class Variabili.
     */
    @Test(expected=Exception.class)
    public void testGetNumero() throws Exception {
        Variabili v = new Variabili();
        NumeroComplesso n = new NumeroComplesso(3,5);
        v.inserisci(n, 0);
        assertEquals(n, v.getNumero('a'));
        
        Variabili v1 = new Variabili();
        v.getNumero('b');
    }

    /**
     * Test of inserisciInVariabile method, of class Variabili.
     */
    @Test
    public void testInserisciInVariabile() {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(5,76);
        s.push(n);
        
        Variabili v = new Variabili();
        v.inserisciInVariabile(s, 'a');
        
        assertEquals(s.top(), v.array[v.indice('a')]);
    }
    
}
