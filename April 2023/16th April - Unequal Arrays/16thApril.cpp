// C++ solution
class Solution {
  public:
    long long solve(int N, vector<int> &A, vector<int> &B) {
        
        vector<int> a[2], b[2];
        
        long long s1=0, s2=0;
        
        for(int i=0; i<N; i++){
            s1+=A[i];
            s2+=B[i];
            
            if(abs(A[i])%2==0)
                a[0].push_back(A[i]);
            else
                a[1].push_back(A[i]);
            
            if(abs(B[i])%2==0)
                b[0].push_back(B[i]);
            else
                b[1].push_back(B[i]);
        }
        
        if(s1!=s2 or (a[0].size()!=b[0].size()))
        {
            return -1;
        }
        
        long long ans = 0;
    
        for(int i = 0; i < 2; i++) 
        {
            sort(a[i].begin(), a[i].end());
            sort(b[i].begin(), b[i].end());
            
            for(int j = 0; j < a[i].size(); j++) 
            {
                ans += abs(a[i][j] - b[i][j]) / 2;
            }
        }
        return ans / 2;
    }
};