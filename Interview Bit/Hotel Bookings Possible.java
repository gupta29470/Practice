public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int len = arrive.size();
        Collections.sort(arrive);
        Collections.sort(depart);
        int arriveIndex = 1, departIndex = 0, currentBooking = 1, maxBooking = 1;
        
        while (arriveIndex < len && departIndex < len){
            if (arrive.get(arriveIndex) >= depart.get(departIndex)){
                currentBooking --;
                departIndex ++;
            }
            else{
                currentBooking ++;
                arriveIndex ++;
                maxBooking = Math.max(maxBooking, currentBooking);
            }
            
            if (maxBooking > K){
                return false;
            }
        }
        return true;
    }
}





public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int len = arrive.size();
        Collections.sort(arrive);
        Collections.sort(depart);
        int arriveIndex = 1, departIndex = 0, currentBooking = 1, maxBooking = 1;
        
        while (arriveIndex < len && departIndex < len){
            if (arrive.get(arriveIndex) < depart.get(departIndex)){
                currentBooking ++;
                arriveIndex ++;
                maxBooking = Math.max(currentBooking, maxBooking);
            }
            else{
                currentBooking --;
                departIndex ++;
            }
            if (maxBooking > K){
                return false;
            }
        }
        return true;
    }
}
Time --> O(nLogn)


