/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author sameer
 */
class Link{
    int data;
    Link next;
    
    Link(int data){
        this.data = data;
    }
}
public class LinkedList {

    Link first;
    LinkedList(){
        first = null;
    }
    public void insert(int data){
        Link l = new Link(data);
        l.next = first;
        first = l;
    }
    public void delete(){
        if(first == null){
            System.out.println("Linked list is empty");
        }
        else
            first  = first.next;
    }
    public void printList(){
        Link currentLink = first;
        System.out.print("List: ");
        while(currentLink!=null){
            System.out.print(currentLink.data+ " ");
            currentLink = currentLink.next;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList linkedList = new LinkedList();
        
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(15);
        
        if(!linkedList.isEmpty()){
            linkedList.printList();
        }
    }

    private boolean isEmpty() {
        return first==null;
    }
    
}
