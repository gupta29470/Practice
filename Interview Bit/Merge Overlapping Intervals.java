public class Solution {
  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
      
      if (intervals.size() < 2){
          return intervals;
      }
    
    Collections.sort(intervals, new Comparator<Interval>(){
        public int compare (Interval i1, Interval i2){
            int temp = i1.start - i2.start;
            if (temp != 0){
                return temp;
            }
            return i1.end - i2.end;
        }
    });
    
    ArrayList<Interval> res = new ArrayList<Interval>();
    
    Interval temp = intervals.get(0);
    int start = temp.start;
    int end = temp.end;
    
    for (int index = 1; index < intervals.size(); index++){
        Interval current = intervals.get(index);
        
        if (current.start <= end){
            end = Math.max(current.end, end);
        }
        else{
            res.add(new Interval(start, end));
            start = current.start;
            end = current.end;
        }
    }
    res.add(new Interval(start,end));
    return res;
    
  }
}




import java.util.*;

public class vit {

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 5), new Interval(2, 3),
                new Interval(4, 6), new Interval(7, 8),
                new Interval(8, 10), new Interval(12, 15)
        );
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
//                int temp = i1.start - i2.start;
//                if (temp != 0){
//                    return temp;
//                }
                return i1.start - i2.start;
            }
        });

        Interval temp = intervals.get(0);
        int start = temp.start, end = temp.end;
        List<Interval> result = new ArrayList<>();

        int index = 1;
        while (index < intervals.size()) {
            Interval current = intervals.get(index);

            if (current.start <= end) {
                end = Math.max(current.end, end);
                index ++;
            } else {
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
                index ++;
            }
        }
        result.add(new Interval(start, end));

        for (Interval printInterval : result) {
            System.out.println("{" + printInterval.start + " " + printInterval.end + "}");
        }
    }
}

class Interval {

    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
