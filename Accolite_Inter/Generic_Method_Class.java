import java.util.*;

public class Generic_Method_Class {

    public static void main(String[] args) throws IOException {
        Container <Integer>c=new Container<>();
        c.value=8;
        c.show();

    }
}
class Container <T>{
    T value;
    public void show(){
        System.out.println(value.getClass().getName());//java.lang.Integer
    }
}