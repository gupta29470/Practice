class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targeted[] = times[targetFriend];
        
        Arrays.sort(times, (times1, times2) -> (times1[0] - times2[0]));
        
        TreeMap<Integer, ArrayList<Integer>> allocatedChairs = new TreeMap<>();
        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();
        int satOn;
        int chairNumber = -1;
        
        for(int index = 0; index < times.length; index++) {
            int arrivalTime = times[index][0];
            int leavingTime = times[index][1];
            
            while(allocatedChairs.size() > 0 && allocatedChairs.firstKey() <= arrivalTime) {
                int _leavingTime = allocatedChairs.firstKey();
                
                ArrayList<Integer> freeingChairs = allocatedChairs.get(_leavingTime);
                
                allocatedChairs.remove(_leavingTime);
                
                for(int freeChair : freeingChairs) {
                    freeChairs.add(freeChair);
                }
            }
            
            if (freeChairs.size() > 0) {
                satOn = freeChairs.poll();
            }
            else {
                satOn = ++chairNumber;
            }
            
            allocatedChairs.putIfAbsent(leavingTime, new ArrayList<>());
            allocatedChairs.get(leavingTime).add(satOn);
            
            if (arrivalTime == targeted[0] && leavingTime == targeted[1]) {
                return satOn;
            }
        }
        return -1;
    }
}
