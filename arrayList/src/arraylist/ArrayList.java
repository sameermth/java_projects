/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

/**
 *
 * @author sameer
 */
class MyArrayList{
    private static final int SIZE_FACTOR = 5;
    
    private Object data[];
    
    private int index;
    
    private int size;
    
    private boolean name;

    public MyArrayList() {
        this.data = new Object[SIZE_FACTOR];
        this.size = SIZE_FACTOR;
    }
    
    public void add(Object obj){
        if(this.index == this.size-1){
            increaseSizeAndReallocate();
        }
        data[this.index] = obj;
        this.index++;
    }
    
    public void increaseSizeAndReallocate(){
        this.size = this.size+SIZE_FACTOR;
        Object newData[] = new Object[this.size];
        
        for(int i=0; i<data.length; i++){
            newData[i] = data[i];
        }
        this.data = newData;
    }
    public Object get(int i)throws Exception{
        if(i>this.index-1){
            throw new Exception("ArrayIndexOutOfBound");
        }
        if(i<0){
            throw new Exception("Negative Value");
        }
        return this.data[i];
    }
    public void remove(int i) throws Exception{
		if(i>this.index-1){
			throw new Exception("ArrayIndexOutOfBound");
		}
		if(i<0){
			throw new Exception("Negative Value");
		}
		for(int x=i; x<this.data.length-1;x++){
			data[x]=data[x+1];
		}
		this.index--;
	}
}
public class ArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        MyArrayList mal = new MyArrayList();
		for(int i=0; i<10;i++){
                    mal.add(i);
                }
		
		mal.remove(5);
		System.out.println(mal.get(7));
    }
    
}
