/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;

import java.util.Stack;

/**
 *
 * @author carmi
 */
public class GestoreInput {
    private StackNumeri stack;

    public GestoreInput(StackNumeri stack) {
        this.stack = stack;
    }
    
    public StackNumeri controlloSeNumero(String input) throws Exception{
        String inputFormattato= input.replaceAll("\\s+","");
        System.out.println(inputFormattato);
        for(int i=0;i<inputFormattato.length();i++){
            char c=inputFormattato.charAt(i);
            if((c < '0' || c > '9') && c !='j' && c!='+' && c!='-' && c!='.') throw new Exception();
        }
        System.out.println("qui1");
        if(inputFormattato.contains("j")){
            System.out.println("qui2");
            String[] s= new String[2];
            s[0]="";
            s[1]="";
            int count=0;
            int j=0;
            if(inputFormattato.charAt(0) == '-') {
                s[count]= s[count] + inputFormattato.charAt(0);
                j++;
            }
            if(inputFormattato.charAt(0) == '+') {
                j++;
            }
            for(;j<inputFormattato.length();j++){
                char c=inputFormattato.charAt(j);
                System.out.println(c);
                if((c>='0' && c<='9') || c=='.'){
                    if(count >=2) throw new Exception();
                    s[count]= s[count] + c;
                }
                if(c == '+'){
                    if(count >=2) throw new Exception();
                    count++;
                }
                if(c== '-') {
                    if(count >=2) throw new Exception();
                    count++;
                    s[count]= s[count] + c;
                }
                if(c== 'j'){
                    if(count >=2) throw new Exception();
                    s[count]= s[count] + c;
                    count++;
                }
            }
            System.out.println("sono qui3");
            System.out.println("count =" + count);
            if(count == 2){
                System.out.println("sono qui4");
                System.out.println(s[0]);
                double n1=Double.parseDouble(s[0]);
                System.out.println(n1);
                System.out.println(s[1]);
                double n2=Double.parseDouble(s[1].substring(0, s[1].length()-1));
                System.out.println(n2);
                NumeroComplesso n= new NumeroComplesso(n1,n2);
                System.out.println(n);
                this.stack.inserimento(n);
            }
            if(count == 1){
                double n3=Double.parseDouble(s[0].substring(0, s[0].length()-1));
                NumeroComplesso nc= new NumeroComplesso(0,n3);
                System.out.println(nc);
                this.stack.inserimento(nc);
            }
        }
        else{
            System.out.println("qui22");
            String a="";
            int k=0;
            char d=inputFormattato.charAt(0);
            if(d=='-'){
                a=a+d;
                k++;
            }
            for(;k<inputFormattato.length();k++){
                d=inputFormattato.charAt(k);
                if((d>='0' && d<='9') || d=='.'){
                    a=a+d;
                }
                else throw new Exception();
            }
            System.out.println(Double.parseDouble(a));
            this.stack.inserimento(new NumeroComplesso(Double.parseDouble(a),0));
        }
        return this.stack;
    }
    
    
}
