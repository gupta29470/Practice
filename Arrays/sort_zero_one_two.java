public class sort_zero_one_two {

    public static void main(String[] args) throws IOException {

       int a[]={0,1,2,1,1,0,0,2,2};
       int c0=0,c1=0,c2=0;
       for(int i=0;i<a.length;i++){
            switch(a[i]){
                case 0:
                    c0++;
                    break;
                case 1:
                    c1++;
                    break;
                case 2:
                    c2++;
                    break;
                
                   
       }
       }
            int i=0;
            
            while(c0>0){
                a[i++]=0;
                c0--;
            }
             while(c1>0){
                 a[i++]=1;
                 c1--;
             }
             while(c2>0){
                 a[i++]=2;
                 c2--;
             
            }
            for(int j:a){
        System.out.print(j+" ");
            }
      
       
       
       
    }
    
}
