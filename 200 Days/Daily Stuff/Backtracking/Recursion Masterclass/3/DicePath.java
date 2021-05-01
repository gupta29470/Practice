/*
There are n cells arranged in linear fashion. You are standing at 0th cell and want to 
reach n - 1 cell. At each cell you can have 6 possible jumps to make.

cells : | | | | | 
		 0 1 2 3

So you can give me all the ways from 1 to n - 1, 2 to n - 1, 3 to n - 1... n - 2 to n - 1
paths, I just want to append 1 to 6 at end because from 0 I can directly jump to 1
with 1 jump, from 0 I can directly jump to 2 with 2 jump and so on....
*/

public class Practice {

    public static void main(String[] args) {
        int n = 7, value = 0;
        
        dicePath(n, value, "");
    }
    
    public static void dicePath(int n, int value, String outputPaths){
        
        // Base Cases
        // invalid path
        if (value >= n){
            return;
        }
        // valid path
        if (value == n - 1){
            System.out.println(outputPaths);
            return;
        }
        
		/*
So you can give me all the ways from 1 to n - 1, 2 to n - 1, 3 to n - 1... n - 2 to n - 1
paths, I just want to append 1 to 6 at end because from 0 I can directly jump to 1
with 1 jump, from 0 I can directly jump to 2 with 2 jump and so on....
		*/
        for (int _value = 1; _value <= 6; _value++){
            dicePath(n, value + _value, outputPaths + _value + "->");
        }
    }
}
