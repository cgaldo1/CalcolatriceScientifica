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
public class CommandRipristinaVariabili implements Command {

    private StackVariabili s;
    private Variabili v;

    public CommandRipristinaVariabili(StackVariabili s, Variabili v) {
        this.s = s;
        this.v = v;
    }

    @Override
    public void esegui() throws Exception {
        Variabili x = s.ripristinaVariabili();
        v.copiaArray(x.getArray(), x.getDim());
    }

}
