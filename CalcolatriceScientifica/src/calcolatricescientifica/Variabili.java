/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

/**
 *
 * @author jessi
 */
public class Variabili {
    NumeroComplesso[] array;
    int dim;

    public Variabili() {
        array = new NumeroComplesso[26];
        dim = 0;
    }
    
    public int indice(char x){
        char y = 'a';
        int i;
        for(i=0; i<26 && x!=y; i++) y++;
        return i;
    }
    
    //metodo che inserisce il numero complesso nell'array 
    public void inserisci(NumeroComplesso n, int indice){
        array[indice] = n;
        dim++;
    }
    
    public boolean isEmpty(){
        return this.dim==0;
    }

    public void stampa(){
        System.out.println("Array:");
        for(NumeroComplesso n: array) {
            System.out.println(n);
        }
    }
    
    //metodo che ritorna il numero complesso presente nella variabile 'x', lancia eccezione se l'array è vuoto o la variabile è null
    public NumeroComplesso getNumero(char x) throws Exception{
        int i = this.indice(x);
        if(this.isEmpty() || array[i]==null) throw new Exception();
        return array[i];
    }
    
    public void inserisciInVariabile(StackNumeri s, char x){
        int i = this.indice(x);
        this.inserisci(s.top(),i);        
    }
    
    public void inserisciInStack(StackNumeri s, char x) throws Exception{
        s.push(this.getNumero(x));
}
    
    public void sommaVariabile(StackNumeri s, char x) throws Exception{
         NumeroComplesso sum = this.getNumero(x).somma(s.top());
         this.inserisci(sum, indice(x));
    }
    
    public void sottrazioneVariabile(StackNumeri s, char x) throws Exception{
         NumeroComplesso sub = this.getNumero(x).sottrazione(s.top());
         this.inserisci(sub, indice(x));
    }
}
