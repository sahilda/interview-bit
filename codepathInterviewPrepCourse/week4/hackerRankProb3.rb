# counter game to get to 1 first

# Complete the function below.

def counterGame(tests)
    tests.each do | test |
        print gameWinner(test)
        print "\n"
    end
end

def gameWinner(test)
    counter = test.to_i
    turn = -1
    while counter != 1
        turn = turn + 1
        if (powOf2(counter)) 
            counter = counter / 2
        else
            largestNext = largestPowOf2(counter)
            counter = counter - largestNext
        end
    end
    
    if (turn % 2 == 0)
        return "Louise"
    else
        return "Richard"
    end
end

def largestPowOf2(num)
    start = 1
    while (start < num)
        start = start * 2
    end
    return start / 2
end

def powOf2(num)
    if num & (num - 1) == 0
        return true
    else
        return false
    end
end