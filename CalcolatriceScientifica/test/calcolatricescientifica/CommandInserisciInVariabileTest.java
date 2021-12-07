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
public class CommandInserisciInVariabileTest {
    
    public CommandInserisciInVariabileTest() {
    }

    /**
     * Test of esegui method, of class CommandInserisciInVariabile.
     */
    @Test(expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
        Variabili v = new Variabili();
        char x = 'a';
        
        NumeroComplesso n = new NumeroComplesso(5,7);
        NumeroComplesso n1 = new NumeroComplesso(5,7);
        NumeroComplesso n2 = new NumeroComplesso(5,7);
        
        s.push(n);
        s.push(n1);
        s.push(n2);
               
        CommandInserisciInVariabile c = new CommandInserisciInVariabile(v,x,s);
        c.esegui();
        
        assertEquals(v.getArray()[v.indice(x)], s.top());
        
        s.clear();
        c.esegui();
    }
    
}
