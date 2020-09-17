# Taken from https://www.facebook.com/careers/life/sample_interview_questions

# Spiral problem
def input(n)
  return nil if n < 1
  return [1] if n == 1

  result = []
  n.times do
    result << Array.new(n)
  end
  num = 1
  rmax = n-1
  rmin = 0
  tmax = 0
  tmin = n-1

  while num <= n**2  
    ridx = tmax
    cidx = rmin

    if num == n**2
      result[ridx][cidx] = num
       break
     end

    # go right
    while cidx < rmax
      result[ridx][cidx] = num
      num += 1
      cidx += 1
    end
    rmax -= 1

    # go down
    while ridx < tmin
      result[ridx][cidx] = num
      num+=1
      ridx += 1
    end
    tmin -= 1

    # go left
    while cidx > rmin
      result[ridx][cidx] = num
      num+=1
      cidx -= 1
    end
    rmin += 1

    # go up
    while ridx > tmax
      result[ridx][cidx] = num
      num+=1
      ridx -= 1
    end
    tmax += 1
  end

  result
end

p input(3)
p input(4)
p input(8)

# Look and Say

def look_and_say
  result = []
  last = [1]
  result << last

  10.times do
    row = []
    idx = 0

    cur = nil
    count = 1
    while idx < last.size
      if cur == nil
        cur = last[idx]
      elsif cur == last[idx]
        count += 1
      else
        row << count
        row << cur
        count = 1
        cur = last[idx]
      end
      idx += 1
    end
    row << count
    row << cur

    result << row
    last = row
  end
  result
end

p look_and_say


# Edit Distance

def one_edit_apart(s1, s2)  
  return false if (s1.size - s2.size).abs > 1

  edits = 0
  s1_idx = 0
  s2_idx = 0
  if s1.size == s2.size
    while s1_idx < s1.size
      edits += 1 if s1[s1_idx] != s2[s2_idx]            
      s1_idx += 1
      s2_idx += 1
    end
  else
    large = s1.size > s2.size ? s1 : s2
    small = s1.size > s2.size ? s2 : s1

    while s1_idx < large.size
      if large[s1_idx] == small[s2_idx]
        s1_idx += 1
        s2_idx += 1
      else
        edits += 1
        s1_idx += 1
      end
    end
  end
  edits < 2
end

p one_edit_apart('cat', 'dog')
p one_edit_apart('cat', 'cats')
p one_edit_apart('cat', 'cut')
p one_edit_apart('cat', 'cast')
p one_edit_apart('cat', 'at')
p one_edit_apart('cat', 'act')