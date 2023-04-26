// Java solution
class Solution 
{ 
    boolean wifiRange(int N, String S, int X) 
    { 
        // code here
        int c = 0;
        int i = 0;
        while(i<N){
            if(S.charAt(i)=='0')
                c++;
            else
                c = (-1)*(X);
            i++;
            if(c>X)
                return false;
        }
        if(c>0)
            return false;
        return true;

    }
} 