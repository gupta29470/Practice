import java.io.*;
public class Object_Serialization {

    public static void main(String[] args) throws Exception {
       
       Object object1=new Object();
       object1.i=3;
       //Writing Object
       FileOutputStream fos=new FileOutputStream("object1.txt");
       ObjectOutputStream dos=new ObjectOutputStream(fos);
       dos.writeObject(object1);//¬í sr javaapplication1.ObjectFbk]’c I ixp    it saves byte stream
       
       //Reading Object
       FileInputStream fis=new FileInputStream("object1.txt");
       ObjectInputStream ois=new ObjectInputStream(fis);
       Object object2=(Object)ois.readObject();
        System.out.println(object2.i);
    }
}

class Object implements Serializable{
    int i;
}