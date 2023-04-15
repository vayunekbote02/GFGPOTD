// C++ solution
class Solution {
  public:
    int totalTime(int n, vector<int> &arr, vector<int> &time) {
        // code here
        map<int,bool> visited;
        int t=-1;
        for( int i=0; i<n; i++ )
            visited[arr[i]] = false;
        for( int i=0; i<n; i++ ){
            if( !visited[arr[i]] ){
                visited[arr[i]] = true;
                t++;
            }
            else
                t+=time[arr[i]-1];
        }
        return t;
    }
};