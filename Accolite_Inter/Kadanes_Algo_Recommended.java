class Kadanes_Algo_Recommended {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-->0){
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		    }
		    int msf=Integer.MIN_VALUE,meh=0;
		    for(int i=0;i<n;i++){
		        meh=meh+a[i];
		        if(meh<a[i]){
		            meh=a[i];
		        }
		        if(msf<meh){
		            msf=meh;
		        }
		    }
		    System.out.println(msf);
		    
		}
	}
}