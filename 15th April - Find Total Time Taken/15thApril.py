# Python solution
class Solution:
    def totalTime(self, n : int, arr : List[int], time : List[int]) -> int:
        # code here
        s = set()
        s.add(arr[0])
        
        total_time = 0
        for i in range(1, n):
            if arr[i] not in s:
                total_time += 1
                s.add(arr[i])
            else:
                total_time += time[arr[i]-1]
            
        return total_time