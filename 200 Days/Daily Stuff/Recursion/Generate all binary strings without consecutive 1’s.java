public class vit {

    public static void main(String[] args) throws Exception {
        int input = 4;
        generateAllString(input);
    }

    public static void generateAllString(int limit){
        
        if (limit <= 0){
            return;
        }
        
        char str[] = new char[limit];
        
         // Generate all Binary string starts with '0' 
        str[0] = '0';
        generateAllStringUtil(limit, str, 1);
        
        // Generate all Binary string starts with '1'
        str[0] = '1';
        generateAllStringUtil(limit, str, 1);
    }
    
    public static void generateAllStringUtil(int limit, char []str, int size){
        
        if (size == limit){
            for (char temp : str){
                System.out.print(temp);
            }
            System.out.println("");
            return;
        }
        
        //if previous character is '1' then we put only 0 at end of string 
        //example str = "01" then new string be "010" 
        if (str[size -1 ] =='1'){
            str[size] = '0';
            generateAllStringUtil(limit, str, size + 1);
        }
        
        // if previous character is '0' than we put both '1' and '0' at end of string 
        // example str = "00" then new  string "001" and "000"
        if (str[size - 1] == '0'){
            str[size] = '0';
            generateAllStringUtil(limit, str, size + 1);
            
            str[size] = '1';
            generateAllStringUtil(limit, str, size + 1);
        }
    }

}
/*
K : size of string 
First We Generate All string starts with '0'
initialize n = 1 . 
GenerateALLString ( K  , Str , n )
  a. IF n == K 
     PRINT str.
  b. IF previous character is '1' :: str[n-1] == '1'
     put str[n] = '0'
     GenerateAllString ( K , str , n+1 )
  c. IF previous character is '0' :: str[n-1] == '0'
     First We Put zero at end and call function 
      PUT  str[n] = '0'
           GenerateAllString ( K , str , n+1 )  
      PUT  str[n] = '1'
           GenerateAllString ( K , str , n+1 )

Second Generate all binary string starts with '1'
DO THE SAME PROCESS 
*/