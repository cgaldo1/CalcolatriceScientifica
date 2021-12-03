/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calcolatricescientifica;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carmi
 */
public class GestoreInputTest {
    
    public GestoreInputTest() {
    }
    
    /**
     * Test of controlloSeNumero method, of class GestoreInput.
     */
    @Test
    public void testControlloSeNumero() {
        System.out.println("controlloSeNumero");
        StackNumeri stack = new StackNumeri();
        GestoreInput istanza = new GestoreInput();
        
        NumeroComplesso n=new NumeroComplesso(8,10);
        StackNumeri risultato = istanza.controlloSeNumero("8 + 10j",stack);
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        n=new NumeroComplesso(5,0);
        risultato= istanza.controlloSeNumero("5",stack);
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        risultato= istanza.controlloSeNumero("10j",stack);
        n=new NumeroComplesso(0,10);
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        risultato= istanza.controlloSeNumero("j",stack);
        n=new NumeroComplesso(0,1);
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        risultato= istanza.controlloSeNumero("-j",stack);
        n=new NumeroComplesso(0,-1);
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        risultato= istanza.controlloSeNumero("5j+10",stack);
        n=new NumeroComplesso(10,5);
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        risultato= istanza.controlloSeNumero("5+7k",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("f5.0+7j",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("5+j7.0",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("++3",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("--3",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("1.0.0+2j",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("1.0++7j",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("1.0--7j",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("+7+",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("--j",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("j9",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("3+-",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("+",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("-",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero("+-",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero(".0",stack);
        assertEquals(null,risultato);
        risultato= istanza.controlloSeNumero(".0j",stack);
        assertEquals(null,risultato);
    }
    
    @Test
    public void testControllaSeOperazione(){
        StackNumeri stack = new StackNumeri();
        stack.push(new NumeroComplesso(3,5));
        stack.push(new NumeroComplesso(1,1));
        
        GestoreInput istanza = new GestoreInput();
        
        StackNumeri risultato = null;
        
        //test somma
        NumeroComplesso n = new NumeroComplesso(4,6);
        try {
            risultato = istanza.controllaSeOperazione("+",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        boolean thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("+",new StackNumeri());
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        StackNumeri stackEccezione = new StackNumeri();
        stackEccezione.push(new NumeroComplesso(2,2));
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("+",stackEccezione);
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        //test differenza
        stack.push(new NumeroComplesso(1,2));
        n=new NumeroComplesso(3,4);
        try {
            risultato = istanza.controllaSeOperazione("-",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("-",new StackNumeri());
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("-",stackEccezione);
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        
        //test prodotto
        stack.push(new NumeroComplesso(2,2));
        n=new NumeroComplesso(-2,14);
        try {
            risultato = istanza.controllaSeOperazione("*",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("*",new StackNumeri());
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("*",stackEccezione);
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        //test rapporto
        stack.push(new NumeroComplesso(2,2));
        n=new NumeroComplesso(3,4);
        try {
            risultato = istanza.controllaSeOperazione("/",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("/",new StackNumeri());
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("/",stackEccezione);
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        
        //test radice
        n = new NumeroComplesso(2,1);
        try {
            risultato = istanza.controllaSeOperazione("sqrt",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("sqrt",new StackNumeri());
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        
        //test inversione segno
        n = new NumeroComplesso(-2,-1);
        try {
            risultato = istanza.controllaSeOperazione("+-",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(n.parteReale(), risultato.top().parteReale(),0.00001);
        assertEquals(n.parteImmaginaria(), risultato.top().parteImmaginaria(),0.00001);
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("+-",new StackNumeri());
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        
        //test drop
        StackNumeri stackTest = new StackNumeri();
        
        try {
            risultato = istanza.controllaSeOperazione("drop",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(stackTest.toString(), risultato.toString());
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("drop",new StackNumeri());
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        
        //test swap
        stackTest = new StackNumeri();
        stackTest.push(new NumeroComplesso(3,5));
        stackTest.push(new NumeroComplesso(1,1));
        stack.push(new NumeroComplesso(1,1));
        stack.push(new NumeroComplesso(3,5));
        
        try {
            risultato = istanza.controllaSeOperazione("swap",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(stackTest.toString(), risultato.toString());
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("swap",new StackNumeri());
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("swap",stackEccezione);
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        //test dup
        stackTest.push(new NumeroComplesso(1,1));
        try {
            risultato = istanza.controllaSeOperazione("dup",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(stackTest.toString(), risultato.toString());
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("swap",new StackNumeri());
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        //test over
        stackTest.push(new NumeroComplesso(1,1));
        try {
            risultato = istanza.controllaSeOperazione("over",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(stackTest.toString(), risultato.toString());
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("over",new StackNumeri());
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        thrown=false;
        try {
            risultato = istanza.controllaSeOperazione("over",stackEccezione);
        } catch (Exception ex) {
            thrown=true;
        }
        assertTrue(thrown);
        
        //test clear
        stackTest = new StackNumeri();
        try {
            risultato = istanza.controllaSeOperazione("clear",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(stackTest.toString(), risultato.toString());
        
        //test input errato
        StackNumeri stackInputErrato = new StackNumeri();
        stackInputErrato.push(new NumeroComplesso(1,2));
        try {
            risultato = istanza.controllaSeOperazione("+a",stack);
        } catch (Exception ex) {
            Logger.getLogger(GestoreInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(null, risultato);
        
    }
}
