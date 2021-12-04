/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricescientifica;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author simfe
 */
public class OperazioneUtenteMacroCommandTest {
    
    @Test
    public void testEsegui() throws Exception{
        StackNumeri stack = new StackNumeri();
        stack.push(new NumeroComplesso(2,3));
        stack.push(new NumeroComplesso(1,1));
        stack.push(new NumeroComplesso(5,3));
        OperazioneUtenteMacroCommand macro = new OperazioneUtenteMacroCommand();
        macro.aggiungi(new CommandSomma(stack));
        macro.aggiungi(new CommandSottrazione(stack));
        macro.esegui();
        NumeroComplesso n = new NumeroComplesso(-4,-1);
        assertEquals(n.parteReale(), stack.top().parteReale(), 0.00001);
        assertEquals(n.parteImmaginaria(), stack.top().parteImmaginaria(), 0.00001);
        
        boolean thrown=false;
        try{
            macro.esegui();
        }catch(Exception e){
            thrown=true;
        }
        assertTrue(thrown);
    }
}
