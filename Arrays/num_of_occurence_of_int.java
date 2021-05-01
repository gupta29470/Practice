public class num_of_occurence_of_int {

    public static void main(String[] args) throws IOException {

       int a[]={1,2,3,3,3,3,5,3,4,5,3},n=3,counter=1,ans=0;
       Map<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<a.length;i++){
           if(map.containsKey(a[i])){
               map.put(a[i],map.get(a[i])+1);
           }
           else{
               map.put(a[i],1);
           }
       }
       for(int i:map.keySet()){
           if(map.containsKey(n)){
                ans=map.get(n);
           }
       }
        System.out.println(ans);
       
       
       
       
    }
    
}