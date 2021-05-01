/*
1. For n platforms we will simply make n size list and it contains m size 
array list of pair. n = no of platforms, m = number of trains 
ArrayList<ArrayList<Pair>> list = new ArrayList<>(noOfPlatforms + 1);

2. Pair will contains(arrivalTime, departureTime)

3. Grouping trains according to platform number.

4. Sort each group by departure time.

5. Using nested loop check maximum trains possible for each platforms
*/

class MaximumTrains {

    public static void main(String[] args) {
        int array[][] = {{1000, 1030, 1},
        {1110, 1130, 1},
        {1200, 1220, 1},
        {1130, 1145, 2},
        {1130, 1140, 2}};

        int trainCounts = 5;
        int noOfPlatforms = 2;

        System.out.println(maxTrains(array, trainCounts, noOfPlatforms));;
    }

    public static int maxTrains(int array[][], int trainsCount,
            int noOfPlatforms) {

        int count = 0;
        ArrayList<ArrayList<Pair>> list = new ArrayList<>(noOfPlatforms + 1);
        
        for (int index = 0; index < noOfPlatforms + 1; index++){
            list.add(new ArrayList<Pair>());
        }
        
        for (int index = 0; index < trainsCount; index++){
            list.get(array[index][2]).add(new Pair(array[index][0], array[index][1]));
        }
        
        for (int index = 0; index < noOfPlatforms + 1; index++){
            ArrayList<Pair> currentList = list.get(index);
            
            Collections.sort(currentList, (pair1, pair2) -> pair1.end - pair2.end);
        }
        
        for (int index1 = 0; index1 < noOfPlatforms + 1; index1++){
            ArrayList<Pair> currentList = list.get(index1);
            
            if (currentList.isEmpty()){
                continue;
            }
            else{
                int previousIndex = 0;
                count++;
                for (int index2 = 1; index2 < currentList.size(); index2++){
                    if (currentList.get(previousIndex).end <= currentList.get(index2).start){
                        count++;
                        previousIndex = index2;
                    }
                }
            }
        }
        return count;
    }
}

class Pair {

    int start, end;

    Pair() {
    }

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
