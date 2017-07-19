class Solution
    # param a : array of array of integers
    # return a array of integers
    def spiralOrder(a)
    	top = 0
    	bottom = a.size - 1
    	left = 0
    	right = a[0].size - 1
    	dir = 0 
    	output = []

    	while (top <= bottom && left <= right)
    		if dir == 0
    			for element in a[top][left..right]
    				output << element
    			end
    			top += 1
    			dir = 1
    		elsif dir == 1
    			(top..bottom).each do | i |
    				output << a[i][right]
    			end
    			right -= 1
    			dir = 2
    		elsif dir == 2
    			for element in a[bottom][left..right].reverse
    				output << element
    			end
    			bottom -= 1
    			dir = 3
    		elsif dir == 3
    			(top..bottom).reverse_each do | i |
    				output << a[i][left]
    			end
    			left += 1
    			dir = 0
    		end
    	end
    	output
	end

	    def spiralOrderB(a)
    	top = 0
    	bottom = a.size - 1
    	left = 0
    	right = a[0].size - 1
    	dir = 0 

    	while (top <= bottom && left <= right)
    		if dir == 0
    			printer(a[top][left..right])
    			top += 1
    			dir = 1
    		elsif dir == 1
    			(top..bottom).each do | i |
    				print a[i][right]
    			end
    			right -= 1
    			dir = 2
    		elsif dir == 2
    			printer(a[bottom][left..right].reverse)
    			bottom -= 1
    			dir = 3
    		elsif dir == 3
    			(top..bottom).reverse_each do | i |
    				print a[i][left]
    			end
    			left += 1
    			dir = 0
    		end
    	end
	end

	def printer(a)
		for i in a
			print i
		end
	end
end

a = [[ 1, 2, 3 ],[ 4, 5, 6 ],[ 7, 8, 9 ]]
b = [[1]]

print Solution.new.spiralOrder(a)
print Solution.new.spiralOrder(b)
print Solution.new.spiralOrderB(a)
print Solution.new.spiralOrderB(b)
