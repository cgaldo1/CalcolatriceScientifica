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
    private StackNumeri stack;

    public GestoreInput(StackNumeri stack) {
        this.stack = stack;
    }
    
    public StackNumeri controlloSeNumero(String input) throws InputNonNumeroException{
        String inputFormattato= input.replaceAll("\\s+","");
        boolean corretto=true;
        for(int i=0;i<inputFormattato.length();i++){
            char c=inputFormattato.charAt(i);
            if((c < '0' || c > '9') && c !='j' && c!='+' && c!='-' && c!='.') throw new InputNonNumeroException("Input non valido");
            if(corretto==false && c>='0' && c<='9')corretto = true;
            if(corretto==false)throw new InputNonNumeroException("Input non valido");
            if(c=='.')corretto=false;
        }
        if(inputFormattato.contains("j")){
            String[] s= new String[2];
            s[0]="";
            s[1]="";
            int count=0;
            int j=0;
            boolean doppio= false;
            if(inputFormattato.charAt(0) == '-') {
                s[count]= s[count] + inputFormattato.charAt(0);
                j++;
                doppio=true;
            }
            if(inputFormattato.charAt(0) == '+') {
                j++;
                doppio=true;
            }
            if(inputFormattato.charAt(inputFormattato.length()-1) != 'j') throw new InputNonNumeroException("Input non valido");
            for(;j<inputFormattato.length();j++){
                char c=inputFormattato.charAt(j);
                if((c>='0' && c<='9') || c=='.'){
                    doppio=false;
                    if(count >=2) throw new InputNonNumeroException("Input non valido");
                    if(c=='.' && s[count].contains(".")) throw new InputNonNumeroException("Input non valido");
                    s[count]= s[count] + c;
                }
                if(c == '+'){
                    if(doppio == true) throw new InputNonNumeroException("Input non valido");
                    if(count >=2) throw new InputNonNumeroException("Input non valido");
                    count++;
                }
                if(c== '-') {
                    if(doppio == true) throw new InputNonNumeroException("Input non valido");
                    if(count >=2) throw new InputNonNumeroException("Input non valido");
                    count++;
                    s[count]= s[count] + c;
                }
                if(c== 'j'){
                    doppio = false;
                    if(count >=2) throw new InputNonNumeroException("Input non valido");
                    s[count]= s[count] + c;
                    count++;
                }
            }
            if(count == 2){
                double n1=Double.parseDouble(s[0]);
                double n2;
                if (s[1] != "j") n2=Double.parseDouble(s[1].substring(0, s[1].length()-1));
                else n2=1;
                NumeroComplesso n= new NumeroComplesso(n1,n2);
                this.stack.push(n);
            }
            if(count == 1){
                double n3;
                if (s[0] != "j") n3=Double.parseDouble(s[0].substring(0, s[0].length()-1));
                else n3=1;
                NumeroComplesso nc= new NumeroComplesso(0,n3);
                this.stack.push(nc);
            }
        }
        else{
            String a="";
            int k=0;
            char d=inputFormattato.charAt(0);
            if(d=='-'){
                a=a+d;
                k++;
            }
            if(d=='+'){
                k++;
            }
            for(;k<inputFormattato.length();k++){
                d=inputFormattato.charAt(k);
                if((d>='0' && d<='9') || d=='.'){
                    a=a+d;
                }
                else throw new InputNonNumeroException("Input non valido");
            }
            this.stack.push(new NumeroComplesso(Double.parseDouble(a),0));
        }
        return this.stack;
    }
    
    
}
