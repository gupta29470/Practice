/*
Let capacity be the number of pages that
memory can hold.  Let set be the current
set of pages in memory.

1- Start traversing the pages.
 i) If set holds less pages than capacity.
   a) Insert page into the set one by one until 
      the size  of set reaches capacity or all
      page requests are processed.
   b) Simultaneously maintain the recent occurred
      index of each page in a map called indexes.
   c) Increment page fault
 ii) Else 
   If current page is present in set, do nothing.
   Else 
     a) Find the page in the set that was least 
     recently used. We find it using index array.
     We basically need to replace the page with
     minimum index.
     b) Replace the found page with current page.
     c) Increment page faults.
     d) Update index of current page.

2. Return page faults.
*/

import java.util.*;

public class prat {

    public static void main(String[] args) {
        int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int capacity = 4;

        System.out.println(LRU(pages.length, pages, capacity));
    }

    public static int LRU(int numberOfPages, int pages[], int capacity) {
        
        // To represent set of current pages. We use
        // an unordered_set so that we quickly check
        // if a page is present in set or not
        Set<Integer> pageSet = new HashSet<>();
        
        // To store least recently used indexes
        // of pages.
        Map<Integer, Integer> indexes = new HashMap<>();
        
        // Start from initial page
        int pageFaults = 0;

        for (int index = 0; index < numberOfPages; index++) {
            
            // Check if the set can hold more pages
            if (pageSet.size() < capacity) {
                
                // Insert it into set if not present
                // already which represents page fault
                if (!pageSet.contains(pages[index])) {
                    pageSet.add(pages[index]);
                    
                    // increment page fault
                    pageFaults++;
                }
                
                // Store the recently used index of
                // each page
                indexes.put(pages[index], index);
            } 
            
            // If the set is full then need to perform lru
            // i.e. remove the least recently used page
            // and insert the current page
            else {
                
                // Check if current page is not already
                // present in the set
                if (!pageSet.contains(pages[index])) {
                    
                    // Find the least recently used pages
                    // that is present in the set
                    int lru = Integer.MAX_VALUE, removeValue = Integer.MIN_VALUE;

                    Iterator<Integer> iterator = pageSet.iterator();
                    while (iterator.hasNext()) {
                        int currentValue = iterator.next();

                        if (indexes.get(currentValue) < lru) {
                            lru = indexes.get(currentValue);
                            removeValue = currentValue;
                        }
                    }
                    
                    // Remove the indexes page
                    pageSet.remove(removeValue);
                    
                    //remove lru from hashmap
                    indexes.remove(removeValue);
                    
                     // insert the current page
                    pageSet.add(pages[index]);
                    
                    // Increment page faults
                    pageFaults++;
                }
                
                // Update the current page index
                indexes.put(pages[index], index);
            }
        }
        return pageFaults;
    }
}
// Time --> O(n)  Space --> 2 * O(capacity)


			********************* USING ARRAY LIST ************************

import java.util.*;

public class prat {

    public static void main(String[] args) {
        int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int capacity = 4;

        System.out.println(LRU(pages.length, pages, capacity));
    }

    public static int LRU(int numberOfPages, int pages[], int capacity) {

        // To represent set of current pages.We use
        // an Arraylist
        ArrayList<Integer> pageList = new ArrayList<>(capacity);
        int pageFaults = 0, index = 0;

        for (int currentPage : pages) {
            
            // Insert it into set if not present
            // already which represents page fault
            if (!pageList.contains(currentPage)) {
                
                // Check if the set can hold equal pages
                if (pageList.size() == capacity) {
                    pageList.remove(0);
                    pageList.add(capacity - 1, currentPage);
                } 
                else {
                    pageList.add(index, currentPage);
                }
                 // Increment page faults
                pageFaults++;
                index++;
            } 
            else {
                // Remove the indexes page
                pageList.remove((Object) currentPage);
                // insert the current page
                pageList.add(pageList.size(), currentPage);
            }
        }
        return pageFaults;
    }
}
// Time --> O(n)  Space --> O(capacity)