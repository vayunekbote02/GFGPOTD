class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        // code here
        for (int i=0; i<m; i++) {
            if (n == 0) return true;
            if (seats[i] == 0 && (i == 0 || seats[i-1] == 0) && (i == m-1 || seats[i+1] == 0)) {
                seats[i] = 1;
                n -= 1;
            }
        }
        return n == 0;
    }
}