// Java solution
class Solution
{
    public static long totalTime(int n,int arr[],int time[])
    {
        long count=0;
        HashSet<Integer> hs=new HashSet<>();
        hs.add(arr[0]);
        for(int i=1;i<n;i++){
            if(hs.contains(arr[i])){
                count+=time[arr[i]-1];
            }else{
                hs.add(arr[i]);
                count+=1;
            }
        }
        return count;
    }
}