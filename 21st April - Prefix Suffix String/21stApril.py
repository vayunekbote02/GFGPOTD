class Solution:
    def prefixSuffixString(self, s1, s2) -> int:
        #code here
        dot = '.'
        count = 0
        for string in s1:
            dot += string
            dot += '.'
            
        for string in s2:
            prefix = '.' + string
            suffix = string + '.'
            
            if prefix in dot or suffix in dot:
                count += 1
                
        return count