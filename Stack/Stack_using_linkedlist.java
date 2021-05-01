public class Stack_using_linkedlist {

    static Nodess top=null;
    static int max = 10;
    static int stack[] = new int[max];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        push(55);
        push(56);
        push(57);
        foss f=new foss();
        f.print();
        pop();
        f.print();
        peek();
        isEmpty();
        System.out.println(size());
    }
    static void push(int data) {
       Nodess newnode=new Nodess();
       if(newnode==null){
           System.out.println("Stack Overflow");
       }
       else{
           newnode.data=data;
           newnode.next=top;
           top=newnode;
       }
    }
    static void  pop() { 
         if(top==null){
             System.out.println("Stack Underflow");
         }
         else{
             top=top.next;
         }
    }
    void print(){
        if(top==null){
            System.out.println("Stack is empty");
        }
        else{
            Nodess temp=top;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
        System.out.println("");
    }

//
   static void peek() {
        if(top==null){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println(top.data);
        }
    }
   static boolean isEmpty(){  
       return top==null;
   }
   static int size(){
       int count=0;
       if(top==null){
           System.out.println("0");
       }
       else{
           Nodess temp=top;
           while(temp!=null){
               count++;
               temp=temp.next;
           }
       }
       return count;
   }
}

class Nodess{
   int data;
   Nodess next;
   Nodess(){
       data=0;
       next=null;
   }
   Nodess(int data){
       this.data=data;
       next=null;
   }
    
}