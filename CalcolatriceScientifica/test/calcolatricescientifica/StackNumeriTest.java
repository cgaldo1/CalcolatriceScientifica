/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

import java.util.EmptyStackException;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jessi
 */
public class StackNumeriTest {
    
    public StackNumeriTest() {
    }

    /**
     * Test of push method, of class StackNumeri.
     */
    @Test
    public void testPush() {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(-6, 34);
        s.push(n);
        assertEquals(n.toString(), s.top().toString());
    }

    /**
     * Test of top method, of class StackNumeri.
     */
    @Test(expected=EmptyStackException.class)
    public void testTop() {
        StackNumeri s = new StackNumeri();
        s.top();
        NumeroComplesso n = new NumeroComplesso(34,-9);
        s.push(n);
        assertEquals(s.top().toString(), n.toString());
        NumeroComplesso n1 = new NumeroComplesso(34, 99);
        s.push(n1);
        assertEquals(s.top().toString(), n1.toString());
    }

    /**
     * Test of isEmpty method, of class StackNumeri.
     */
    @Test
    public void testIsEmpty() {
        StackNumeri s = new StackNumeri();
        assertTrue(s.isEmpty());
    }

    /**
     * Test of lenght method, of class StackNumeri.
     */
    @Test
    public void testLenght() {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(5,6);
        s.push(n);
        NumeroComplesso n2 = new NumeroComplesso(7,-2);
        s.push(n2);
        assertEquals(1, s.lenght());
        s.push(n2);
        assertEquals(2, s.lenght());
    }

    /**
     * Test of toString method, of class StackNumeri.
     */
    @Test
    public void testToString() {
    }

    /**
     * Test of clear method, of class StackNumeri.
     */
    @Test
    public void testClear() {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(5,6);
        s.push(n);
        NumeroComplesso n2 = new NumeroComplesso(7,-2);
        s.push(n2);
        
        s.clear();
        assertTrue(s.isEmpty());
    }

    /**
     * Test of drop method, of class StackNumeri.
     */
    @Test(expected=EmptyStackException.class)
    public void testDrop() {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(5,6);
        s.push(n);
        NumeroComplesso n2 = new NumeroComplesso(7,-2);
        s.push(n2);
        
        assertEquals(n2,s.drop());
        assertEquals(n, s.top());
        
        StackNumeri s2 = new StackNumeri();
        s2.drop();
    }

    /**
     * Test of dup method, of class StackNumeri.
     */
    @Test(expected=Exception.class)
    public void testDup() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(5,6);
        s.push(n);
        NumeroComplesso n2 = new NumeroComplesso(7,-2);
        s.push(n2);
        
        s.dup();
        assertEquals(n2, s.top());
        assertEquals(n2, s.penultimo());
        
        StackNumeri s2 = new StackNumeri();
        s2.dup();
    }

    /**
     * Test of swap method, of class StackNumeri.
     */
    @Test(expected=Exception.class)
    public void testSwap() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(5,6);
        s.push(n);
        NumeroComplesso n2 = new NumeroComplesso(7,-2);
        s.push(n2);
        
        s.swap();
        assertEquals(n, s.top());
        assertEquals(n2, s.penultimo());
        
        StackNumeri s2 = new StackNumeri();
        s2.swap();
        
    }

    /**
     * Test of over method, of class StackNumeri.
     */
    @Test(expected=Exception.class)
    public void testOver() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(5,6);
        s.push(n);
        NumeroComplesso n2 = new NumeroComplesso(7,-2);
        s.push(n2);
        
        s.over();
        assertEquals(n, s.top());
        assertEquals(n2, s.penultimo());
        s.drop();
        assertEquals(n, s.penultimo());
        
        StackNumeri s2 = new StackNumeri();
        s2.over();
    }

    /**
     * Test of penultimo method, of class StackNumeri.
     */
    @Test(expected=Exception.class)
    public void testPenultimo() throws Exception {
        StackNumeri s = new StackNumeri();
        NumeroComplesso n = new NumeroComplesso(5,6);
        s.push(n);
        NumeroComplesso n2 = new NumeroComplesso(7,-2);
        s.push(n2);
        
        assertEquals(n, s.penultimo());
        
        StackNumeri s2 = new StackNumeri();
        s2.penultimo();
    }

    /**
     * Test of convertiInLista method, of class StackNumeri.
     */
    @Test
    public void testConvertiInLista() {
        StackNumeri stack = new StackNumeri();
        stack.push(new NumeroComplesso(2,4));
        stack.push(new NumeroComplesso(1,3));
        stack.push(new NumeroComplesso(5,6));
        List<NumeroComplesso> lista = stack.convertiInLista();
        for(int i=0; i<3; i++){
            assertEquals(lista.get(i), stack.drop());
        }
        
    }
    
}
