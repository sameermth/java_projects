/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass;

/**
 *
 * @author sameer
 * 
 */

abstract class A{
    int a;
    void show(){
            System.out.println("Abstract class show");
            System.out.println("value of a: "+a);
    }
    abstract void print();
}
public class AbstractClass extends A {
    @Override
    void print(){
        System.out.println("Overriding abstract method and printing it in main body");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AbstractClass a = new AbstractClass();
        a.print();
        a.show();
        a.a = 25;
        a.show();
        
    }
    
}
