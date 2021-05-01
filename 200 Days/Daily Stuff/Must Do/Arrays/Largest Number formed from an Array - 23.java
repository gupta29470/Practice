/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    String s[] = br.readLine().trim().split(" ");
		    Arrays.sort(s, new MyComparator());
		    for (String ans : s){
		        System.out.print(ans);
		    }
		    System.out.println();
		}
	}
}

class MyComparator implements Comparator{
    public int compare(Object o1, Object o2){
        String a = o1.toString();
        String b = o2.toString();
        
        String ab = a + b;
        String ba = b + a;
        
        return ab.compareTo(ba) > 0? -1 : 1;
    }
}







/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    String s[] = br.readLine().trim().split(" ");
		    Arrays.sort(s, new MyComparator());
		    for (String ans : s){
		        System.out.print(ans);
		    }
		    System.out.println();
		}
	}
}

class MyComparator implements Comparator<String>{
    public int compare(String a, String b){
        String ab = a + b;
        String ba = b + a;
        
        return ab.compareTo(ba) > 0? -1 : 1;
    }
}




/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().trim().split(" ");
            ArrayList<String> a = new ArrayList<>();
            for (int index = 0; index < n; index++) {
                a.add(s[index]);
            }
            Collections.sort(a, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    String ab = a + b;
                    String ba = b + a;

                    return ab.compareTo(ba) > 0 ? -1 : 1;
                }
            });

            Iterator itr = a.iterator();
            while (itr.hasNext()) {
                System.out.print(itr.next());
            }
            System.out.println("");
        }
    }
}



Time --> O(nLogn)