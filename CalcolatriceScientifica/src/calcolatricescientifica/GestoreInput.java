/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

/**
 *
 * @author carmi
 */
public class GestoreInput {

    public GestoreInput() {
    }
    //metodo che controlla se l'input è un numero e nel caso ne controlla la correttezza
    public StackNumeri controlloSeNumero(String input, StackNumeri stack){
        String inputFormattato= input.replaceAll("\\s+",""); //elimino spazi dalla stringa di input
        if(inputFormattato == "") return null;
        boolean decimale=true;
        //controllo ogni carattere della stringa se è diverso da quelli consentiti nel caso sia un numero
        //controllo inoltre se i numeri decimali siano scritti correttamente
        for(int i=0;i<inputFormattato.length();i++){
            char c=inputFormattato.charAt(i);
            if((c < '0' || c > '9') && c !='j' && c!='+' && c!='-' && c!='.') return null;
            if(decimale==false && c>='0' && c<='9')decimale = true;
            if(decimale==false)return null;
            if(c=='.')decimale=false;
        }
        if(inputFormattato.contains("j")){ //verifico se l'input contiene j
            String[] s= new String[2];
            s[0]=""; //stringa che conterrà parte reale o immaginaria dell'input
            s[1]=""; //stringa che conterrà parte immaginaria dell'input
            int count=0;
            int j=0;
            boolean doppio= false; //boolean utilizzato per verficare se all'inizio dell'input sono inseriti due segni di fila
            if(inputFormattato.charAt(0) == '-') { //controllo se il primo carattere è un - e nel caso lo aggiungo alla prima stringa
                s[count]= s[count] + inputFormattato.charAt(0);
                j++;
                doppio=true;
            }
            if(inputFormattato.charAt(0) == '+') { //controllo se il primo carattere è un + e nel caso lo salto
                j++;
                doppio=true;
            }  
            if(inputFormattato.charAt(0) == '.') return null; //se il primo carattere è un punto ritorno null
            
            if(inputFormattato.charAt(inputFormattato.length()-1) != 'j') return null; //se l'ultimo carattere non è j ritorno null
            for(;j<inputFormattato.length();j++){ //controllo carattere per carattere e se corretti li inserisco nelle stringhe apposite
                char c=inputFormattato.charAt(j);
                if((c>='0' && c<='9') || c=='.'){
                    doppio=false;
                    if(count >=2) return null;
                    if(c=='.' && s[count].contains(".")) return null;
                    s[count]= s[count] + c;
                }
                if(c == '+'){
                    if(doppio == true) return null;
                    count++;
                    if(count >=2) return null;
                }
                if(c== '-') {
                    if(doppio == true) return null;
                    count++;
                    if(count >=2) return null;
                    s[count]= s[count] + c;
                }
                if(c== 'j'){
                    doppio = false;
                    if(count >=2) return null;
                    s[count]= s[count] + c;
                    count++;
                }
            }
            if(count == 2){ // se l'input è formato da parte reale e parte immaginaria
                double n1=Double.parseDouble(s[0]);
                double n2;
                if (!"j".equals(s[1])) n2=Double.parseDouble(s[1].substring(0, s[1].length()-1)); //elimino la j dalla stringa
                else n2=1;
                NumeroComplesso nc= new NumeroComplesso(n1,n2);
                stack.push(nc);
            }
            if(count == 1){ // se l'input è formato da sola parte immaginaria
                double n3=0;
                if (!"j".equals(s[0]) && !"-j".equals(s[0])) n3=Double.parseDouble(s[0].substring(0, s[0].length()-1)); // se la parte immaginaria non è j o -j allora elimino la j dalla stringa
                else if("j".equals(s[0])) n3=1;
                else if("-j".equals(s[0])) n3=-1;
                NumeroComplesso nc= new NumeroComplesso(0,n3);
                stack.push(nc);
            }
        }
        else{ //se l'input non contiene j e quindi è formato da sola parte reale
            String a=""; //stringa utilizzata per memorizzare la parte reale
            int k=0;
            char d=inputFormattato.charAt(0);
            if(d == '.') return null; //se il primo carattere è un punto ritorno null
            if(d=='-'){
                a=a+d;
                k++;
                if(inputFormattato.length()==1)return null;
            }
            if(d=='+'){
                k++;
                if(inputFormattato.length()==1)return null;
            }
            for(;k<inputFormattato.length();k++){ //controllo carattere per carattere e se corretto inserisco nella stringa
                d=inputFormattato.charAt(k);
                if((d>='0' && d<='9') || d=='.'){
                    a=a+d;
                }
                else return null;
            }
            stack.push(new NumeroComplesso(Double.parseDouble(a),0));
        }
        return stack;
    }
    
    public StackNumeri controllaSeOperazione(String input, StackNumeri stack) throws Exception {
        NumeroComplesso nc = null;
        switch(input){
            case "+":
                nc=stack.penultimo().somma(stack.top());
                stack.push(nc);
                break;
            case "-":
                nc=stack.penultimo().sottrazione(stack.top());
                stack.push(nc);
                break;
            case "*":
                nc=stack.penultimo().prodotto(stack.top());
                stack.push(nc);
                break;
            case "/":
                nc=stack.penultimo().rapporto(stack.top());
                stack.push(nc);
                break;
            case "sqrt":
                nc = stack.top().radice();
                stack.push(nc);
                break;
            case "+-":
                nc=stack.top().inversioneSegno();
                stack.push(nc);
                break;
            case "clear":
                stack.clear();
                break;
            case "drop":
                stack.drop();
                break;
            case "dup":
                stack.dup();
                break;
            case "swap":
                stack.swap();
                break;
            case "over":
                stack.over();
                break;
            default:
                stack=null;
                
        }
        return stack;
    }
    
    
}
