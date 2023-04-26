class Solution:
    def is_possible_to_get_seats(self, n : int, m : int, seats : List[int]) -> bool:
        for i in range(m):
            if n == 0:
                return True
            if seats[i] == 0 and (i == 0 or seats[i-1] == 0) and (i == m-1 or seats[i+1] == 0):
                seats[i] = 1
                n -= 1
                
        return n == 0