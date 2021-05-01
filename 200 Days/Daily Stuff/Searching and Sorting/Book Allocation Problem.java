/*
maxPages function: 
	1. Initializing low = book which has max pages, high = sum of all books pages.
	
	2. while low is less than or equals to high
		-> calculate max amount of pages one student can read 
		maxPagesPerStudent = (low + high) / 2
		
		-> Pass (books array, students, and maxPagesPerStudent) to 
		isPossibleAllocation function. If isPossibleAllocation function is true
		update result = maxPagesPerStudent and check for another minimum possible 
		pages can assign to students by high = maxPagesPerStudent - 1
			
		-> If isPossibleAllocation is false then we have assigned more minimum 
		pages to students which results that pages is left check for another
		maxPagesPerStudent which can utilize all pages by given student by 
		low = maxPagesPerStudent + 1
		
	3. return maxPagesPerStudent
	

isPossibleAllocation function:
	1. Initializing studentsCount = 1, because we have to give atleast one book
	to each student and currentPagesSum = 0, possible pages can be assigned to 
	students
	
	2. loop to book array
		-> if current pages is greater than maxPagesPerStudent means we have 
		select very low value maxPagesPerStudent, there is a chance that pages 
		will be left so return false
		
		-> if currentPagesSum + current pages is greater than maxPagesPerStudent, 
		means one student get atmost pages to read so we increment studentsCount,
		means we are assigning these pages to next student and update 
		currentPagesSum = current page
		if (studentsCount is greater than given number of students return false)
		
		-> else add current page to currentPagesSum
*/


import java.util.*;

class BookAllocation{
    public static void main(String[] args) {
        
        int array[] = {12, 34, 67, 90};
        int students = 2;
        
        System.out.println(maxPages(array, students));
    }
    
    public static int maxPages(int books[], int students){
        
        if (books.length < students){
            return -1;
        }
        
        int minPages = -1;
        int overAllsum = 0;
        
        for (int pages : books){
            overAllsum+= pages;
        }
        
        int low = Arrays.stream(books).max().getAsInt(), high = overAllsum;
        
        while (low <= high){
            int maxPagesPerStudent = (low + high) / 2;
            
            if (isPossibleAllocation(books, students, maxPagesPerStudent)){
                minPages = maxPagesPerStudent;
                high = maxPagesPerStudent - 1;
            }
            else{
                low = maxPagesPerStudent + 1;
            }
        }
        return minPages;
    }
    
    public static boolean isPossibleAllocation(int books[], int students, 
            int maxPagesPerStudent){
        int studentsCount = 1;
        int currentPagesSum = 0;
        
        for (int pages : books){
            if (pages > maxPagesPerStudent){
                return false;
            }
            
            if (currentPagesSum + pages > maxPagesPerStudent){
                studentsCount++;
                currentPagesSum = pages;
                
                if (studentsCount > students){
                    return false;
                }         
            }
            else{
                currentPagesSum+= pages;
            }
        }
        return true;
    }
    
}

// Time --> O(N LogN)




// Java program for optimal allocation of pages 
  
public class GFG  
{ 
    // Utility method to check if current minimum value 
    // is feasible or not. 
    static boolean isPossible(int arr[], int n, int m, int curr_min) 
    { 
        int studentsRequired = 1; 
        int curr_sum = 0; 
       
        // iterate over all books 
        for (int i = 0; i < n; i++) 
        { 
            // check if current number of pages are greater 
            // than curr_min that means we will get the result 
            // after mid no. of pages 
            if (arr[i] > curr_min) 
                return false; 
       
            // count how many students are required 
            // to distribute curr_min pages 
            if (curr_sum + arr[i] > curr_min) 
            { 
                // increment student count 
                studentsRequired++; 
       
                // update curr_sum 
                curr_sum = arr[i]; 
       
                // if students required becomes greater 
                // than given no. of students,return false 
                if (studentsRequired > m) 
                    return false; 
            } 
       
            // else update curr_sum 
            else
                curr_sum += arr[i]; 
        } 
        return true; 
    } 
       
    // method to find minimum pages 
    static int findPages(int arr[], int n, int m) 
    { 
        long sum = 0; 
       
        // return -1 if no. of books is less than 
        // no. of students 
        if (n < m) 
            return -1; 
       
        // Count total number of pages 
        for (int i = 0; i < n; i++) 
            sum += arr[i]; 
       
        // initialize start as 0 pages and end as 
        // total pages 
        int start = 0, end = (int) sum; 
        int result = Integer.MAX_VALUE; 
       
        // traverse until start <= end 
        while (start <= end) 
        { 
            // check if it is possible to distribute 
            // books by using mid is current minimum 
            int mid = (start + end) / 2; 
            if (isPossible(arr, n, m, mid)) 
            { 
                // if yes then find the minimum distribution 
                result = Math.min(result, mid); 
       
                // as we are finding minimum and books 
                // are sorted so reduce end = mid -1 
                // that means 
                end = mid - 1; 
            } 
       
            else
                // if not possible means pages should be 
                // increased so update start = mid + 1 
                start = mid + 1; 
        } 
       
        // at-last return minimum no. of  pages 
        return result; 
    } 
      
    // Driver Method 
    public static void main(String[] args) 
    { 
        //Number of pages in books 
        int arr[] = {12, 34, 67, 90}; 
         
        int m = 2; //No. of students 
       
        System.out.println("Minimum number of pages = " + 
                          findPages(arr, arr.length, m)); 
    } 
} 