class Solution:
    def smallerSum(self, n : int, arr : List[int]) -> List[int]:
        # code here
        temp = arr.copy()
        temp.sort()
        
        d = {}
        d[temp[0]] = 0
        prefix_sum = temp[0]
        
        for i in range(1, n):
            if temp[i] == temp[i-1]:
                prefix_sum += temp[i]
                i += 1
            else:
                d[temp[i]] = prefix_sum
                prefix_sum += temp[i]
            
        res = []
        for i in arr:
            res.append(d[i])
            
        return res