/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author sameer
 */
public class MergeSort {
    
    public static void divide(int [] arr, int start,int  end){
        int mid;
        if(start<end){
            mid = (start+end)/2;
            System.out.println(mid+ " " +start+" "+end);
            
            divide(arr, start, mid);
            divide(arr, mid+1, end);
            
            merge(arr, start, mid, end);
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] arr = {2,5,4,10,1,8,9,3};
        divide(arr, 0, arr.length-1);
        
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid-start+1;
        int n2 = end-mid;
        
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        for(int i=0; i<n1; i++){
            L[i] = arr[start+i];
        }
        for(int j=0; j<n2; j++){
            R[j] = arr[mid +1+j];
        }
        
        int i=0, j=0;
        
        int k=start;
        
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
             arr[k] = L[i];
             i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
         while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
}
