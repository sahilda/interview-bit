class Solution
    # param a : integer
    # return a array of array of integers
    def prettyPrint(a)
    	answer = []
    	num_lines = (a * 2) - 1
    	mid = num_lines / 2
        for row_idx in 0...num_lines
        	row = []
        	for col_idx in 0...num_lines
        		max_diff = [(col_idx - mid).abs, (row_idx - mid).abs].max
        		row << max_diff + 1        		
        	end
        	answer << row
        end
        return answer
    end

end
