/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatricescientifica;

/**
    Complex implements a complex number and defines complex
    arithmetic and mathematical functions
    Last Updated February 27, 2001
    Copyright 1997-2001
    @version 1.0
    @author Andrew G. Bennett
*/
public class NumeroComplesso extends Object {

    private double x,y;
    
    /**
        Constructs the complex number z = u + i*v
        @param u Real part
        @param v Imaginary part
    */
    public NumeroComplesso(double u,double v) {
        this.x=u;
        this.y=v;
    }
    
    /**
        Real part of this Complex number 
        @return Re[z] where z is this Complex number.
    */
    public double parteReale() {
        return x;
    }
    
    /**
        Imaginary part of this Complex number 
        @return Im[z] where z is this Complex number.
    */
    public double parteImmaginaria() {
        return y;
    }
    
    /**
        Modulus of this Complex number
       //funzione trascendentale
        @return |z| where z is this Complex number.
    */
    public double modulo(){
        if (x!=0 || y!=0) {
            return Math.sqrt(x*x+y*y);
        } else {
            return -1;
        }
    }
    

    
    public NumeroComplesso somma(NumeroComplesso w) {
        return new NumeroComplesso(x+w.parteReale(),y+w.parteImmaginaria());
    }
    

    public NumeroComplesso sottrazione(NumeroComplesso w) {
        return new NumeroComplesso(x-w.parteReale(),y-w.parteImmaginaria());
    }
    
    /**
        Complex multiplication (doesn't change this Complex number).
        @param w is the number to multiply by.
        @return z*w where z is this Complex number.
    */
    public NumeroComplesso prodotto(NumeroComplesso w) {
        return new NumeroComplesso(x*w.parteReale()-y*w.parteImmaginaria(),x*w.parteImmaginaria()+y*w.parteReale());
    }
    

    public NumeroComplesso rapporto(NumeroComplesso w) {
        double den=Math.pow(w.modulo(),2);
        return new NumeroComplesso((x*w.parteReale()+y*w.parteImmaginaria())/den,(y*w.parteReale()-x*w.parteImmaginaria())/den);
    }
    
    /**
        Complex exponential (doesn't change this Complex number).
        @return exp(z) where z is this Complex number.
        * trascendentale
    */
    public NumeroComplesso esponenziale() {
        return new NumeroComplesso(Math.exp(x)*Math.cos(y),Math.exp(x)*Math.sin(y));
    }
    
    /**
        Principal branch of the Complex logarithm of this Complex number.
        (doesn't change this Complex number).
        The principal branch is the branch with -pi < arg <= pi.
        @return log(z) where z is this Complex number.
        * trascendentale
    */
    
        /**
        Argument of this Complex number 
        (the angle in radians with the x-axis in polar coordinates).
        @return arg(z) where z is this Complex number.
    */
    public double argomento() {
        return Math.atan2(y,x);
    }
    public NumeroComplesso logaritmo() {
        return new NumeroComplesso(Math.log(this.modulo()),this.argomento());
    }
    
    /**
        Complex square root (doesn't change this complex number).
        Computes the principal branch of the square root, which 
        is the value with 0 <= arg < pi.
        @return sqrt(z) where z is this Complex number.
    */
    public NumeroComplesso radice() {
        double r=Math.sqrt(this.modulo());
        double theta=this.argomento()/2;
        return new NumeroComplesso(r*Math.cos(theta),r*Math.sin(theta));
    }
    
    // Real cosh function (used to compute complex trig functions). TRASCENDENTALE
    private double cosh(double theta) {
        return (Math.exp(theta)+Math.exp(-theta))/2;
    }
    
    // Real sinh function (used to compute complex trig functions)
    private double sinh(double theta) {
        return (Math.exp(theta)-Math.exp(-theta))/2;
    }
    
    /**
        Sine of this Complex number (doesn't change this Complex number).
        <br>sin(z) = (exp(i*z)-exp(-i*z))/(2*i).
        @return sin(z) where z is this Complex number.
    */
    public NumeroComplesso seno() {
        return new NumeroComplesso(cosh(y)*Math.sin(x),sinh(y)*Math.cos(x));
    }
    
    /**
        Cosine of this Complex number (doesn't change this Complex number).
        <br>cos(z) = (exp(i*z)+exp(-i*z))/ 2.
        @return cos(z) where z is this Complex number.
    */
    public NumeroComplesso coseno() {
        return new NumeroComplesso(cosh(y)*Math.cos(x),-sinh(y)*Math.sin(x));
    }
    
    /**
        Hyperbolic sine of this Complex number 
        (doesn't change this Complex number).
        <br>sinh(z) = (exp(z)-exp(-z))/2.
        @return sinh(z) where z is this Complex number.
    */
    public NumeroComplesso sinh() {
        return new NumeroComplesso(sinh(x)*Math.cos(y),cosh(x)*Math.sin(y));
    }
    
    /**
        Hyperbolic cosine of this Complex number 
        (doesn't change this Complex number).
        <br>cosh(z) = (exp(z) + exp(-z)) / 2.
        @return cosh(z) where z is this Complex number.
    */
    public NumeroComplesso cosh() {
        return new NumeroComplesso(cosh(x)*Math.cos(y),sinh(x)*Math.sin(y));
    }
    
    /**
        Tangent of this Complex number (doesn't change this Complex number).
        <br>tan(z) = sin(z)/cos(z).
        @return tan(z) where z is this Complex number.
    */
    public NumeroComplesso tan() {
        return (this.seno()).rapporto(this.coseno());
    }
    
    /**
        Negative of this complex number (chs stands for change sign). 
        This produces a new Complex number and doesn't change 
        this Complex number.
        <br>-(x+i*y) = -x-i*y.
        @return -z where z is this Complex number.
    */
    public NumeroComplesso inversioneSegno() {
        return new NumeroComplesso(-x,-y);
    }
    
    /**
        String representation of this Complex number.
        @return x+i*y, x-i*y, x, or i*y as appropriate.
    */
    public String toString() {
        if (x!=0 && y>0) {
            return x+" + "+y+"i";
        }
        if (x!=0 && y<0) {
            return x+" - "+(-y)+"i";
        }
        if (y==0) {
            return String.valueOf(x);
        }
        if (x==0) {
            return y+"i";
        }
        // shouldn't get here (unless Inf or NaN)
        return x+" + i*"+y;
        
    }       
}
