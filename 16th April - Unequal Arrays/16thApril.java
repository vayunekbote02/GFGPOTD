// Java solution
class Solution {
    public static long solve(int N, int[] A, int[] B) {
        Arrays.sort(A); // closer element should remain closer 
        Arrays.sort(B); // Minimum opern
        List<Integer> Aodds = new ArrayList<Integer>();
        List<Integer> Aevens = new ArrayList<Integer>();
        List<Integer> Bodds = new ArrayList<Integer>();
        List<Integer> Bevens = new ArrayList<Integer>();
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < N; i++) {
            sum1 += A[i];
            sum2 += B[i];
            if (A[i] % 2 != 0) {
                Aodds.add(A[i]);
            } else {
                Aevens.add(A[i]);
            }
            if (B[i] % 2 != 0) {
                Bodds.add(B[i]);
            } else {
                Bevens.add(B[i]);
            }
        }
        // confirmation that A->B
        if (sum1 != sum2 || Aodds.size() != Bodds.size()) {
            return -1;
        }

        long ans = 0;
        for (int i = 0; i < Aodds.size(); i++) {
            ans += Math.abs(Aodds.get(i) - Bodds.get(i));
        }
        for (int i = 0; i < Aevens.size(); i++) {
            ans += Math.abs(Aevens.get(i) - Bevens.get(i));
        }
        return ans / 4;
    }
}