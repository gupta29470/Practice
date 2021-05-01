public class MarkerInterface implements I {
 public static void main(String[] args) {
        MarkerInterface jp=new MarkerInterface();
        if(jp instanceof I){
            System.out.println("True");
        
    }
        else{
            System.out.println("False");
        }

    }
    public void show(){
        System.out.println("Hii");
    }

}

interface I { // marker interface
    
}