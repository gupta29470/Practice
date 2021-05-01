public class Recursion {

    public static void main(String[] args) throws IOException {
     int n = 5,p=4;
//        
        System.out.println(pow(n,p));
        System.out.println(sum(n));
        System.out.println(fastpow(n,p));
        System.out.println(path(4,5));
        
        

 }
//
    static int pow(int n,int p) {
        if (p == 0)
        return 1;
        return n*pow(n,p-1);
        
//
 }
    static int fastpow(int n,int p) {
        if (p == 0)
        return 1;
        if(p%2==0)
            return fastpow(n*n,p/2);
        return n*fastpow(n,p-1);

    }
//    
    static int sum(int n){
        if(n==1)
            return 1;
        return n+sum(n-1);
    }
    // No.of paths to reach end in n*m grid
    static int path(int a,int b){
        if(a==1||b==1) return 1;
        return path(a,b-1)+path(a-1,b);
    }
	}