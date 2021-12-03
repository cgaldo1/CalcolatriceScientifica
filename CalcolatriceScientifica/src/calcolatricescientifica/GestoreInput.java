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
    
    /*Controlla se l'input inserito dall'utente è un numero,
    caso in cui tale numero viene inserito nello stack passato come parametro.
    */
    public StackNumeri controlloSeNumero(String input, StackNumeri stack){
        String[] s= new String[2];
        s[0]=""; //stringa che conterrà parte reale o immaginaria dell'input
        s[1]=""; //stringa che conterrà parte immaginaria o reale dell'input
        int indice=0;
        int j=0;
        String inputFormattato= input.replaceAll("\\s+","");
        //formati della stringa nel caso in cui sia composta prima dalla parte reale e poi dalla parte immaginaria
        String formato1 = "[+-]?[0-9]+[/.]?[0-9]*[+-][0-9]+[/.]?[0-9]*[ji]"; //formato corretto
        String formatonot11="[+-]?[0-9]+[/.][+-][0-9]+[/.]?[0-9]*[ji]"; //formato errato
        String formatonot12 ="[+-]?[0-9]+[/.]?[0-9]*[+-][0-9]+[/.][ji]"; //formato errato
        //formati della stringa nel caso in cui sia composta prima dalla parte immaginaria e poi dalla parte reale
        String formato2 = "[+-]?[0-9]+[/.]?[0-9]*[ji][+-][0-9]+[/.]?[0-9]*"; //formato corretto
        String formatonot21="[+-]?[0-9]+[/.][ji][+-][0-9]+[/.]?[0-9]*"; //formato errato
        String formatonot22="[+-]?[0-9]+[/.]?[0-9]*[ji][+-][0-9]+[/.]"; //formato errato
        //formati della stringa nel caso in cui sia composta solo dalla parte reale
        String formato3 = "[+-]?[0-9]+[/.]?[0-9]*"; //formato corretto
        String formatonot31="[+-]?[0-9]+[/.]"; //formato errato
        //formati della stringa nel caso in cui sia composta solo dalla parte immaginaria
        String formato4 = "[+-]?[0-9]+[/.]?[0-9]*[ji]"; //formato corretto
        String formatonot41 = "[+-]?[0-9]+[/.][ji]"; //formato errato
        
        if (inputFormattato.matches(formato1)&&!inputFormattato.matches(formatonot11)&&!inputFormattato.matches(formatonot12)){
            if(inputFormattato.charAt(0) == '-') { //controllo se il primo carattere è un - e nel caso lo aggiungo alla prima stringa
                s[indice]= s[indice] + inputFormattato.charAt(0);
                j++;
            }
            if(inputFormattato.charAt(0) == '+') { //controllo se il primo carattere è un + e nel caso lo salto
                j++;
            }  
            for(;j<inputFormattato.length();j++){
                char c=inputFormattato.charAt(j);
                if ( c!= '+' && c!= '-' && c != 'j' && c != 'i') s[indice]= s[indice]+c;
                if (c== '+' || c == '-') indice++; //se il carattere è un + o un -, passo a riempire l'altra stringa
            }
            stack.push(new NumeroComplesso(Double.parseDouble(s[0]),Double.parseDouble(s[1]))); //inserimento all'interno dello stack
            return stack;
        }
        else if (inputFormattato.matches(formato2)&&!inputFormattato.matches(formatonot21)&&!inputFormattato.matches(formatonot22)){
            if(inputFormattato.charAt(0) == '-') { 
                s[indice]= s[indice] + inputFormattato.charAt(0);
                j++;
            }
            if(inputFormattato.charAt(0) == '+') { 
                j++;
            }  
            for(;j<inputFormattato.length();j++){ 
                char c=inputFormattato.charAt(j);
                if ( c!= '+' && c!= '-' && c != 'j' && c != 'i') s[indice]= s[indice]+c;
                if (c== '+' || c == '-') indice++;
            }
            stack.push(new NumeroComplesso(Double.parseDouble(s[1]),Double.parseDouble(s[0])));
            return stack;
        }
        else  if (inputFormattato.matches(formato3)&&!inputFormattato.matches(formatonot31)){
            stack.push(new NumeroComplesso(Double.parseDouble(inputFormattato),0));
            return stack;
        }
        else if(inputFormattato.matches(formato4)&&!inputFormattato.matches(formatonot41) || inputFormattato.equals("+j") || inputFormattato.equals("j") || inputFormattato.equals("-j")){
            if(inputFormattato.equals("+j") || inputFormattato.equals("j")) inputFormattato="1";
            else if(inputFormattato.equals("-j"))inputFormattato="-1";
            else inputFormattato=inputFormattato.replace("j", "");
            stack.push(new NumeroComplesso(0,Double.parseDouble(inputFormattato)));
            return stack;
        }
        return null;
    }
    
    /*Controlla se l'input inserito dall'utente è un'operazione,
    caso in cui tale operazione viene eseguita sullo stack passato come parametro.
    */
    public StackNumeri controllaSeOperazione(String input, StackNumeri stack) throws Exception {
        NumeroComplesso nc = null;
        switch(input){
            case "+":
                nc=stack.penultimo().somma(stack.drop());
                stack.drop();
                stack.push(nc);
                break;
            case "-":
                nc=stack.penultimo().sottrazione(stack.drop());
                stack.drop();
                stack.push(nc);
                break;
            case "*":
                nc=stack.penultimo().prodotto(stack.drop());
                stack.drop();
                stack.push(nc);
                break;
            case "/":
                nc=stack.penultimo().rapporto(stack.drop());
                stack.drop();
                stack.push(nc);
                break;
            case "sqrt":
                nc = stack.drop().radice();
                stack.push(nc);
                break;
            case "+-":
                nc=stack.drop().inversioneSegno();
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
