/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package calcolatricescientifica;

/**
 *
 * @author carmi
 */
public class InputNonValidoException extends Exception{

    /**
     * Creates a new instance of <code>InputNonValidoException</code> without
     * detail message.
     */
    public InputNonValidoException() {
    }

    /**
     * Constructs an instance of <code>InputNonValidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InputNonValidoException(String msg) {
        System.out.println(msg);
    }
}
