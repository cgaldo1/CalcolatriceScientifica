/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calcolatricescientifica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carmi
 */
public class CommandRipristinaVariabiliTest {
    
    public CommandRipristinaVariabiliTest() {
    }

    /**
     * Test of esegui method, of class CommandRipristinaVariabili.
     */
    @Test(expected=Exception.class)
    public void testEsegui() throws Exception {
        StackVariabili sv = new StackVariabili();
        NumeroComplesso n = new NumeroComplesso(3,-5);
        NumeroComplesso n1 = new NumeroComplesso(31,-5);
        NumeroComplesso n2 = new NumeroComplesso(53,25);
        
        Variabili v = new Variabili();
        v.inserisci(n, 0);
        v.inserisci(n1, 1);
        v.inserisci(n2, 2);
        sv.salvaVariabili(v);
        
        Variabili restore = new Variabili();
        CommandRipristinaVariabili crv = new CommandRipristinaVariabili(sv, restore);
        crv.esegui();
        
        assertEquals(n, restore.getArray()[0]);
        assertEquals(n1, restore.getArray()[1]);
        assertEquals(n2, restore.getArray()[2]);
        
        StackVariabili s = new StackVariabili();
        Variabili x = new Variabili();
        CommandRipristinaVariabili cr = new CommandRipristinaVariabili(s, x);
        cr.esegui();
    }
    
}
