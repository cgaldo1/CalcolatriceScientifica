/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

import static java.lang.Double.NaN;
import static jdk.nashorn.internal.objects.Global.Infinity;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author picac
 */
public class NumeroComplessoTest {

    public NumeroComplessoTest() {
    }

    /**
     * Test of parteReale method, of class NumeroComplesso.
     */
    @Test
    public void testParteReale() {
        double inf = Double.POSITIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(1.0, 2.0);          //parte reale positiva
        NumeroComplesso n1 = new NumeroComplesso(-1, 2);          //parte reale negativa
        NumeroComplesso n2 = new NumeroComplesso(1.5, 2.0);         //parte reale double
        NumeroComplesso n3 = new NumeroComplesso(3.0 / 2.0, 2);         //parte reale frazionaria
        NumeroComplesso n4 = new NumeroComplesso(inf, 3);           //parte reale Infinita
        NumeroComplesso n5 = new NumeroComplesso(inf - inf, 5);     //parte reale Nan
        assertEquals(1.0, n.parteReale(), 10e-1);
        assertEquals(-1, n1.parteReale(), 10e-1);
        assertEquals(1.5, n2.parteReale(), 10e-1);
        assertEquals(1.5, n3.parteReale(), 10e-1);
        assertEquals(Infinity, n4.parteReale(), 10e-1);
        assertEquals(NaN, n5.parteReale(), 10e-1);
    }

    /**
     * Test of parteImmaginaria method, of class NumeroComplesso.
     */
    @Test
    public void testParteImmaginaria() {
        double inf = Double.POSITIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(1.0, 2.0);          //parte immaginaria positiva
        NumeroComplesso n1 = new NumeroComplesso(-1, -2.0);         //parte immaginaria negativa
        NumeroComplesso n2 = new NumeroComplesso(1.5, 2.5);         //parte immaginaria double
        NumeroComplesso n3 = new NumeroComplesso(3.0 / 2.0, 3.0 / 2.0);     //parte immaginaria frazionaria
        NumeroComplesso n4 = new NumeroComplesso(3, inf);           //parte immaginaria infinita
        NumeroComplesso n5 = new NumeroComplesso(3, inf - inf);     //parte immaginaria NaN
        assertEquals(2.0, n.parteImmaginaria(), 10e-1);
        assertEquals(-2, n1.parteImmaginaria(), 10e-1);
        assertEquals(2.5, n2.parteImmaginaria(), 10e-1);
        assertEquals(1.5, n3.parteImmaginaria(), 10e-1);
        assertEquals(Infinity, n4.parteImmaginaria(), 10e-1);
        assertEquals(NaN, n5.parteImmaginaria(), 10e-1);
    }

    /**
     * Test of modulo method, of class NumeroComplesso.
     */
    @Test
    public void testModulo() {
        double inf = Double.POSITIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(3, 3);              //Modulo con parte reale positiva e parte immaginaria positiva
        NumeroComplesso n1 = new NumeroComplesso(-3, -3);           //Modulo con parte reale negativa e parte immaginaria negativa  
        NumeroComplesso n2 = new NumeroComplesso(-3, 3);            //Modulo con parte reale negativa e parte immaginaria positiva
        NumeroComplesso n3 = new NumeroComplesso(3, -3);            //Modulo con parte reale positiva e parte immaginaria negativa
        NumeroComplesso n4 = new NumeroComplesso(inf, -3);          //Modulo con parte reale infinita e parte immaginaria negativa
        NumeroComplesso n5 = new NumeroComplesso(2, inf);           //Modulo con parte reale positiva e parte immaginaria infinita
        NumeroComplesso n6 = new NumeroComplesso(-3, inf);          //Modulo con parte reale negativa e parte immaginaria infinita
        NumeroComplesso n7 = new NumeroComplesso(inf, 3);           //Modulo con parte reale infinita e parte immaginaria positiva
        NumeroComplesso n8 = new NumeroComplesso(3.0/2.0, 3.0/2.0);         //Modulo con parte reale frazionaria e parte immaginaria frazionaria
        
        assertEquals(4.242640687119285, n.modulo(), 10e-15);
        assertEquals(4.242640687119285, n1.modulo(), 10e-15);
        assertEquals(4.242640687119285, n2.modulo(), 10e-15);
        assertEquals(4.242640687119285, n3.modulo(), 10e-15);
        assertEquals(Infinity, n4.modulo(), 10e-15);
        assertEquals(Infinity, n5.modulo(), 10e-15);
        assertEquals(Infinity, n6.modulo(), 10e-15);
        assertEquals(Infinity, n7.modulo(), 10e-15);
        assertEquals(2.121320343559643, n8.modulo(), 10e-15);

    }

    /**
     * Test of somma method, of class NumeroComplesso.
     */
    @Test
    public void testSomma() {
    }

    /**
     * Test of sottrazione method, of class NumeroComplesso.
     */
    @Test
    public void testSottrazione() {
    }

    /**
     * Test of prodotto method, of class NumeroComplesso.
     */
    @Test
    public void testProdotto() {
    }

    /**
     * Test of rapporto method, of class NumeroComplesso.
     */
    @Test
    public void testRapporto() {
    }

    /**
     * Test of esponenziale method, of class NumeroComplesso.
     */
    @Test
    public void testEsponenziale() {
    }

    /**
     * Test of argomento method, of class NumeroComplesso.
     */
    @Test
    public void testArgomento() {
    }

    /**
     * Test of logaritmo method, of class NumeroComplesso.
     */
    @Test
    public void testLogaritmo() {
    }

    /**
     * Test of radice method, of class NumeroComplesso.
     */
    @Test
    public void testRadice() {
    }

    /**
     * Test of seno method, of class NumeroComplesso.
     */
    @Test
    public void testSeno() {
    }

    /**
     * Test of coseno method, of class NumeroComplesso.
     */
    @Test
    public void testCoseno() {
    }

    /**
     * Test of senoIperbolico2 method, of class NumeroComplesso.
     */
    @Test
    public void testSenoIperbolico2() {
    }

    /**
     * Test of cosenoIperbolico2 method, of class NumeroComplesso.
     */
    @Test
    public void testCosenoIperbolico2() {
    }

    /**
     * Test of tan method, of class NumeroComplesso.
     */
    @Test
    public void testTan() {
    }

    /**
     * Test of inversioneSegno method, of class NumeroComplesso.
     */
    @Test
    public void testInversioneSegno() {
    }

    /**
     * Test of toString method, of class NumeroComplesso.
     */
    @Test
    public void testToString() {
    }

}
