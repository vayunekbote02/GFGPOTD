// Java Code
class Solution {
    public static int finLength(int n, int[] color, int[] radius) {
        // code here
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{color[0] , radius[0]});
        
        for(int i = 1; i<n; i++){
            
            if( !stack.isEmpty() && color[i]== stack.peek()[0] && radius[i]== stack.peek()[1]){
                stack.pop();
            }
            else stack.push(new int[]{color[i], radius[i]});
        }
        
        return stack.size();
    }
}
