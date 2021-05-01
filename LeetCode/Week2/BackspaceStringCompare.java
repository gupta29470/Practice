class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        
       Stack <Character> a=backspace(S);
        Stack <Character> b=backspace(T);
        return a.equals(b);
        
    }
    public static Stack<Character> backspace (String s)
    {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if( s.charAt(i)!='#' )
            {
                char c=s.charAt(i);
                st.push(c);
                
            }
            else if(!st.isEmpty())
            {
               
                st.pop();
            }
        }
        return st;
        }
    }
	/*
	Given two strings S and T, return if they are equal when both are typed into
	empty text editors. # means a backspace character.
	
	Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".


Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".


https://www.youtube.com/watch?v=ddyikohCqyo