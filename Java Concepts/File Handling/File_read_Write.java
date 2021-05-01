import java.io.*;
public class File_read_Write {

    public static void main(String[] args) throws Exception {
        //Writing in file
       FileOutputStream fos=new FileOutputStream("demo.txt");
       DataOutputStream dos=new DataOutputStream(fos);
       dos.writeUTF("Demo Content");
       
       //Reading in File
       FileInputStream fis=new FileInputStream("demo.txt");
       DataInputStream dis=new DataInputStream(fis);
       String filedata=dis.readUTF();
        System.out.println(filedata);
    }
}