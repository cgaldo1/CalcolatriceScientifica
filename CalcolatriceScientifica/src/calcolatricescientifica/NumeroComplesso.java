
package calcolatricescientifica;

import static java.lang.Double.NaN;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

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
            return 0;
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
    public NumeroComplesso logaritmonaturale() {
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
    
    public NumeroComplesso atan() {
        return ((new NumeroComplesso(1,0).somma(new NumeroComplesso(0,1).prodotto(this))).rapporto((new NumeroComplesso(1,0).sottrazione(new NumeroComplesso(0,1).prodotto(this))))).logaritmonaturale().prodotto((new NumeroComplesso(1,0).rapporto(new NumeroComplesso(0,2))));
    }
    
    public NumeroComplesso asin() throws Exception {
        NumeroComplesso pow = new NumeroComplesso(2,0);
        NumeroComplesso membro1 = new NumeroComplesso(0,1).prodotto(this);
        NumeroComplesso membro2 = new NumeroComplesso((new NumeroComplesso(1,0).sottrazione(this.potenza(pow))).modulo(),0).radice();
        NumeroComplesso membro3 = (new NumeroComplesso(0,(new NumeroComplesso(1,0).sottrazione(this.potenza(pow))).argomento()).prodotto(new NumeroComplesso(0,1).rapporto(new NumeroComplesso(2,0)))).esponenziale();
        return membro1.somma(membro2).prodotto(membro3).logaritmonaturale().prodotto(new NumeroComplesso(1,0).rapporto(new NumeroComplesso(0,1)));
    }
    
    public NumeroComplesso acos() throws Exception{
        NumeroComplesso pow = new NumeroComplesso(2,0);
        NumeroComplesso membro1 = new NumeroComplesso((this.potenza(pow).sottrazione(new NumeroComplesso(1,0))).modulo(),0).radice();
        NumeroComplesso membro2 = (new NumeroComplesso(0,(this.potenza(pow)).sottrazione(new NumeroComplesso(1,0)).argomento()).prodotto(new NumeroComplesso(0,1).rapporto(new NumeroComplesso(2,0)))).esponenziale();
        return this.somma(membro1).prodotto(membro2).logaritmonaturale().prodotto(new NumeroComplesso(1,0).rapporto(new NumeroComplesso(0,1)));
    }
    

    /*La funzione si occupa di effettuare l'inversione del segno di un numero complesso;*/
    public NumeroComplesso inversioneSegno() {
        return new NumeroComplesso(-x, -y);
    }
    
    public NumeroComplesso potenza(NumeroComplesso n) throws Exception{
        if(n.parteImmaginaria() != 0){
             throw new Exception();
        }
        return new NumeroComplesso(Math.round(Math.pow(this.modulo(),n.parteReale())*Math.cos(this.argomento()*n.parteReale())),Math.round(Math.pow(this.modulo(),n.parteReale()))*Math.sin(this.argomento()*n.parteReale()));
    }

    /*La funzione si occupa di fornire la rappresentazione di un numero complesso sottoforma di stringa. 
      La funzione ritorna la rappresentazione di un numero complesso nella maniera più appropriata tra le seguenti: 
      x+i*y, x-i*y */
    public String toString() {
        if (x != 0 && y > 0 || x == 0 && y > 0) {
            return x + " + " + y + "j";
        }
        if (x != 0 && y < 0 || x == 0 && y < 0) {
            return x + " - " + (-y) + "j";
        }
        if (y == 0) {
            return String.valueOf(x) + " " + "+" + y +"j";
        }
        //if (x == 0) {
        //    return y + "j";
        //}
        //shouldn't get here (unless Inf or NaN)
        return x + " + j*" + y;

    }
    
    //metodo che controlla se l'input passato come parametro è un numero complesso e in questo caso lo ritorna, altrimenti ritorna null
    public static NumeroComplesso inserisciNumero(String input) {
        String[] s = new String[2];
        s[0] = ""; //stringa che conterrà parte reale o immaginaria dell'input
        s[1] = ""; //stringa che conterrà parte immaginaria o reale dell'input
        int indice = 0;
        int j = 0;
        String inputFormattato = input.replaceAll("\\s+", "");
        //formati della stringa nel caso in cui sia composta prima dalla parte reale e poi dalla parte immaginaria
        String formato1 = "[+-]?[0-9]+[/.]?[0-9]*[+-][0-9]+[/.]?[0-9]*[ji]"; //formato corretto
        String formatonot11 = "[+-]?[0-9]+[/.][+-][0-9]+[/.]?[0-9]*[ji]"; //formato errato
        String formatonot12 = "[+-]?[0-9]+[/.]?[0-9]*[+-][0-9]+[/.][ji]"; //formato errato
        //formati della stringa nel caso in cui sia composta prima dalla parte immaginaria e poi dalla parte reale
        String formato2 = "[+-]?[0-9]+[/.]?[0-9]*[ji][+-][0-9]+[/.]?[0-9]*"; //formato corretto
        String formatonot21 = "[+-]?[0-9]+[/.][ji][+-][0-9]+[/.]?[0-9]*"; //formato errato
        String formatonot22 = "[+-]?[0-9]+[/.]?[0-9]*[ji][+-][0-9]+[/.]"; //formato errato
        //formati della stringa nel caso in cui sia composta solo dalla parte reale
        String formato3 = "[+-]?[0-9]+[/.]?[0-9]*"; //formato corretto
        String formatonot31 = "[+-]?[0-9]+[/.]"; //formato errato
        //formati della stringa nel caso in cui sia composta solo dalla parte immaginaria
        String formato4 = "[+-]?[0-9]+[/.]?[0-9]*[ji]"; //formato corretto
        String formatonot41 = "[+-]?[0-9]+[/.][ji]"; //formato errato

        if (inputFormattato.matches(formato1) && !inputFormattato.matches(formatonot11) && !inputFormattato.matches(formatonot12)) {
            if (inputFormattato.charAt(0) == '-') { //controllo se il primo carattere è un - e nel caso lo aggiungo alla prima stringa
                s[indice] = s[indice] + inputFormattato.charAt(0);
                j++;
            }
            if (inputFormattato.charAt(0) == '+') { //controllo se il primo carattere è un + e nel caso lo salto
                j++;
            }
            for (; j < inputFormattato.length(); j++) {
                char c = inputFormattato.charAt(j);
                if (c != '+' && c != '-' && c != 'j' && c != 'i') {
                    s[indice] = s[indice] + c;
                }
                if (c == '+' || c == '-') {
                    indice++; //se il carattere è un + o un -, passo a riempire l'altra stringa
                }
            }
            return new NumeroComplesso(Double.parseDouble(s[0]), Double.parseDouble(s[1])); 
            
        } else if (inputFormattato.matches(formato2) && !inputFormattato.matches(formatonot21) && !inputFormattato.matches(formatonot22)) {
            if (inputFormattato.charAt(0) == '-') {
                s[indice] = s[indice] + inputFormattato.charAt(0);
                j++;
            }
            if (inputFormattato.charAt(0) == '+') {
                j++;
            }
            for (; j < inputFormattato.length(); j++) {
                char c = inputFormattato.charAt(j);
                if (c != '+' && c != '-' && c != 'j' && c != 'i') {
                    s[indice] = s[indice] + c;
                }
                if (c == '+' || c == '-') {
                    indice++;
                }
            }
            return new NumeroComplesso(Double.parseDouble(s[1]), Double.parseDouble(s[0]));
            
        } else if (inputFormattato.matches(formato3) && !inputFormattato.matches(formatonot31)) {
            return new NumeroComplesso(Double.parseDouble(inputFormattato), 0);
 
        } else if (inputFormattato.matches(formato4) && !inputFormattato.matches(formatonot41) || inputFormattato.equals("+j") || inputFormattato.equals("-j")) {
            if (inputFormattato.equals("+j")) {
                inputFormattato = "1";
            } else if (inputFormattato.equals("-j")) {
                inputFormattato = "-1";
            } else {
                inputFormattato = inputFormattato.replace("j", "");
            }
            return new NumeroComplesso(0, Double.parseDouble(inputFormattato));

        }
        return null;
    }
    
}