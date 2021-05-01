import java.util.*;
import java.io.*;
import java.math.*;

public class LinkedList_search_count {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedl lw=new Linkedl();
        boolean flag=true;
         lw.insert_at_end(55);
        lw.insert_at_end(99);
        lw.insert_at_end(3222);
         lw.insert_at_end(55);
        lw.insert_at_end(985);
        lw.insert_at_end(99);
         lw.insert_at_end(55);
         
        lw.print();
        if(lw.search(lw.starts,199)) System.out.println("Yes");
        else System.out.println("No");
        System.out.println(lw.count(55));
}
}
class Nodes{
    private int data;
    private Nodes next;
    Nodes(){
        data=0;
        next=null;
    }
    public void setData(int data){
        this.data=data;
        
    }
    public void setNext(Nodes next){
        this.next=next;
    }
    public int getData(){
        return data;
    }
    public Nodes getNext(){
        return next;
    }
    
    
}
class Linkedl{
     Nodes starts;
    private int size;
    Linkedl(){
        size=0;
        starts=null;
    }
    public void insert_at_end(int data){
        Nodes newnode=new Nodes();
        newnode.setData(data);
        Nodes temp=starts;
        if(temp==null){
            starts=newnode;
        }
        else
        {
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(newnode);
            size++;
        }
    }
    public void print(){
        Nodes temp=starts;
        if(starts==null){
            System.out.println("Nothing to print!");
        }
        for(int i=0;i<=size;i++){
            System.out.println(temp.getData());
            temp=temp.getNext();
        }
    }
    public boolean search(Nodes head,int data){
        
        if(head==null){
           return false;
        }
        if(head.getData()==data)
            return true;
        
        return search(head.getNext(),data);
    }
    public int count(int data){
        Nodes temp=starts;
        int count=0;
        if(temp==null){
            System.out.println("Nothing to count!!");
        }
        else{
            while(temp!=null){
                if(temp.getData()==data){
                    count++;
                }
                temp=temp.getNext();
            }
        }
        return count;
    }
}