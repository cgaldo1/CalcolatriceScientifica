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
public class CommandSalvaVariabiliTest {
    
    public CommandSalvaVariabiliTest() {
    }

    /**
     * Test of esegui method, of class CommandSalvaVariabili.
     */
    @Test
    public void testEsegui() throws Exception{
        
        StackVariabili stack = new StackVariabili();
        Variabili v= new Variabili();
        NumeroComplesso n = new NumeroComplesso(1,5);
        NumeroComplesso n1 = new NumeroComplesso(16,-5);
        NumeroComplesso n2 = new NumeroComplesso(1,0);
        NumeroComplesso n3 = new NumeroComplesso(6,-3);
        
        v.inserisci(n, 0);
        v.inserisci(n1, 1);
        v.inserisci(n2, 2);
        v.inserisci(n3, 3);
        
        CommandSalvaVariabili c = new CommandSalvaVariabili(stack,v);
        c.esegui();
        
        Variabili ripristino = new Variabili();
        
        ripristino = stack.ripristinaVariabili();
        
        assertEquals(n, ripristino.getArray()[0]);
        assertEquals(n1, ripristino.getArray()[1]);
        assertEquals(n2, ripristino.getArray()[2]);
        assertEquals(n3, ripristino.getArray()[3]);
    }
    
}
