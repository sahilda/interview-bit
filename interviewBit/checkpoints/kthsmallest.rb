class Solution
    # param a : array of integers
    # param b : integer
    # returns an integer
    def kthsmallest(a, b)
        answer = -1
        size = a.size
        i = 0
        num = a[i]
        
        while (answer == -1)
            smaller = 0
            same = 0
        
            for n in a
                if n < num
                    smaller += 1
                elsif n == num
                    same += 1
                end        
            end

            if b > smaller && b <= (smaller + same)
                answer = num
            else
                if b <= smaller                    
                    for j in i...size
                        if a[j] < num
                            i = j
                            num = a[j]
                            break
                        end
                    end
                else
                    for j in i...size
                        if a[j] > num
                            i = j
                            num = a[j]
                            break
                        end
                    end
                end
            end
        end
        return answer
    end

end

s = Solution.new

puts s.kthsmallest([2,1,4,3,2], 1)
puts s.kthsmallest([2,1,4,3,2], 2)
puts s.kthsmallest([2,1,4,3,2], 3)
puts s.kthsmallest([2,1,4,3,2], 4)
puts s.kthsmallest([2,1,4,3,2], 5)