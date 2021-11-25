/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calcolatricescientifica;
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
        risultato= istanza.controlloSeNumero("5j+10",stack);
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
    }
    
}
