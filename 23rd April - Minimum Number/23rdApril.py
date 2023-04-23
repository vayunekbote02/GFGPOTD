class Solution:
    def minimumNumber(self, n, arr):
        #code here
        smallest = min(arr)
        for i in arr:
            if i % smallest != 0:
                smallest = i % smallest
        return smallest