/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author sameer
 */
interface i1{
    public static int a = 15;
    public void show();
    public static void show1(){
        System.out.println("i1");
    };
}
interface i2{
    public static  void show2(){
        System.out.println("i2");
    };
}
interface i3{
    public static  void show3(){
        System.out.println("i3");
    };
}
interface i4{
    public static void show4(){
        System.out.println("i4");
    };
}
public class InterfaceExample implements i2, i3, i4 {

    void show(){
        System.out.println(i1.a);
    }
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        InterfaceExample example = new InterfaceExample();
        i2.show2();
        Object o = new Object();
        System.out.println(o.getClass());
    }
    
}
