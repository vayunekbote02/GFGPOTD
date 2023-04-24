class Solution:
    def nearestSmallestTower(self,arr):
        #code here
        n = len(arr)
        stack, smallest_to_left, smallest_to_right = [], [], []

        for i in range(n):
            while len(stack) > 0 and arr[stack[-1]] >= arr[i]:
                stack.pop()
                
            if len(stack) == 0:
                smallest_to_left.append(-1)
            else:
                smallest_to_left.append(stack[-1])
            stack.append(i)
        
        stack.clear()    
            
        for i in range(n-1, -1, -1):
            while len(stack) > 0 and arr[stack[-1]] >= arr[i]:
                stack.pop()
                
            if len(stack) == 0:
                smallest_to_right.append(-1)
            else:
                smallest_to_right.append(stack[-1])
            stack.append(i)
        smallest_to_right = smallest_to_right[::-1]
            
        res = []
        
        for i in range(n):
            if smallest_to_left[i] == smallest_to_right[i]:
                res.append(-1)
            elif smallest_to_left[i] == -1:
                res.append(smallest_to_right[i])
            elif smallest_to_right[i] == -1:
                res.append(smallest_to_left[i])
            
            elif i - smallest_to_left[i] == smallest_to_right[i] - i:
                if arr[smallest_to_left[i]] < arr[smallest_to_right[i]]:
                    res.append(smallest_to_left[i])
                elif arr[smallest_to_left[i]] == arr[smallest_to_right[i]]:
                    res.append(min(smallest_to_left[i], smallest_to_right[i]))
                else:
                    res.append(smallest_to_right[i])
                    
            else:
                if i - smallest_to_left[i] < smallest_to_right[i] - i:
                    res.append(smallest_to_left[i])
                else:
                    res.append(smallest_to_right[i])
                    
                    
        return res