/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

/**
 *
 * @author0 sameer
 */
import java.util.*;

class TestClass {	 
    public static void main(String args[])throws Exception
    {
       Scanner s = new Scanner(System.in);
       
       int t = s.nextInt();
       while(t-- > 0){
           int a = s.nextInt();
           int [] a1 = new int[a];
           
           for(int i=0; i<a; i++){
               a1[i] = s.nextInt();
           }
           
           int q = s.nextInt();
           while(q-- > 0){
               int search = s.nextInt();
               int position = -1;
               for(int i=0; i<a;i++){
                   if(a1[i] == search){
                       position = i+1;
                    }
               }
               System.out.println(position);
           }
       }
       
    }
}
