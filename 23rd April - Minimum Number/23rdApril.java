class Solution {
    public static int minimumNumber(int n, int[] arr) {
        // code here
         if(n==1)
            return arr[0];
        int gc = gcd(arr[0],arr[1]);
        for(int i=2; i<n; i++)
            gc = gcd(gc,arr[i]);
        return gc;
    }
    public static int gcd(int a,int b){
        if(a==b)
            return b;
        if(a==0)
            return b;
        if(b==0)
            return a;
        if(a>b)
            return gcd(a%b,b);
        return gcd(a,b%a);
    }
}