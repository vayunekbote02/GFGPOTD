class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
		int n = arr.length;
		Stack <Integer> stack = new Stack<>();
		
		int pre[] = new int[n];
		int suf[] = new int[n];
		
		// from left side
		for(int i = 0; i<n; i++){

		    while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]) stack.pop();
		    
		    if(stack.isEmpty()) pre[i] = -1;
		    else pre[i] = stack.peek();
		    
		    stack.push(i);
		}
		
		//from right side
		for(int i = n-1; i>=0; i--){

		    while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]) stack.pop();
		    
		    if(stack.isEmpty()) suf[i] = -1;
		    else suf[i] = stack.peek();
		    
		    stack.push(i);
		}
		
		int ans[] = new int[n];
		
		// answer
		for(int i = 0; i<n; i++){
		    if(pre[i]== -1 && suf[i]==-1) ans[i] = -1;
		    else if(pre[i] == -1 ) ans[i] = suf[i];
		    else if(suf[i] == -1) ans[i] = pre[i];
	        else if(i - pre[i] == suf[i] - i) {
	            if(arr[pre[i]]<=arr[suf[i]]) ans[i] = pre[i];
	            else ans[i] = suf[i];
	        }
		    else if(i - pre[i] > suf[i] - i) ans[i] = suf[i];
		    else ans[i] = pre[i];
		}
		return ans;
	}
	

}