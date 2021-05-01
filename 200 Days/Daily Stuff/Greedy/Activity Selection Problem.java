/*
1. Sort given meetings list by finish time.
After sorting:
3 6 7
5 7 24
24 27 12
3 49 6
8 50 18
45 59 10
48 60 15
43 67 1
41 68 20
21 73 14
54 82 23
33 93 27
87 96 13
54 99 16
87 102 22
64 104 21
88 108 17
72 109 11
84 115 5
59 117 8
87 118 26
30 126 9
62 126 25
54 131 3
61 137 2
99 139 4
67 145 19
74 148 28
48 150 0
92 150 29

As above meetings sorted by end time.

2. Always consider first meeting.

3. Store 1st meeting end time in endTime variable

3. Loop from index 1:
	if current start  is greater than previous end consider this meeting 
	and update endTime by current's meeting end time
*/

class NMettings {

    public static void main(String[] args) {
        ArrayList<Meeting> meetings = new ArrayList<>();

        // Starting time 
        int s[] = {48, 43, 61, 54, 99, 84, 3, 3, 59, 30, 45, 72, 24, 87, 21, 48,
            54, 88, 8, 67, 41, 64, 87, 54, 5, 62, 87, 33, 74, 92};

        // Finish time 
        int f[] = {150, 67, 137, 131, 139, 115, 49, 6, 117, 126, 59, 109, 27,
            96, 73, 60, 99, 108, 50, 145, 68, 104, 102, 82, 7, 126, 118, 93,
            148, 150};

        // Defining an arraylist of meet type
        for (int i = 0; i < s.length; i++) // Creating object of meeting 
        // and adding in the list
        {
            meetings.add(new Meeting(s[i], f[i], i));
        }

        maxMeetings(meetings);
    }

    public static void maxMeetings(ArrayList<Meeting> meetings) {
        Sort sort = new Sort();

        Collections.sort(meetings, sort);

        ArrayList<Integer> positions = new ArrayList<>();
        positions.add(meetings.get(0).position);

        int endTime = meetings.get(0).end;

        for (int index = 1; index < meetings.size(); index++) {
            if (endTime < meetings.get(index).start) {
                positions.add(meetings.get(index).position);
                endTime = meetings.get(index).end;
            }
        }

        for (int index = 0; index < positions.size(); index++) {
            System.out.print((positions.get(index) + 1) + " ");
        }
    }

}

class Meeting {

    int start, end, position;

    Meeting(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
}

class Sort implements Comparator<Meeting> {

    @Override
    public int compare(Meeting meet1, Meeting meet2) {
        if (meet1.end < meet2.end) {
            return -1;
        } else if (meet1.end > meet2.end) {
            return 1;
        }
        return 0;
    }
}
// Time --> O(n logn + n)