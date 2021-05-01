public class longestCommonSequence {
    
    public static int lcs(String str,String str1)
    {int len=str.length();
    int len1=str1.length();
    int table[][]=new int[len+1][len+1];
    for(int i=1;i<=len;i++)
    {
        for(int j=1;j<=len1;j++)
        {
            if(i==0||j==0)
            {
                table[i][j]=0;
            }
            else if(str.charAt(i-1)==str.charAt(j-1))
            {
                table[i][j]=1+table[i-1][j-1];
            }
            else
            {
                table[i][j]=Math.max(table[i][j-1], table[i-1][j]);
            }
        }
    }return table[len][len1]/2;
            }
    public static void main(String[] args) {
        String str="ABCDGH",str1="AEDFHR";
        
        System.out.println(lrs(str,str1));
    }
}
