/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Random;

/**
 *
 * @author sameer
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    static void quickSort(int [] arr, int start, int end){
        int pivot = arr[end];
        int j=start-1;
        for(int i =start; i<=end; i++){
            if(arr[i]<=pivot){
                j++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }  
        if(j>start+2)
        quickSort(arr, start, j-1);
        
        if((j+1)<end)
        quickSort(arr, j+1, end);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int n=10000;
        
        int [] arr = new int[n];
        Random rand = new Random();
        for(int i=0; i<n; i++){
            arr[i] = rand.nextInt(9999999)+1;
        }
        QuickSort.quickSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+" ");
        }
        
    }
    
}
