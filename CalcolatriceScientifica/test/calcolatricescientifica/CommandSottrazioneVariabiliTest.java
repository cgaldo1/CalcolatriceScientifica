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
public class CommandSottrazioneVariabiliTest {
    
    public CommandSottrazioneVariabiliTest() {
    }

    /**
     * Test of esegui method, of class CommandSottrazioneVariabili.
     */
    @Test(expected=Exception.class)
    public void testEsegui() throws Exception {
        StackNumeri s = new StackNumeri();
                NumeroComplesso n = new NumeroComplesso(12,2);
                NumeroComplesso k = new NumeroComplesso(12,8);
                s.push(n);
                Variabili var = new Variabili();
                var.inserisci(k, var.indice('a'));
                CommandSottrazioneVariabili csv = new CommandSottrazioneVariabili(var, ('a'), s);
                csv.esegui();
                assertEquals(new NumeroComplesso(0,6).parteReale(), var.getNumero('a').parteReale(),10e-1);
                assertEquals(new NumeroComplesso(0,6).parteImmaginaria(), var.getNumero('a').parteImmaginaria(),10e-1);
                s.drop();
                CommandSottrazioneVariabili csv2 = new CommandSottrazioneVariabili(var, 'a', s);
                csv2.esegui();       
    }
    
}
