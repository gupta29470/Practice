class GroupAnangram {
    public List<List<String>> groupAnagrams(String[] strs) {
        
       List<List<String>> res=new ArrayList<>();
        Map<String, List<String>> map =new HashMap<>();
        for(String s:strs)
        {
            char c[]=s.toCharArray();
            
            Arrays.sort(c);
            String keys=new String(c);
            
            if(map.containsKey(keys))
            {
                map.get(keys).add(s);
            }
            else
            {
                List<String> indi=new ArrayList<>();
                indi.add(s);
                map.put(keys,indi);
            }
        }
        res.addAll(map.values());
        return res;
    }
	
}

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]