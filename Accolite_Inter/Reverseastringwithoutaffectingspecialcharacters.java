public class Reverseastringwithoutaffectingspecialcharacters {

    public static void main(String[] args) {
        String s="$S%^UR&ESH@";
        char c[]=s.toCharArray();
        int l=0,r=c.length-1;
        while(l<r){
            if(!Character.isAlphabetic(c[l])){
                l++;
            }
            else if(!Character.isAlphabetic(c[r])){
                r--;
            }
            else{
                char temp=c[l];
                c[l]=c[r];
                c[r]=temp;
                l++;r--;
            }
        }
        s= new String(c);
        System.out.println(s);

    }
}
