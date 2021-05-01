public class duplicate_element {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            duplicate_element g = new duplicate_element();
            g.printDuplicates(a, n);
            System.out.println();
        }
    }

    static void printDuplicates(int[] a, int n) {
        int flag=0;
        SortedMap<Integer,Integer> map=new TreeMap<>();
        for(int i:a)
        {
            Integer counter=map.get(i);
            if(counter==null)
            {
                map.put(i,1);
            }
            else
            {
                counter+=1;
                map.put(i,counter);
            }
        }
        for(SortedMap.Entry<Integer,Integer> st:map.entrySet())
        {
            if(st.getValue()>1)
            {
                flag=1;
                System.out.print("Duplicate:"+st.getKey()+" ");
            }
        }
        if(flag==0)
        {
            System.out.println("-1");
        }
    }
      

    }

