/*
Sort the list according to finishing time in increasing order, because I want max
meetings in room so we will perform the meeting first we have less finishing time,
so we can achieve max meetings in one room.
*/

import java.util.*;

class MaxMeetings {

    public static void main(String[] args) {
        // Starting time
        int start[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};

        // Finish time
        int end[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };
        
        System.out.println(maxMeet(start, end));
    }

    public static int maxMeet(int start[], int end[]) {
        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int index = 0; index < start.length; index++) {
            meetings.add(new Meeting(start[index], end[index]));
        }

        Collections.sort(meetings, (Meeting meet1, Meeting meet2) -> meet1.ending - meet2.ending);
		
		// consider first meeting will happen for sure
        int maxMeetings = 1;
		
		// time_limit to check whether new 
		// meeting can be conducted or not.
        int endTime = meetings.get(0).ending;
		
		// Check for all meeting whether it 
		// can be selected or not.
        for (int index = 1; index < meetings.size(); index++) {
            int currentStartTime = meetings.get(index).starting;

            if (endTime < currentStartTime) {
                maxMeetings++;
				
				 // Update time limit
                endTime = meetings.get(index).ending;
            }
        }
        return maxMeetings;
    }
}

class Meeting {

    int starting, ending;

    Meeting(int starting, int ending) {
        this.starting = starting;
        this.ending = ending;
    }
}

import java.util.*;

class MaxMeetings {

    public static void main(String[] args) {
        // Starting time
        int start[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};

        // Finish time
        int end[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };
        
        System.out.println(maxMeet(start, end));
    }

    public static int maxMeet(int start[], int end[]) {
        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int index = 0; index < start.length; index++) {
            meetings.add(new Meeting(start[index], end[index]));
        }

        Collections.sort(meetings, (Meeting meet1, Meeting meet2) -> meet1.ending - meet2.ending);

        int maxMeetings = 1;
        int endTime = meetings.get(0).ending;

        for (int index = 1; index < meetings.size(); index++) {
            int currentStartTime = meetings.get(index).starting;

            if (endTime < currentStartTime) {
                maxMeetings++;
                endTime = meetings.get(index).ending;
            }
        }
        return maxMeetings;
    }
}

class Meeting {

    int starting, ending;

    Meeting(int starting, int ending) {
        this.starting = starting;
        this.ending = ending;
    }
}
import java.util.*;

class MaxMeetings {

    public static void main(String[] args) {
        // Starting time
        int start[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};

        // Finish time
        int end[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };
        
        System.out.println(maxMeet(start, end));
    }

    public static int maxMeet(int start[], int end[]) {
        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int index = 0; index < start.length; index++) {
            meetings.add(new Meeting(start[index], end[index]));
        }

        Collections.sort(meetings, (Meeting meet1, Meeting meet2) -> meet1.ending - meet2.ending);

        int maxMeetings = 1;
        int endTime = meetings.get(0).ending;

        for (int index = 1; index < meetings.size(); index++) {
            int currentStartTime = meetings.get(index).starting;

            if (endTime < currentStartTime) {
                maxMeetings++;
                endTime = meetings.get(index).ending;
            }
        }
        return maxMeetings;
    }
}

class Meeting {

    int starting, ending;

    Meeting(int starting, int ending) {
        this.starting = starting;
        this.ending = ending;
    }
}

// Time Complexity: O(N log(N)) 
