class DoubleHelix{
    public static void main(String[] args) {
        
        int first[] = {4, -5, 100, 1000, 1005};
        int second[] = {3, -12, 1000, 1001};
        
        System.out.println(maxSum(first, second));
    }
    
    public static int maxSum(int first[], int second[]){
        int maximum = 0;
        int index1 = 0, index2 = 0;
        int sum1 = 0, sum2 = 0;
        
        while (index1 < first.length && index2 < second.length){
            if (first[index1] < second[index2]){
                sum1+= first[index1];
                index1++;
            }
            else if (first[index1] > second[index2]){
                sum2+= second[index2];
                index2++;
            }
            else{
                maximum = maximum + Math.max(sum1, sum2) + first[index1];
                sum1 = 0;
                sum2 = 0; 
                index1++;
                index2++;
            }
        }
        
        while (index1 < first.length){
            sum1+= first[index1];
            index1++;
        }
        
        while (index2 < second.length){
            sum2+= second[index2];
            index2++;
        }
        
        maximum = maximum + Math.max(sum1, sum2);
        
        return maximum;
    }
}
// Time --> O(n)