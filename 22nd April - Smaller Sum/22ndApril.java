class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
       
     int b[]=new int [n];
        for(int i =0;i<n;i++){
            b[i]=arr[i];
        }

       Arrays.sort(b);
        long[] result = new long[arr.length];
        
        long sum =0;
        HashMap<Integer,Long> A = new HashMap<>();
        for(int i =0;i<n;i++){
            if(!A.containsKey(b[i])){
                A.put(b[i],sum);
            }
            
            sum = sum+b[i];
        }


        for(int i=0;i<n;i++){
            result[i] = A.get(arr[i]);
        } 
        return result;


    }
}