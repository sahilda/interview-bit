class Solution
	# @param a : array of array of integers
	# @return an integer
	def findMedian(a)
		min_median = -1
		max_median = -1
		a.each_with_index do | row, idx |
			median = row[row.size / 2]
			if idx == 0
				min_median = median
				max_median = median
			else
				if median < min_median 
					min_median = median
				elsif median > max_median
					max_median = median
				end
			end
		end

		desired = (a.size * a[0].size + 1) / 2
		while min_median < max_median
			mid = min_median + (max_median - min_median) / 2
			place = 0
			a.each do | row |				
				place += upperBound(row, mid)
			end
			# print "#{min_median}, #{max_median}, #{desired}, #{place}, #{mid}\n"
			if (place < desired)
				min_median = mid + 1
			else
				max_median = mid
			end
		end

		return min_median
	end

	def upperBound(a, target)
		min = 0
		max = a.size - 1
		while (min <= max)
			mid = (min + max) / 2
			if a[mid] <= target
				min = mid + 1
			else
				max = mid - 1
			end
		end
		return min
	end

end


a = [[1,3,5], [2,6,9], [3, 6, 9]]
print Solution.new.findMedian(a)
print "\n"

b = [[9, 10, 10, 13, 14, 15, 16, 16, 16, 17, 18],[1, 4, 9, 14, 16, 18, 19, 22, 26, 26, 27],[4, 6, 7, 10, 14, 20, 21, 23, 24, 27, 28]]
print Solution.new.findMedian(b)
print "\n"

c = [[2],[1],[4],[1],[2],[2],[5]]
print Solution.new.findMedian(c)
print "\n"