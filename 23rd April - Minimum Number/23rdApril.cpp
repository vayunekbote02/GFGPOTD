class Solution{
public:
    int minimumNumber(int n,vector<int> &arr){
        int gc=arr[0];
        int mnm=*min_element(arr.begin(),arr.end());
        for(int i=1;i<n;i++)gc=__gcd(gc,arr[i]);
        if(gc==mnm)return mnm;
        return 1;
    }
};