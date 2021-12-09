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
        
        s.push(n);
               
        CommandInserisciInVariabile c = new CommandInserisciInVariabile(v,x,s);
        c.esegui();
        
        assertEquals(v.getArray()[v.indice(x)].parteReale(), n.parteReale(), 10e-15);
        assertEquals(v.getArray()[v.indice(x)].parteImmaginaria(), n.parteImmaginaria(), 10e-15);
        
        s.clear();
        c.esegui();
    }
    
}
