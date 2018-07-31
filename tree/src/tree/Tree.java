/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author sameer
 */

class Node{
    int key;
    Node left, right;
    
    Node(int item){
        this.key = item;
        left=right=null;
    }
    
}
public class Tree {

    /**
     * @param args the command line arguments
     */
    Node root;
    static Scanner in = new Scanner(System.in);
    Tree(int key){
        root=new Node(key);
    }
    Tree(){
        root=null;
    }
    public static Node insert(Node node, int i, int t){
        if(i<t){
        int key = in.nextInt();
        Node temp = new Node(key);
        node = temp;
        
        node.left = insert(node.left, 2*i+1, t);
        node.right = insert(node.right,2*i+2, t);
        
        }
        return node;
    }
    public static void print(Node node){
        if(node!= null){
            print(node.left);
            System.out.print(" "+node.key+" ");
            print(node.right);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        int t = in.nextInt();
        
        Tree tree = new Tree();
        
        tree.root = insert(tree.root, 0, t);
        
        print(tree.root);
        
       
        /*
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
*/
        
        
    }
    
}
