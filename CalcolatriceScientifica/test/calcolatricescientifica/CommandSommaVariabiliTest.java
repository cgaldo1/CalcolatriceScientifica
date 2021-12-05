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
 * @author picac
 */
public class CommandSommaVariabiliTest {
    
    public CommandSommaVariabiliTest() {
    }

    /**
     * Test of esegui method, of class CommandSommaVariabili.
     */
    @Test(expected=Exception.class)
    public void testEsegui() throws Exception {
                StackNumeri s = new StackNumeri();
                NumeroComplesso n = new NumeroComplesso(12,2);
                NumeroComplesso k = new NumeroComplesso(12,8);
                s.push(n);
                Variabili var = new Variabili();
                var.inserisci(k, var.indice('a'));
                CommandSommaVariabili csv = new CommandSommaVariabili(var, ('a'), s);
                csv.esegui();
                assertEquals(new NumeroComplesso(24,10).parteReale(), var.getNumero('a').parteReale(),10e-1);
                assertEquals(new NumeroComplesso(24,10).parteImmaginaria(), var.getNumero('a').parteImmaginaria(),10e-1);
                s.drop();
                CommandSommaVariabili csv2 = new CommandSommaVariabili(var, 'a', s);
                csv2.esegui();        
    }
    
}
