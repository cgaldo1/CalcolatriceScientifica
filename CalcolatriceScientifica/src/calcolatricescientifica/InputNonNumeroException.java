/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package calcolatricescientifica;

/**
 *
 * @author carmi
 */
public class InputNonNumeroException extends Exception{

    /**
     * Creates a new instance of <code>InputNonNumeroException</code> without
     * detail message.
     */
    public InputNonNumeroException() {
    }

    /**
     * Constructs an instance of <code>InputNonNumeroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InputNonNumeroException(String msg) {
        System.out.println(msg);
    }
}
