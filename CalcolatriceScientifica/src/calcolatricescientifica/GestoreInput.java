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
    
    public StackNumeri controlloSeNumero(String input, StackNumeri stack){
        String inputFormattato= input.replaceAll("\\s+","");
        boolean decimale=true;
        for(int i=0;i<inputFormattato.length();i++){
            char c=inputFormattato.charAt(i);
            if((c < '0' || c > '9') && c !='j' && c!='+' && c!='-' && c!='.') return null;
            if(decimale==false && c>='0' && c<='9')decimale = true;
            if(decimale==false)return null;
            if(c=='.')decimale=false;
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
            if(inputFormattato.charAt(inputFormattato.length()-1) != 'j') return null;
            for(;j<inputFormattato.length();j++){
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
            if(count == 2){
                double n1=Double.parseDouble(s[0]);
                double n2;
                if (!"j".equals(s[1])) n2=Double.parseDouble(s[1].substring(0, s[1].length()-1));
                else n2=1;
                NumeroComplesso nc= new NumeroComplesso(n1,n2);
                stack.push(nc);
            }
            if(count == 1){
                double n3=0;
                if (!"j".equals(s[0]) && !"-j".equals(s[0])) n3=Double.parseDouble(s[0].substring(0, s[0].length()-1));
                else if("j".equals(s[0])) n3=1;
                else if("-j".equals(s[0])) n3=-1;
                NumeroComplesso nc= new NumeroComplesso(0,n3);
                stack.push(nc);
            }
        }
        else{
            String a="";
            int k=0;
            char d=inputFormattato.charAt(0);
            if(d=='-'){
                a=a+d;
                k++;
                if(inputFormattato.length()==1)return null;
            }
            if(d=='+'){
                k++;
                if(inputFormattato.length()==1)return null;
            }
            for(;k<inputFormattato.length();k++){
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
    
    
}
