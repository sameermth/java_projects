package javaapplication1;

class JavaApplication1 {
int id;
String name;
String city;
        JavaApplication1(){
            
        }
	JavaApplication1(int id,String name)
	{
		this.id= id;
		this.name= name;
	}
        JavaApplication1( int id, String name, String city){
        this.city = city;
         }
        @Override
        public String toString(){
          return id+"..."+name+"..."+city;  
        }
        void display() { 
            System.out.println(id+ " "+ name+ " "+city);
}
public static void main (String [] args)
{
    
   
    JavaApplication1 e1 = new JavaApplication1 (111, "karan");
    JavaApplication1 e2 = new JavaApplication1 (222, "simran", "pune");
    e1.display();
    e2.display();
    
    System.out.println(e2);
    
    System.out.println(Integer.toHexString(e2.hashCode()));
    
    
}
}
