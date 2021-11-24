/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

/**
 * @author Francesco
 */
public class NumeroComplesso extends Object {

    private double x, y;

    //Costruttore del numero complesso z = u + i*v;
    public NumeroComplesso(double u, double v) {
        this.x = u;
        this.y = v;
    }
    

    //Funzione che ritorna la parte reale del numero complesso; ritorna Re[z], dove z è il numero complesso;
    public double parteReale() {
        return x;
    }

    //Funzione che ritorna la parte immaginaria del numero complesso; ritorna Im[z], dove z è il numero complesso;
    public double parteImmaginaria() {
        return y;
    }

    //La funzione ritorna il modulo di un numero complesso; ritorna |z|, dove z è il numero complesso; 
    public double modulo() {
        if (x != 0 || y != 0) {
            return Math.sqrt(x * x + y * y);
        } else {
            return -1;
        }
    }

    /*funzione che si occupa di effettuare la somma tra due numeri complessi. 
    La funzione prende in input un numero complesso e lo somma all'oggetto numero complesso che richiama il metodo.*/
    public NumeroComplesso somma(NumeroComplesso w) {
        return new NumeroComplesso(x + w.parteReale(), y + w.parteImmaginaria());
    }

    /*funzione che si occupa di effettuare la sottrazione tra due numeri complessi.
    La funzione prende in input un numero complesso e lo sottrae all'oggetto numero complesso che richiama il metodo.*/
    public NumeroComplesso sottrazione(NumeroComplesso w) {
        return new NumeroComplesso(x - w.parteReale(), y - w.parteImmaginaria());
    }

    /*funzione che si occupa di effettuare il prodotto tra due numeri complessi.
    La funzione prende in input un numero complesso e lo moltiplica all'oggetto numero complesso che richiama il metodo.*/
    public NumeroComplesso prodotto(NumeroComplesso w) {
        return new NumeroComplesso(x * w.parteReale() - y * w.parteImmaginaria(), x * w.parteImmaginaria() + y * w.parteReale());
    }

    /*funzione che si occupa di effettuare il rapporto tra due numeri complessi.
    La funzione prende in input un numero complesso e lo divide all'oggetto numero complesso che richiama il metodo.*/
    public NumeroComplesso rapporto(NumeroComplesso w) {
        double den = Math.pow(w.modulo(), 2);
        return new NumeroComplesso((x * w.parteReale() + y * w.parteImmaginaria()) / den, (y * w.parteReale() - x * w.parteImmaginaria()) / den);
    }

    /*funzione che si occupa di effettuare l'esponenziale complesso di un numero complesso.*/
    public NumeroComplesso esponenziale() {
        return new NumeroComplesso(Math.exp(x) * Math.cos(y), Math.exp(x) * Math.sin(y));
    }

    /*La funzione si occupa di calcolare l'argomento di un numero complesso*/
    public double argomento() {
        return Math.atan2(y, x);
    }

    /*La funzione si occupa di calcolare il logaritmo di un numero complesso.
    Il logaritmo è calcolato secondo la formulazione: ln(z) = ln|z| + iarg(z), dove z è il numero complesso;*/
    public NumeroComplesso logaritmo() {
        return new NumeroComplesso(Math.log(this.modulo()), this.argomento());
    }

    /*La funzione effettua il calcolo di radice quadrata di un numero complesso;*/
    public NumeroComplesso radice() {
        double r = Math.sqrt(this.modulo());
        double theta = this.argomento() / 2;
        return new NumeroComplesso(r * Math.cos(theta), r * Math.sin(theta));
    }

    /*La funzione si occupa di calcolare il coseno iperbolico di un numero complesso.
    Questa funzione richiede un input di tipo double, ed è usata per il calcolo delle funzioni trigonometriche complesse;*/
    private double cosenoIperbolico1(double theta) {
        return (Math.exp(theta) + Math.exp(-theta)) / 2;
    }

    /*La funzione si occupa di calcolare il seno iperbolico di un numero complesso.
    Questa funzione richiede un input di tipo double, ed è usata per il calcolo delle funzioni trigonometriche complesse successive;*/
    private double senoIperbolico1(double theta) {
        return (Math.exp(theta) - Math.exp(-theta)) / 2;
    }

    /*La funzione si occupa di calcolare il seno di un numero complesso;*/
    public NumeroComplesso seno() {
        return new NumeroComplesso(cosenoIperbolico1(y) * Math.sin(x), senoIperbolico1(y) * Math.cos(x));
    }

    /*La funzione si occupa di calcolare il coseno di un numero complesso;*/
    public NumeroComplesso coseno() {
        return new NumeroComplesso(cosenoIperbolico1(y) * Math.cos(x), -senoIperbolico1(y) * Math.sin(x));
    }

    /*La funzione si occupa di calcolare il seno iperbolico di un numero complesso senza richiedere input;*/
    public NumeroComplesso senoIperbolico2() {
        return new NumeroComplesso(senoIperbolico1(x) * Math.cos(y), cosenoIperbolico1(x) * Math.sin(y));
    }

    /*La funzione si occupa di calcolare il coseno iperbolico di un numero complesso senza richiedere input;*/
    public NumeroComplesso cosenoIperbolico2() {
        return new NumeroComplesso(cosenoIperbolico1(x) * Math.cos(y), senoIperbolico1(x) * Math.sin(y));
    }

    /*La funzione si occupa di calcolare la tangente di un numero complesso;*/
    public NumeroComplesso tan() {
        return (this.seno()).rapporto(this.coseno());
    }

    /*La funzione si occupa di effettuare l'inversione del segno di un numero complesso;*/
    public NumeroComplesso inversioneSegno() {
        return new NumeroComplesso(-x, -y);
    }

    /*La funzione si occupa di fornire la rappresentazione di un numero complesso sottoforma di stringa. 
      La funzione ritorna la rappresentazione di un numero complesso nella maniera più appropriata tra le seguenti: 
      x+i*y, x-i*y, x, or i*y as appropriate.*/
    public String toString() {
        if (x != 0 && y > 0) {
            return x + " + " + y + "i";
        }
        if (x != 0 && y < 0) {
            return x + " - " + (-y) + "i";
        }
        if (y == 0) {
            return String.valueOf(x);
        }
        if (x == 0) {
            return y + "i";
        }
        //shouldn't get here (unless Inf or NaN)
        return x + " + i*" + y;

    }
}
