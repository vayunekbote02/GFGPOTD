class Solution{
public:
    vector<long long> smallerSum(int n,vector<int> &arr){
        // Code here
        if(n<2) return {0};
        vector<int>copy;
        for(int i=0; i<n; i++){
            copy.push_back(arr[i]);
        }
        sort(copy.begin(), copy.end());
      vector<long>sum(n,0);
        long long pre_sum=0;
       
        for(int i=1; i<n; i++){
            pre_sum+=copy[i-1];
            sum[i]=pre_sum;
            
        }
        vector<long long>res(n,0);
        for(int i=0; i<n; i++){
            int x=lower_bound(copy.begin(),copy.end(),arr[i] )-copy.begin();
            res[i]=sum[x];
        }
        return res;
    }
};