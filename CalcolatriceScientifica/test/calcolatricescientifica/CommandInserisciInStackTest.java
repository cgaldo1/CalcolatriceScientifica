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
public class CommandInserisciInStackTest {
    
    public CommandInserisciInStackTest() {
    }

    /**
     * Test of esegui method, of class CommandInserisciInStack.
     */
    @Test
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
        Variabili v = new Variabili();
        char x = 'a';
        
        NumeroComplesso n = new NumeroComplesso(5,7);
        
        v.inserisci(n, v.indice(x));
               
        CommandInserisciInStack c = new CommandInserisciInStack(v,x,s);
        c.esegui();
        
        assertEquals(v.array[v.indice(x)], s.top());
    }
    
}
