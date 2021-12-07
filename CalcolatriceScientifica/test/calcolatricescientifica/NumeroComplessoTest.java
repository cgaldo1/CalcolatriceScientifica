package calcolatricescientifica;

import static java.lang.Double.NaN;
import static jdk.nashorn.internal.objects.Global.Infinity;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Francesco
 */
public class NumeroComplessoTest {

    public NumeroComplessoTest() {
    }

    /**
     * Test del metodo parteReale, della classe NumeroComplesso.
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
     * Test del metodo parteImmaginaria, della classe NumeroComplesso.
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
     * Test del metodo modulo, della classe NumeroComplesso.
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
     * Test del metodo somma, della classe NumeroComplesso.
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
     * Test del metodo sottrazione, della classe NumeroComplesso.
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
     * Test del metodo prodotto, della classe NumeroComplesso.
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
     * Test del metodo rapporto, della classe NumeroComplesso.
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
        NumeroComplesso n9 = new NumeroComplesso(0, 0);                     //Rapporto con parte reale nulla e parte immaginaria nulla

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

        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n0.rapporto(n9).parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n0.rapporto(n9).parteImmaginaria(), 10e-1);

    }

    /**
     * Test del metodo esponenziale, della classe NumeroComplesso.
     */
    @Test
    public void testEsponenziale() {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(2.0, 1.0);                  //a>0,b>0
        NumeroComplesso n0 = new NumeroComplesso(-3, -3);                   //a<0,b<0  
        NumeroComplesso n1 = new NumeroComplesso(-3, 3);                    //a<0,b>0
        NumeroComplesso n2 = new NumeroComplesso(3, -3);                    //a>0,b<0
        NumeroComplesso n3 = new NumeroComplesso(inf, -3);                  //a=inf,b<0
        NumeroComplesso n4 = new NumeroComplesso(2, inf);                   //a>0,b=inf                                                                    //Somma con parte reale infinita e parte immaginaria positiva
        NumeroComplesso n5 = new NumeroComplesso(inf, 2);                   //a=inf,b>0
        NumeroComplesso n6 = new NumeroComplesso(negativeinf, inf);         //a=-inf,b=inf
        NumeroComplesso n7 = new NumeroComplesso(inf, negativeinf);         //a=inf,b=-inf
        NumeroComplesso n8 = new NumeroComplesso(0, 0);                     //a=0,b=0
        NumeroComplesso n9 = new NumeroComplesso(-3,inf);                   //a<0,b=inf
        
        assertEquals(new NumeroComplesso(3.992324048441272, 6.217676312367968).parteReale(), n.esponenziale().parteReale(), 10e-15);
        assertEquals(new NumeroComplesso(3.992324048441272, 6.217676312367968).parteImmaginaria(), n.esponenziale().parteImmaginaria(), 10e-15);
        
        assertEquals(new NumeroComplesso(-0.04928882411191869, -0.00702595148935012).parteReale(), n0.esponenziale().parteReale(), 10e-15);
        assertEquals(new NumeroComplesso(-0.04928882411191869, -0.00702595148935012).parteImmaginaria(), n0.esponenziale().parteImmaginaria(), 10e-15);
        
        assertEquals(new NumeroComplesso(-0.04928882411191869, 0.00702595148935012).parteReale(), n1.esponenziale().parteReale(), 10e-15);
        assertEquals(new NumeroComplesso(-0.04928882411191869, 0.00702595148935012).parteImmaginaria(), n1.esponenziale().parteImmaginaria(), 10e-15);
        
        assertEquals(new NumeroComplesso(-19.884530844146987, -2.834471132487004).parteReale(), n2.esponenziale().parteReale(), 10e-15);
        assertEquals(new NumeroComplesso(-19.884530844146987, -2.834471132487004).parteImmaginaria(), n2.esponenziale().parteImmaginaria(), 10e-15);
        
        assertEquals(new NumeroComplesso(-Infinity, -Infinity).parteReale(), n3.esponenziale().parteReale(), 10e-15);
        assertEquals(new NumeroComplesso(-Infinity, -Infinity).parteImmaginaria(), n3.esponenziale().parteImmaginaria(), 10e-15);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n4.esponenziale().parteReale(), 10e-15);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n4.esponenziale().parteImmaginaria(), 10e-15);
        
        assertEquals(new NumeroComplesso(-Infinity, Infinity).parteReale(), n5.esponenziale().parteReale(), 10e-15);
        assertEquals(new NumeroComplesso(-Infinity, Infinity).parteImmaginaria(), n5.esponenziale().parteImmaginaria(), 10e-15);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n6.esponenziale().parteReale(), 10e-15);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n6.esponenziale().parteImmaginaria(), 10e-15);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n7.esponenziale().parteReale(), 10e-15);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n7.esponenziale().parteImmaginaria(), 10e-15);
        
        assertEquals(new NumeroComplesso(1.0, 0.0).parteReale(), n8.esponenziale().parteReale(), 10e-15);
        assertEquals(new NumeroComplesso(1.0, 0.0).parteImmaginaria(), n8.esponenziale().parteImmaginaria(), 10e-15);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n9.esponenziale().parteReale(), 10e-15);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n9.esponenziale().parteImmaginaria(), 10e-15);
        
        
    }

    /**
     * Test del metodo argomento, della classe NumeroComplesso.
     */
    @Test
    public void testArgomento() {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(0, 4);                  // a=0,b>0
        NumeroComplesso n0 = new NumeroComplesso(0, -4);                // a=0,b<0
        NumeroComplesso n1 = new NumeroComplesso(0, 0);                 //a=0,b=0
        NumeroComplesso n2 = new NumeroComplesso(3, 5);                 //a>0,b>0
        NumeroComplesso n3 = new NumeroComplesso(3, -5);                //a>0,b<0
        NumeroComplesso n4 = new NumeroComplesso(-3, 0);                // a<0,b>0
        NumeroComplesso n5 = new NumeroComplesso(-3, 5);                // a<0,b>0
        NumeroComplesso n6 = new NumeroComplesso(-5, -5);               // a<0,b<0
        NumeroComplesso n7 = new NumeroComplesso(-4,inf);                // a<0,b=inf
        NumeroComplesso n8 = new NumeroComplesso(4,negativeinf);        // a>0,b=-inf
        NumeroComplesso n9 = new NumeroComplesso(inf,4);                // a=inf,b>0
        NumeroComplesso n10 = new NumeroComplesso(negativeinf,4);       // a=-inf,b=qualsiasi
        
        assertEquals(1.5707963267948966,n.argomento(),10e-15);
        assertEquals(-1.5707963267948966,n0.argomento(),10e-15);
        assertEquals(0.0,n1.argomento(),10e-15);
        assertEquals(1.0303768265243125,n2.argomento(),10e-15);
        assertEquals(-1.0303768265243125,n3.argomento(),10e-15);
        assertEquals(3.141592653589793,n4.argomento(),10e-15);
        assertEquals(2.1112158270654806,n5.argomento(),10e-15);
        assertEquals(-2.356194490192345,n6.argomento(),10e-15);
        assertEquals(1.5707963267948966,n7.argomento(),10e-15);
        assertEquals(-1.5707963267948966,n8.argomento(),10e-15);
        assertEquals(0.0,n9.argomento(),10e-15);
        assertEquals(3.141592653589793,n10.argomento(),10e-15);
        
        
    }

    /**
     * Test del metodo logaritmo, della classe NumeroComplesso.
     */
    @Test
    public void testLogaritmo() {
    }

    /**
     * Test del metodo radice, della classe NumeroComplesso.
     */
    @Test
    public void testRadice() {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n0 = new NumeroComplesso(-4, 0);
        NumeroComplesso n = new NumeroComplesso(0, 0);
        NumeroComplesso n1 = new NumeroComplesso(inf, 0);
        NumeroComplesso n2 = new NumeroComplesso(negativeinf, 0);
        NumeroComplesso n3 = new NumeroComplesso(3.0 / 2.0, 3.0 / 2.0);

        assertTrue(new NumeroComplesso(1.2246467991473532E-16, 2).parteReale() == n0.radice().parteReale() && new NumeroComplesso(1.2246467991473532E-16, 2).parteImmaginaria() == n0.radice().parteImmaginaria());

        assertTrue(new NumeroComplesso(0, 0).parteReale() == n.radice().parteReale() && new NumeroComplesso(0, 0).parteImmaginaria() == n.radice().parteImmaginaria());

        assertEquals(new NumeroComplesso(inf, NaN).parteReale(), n1.radice().parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(inf, NaN).parteImmaginaria(), n1.radice().parteImmaginaria(), 10e-1);

        assertEquals(new NumeroComplesso(inf, inf).parteReale(), n2.radice().parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(inf, inf).parteImmaginaria(), n2.radice().parteImmaginaria(), 10e-1);

        assertEquals(new NumeroComplesso(1.4564753151219703, 0).parteReale(), n3.radice().parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(1.4564753151219703, 0).parteImmaginaria(), n3.radice().parteImmaginaria(), 10e-1);
    }

    /**
     * Test del metodo seno, della classe NumeroComplesso.
     */
    @Test
    public void testSeno() {
    }

    /**
     * Test del metodo coseno, della classe NumeroComplesso.
     */
    @Test
    public void testCoseno() {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(0, 4);                              // a=0,b>0
        NumeroComplesso n0 = new NumeroComplesso(0, -4);                            // a=0,b<0
        NumeroComplesso n1 = new NumeroComplesso(0, 0);                             //a=0,b=0
        NumeroComplesso n2 = new NumeroComplesso(3, 5);                             //a>0,b>0
        NumeroComplesso n3 = new NumeroComplesso(3, -5);                            //a>0,b<0
        NumeroComplesso n4 = new NumeroComplesso(-3, 0);                            // a<0,b=0
        NumeroComplesso n5 = new NumeroComplesso(-3, 5);                            // a<0,b>0
        NumeroComplesso n6 = new NumeroComplesso(-5, -5);                           // a<0,b<0
        NumeroComplesso n7 = new NumeroComplesso(-4,inf);                           // a<0,b=inf
        NumeroComplesso n8 = new NumeroComplesso(4,inf);                            // a>0,b=inf
        NumeroComplesso n9 = new NumeroComplesso(0,inf);                            // a=0,b=inf
        NumeroComplesso n10 = new NumeroComplesso(-4,negativeinf);                  // a<0,b=-inf
        NumeroComplesso n11 = new NumeroComplesso(4,negativeinf);                   // a>0,b=-inf
        NumeroComplesso n12 = new NumeroComplesso(0,negativeinf);                   // a=0,b=-inf
        NumeroComplesso n13 = new NumeroComplesso(inf,-4);                          // a=inf,b<0
        NumeroComplesso n14 = new NumeroComplesso(inf,4);                           // a=inf,b>0
        NumeroComplesso n15 = new NumeroComplesso(inf,0);                           // a=inf,b=0
        NumeroComplesso n16 = new NumeroComplesso(negativeinf,-4);                  // a=-inf,b<0
        NumeroComplesso n17 = new NumeroComplesso(negativeinf,4);                   // a=-inf,b>0
        NumeroComplesso n18 = new NumeroComplesso(negativeinf,0);                   // a=-inf,b=0
        NumeroComplesso n19 = new NumeroComplesso(inf,inf);                         // a=inf,b=inf
        NumeroComplesso n20 = new NumeroComplesso(negativeinf,negativeinf);         // a=-inf,b=-inf
        
        assertTrue(new NumeroComplesso(27.308232836016487,0).parteReale() == n.coseno().parteReale() && new NumeroComplesso(27.308232836016487,0).parteImmaginaria() == n.coseno().parteImmaginaria());
        assertTrue(new NumeroComplesso(27.308232836016487,0).parteReale() == n0.coseno().parteReale() && new NumeroComplesso(27.308232836016487,0).parteImmaginaria() == n0.coseno().parteImmaginaria());
        assertTrue(new NumeroComplesso(1,0).parteReale() == n1.coseno().parteReale() && new NumeroComplesso(1,0).parteImmaginaria() == n1.coseno().parteImmaginaria());
        assertTrue(new NumeroComplesso(-73.46729221264526,-10.471557674805572).parteReale() == n2.coseno().parteReale() && new NumeroComplesso(-73.46729221264526,-10.471557674805572).parteImmaginaria() == n2.coseno().parteImmaginaria());
        assertTrue(new NumeroComplesso(-73.46729221264526,10.471557674805572).parteReale() == n3.coseno().parteReale() && new NumeroComplesso(-73.46729221264526,10.471557674805572).parteImmaginaria() == n3.coseno().parteImmaginaria());
        assertTrue(new NumeroComplesso(-0.9899924966004454,0).parteReale() == n4.coseno().parteReale() && new NumeroComplesso(-0.9899924966004454,0).parteImmaginaria() == n4.coseno().parteImmaginaria());
        assertTrue(new NumeroComplesso(-73.46729221264526,10.471557674805572).parteReale() == n5.coseno().parteReale() && new NumeroComplesso(-73.46729221264526,10.471557674805572).parteImmaginaria() == n5.coseno().parteImmaginaria());
        assertTrue(new NumeroComplesso(21.050556181654844,71.1552598809822).parteReale() == n6.coseno().parteReale() && new NumeroComplesso(21.050556181654844,71.1552598809822).parteImmaginaria() == n6.coseno().parteImmaginaria());
        
        assertEquals(new NumeroComplesso(negativeinf, negativeinf).parteReale(), n7.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(negativeinf, negativeinf).parteImmaginaria(), n7.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(negativeinf, inf).parteReale(), n8.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(negativeinf, inf).parteImmaginaria(), n8.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(inf, NaN).parteReale(), n9.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(inf, NaN).parteImmaginaria(), n9.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(negativeinf, inf).parteReale(), n10.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(negativeinf, inf).parteImmaginaria(), n10.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(negativeinf, negativeinf).parteReale(), n11.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(negativeinf, negativeinf).parteImmaginaria(), n11.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(inf, NaN).parteReale(), n12.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(inf, NaN).parteImmaginaria(), n12.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n13.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n13.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n14.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n14.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n15.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n15.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n16.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n16.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n17.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n17.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n18.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n18.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n19.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n19.coseno().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n20.coseno().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n20.coseno().parteImmaginaria(), 10e-1);
    }

    /**
     * Test del metodo senoIperbolico2, della classe NumeroComplesso.
     */
    @Test
    public void testSenoIperbolico2() {
    }

    /**
     * Test del metodo cosenoIperbolico2, della classe NumeroComplesso.
     */
    @Test
    public void testCosenoIperbolico2() {
    }

    /**
     * Test del metodo tan, della classe NumeroComplesso.
     */
    @Test
    public void testTan() {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(0, 4);                              // a=0,b>0
        NumeroComplesso n0 = new NumeroComplesso(0, -4);                            // a=0,b<0
        NumeroComplesso n1 = new NumeroComplesso(0, 0);                             //a=0,b=0
        NumeroComplesso n2 = new NumeroComplesso(3, 5);                             //a>0,b>0
        NumeroComplesso n3 = new NumeroComplesso(3, -5);                            //a>0,b<0
        NumeroComplesso n4 = new NumeroComplesso(-3, 0);                            // a<0,b=0
        NumeroComplesso n5 = new NumeroComplesso(-3, 5);                            // a<0,b>0
        NumeroComplesso n6 = new NumeroComplesso(-5, -5);                           // a<0,b<0
        NumeroComplesso n7 = new NumeroComplesso(-4,inf);                           // a<0,b=inf
        NumeroComplesso n8 = new NumeroComplesso(4,inf);                            // a>0,b=inf
        NumeroComplesso n9 = new NumeroComplesso(0,inf);                            // a=0,b=inf
        NumeroComplesso n10 = new NumeroComplesso(-4,negativeinf);                  // a<0,b=-inf
        NumeroComplesso n11 = new NumeroComplesso(4,negativeinf);                   // a>0,b=-inf
        NumeroComplesso n12 = new NumeroComplesso(0,negativeinf);                   // a=0,b=-inf
        NumeroComplesso n13 = new NumeroComplesso(inf,-4);                          // a=inf,b<0
        NumeroComplesso n14 = new NumeroComplesso(inf,4);                           // a=inf,b>0
        NumeroComplesso n15 = new NumeroComplesso(inf,0);                           // a=inf,b=0
        NumeroComplesso n16 = new NumeroComplesso(negativeinf,-4);                  // a=-inf,b<0
        NumeroComplesso n17 = new NumeroComplesso(negativeinf,4);                   // a=-inf,b>0
        NumeroComplesso n18 = new NumeroComplesso(negativeinf,0);                   // a=-inf,b=0
        NumeroComplesso n19 = new NumeroComplesso(inf,inf);                         // a=inf,b=inf
        NumeroComplesso n20 = new NumeroComplesso(negativeinf,negativeinf);         // a=-inf,b=-inf
        
        assertTrue(new NumeroComplesso(0,0.9993292997390669).parteReale() == n.tan().parteReale() && new NumeroComplesso(0,0.9993292997390669).parteImmaginaria() == n.tan().parteImmaginaria());
        assertTrue(new NumeroComplesso(0,-0.9993292997390669).parteReale() == n0.tan().parteReale() && new NumeroComplesso(0,-0.9993292997390669).parteImmaginaria() == n0.tan().parteImmaginaria());
        assertTrue(new NumeroComplesso(0,0).parteReale() == n1.tan().parteReale() && new NumeroComplesso(0,0).parteImmaginaria() == n1.tan().parteImmaginaria());
        assertTrue(new NumeroComplesso(-2.5368676207713767E-5,0.9999128201513534).parteReale() == n2.tan().parteReale() && new NumeroComplesso(-2.5368676207713767E-5,0.9999128201513534).parteImmaginaria() == n2.tan().parteImmaginaria());
        assertTrue(new NumeroComplesso(-2.5368676207713767E-5,-0.9999128201513534).parteReale() == n3.tan().parteReale() && new NumeroComplesso(-2.5368676207713767E-5,-0.9999128201513534).parteImmaginaria() == n3.tan().parteImmaginaria());
        assertTrue(new NumeroComplesso(0.1425465430742778,0).parteReale() == n4.tan().parteReale() && new NumeroComplesso(0.1425465430742778,0).parteImmaginaria() == n4.tan().parteImmaginaria());
        assertTrue(new NumeroComplesso(2.5368676207713767E-5,0.9999128201513534).parteReale() == n5.tan().parteReale() && new NumeroComplesso(2.5368676207713767E-5,0.9999128201513534).parteImmaginaria() == n5.tan().parteImmaginaria());
        assertTrue(new NumeroComplesso(4.940080407323852E-5,-1.0000761892591825).parteReale() == n6.tan().parteReale() && new NumeroComplesso(4.940080407323852E-5,-1.0000761892591825).parteImmaginaria() == n6.tan().parteImmaginaria());
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n7.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n7.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n8.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n8.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n9.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n9.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n10.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n10.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n11.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n11.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n12.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n12.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n13.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n13.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n14.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n14.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n15.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n15.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n16.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n16.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n17.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n17.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n18.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n18.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n19.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n19.tan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n20.tan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n20.tan().parteImmaginaria(), 10e-1);
    }

    /**
     * Test del metodo inversioneSegno, della classe NumeroComplesso.
     */
    @Test
    public void testInversioneSegno() {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n0 = new NumeroComplesso(2.0, 1.0);
        NumeroComplesso n = new NumeroComplesso(-2.0, 1.0);
        NumeroComplesso n1 = new NumeroComplesso(2.0, -1.0);
        NumeroComplesso n2 = new NumeroComplesso(-2, -1);
        NumeroComplesso n3 = new NumeroComplesso(inf, negativeinf);

        assertTrue(new NumeroComplesso(-2.0, -1.0).parteReale() == n0.inversioneSegno().parteReale() && new NumeroComplesso(-2.0, -1.0).parteImmaginaria() == n0.inversioneSegno().parteImmaginaria());

        assertTrue(new NumeroComplesso(2.0, -1.0).parteReale() == n.inversioneSegno().parteReale() && new NumeroComplesso(2.0, -1.0).parteImmaginaria() == n.inversioneSegno().parteImmaginaria());

        assertTrue(new NumeroComplesso(-2.0, 1.0).parteReale() == n1.inversioneSegno().parteReale() && new NumeroComplesso(-2.0, 1.0).parteImmaginaria() == n1.inversioneSegno().parteImmaginaria());

        assertTrue(new NumeroComplesso(2.0, 1.0).parteReale() == n2.inversioneSegno().parteReale() && new NumeroComplesso(2.0, 1.0).parteImmaginaria() == n2.inversioneSegno().parteImmaginaria());

        assertEquals(new NumeroComplesso(negativeinf, inf).parteReale(), n3.inversioneSegno().parteReale(), 10e-1);

        assertEquals(new NumeroComplesso(negativeinf, inf).parteImmaginaria(), n3.inversioneSegno().parteImmaginaria(), 10e-1);
    }

    /**
     * Test del metodo toString, della classe NumeroComplesso.
     */
    @Test
    public void testToString() {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n0 = new NumeroComplesso(1, 2);
        NumeroComplesso n = new NumeroComplesso(-1, 2);
        NumeroComplesso n1 = new NumeroComplesso(inf, 2);
        NumeroComplesso n2 = new NumeroComplesso(negativeinf, 2);

        assertEquals("1.0 + 2.0j", n0.toString());
        assertEquals("-1.0 + 2.0j", n.toString());
        assertEquals("Infinity + 2.0j", n1.toString());
        assertEquals("-Infinity + 2.0j", n2.toString());
    }

    /**
     * Test of logaritmonaturale method, of class NumeroComplesso.
     */
    @Test
    public void testLogaritmonaturale() {
    }

    /**
     * Test of atan method, of class NumeroComplesso.
     */
    @Test
    public void testAtan() {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(0, 4);                              // a=0,b>0
        NumeroComplesso n0 = new NumeroComplesso(0, -4);                            // a=0,b<0
        NumeroComplesso n1 = new NumeroComplesso(0, 0);                             //a=0,b=0
        NumeroComplesso n2 = new NumeroComplesso(3, 5);                             //a>0,b>0
        NumeroComplesso n3 = new NumeroComplesso(3, -5);                            //a>0,b<0
        NumeroComplesso n4 = new NumeroComplesso(-3, 0);                            // a<0,b=0
        NumeroComplesso n5 = new NumeroComplesso(-3, 5);                            // a<0,b>0
        NumeroComplesso n6 = new NumeroComplesso(-5, -5);                           // a<0,b<0
        NumeroComplesso n7 = new NumeroComplesso(-4,inf);                           // a<0,b=inf
        NumeroComplesso n8 = new NumeroComplesso(4,inf);                            // a>0,b=inf
        NumeroComplesso n9 = new NumeroComplesso(0,inf);                            // a=0,b=inf
        NumeroComplesso n10 = new NumeroComplesso(-4,negativeinf);                  // a<0,b=-inf
        NumeroComplesso n11 = new NumeroComplesso(4,negativeinf);                   // a>0,b=-inf
        NumeroComplesso n12 = new NumeroComplesso(0,negativeinf);                   // a=0,b=-inf
        NumeroComplesso n13 = new NumeroComplesso(inf,-4);                          // a=inf,b<0
        NumeroComplesso n14 = new NumeroComplesso(inf,4);                           // a=inf,b>0
        NumeroComplesso n15 = new NumeroComplesso(inf,0);                           // a=inf,b=0
        NumeroComplesso n16 = new NumeroComplesso(negativeinf,-4);                  // a=-inf,b<0
        NumeroComplesso n17 = new NumeroComplesso(negativeinf,4);                   // a=-inf,b>0
        NumeroComplesso n18 = new NumeroComplesso(negativeinf,0);                   // a=-inf,b=0
        NumeroComplesso n19 = new NumeroComplesso(inf,inf);                         // a=inf,b=inf
        NumeroComplesso n20 = new NumeroComplesso(negativeinf,negativeinf);         // a=-inf,b=-inf
        
        assertTrue(new NumeroComplesso(1.5707963267948966,0.25541281188299536).parteReale() == n.atan().parteReale() && new NumeroComplesso(1.5707963267948966,0.25541281188299536).parteImmaginaria() == n.atan().parteImmaginaria());
        assertTrue(new NumeroComplesso(-1.5707963267948966,-0.25541281188299536).parteReale() == n0.atan().parteReale() && new NumeroComplesso(-1.5707963267948966,-0.25541281188299536).parteImmaginaria() == n0.atan().parteImmaginaria());
        assertTrue(new NumeroComplesso(0,0).parteReale() == n1.atan().parteReale() && new NumeroComplesso(0,0).parteImmaginaria() == n1.atan().parteImmaginaria());
        assertTrue(new NumeroComplesso(1.4808695768986575,0.14694666622552982).parteReale() == n2.atan().parteReale() && new NumeroComplesso(1.4808695768986575,0.14694666622552982).parteImmaginaria() == n2.atan().parteImmaginaria());
        assertTrue(new NumeroComplesso(1.4808695768986575,-0.14694666622552977).parteReale() == n3.atan().parteReale() && new NumeroComplesso(1.4808695768986575,-0.14694666622552977).parteImmaginaria() == n3.atan().parteImmaginaria());
        assertTrue(new NumeroComplesso(-1.2490457723982544,1.1102230246251565E-16).parteReale() == n4.atan().parteReale() && new NumeroComplesso(-1.2490457723982544,1.1102230246251565E-16).parteImmaginaria() == n4.atan().parteImmaginaria());
        assertTrue(new NumeroComplesso(-1.4808695768986575,0.14694666622552982).parteReale() == n5.atan().parteReale() && new NumeroComplesso(-1.4808695768986575,0.14694666622552982).parteImmaginaria() == n5.atan().parteImmaginaria());
        assertTrue(new NumeroComplesso(-1.4701377726075762,-0.09932544936725085).parteReale() == n6.atan().parteReale() && new NumeroComplesso(-1.4701377726075762,-0.09932544936725085).parteImmaginaria() == n6.atan().parteImmaginaria());
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n7.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n7.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n8.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n8.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n9.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n9.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n10.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n10.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n11.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n11.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n12.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n12.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n13.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n13.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n14.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n14.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n15.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n15.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n16.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n16.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n17.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n17.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n18.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n18.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n19.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n19.atan().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n20.atan().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n20.atan().parteImmaginaria(), 10e-1);
    }

    /**
     * Test of potenza method, of class NumeroComplesso.
     */
    @Test
    public void testPotenza() throws Exception {
    }

    /**
     * Test of asin method, of class NumeroComplesso.
     */
    @Test
    public void testAsin() throws Exception {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(0, 4);                              // a=0,b>0
        NumeroComplesso n0 = new NumeroComplesso(0, -4);                            // a=0,b<0
        NumeroComplesso n1 = new NumeroComplesso(0, 0);                             //a=0,b=0
        NumeroComplesso n2 = new NumeroComplesso(3, 5);                             //a>0,b>0
        NumeroComplesso n3 = new NumeroComplesso(3, -5);                            //a>0,b<0
        NumeroComplesso n4 = new NumeroComplesso(-3, 0);                            // a<0,b=0
        NumeroComplesso n5 = new NumeroComplesso(-3, 5);                            // a<0,b>0
        NumeroComplesso n6 = new NumeroComplesso(-5, -5);                           // a<0,b<0
        NumeroComplesso n7 = new NumeroComplesso(-4,inf);                           // a<0,b=inf
        NumeroComplesso n8 = new NumeroComplesso(4,inf);                            // a>0,b=inf
        NumeroComplesso n9 = new NumeroComplesso(0,inf);                            // a=0,b=inf
        NumeroComplesso n10 = new NumeroComplesso(-4,negativeinf);                  // a<0,b=-inf
        NumeroComplesso n11 = new NumeroComplesso(4,negativeinf);                   // a>0,b=-inf
        NumeroComplesso n12 = new NumeroComplesso(0,negativeinf);                   // a=0,b=-inf
        NumeroComplesso n13 = new NumeroComplesso(inf,-4);                          // a=inf,b<0
        NumeroComplesso n14 = new NumeroComplesso(inf,4);                           // a=inf,b>0
        NumeroComplesso n15 = new NumeroComplesso(inf,0);                           // a=inf,b=0
        NumeroComplesso n16 = new NumeroComplesso(negativeinf,-4);                  // a=-inf,b<0
        NumeroComplesso n17 = new NumeroComplesso(negativeinf,4);                   // a=-inf,b>0
        NumeroComplesso n18 = new NumeroComplesso(negativeinf,0);                   // a=-inf,b=0
        NumeroComplesso n19 = new NumeroComplesso(inf,inf);                         // a=inf,b=inf
        NumeroComplesso n20 = new NumeroComplesso(negativeinf,negativeinf);         // a=-inf,b=-inf
        
        assertTrue(new NumeroComplesso(0,2.094712547261101).parteReale() == n.asin().parteReale() && new NumeroComplesso(0,2.094712547261101).parteImmaginaria() == n.asin().parteImmaginaria());
        assertTrue(new NumeroComplesso(0,-2.0947125472611012).parteReale() == n0.asin().parteReale() && new NumeroComplesso(0,-2.0947125472611012).parteImmaginaria() == n0.asin().parteImmaginaria());
        assertTrue(new NumeroComplesso(0,0).parteReale() == n1.asin().parteReale() && new NumeroComplesso(0,0).parteImmaginaria() == n1.asin().parteImmaginaria());
        assertTrue(new NumeroComplesso(1.2878849308928524,-1.6668009074698824).parteReale() == n2.asin().parteReale() && new NumeroComplesso(1.2878849308928524,-1.6668009074698824).parteImmaginaria() == n2.asin().parteImmaginaria());
        assertTrue(new NumeroComplesso(0.2692352262887151,-1.895269057653915).parteReale() == n3.asin().parteReale() && new NumeroComplesso(0.2692352262887151,-1.895269057653915).parteImmaginaria() == n3.asin().parteImmaginaria());
        assertTrue(new NumeroComplesso(-0.8148269163709889,0.15418965476678848).parteReale() == n4.asin().parteReale() && new NumeroComplesso(-0.8148269163709889,0.15418965476678848).parteImmaginaria() == n4.asin().parteImmaginaria());
        assertTrue(new NumeroComplesso(-1.2878849308928524,-0.6115535881339651).parteReale() == n5.asin().parteReale() && new NumeroComplesso(-1.2878849308928524,-0.6115535881339651).parteImmaginaria() == n5.asin().parteImmaginaria());
        assertTrue(new NumeroComplesso(-0.39267837516165705,-3.3454345792412505).parteReale() == n6.asin().parteReale() && new NumeroComplesso(-0.39267837516165705,-3.3454345792412505).parteImmaginaria() == n6.asin().parteImmaginaria());
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n7.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n7.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n8.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n8.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n9.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n9.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n10.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n10.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n11.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n11.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n12.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n12.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n13.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n13.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n14.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n14.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n15.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n15.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n16.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n16.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n17.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n17.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n18.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n18.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n19.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n19.asin().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n20.asin().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n20.asin().parteImmaginaria(), 10e-1);
    }

    /**
     * Test of acos method, of class NumeroComplesso.
     */
    @Test
    public void testAcos() throws Exception {
        double inf = Double.POSITIVE_INFINITY;
        double negativeinf = Double.NEGATIVE_INFINITY;
        NumeroComplesso n = new NumeroComplesso(0, 4);                              // a=0,b>0
        NumeroComplesso n0 = new NumeroComplesso(0, -4);                            // a=0,b<0
        NumeroComplesso n1 = new NumeroComplesso(0, 0);                             //a=0,b=0
        NumeroComplesso n2 = new NumeroComplesso(3, 5);                             //a>0,b>0
        NumeroComplesso n3 = new NumeroComplesso(3, -5);                            //a>0,b<0
        NumeroComplesso n4 = new NumeroComplesso(-3, 0);                            // a<0,b=0
        NumeroComplesso n5 = new NumeroComplesso(-3, 5);                            // a<0,b>0
        NumeroComplesso n6 = new NumeroComplesso(-5, -5);                           // a<0,b<0
        NumeroComplesso n7 = new NumeroComplesso(-4,inf);                           // a<0,b=inf
        NumeroComplesso n8 = new NumeroComplesso(4,inf);                            // a>0,b=inf
        NumeroComplesso n9 = new NumeroComplesso(0,inf);                            // a=0,b=inf
        NumeroComplesso n10 = new NumeroComplesso(-4,negativeinf);                  // a<0,b=-inf
        NumeroComplesso n11 = new NumeroComplesso(4,negativeinf);                   // a>0,b=-inf
        NumeroComplesso n12 = new NumeroComplesso(0,negativeinf);                   // a=0,b=-inf
        NumeroComplesso n13 = new NumeroComplesso(inf,-4);                          // a=inf,b<0
        NumeroComplesso n14 = new NumeroComplesso(inf,4);                           // a=inf,b>0
        NumeroComplesso n15 = new NumeroComplesso(inf,0);                           // a=inf,b=0
        NumeroComplesso n16 = new NumeroComplesso(negativeinf,-4);                  // a=-inf,b<0
        NumeroComplesso n17 = new NumeroComplesso(negativeinf,4);                   // a=-inf,b>0
        NumeroComplesso n18 = new NumeroComplesso(negativeinf,0);                   // a=-inf,b=0
        NumeroComplesso n19 = new NumeroComplesso(inf,inf);                         // a=inf,b=inf
        NumeroComplesso n20 = new NumeroComplesso(negativeinf,negativeinf);         // a=-inf,b=-inf
        
        assertTrue(new NumeroComplesso(0.7702443284143549,-0.1774574539383436).parteReale() == n.acos().parteReale() && new NumeroComplesso(0.7702443284143549,-0.1774574539383436).parteImmaginaria() == n.acos().parteImmaginaria());
        assertTrue(new NumeroComplesso(-0.770244328414355,-3.3190501075281365).parteReale() == n0.acos().parteReale() && new NumeroComplesso(-0.770244328414355,-3.3190501075281365).parteImmaginaria() == n0.acos().parteImmaginaria());
        assertTrue(new NumeroComplesso(0,1.5707963267948966).parteReale() == n1.acos().parteReale() && new NumeroComplesso(0,1.5707963267948966).parteImmaginaria() == n1.acos().parteImmaginaria());
        assertTrue(new NumeroComplesso(0.5131963648382319,-1.277648989353794).parteReale() == n2.acos().parteReale() && new NumeroComplesso(0.5131963648382319,-1.277648989353794).parteImmaginaria() == n2.acos().parteImmaginaria());
        assertTrue(new NumeroComplesso(-0.5131963648382318,-3.36399432360767).parteReale() == n3.acos().parteReale() && new NumeroComplesso(-0.5131963648382318,-3.36399432360767).parteImmaginaria() == n3.acos().parteImmaginaria());
        assertTrue(new NumeroComplesso(3.141592653589793,1.762747174039087).parteReale() == n4.acos().parteReale() && new NumeroComplesso(3.141592653589793,1.762747174039087).parteImmaginaria() == n4.acos().parteImmaginaria());
        assertTrue(new NumeroComplesso(1.0493939327587558,-2.79518674764843).parteReale() == n5.acos().parteReale() && new NumeroComplesso(1.0493939327587558,-2.79518674764843).parteImmaginaria() == n5.acos().parteImmaginaria());
        assertTrue(new NumeroComplesso(-1.17797655855444,-0.8932646724950509).parteReale() == n6.acos().parteReale() && new NumeroComplesso(-1.17797655855444,-0.8932646724950509).parteImmaginaria() == n6.acos().parteImmaginaria());
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n7.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n7.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n8.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n8.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n9.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n9.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n10.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n10.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n11.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n11.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n12.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n12.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n13.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n13.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n14.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n14.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n15.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n15.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n16.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n16.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n17.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n17.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n18.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n18.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n19.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n19.acos().parteImmaginaria(), 10e-1);
        
        assertEquals(new NumeroComplesso(NaN, NaN).parteReale(), n20.acos().parteReale(), 10e-1);
        assertEquals(new NumeroComplesso(NaN, NaN).parteImmaginaria(), n20.acos().parteImmaginaria(), 10e-1);
    }

}
