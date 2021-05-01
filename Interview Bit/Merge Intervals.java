public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        /**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        if (intervals == null){
            intervals = new ArrayList<Interval>();
            intervals.add(newInterval);
            return intervals;
        }
        else if (intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        
        int index = 0;
        Interval toInsert = newInterval;
        
        while (index < intervals.size()){
            Interval current = intervals.get(index);
            if (current.end < toInsert.start){
                index++;
                continue;
            }
            else if (toInsert.end < current.start){
                intervals.add(index, toInsert);
                break;
            }
            else{
                toInsert.start = Math.min(current.start, toInsert.start);
                toInsert.end = Math.max(current.end, toInsert.end);
                intervals.remove(index);
            }
        }
        if (index == intervals.size()){
            intervals.add(toInsert);
        }
        return intervals;
        
    }
}
//Time --> O(nLogn)


import java.io.*;
import java.util.*;

public class vit {

    /* program to test above function */
    public static void main(String args[]) {

        ArrayList<Interval> arr = new ArrayList<>();
        arr.add(new Interval(1, 3));
        arr.add(new Interval(2, 4));
        arr.add(new Interval(15, 18));
        arr.add(new Interval(8, 10));

        
        
        Collections.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                int c = i1.start - i2.start;
                if (c != 0) {
                    return c;
                }
                return i1.end - i2.end;
            }
        }
        );
        ArrayList<Interval> res = new ArrayList<>();
        Interval temp = arr.get(0);
        int start = temp.start;
        int end = temp.end;
        
        for (int index = 1; index < arr.size(); index++){
            Interval current = arr.get(index);
            if (current.start <= end){
                end = Math.max(current.end, end);
            }
            
            else{
                res.add(new Interval(start,end));
                start = current.start;
                end = current.end;
            }
        }
        res.add(new Interval(start,end));
        
        for (int index = 0; index < res.size(); index++){
            System.out.println(res.get(index).start+"  "+ res.get(index).end);
        }

    }

}

class Interval {

    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

