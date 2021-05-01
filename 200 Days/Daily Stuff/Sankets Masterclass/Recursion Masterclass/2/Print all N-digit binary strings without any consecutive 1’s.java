lass Main
{
    // Function to print all n–digit binary strings without any consecutive 1's
    public static void countStrings(int n, String out, int last_digit)
    {
        // if the number becomes n–digit, print it
        if (n == 0)
        {
            System.out.println(out);
            return;
        }
 
        // append 0 to the result and recur with one less digit
        countStrings(n - 1, out + '0', 0);
 
        // append 1 to the result and recur with one less digit
        // only if the last digit is 0
        if (last_digit == 0) {
            countStrings(n - 1, out + '1', 1);
        }
    }
 
    public static void main(String[] args)
    {
        // total number of digits
        int n = 5;
        String out = "";
 
        countStrings(n, out, 0);
    }
}