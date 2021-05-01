import java.util.*;

// Class to represent an interval
class Interval
{
	int begin, end;

	Interval(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}

	@Override
	public String toString() {
		return "{" + begin + "," + end + "}";
	}
}

class Main
{
	// Function to merge overlapping intervals
	public static void mergeIntervals(List<Interval> intervals)
	{
		// sort the intervals in increasing order of their starting time
		Collections.sort(intervals, Comparator.comparingInt(a -> a.begin));

		// create an empty stack
		Stack<Interval> stack = new Stack();

		// do for each interval
		for (Interval curr: intervals)
		{
			// if stack is empty or top interval in stack do not overlap
			// with current interval, push it to the stack
			if (stack.empty() || curr.begin > stack.peek().end) {
				stack.push(curr);
			}

			// if top interval of stack overlap with current interval,
			// merge two intervals by updating ending of top interval
			// to ending of current interval
			if (stack.peek().end < curr.end) {
				stack.peek().end = curr.end;
			}
		}

		// print all non-overlapping intervals
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
	}

	public static void main(String[] args)
	{
		List<Interval> intervals = Arrays.asList(
				new Interval(1, 5), new Interval(2, 3),
				new Interval(4, 6), new Interval(7, 8),
				new Interval(8, 10), new Interval(12, 15)
		);

		mergeIntervals(intervals);
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
                return i1.start - i2.start;
            }
        });

        Stack<Interval> stack = new Stack<>();
        for (Interval current : intervals) {
            if (stack.empty() || current.start > stack.peek().end) {
                stack.push(current);
            }
            if (stack.peek().end < current.end) {
                stack.peek().end = current.end;
            }
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}

class Interval {

    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return start + " " + end;
    }
}
