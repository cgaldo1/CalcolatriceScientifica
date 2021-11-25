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
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(1.0, 2.0);                  //parte reale positiva
        NumeroComplesso n1 = new NumeroComplesso(-1, 2);                    //parte reale negativa
        NumeroComplesso n2 = new NumeroComplesso(1.5, 2.0);                 //parte reale double
        NumeroComplesso n3 = new NumeroComplesso(3.0 / 2.0, 2);             //parte reale frazionaria
        NumeroComplesso n4 = new NumeroComplesso(inf, 3);                   //parte reale Infinita
        NumeroComplesso n5 = new NumeroComplesso(inf - inf, 5);             //parte reale Nan
        NumeroComplesso n6 = new NumeroComplesso(negativeinf, 5);           //parte reale infinita negativa

        assertEquals(1.0, n.parteReale(), 10e-1);

        assertEquals(-1, n1.parteReale(), 10e-1);

        assertEquals(1.5, n2.parteReale(), 10e-1);

        assertEquals(1.5, n3.parteReale(), 10e-1);

        assertEquals(Infinity, n4.parteReale(), 10e-1);

        assertEquals(NaN, n5.parteReale(), 10e-1);

        assertEquals(-Infinity, n6.parteReale(), 10e-1);
    }

    /**
     * Test of parteImmaginaria method, of class NumeroComplesso.
     */
    @Test
    public void testParteImmaginaria() {

        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(1.0, 2.0);                  //parte immaginaria positiva
        NumeroComplesso n1 = new NumeroComplesso(-1, -2.0);                 //parte immaginaria negativa
        NumeroComplesso n2 = new NumeroComplesso(1.5, 2.5);                 //parte immaginaria double
        NumeroComplesso n3 = new NumeroComplesso(3.0 / 2.0, 3.0 / 2.0);     //parte immaginaria frazionaria
        NumeroComplesso n4 = new NumeroComplesso(3, inf);                   //parte immaginaria infinita
        NumeroComplesso n5 = new NumeroComplesso(3, inf - inf);             //parte immaginaria NaN
        NumeroComplesso n6 = new NumeroComplesso(negativeinf, negativeinf); //parte immaginaria infinita negativa

        assertEquals(2.0, n.parteImmaginaria(), 10e-1);

        assertEquals(-2, n1.parteImmaginaria(), 10e-1);

        assertEquals(2.5, n2.parteImmaginaria(), 10e-1);

        assertEquals(1.5, n3.parteImmaginaria(), 10e-1);

        assertEquals(Infinity, n4.parteImmaginaria(), 10e-1);

        assertEquals(NaN, n5.parteImmaginaria(), 10e-1);

        assertEquals(-Infinity, n6.parteImmaginaria(), 10e-1);
    }

    /**
     * Test of modulo method, of class NumeroComplesso.
     */
    @Test
    public void testModulo() {

        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(3, 3);                      //Modulo con parte reale positiva e parte immaginaria positiva
        NumeroComplesso n1 = new NumeroComplesso(-3, -3);                   //Modulo con parte reale negativa e parte immaginaria negativa  
        NumeroComplesso n2 = new NumeroComplesso(-3, 3);                    //Modulo con parte reale negativa e parte immaginaria positiva
        NumeroComplesso n3 = new NumeroComplesso(3, -3);                    //Modulo con parte reale positiva e parte immaginaria negativa
        NumeroComplesso n4 = new NumeroComplesso(inf, -3);                  //Modulo con parte reale infinita e parte immaginaria negativa
        NumeroComplesso n5 = new NumeroComplesso(2, inf);                   //Modulo con parte reale positiva e parte immaginaria infinita
        NumeroComplesso n6 = new NumeroComplesso(-3, inf);                  //Modulo con parte reale negativa e parte immaginaria infinita
        NumeroComplesso n7 = new NumeroComplesso(inf, 3);                   //Modulo con parte reale infinita e parte immaginaria positiva
        NumeroComplesso n8 = new NumeroComplesso(3.0 / 2.0, 3.0 / 2.0);     //Modulo con parte reale frazionaria e parte immaginaria frazionaria
        NumeroComplesso n9 = new NumeroComplesso(inf, inf);                 //Modulo con parte reale infinita e parte immaginaria infinita
        NumeroComplesso n10 = new NumeroComplesso(negativeinf, inf);        //Modulo con parte reale infinita negativa e parte immaginaria infinita
        NumeroComplesso n11 = new NumeroComplesso(negativeinf, negativeinf);//Modulo con parte reale infinita negativa e parte immaginaria infinita negativa
        NumeroComplesso n12 = new NumeroComplesso(inf, negativeinf);        //Modulo con parte reale infinita e parte immaginaria infinita negativa
        NumeroComplesso n13 = new NumeroComplesso(0, 0);                    //Modulo con parte reale nulla e parte immaginaria nulla

        assertEquals(4.242640687119285, n.modulo(), 10e-15);

        assertEquals(4.242640687119285, n1.modulo(), 10e-15);

        assertEquals(4.242640687119285, n2.modulo(), 10e-15);

        assertEquals(4.242640687119285, n3.modulo(), 10e-15);

        assertEquals(Infinity, n4.modulo(), 10e-15);

        assertEquals(Infinity, n5.modulo(), 10e-15);

        assertEquals(Infinity, n6.modulo(), 10e-15);

        assertEquals(Infinity, n7.modulo(), 10e-15);

        assertEquals(2.121320343559643, n8.modulo(), 10e-15);

        assertEquals(Infinity, n9.modulo(), 10e-15);

        assertEquals(Infinity, n10.modulo(), 10e-15);

        assertEquals(Infinity, n11.modulo(), 10e-15);

        assertEquals(Infinity, n12.modulo(), 10e-15);

        assertEquals(0, n13.modulo(), 10e-15);

    }

    /**
     * Test of somma method, of class NumeroComplesso.
     */
    @Test
    public void testSomma() {

        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n0 = new NumeroComplesso(1.0, 1.0);                  //Numero complesso a cui saranno sommati i numeri complessi dichiarati successivamente
        NumeroComplesso n = new NumeroComplesso(3.0, 3.0);                  //Somma con parte reale positiva e parte immaginaria positiva
        NumeroComplesso n1 = new NumeroComplesso(-3, -3);                   //Somma con parte reale negativa e parte immaginaria negativa  
        NumeroComplesso n2 = new NumeroComplesso(-3, 3);                    //Somma con parte reale negativa e parte immaginaria positiva
        NumeroComplesso n3 = new NumeroComplesso(3, -3);                    //Somma con parte reale positiva e parte immaginaria negativa
        NumeroComplesso n4 = new NumeroComplesso(inf, -3);                  //Somma con parte reale infinita e parte immaginaria negativa
        NumeroComplesso n5 = new NumeroComplesso(2, inf);                   //Somma con parte reale positiva e parte immaginaria infinita                                                                     //Somma con parte reale infinita e parte immaginaria positiva
        NumeroComplesso n6 = new NumeroComplesso(3.0 / 2.0, 3.0 / 2.0);     //Somma con parte reale frazionaria e parte immaginaria frazionaria
        NumeroComplesso n7 = new NumeroComplesso(negativeinf, inf);        //Somma con parte reale infinita negativa e parte immaginaria infinita
        NumeroComplesso n8 = new NumeroComplesso(inf, negativeinf);        //Somma con parte reale infinita e parte immaginaria infinita negativa

        assertEquals(new NumeroComplesso(4, 4).parteReale(), n0.somma(n).parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(4, 4).parteImmaginaria(), n0.somma(n).parteImmaginaria(), 10e-1);

        assertTrue(new NumeroComplesso(-2, -2).parteReale() == n0.somma(n1).parteReale() && new NumeroComplesso(-2, -2).parteImmaginaria() == n0.somma(n1).parteImmaginaria());

        assertTrue(new NumeroComplesso(-2, 4).parteReale() == n0.somma(n2).parteReale() && new NumeroComplesso(-2, 4).parteImmaginaria() == n0.somma(n2).parteImmaginaria());

        assertTrue(new NumeroComplesso(4, -2).parteReale() == n0.somma(n3).parteReale() && new NumeroComplesso(4, -2).parteImmaginaria() == n0.somma(n3).parteImmaginaria());

        assertTrue(new NumeroComplesso(inf, -2).parteReale() == n0.somma(n4).parteReale() && new NumeroComplesso(inf, -2).parteImmaginaria() == n0.somma(n4).parteImmaginaria());

        assertTrue(new NumeroComplesso(3, inf).parteReale() == n0.somma(n5).parteReale() && new NumeroComplesso(3, inf).parteImmaginaria() == n0.somma(n5).parteImmaginaria());

        assertTrue(new NumeroComplesso(2.5, 2.5).parteReale() == n0.somma(n6).parteReale() && new NumeroComplesso(2.5, 2.5).parteImmaginaria() == n0.somma(n6).parteImmaginaria());

        assertTrue(new NumeroComplesso(-inf, inf).parteReale() == n0.somma(n7).parteReale() && new NumeroComplesso(-inf, inf).parteImmaginaria() == n0.somma(n7).parteImmaginaria());

        assertTrue(new NumeroComplesso(inf, -inf).parteReale() == n0.somma(n8).parteReale() && new NumeroComplesso(inf, -inf).parteImmaginaria() == n0.somma(n8).parteImmaginaria());

    }

    /**
     * Test of sottrazione method, of class NumeroComplesso.
     */
    @Test
    public void testSottrazione() {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n0 = new NumeroComplesso(1.0, 1.0);                  //Numero complesso a cui saranno sottratti i numeri complessi dichiarati successivamente
        NumeroComplesso n = new NumeroComplesso(3.0, 3.0);                  //Differenza con parte reale positiva e parte immaginaria positiva
        NumeroComplesso n1 = new NumeroComplesso(-3, -3);                   //Differenza con parte reale negativa e parte immaginaria negativa  
        NumeroComplesso n2 = new NumeroComplesso(-3, 3);                    //Differenza con parte reale negativa e parte immaginaria positiva
        NumeroComplesso n3 = new NumeroComplesso(3, -3);                    //Differenza con parte reale positiva e parte immaginaria negativa
        NumeroComplesso n4 = new NumeroComplesso(inf, -3);                  //Differenza con parte reale infinita e parte immaginaria negativa
        NumeroComplesso n5 = new NumeroComplesso(2, inf);                   //Differenza con parte reale positiva e parte immaginaria infinita                                                                     //Somma con parte reale infinita e parte immaginaria positiva
        NumeroComplesso n6 = new NumeroComplesso(3.0 / 2.0, 3.0 / 2.0);     //Differenza con parte reale frazionaria e parte immaginaria frazionaria
        NumeroComplesso n7 = new NumeroComplesso(negativeinf, inf);         //Differenza con parte reale infinita negativa e parte immaginaria infinita
        NumeroComplesso n8 = new NumeroComplesso(inf, negativeinf);         //Differenza con parte reale infinita e parte immaginaria infinita negativa

        assertEquals(new NumeroComplesso(-2, -2).parteReale(), n0.sottrazione(n).parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(-2, -2).parteImmaginaria(), n0.sottrazione(n).parteImmaginaria(), 10e-1);

        assertTrue(new NumeroComplesso(4, 4).parteReale() == n0.sottrazione(n1).parteReale() && new NumeroComplesso(4, 4).parteImmaginaria() == n0.sottrazione(n1).parteImmaginaria());

        assertTrue(new NumeroComplesso(4, -2).parteReale() == n0.sottrazione(n2).parteReale() && new NumeroComplesso(4, -2).parteImmaginaria() == n0.sottrazione(n2).parteImmaginaria());

        assertTrue(new NumeroComplesso(-2, 4).parteReale() == n0.sottrazione(n3).parteReale() && new NumeroComplesso(-2, 4).parteImmaginaria() == n0.sottrazione(n3).parteImmaginaria());

        assertTrue(new NumeroComplesso(-inf, 4).parteReale() == n0.sottrazione(n4).parteReale() && new NumeroComplesso(-inf, 4).parteImmaginaria() == n0.sottrazione(n4).parteImmaginaria());

        assertTrue(new NumeroComplesso(-1, -inf).parteReale() == n0.sottrazione(n5).parteReale() && new NumeroComplesso(-1, -inf).parteImmaginaria() == n0.sottrazione(n5).parteImmaginaria());

        assertTrue(new NumeroComplesso(-0.5, -0.5).parteReale() == n0.sottrazione(n6).parteReale() && new NumeroComplesso(-0.5, -0.5).parteImmaginaria() == n0.sottrazione(n6).parteImmaginaria());

        assertTrue(new NumeroComplesso(inf, -inf).parteReale() == n0.sottrazione(n7).parteReale() && new NumeroComplesso(inf, -inf).parteImmaginaria() == n0.sottrazione(n7).parteImmaginaria());

        assertTrue(new NumeroComplesso(-inf, inf).parteReale() == n0.sottrazione(n8).parteReale() && new NumeroComplesso(-inf, inf).parteImmaginaria() == n0.sottrazione(n8).parteImmaginaria());
    }

    /**
     * Test of prodotto method, of class NumeroComplesso.
     */
    @Test
    public void testProdotto() {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n0 = new NumeroComplesso(2.0, 1.0);                 //Numero complesso a cui saranno moltiplicati i numeri complessi dichiarati successivamente
        NumeroComplesso n = new NumeroComplesso(5.0, 7.0);                  //Prodotto con parte reale positiva e parte immaginaria positiva
        NumeroComplesso n1 = new NumeroComplesso(-3, -3);                   //Prodotto con parte reale negativa e parte immaginaria negativa  
        NumeroComplesso n2 = new NumeroComplesso(-3, 3);                    //Prodotto con parte reale negativa e parte immaginaria positiva
        NumeroComplesso n3 = new NumeroComplesso(3, -3);                    //Prodotto con parte reale positiva e parte immaginaria negativa
        NumeroComplesso n4 = new NumeroComplesso(inf, -3);                  //Prodotto con parte reale infinita e parte immaginaria negativa
        NumeroComplesso n5 = new NumeroComplesso(2, inf);                   //Prodotto con parte reale positiva e parte immaginaria infinita                                                                     //Somma con parte reale infinita e parte immaginaria positiva
        NumeroComplesso n6 = new NumeroComplesso(3.0 / 2.0, 3.0 / 2.0);     //Prodotto con parte reale frazionaria e parte immaginaria frazionaria
        NumeroComplesso n7 = new NumeroComplesso(negativeinf, inf);         //Prodotto con parte reale infinita negativa e parte immaginaria infinita
        NumeroComplesso n8 = new NumeroComplesso(inf, negativeinf);         //Prodotto con parte reale infinita e parte immaginaria infinita negativa

        assertEquals(new NumeroComplesso(3, 19).parteReale(), n0.prodotto(n).parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(3, 19).parteImmaginaria(), n0.prodotto(n).parteImmaginaria(), 10e-1);

        assertTrue(new NumeroComplesso(-3, -9).parteReale() == n0.prodotto(n1).parteReale() && new NumeroComplesso(-3, -9).parteImmaginaria() == n0.prodotto(n1).parteImmaginaria());

        assertTrue(new NumeroComplesso(-9, 3).parteReale() == n0.prodotto(n2).parteReale() && new NumeroComplesso(-9, 3).parteImmaginaria() == n0.prodotto(n2).parteImmaginaria());

        assertTrue(new NumeroComplesso(9, -3).parteReale() == n0.prodotto(n3).parteReale() && new NumeroComplesso(9, -3).parteImmaginaria() == n0.prodotto(n3).parteImmaginaria());

        assertTrue(new NumeroComplesso(inf, inf).parteReale() == n0.prodotto(n4).parteReale() && new NumeroComplesso(inf, inf).parteImmaginaria() == n0.prodotto(n4).parteImmaginaria());

        assertTrue(new NumeroComplesso(-inf, inf).parteReale() == n0.prodotto(n5).parteReale() && new NumeroComplesso(-inf, inf).parteImmaginaria() == n0.prodotto(n5).parteImmaginaria());

        assertTrue(new NumeroComplesso(1.5, 4.5).parteReale() == n0.prodotto(n6).parteReale() && new NumeroComplesso(1.5, 4.5).parteImmaginaria() == n0.prodotto(n6).parteImmaginaria());

        assertEquals(new NumeroComplesso(negativeinf, NaN).parteReale(), n0.prodotto(n7).parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(negativeinf, NaN).parteImmaginaria(), n0.prodotto(n7).parteImmaginaria(), 10e-1);

        assertEquals(new NumeroComplesso(inf, NaN).parteReale(), n0.prodotto(n8).parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(inf, NaN).parteImmaginaria(), n0.prodotto(n8).parteImmaginaria(), 10e-1);

    }

    /**
     * Test of rapporto method, of class NumeroComplesso.
     */
    @Test
    public void testRapporto() {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n0 = new NumeroComplesso(2.0, 1.0);                 //Numero complesso a cui saranno divisi i numeri complessi dichiarati successivamente
        NumeroComplesso n = new NumeroComplesso(5.0, 7.0);                  //Rapporto con parte reale positiva e parte immaginaria positiva
        NumeroComplesso n1 = new NumeroComplesso(-3, -3);                   //Rapporto con parte reale negativa e parte immaginaria negativa  
        NumeroComplesso n2 = new NumeroComplesso(-3, 3);                    //Rapporto con parte reale negativa e parte immaginaria positiva
        NumeroComplesso n3 = new NumeroComplesso(3, -3);                    //Rapporto con parte reale positiva e parte immaginaria negativa
        NumeroComplesso n4 = new NumeroComplesso(inf, -3);                  //Rapporto con parte reale infinita e parte immaginaria negativa
        NumeroComplesso n5 = new NumeroComplesso(2, inf);                   //Rapporto con parte reale positiva e parte immaginaria infinita                                                                     //Somma con parte reale infinita e parte immaginaria positiva
        NumeroComplesso n6 = new NumeroComplesso(3.0 / 2.0, 3.0 / 2.0);     //Rapporto con parte reale frazionaria e parte immaginaria frazionaria
        NumeroComplesso n7 = new NumeroComplesso(negativeinf, inf);         //Rapporto con parte reale infinita negativa e parte immaginaria infinita
        NumeroComplesso n8 = new NumeroComplesso(inf, negativeinf);         //Rapporto con parte reale infinita e parte immaginaria infinita negativa

        assertEquals(new NumeroComplesso(0.22972972972972974, -0.12162162162162163).parteReale(), n0.rapporto(n).parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(0.22972972972972974, -0.12162162162162163).parteImmaginaria(), n0.rapporto(n).parteImmaginaria(), 10e-1);

        assertTrue(new NumeroComplesso(-0.5000000000000001, 0.1666666666666667).parteReale() == n0.rapporto(n1).parteReale() && new NumeroComplesso(-0.5000000000000001, 0.1666666666666667).parteImmaginaria() == n0.rapporto(n1).parteImmaginaria());

        assertTrue(new NumeroComplesso(-0.1666666666666667, -0.5000000000000001).parteReale() == n0.rapporto(n2).parteReale() && new NumeroComplesso(-0.1666666666666667, -0.5000000000000001).parteImmaginaria() == n0.rapporto(n2).parteImmaginaria());

        assertTrue(new NumeroComplesso(0.1666666666666667, 0.5000000000000001).parteReale() == n0.rapporto(n3).parteReale() && new NumeroComplesso(0.1666666666666667, 0.5000000000000001).parteImmaginaria() == n0.rapporto(n3).parteImmaginaria());

        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n0.rapporto(n4).parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n0.rapporto(n4).parteImmaginaria(), 10e-1);

        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n0.rapporto(n5).parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n0.rapporto(n5).parteImmaginaria(), 10e-1);

        assertTrue(new NumeroComplesso(1.0000000000000002, -0.3333333333333334).parteReale() == n0.rapporto(n6).parteReale() && new NumeroComplesso(1.0000000000000002, -0.3333333333333334).parteImmaginaria() == n0.rapporto(n6).parteImmaginaria());

        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n0.rapporto(n7).parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n0.rapporto(n7).parteImmaginaria(), 10e-1);

        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n0.rapporto(n8).parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n0.rapporto(n8).parteImmaginaria(), 10e-1);

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
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n0 = new NumeroComplesso(2.0, 1.0);
        NumeroComplesso n = new NumeroComplesso(-2.0, 1.0);
        NumeroComplesso n1 = new NumeroComplesso(2.0, -1.0);
        NumeroComplesso n2 = new NumeroComplesso(-2,-1);
        NumeroComplesso n3 = new NumeroComplesso(inf, negativeinf);

        assertTrue(new NumeroComplesso(-2.0, -1.0).parteReale() == n0.inversioneSegno().parteReale() && new NumeroComplesso(-2.0, -1.0).parteImmaginaria() == n0.inversioneSegno().parteImmaginaria());

        assertTrue(new NumeroComplesso(2.0, -1.0).parteReale() == n.inversioneSegno().parteReale() && new NumeroComplesso(2.0, -1.0).parteImmaginaria() == n.inversioneSegno().parteImmaginaria());

        assertTrue(new NumeroComplesso(-2.0, 1.0).parteReale() == n1.inversioneSegno().parteReale() && new NumeroComplesso(-2.0, 1.0).parteImmaginaria() == n1.inversioneSegno().parteImmaginaria());
        
        assertTrue(new NumeroComplesso(2.0, 1.0).parteReale() == n2.inversioneSegno().parteReale() && new NumeroComplesso(2.0, 1.0).parteImmaginaria() == n2.inversioneSegno().parteImmaginaria());
        
        assertEquals(new NumeroComplesso(negativeinf, inf).parteReale(), n3.inversioneSegno().parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(negativeinf, inf).parteImmaginaria(), n3.inversioneSegno().parteImmaginaria(), 10e-1);
    }

    /**
     * Test of toString method, of class NumeroComplesso.
     */
    @Test
    public void testToString() {
    }

}