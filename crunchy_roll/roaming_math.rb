require 'net/http'
require 'json'

BASE_URL = 'http://www.crunchyroll.com/tech-challenge/roaming-math/sahildagarwal@gmail.com/'

class LineEvaluator
    @@abs = "abs"
    @@sub = "subtract"
    @@add = "add"
    @@mul = "multiply"

    def evaluate(part)
        return part.to_i if !contains_nondigits?(part)
        operator = part.match(/\A\w+/)[0]   
        inner = part.sub(/\A\w+/, '')[1...-1]
        case operator
        when @@abs
            return evaluate(inner).abs
        else
            p1, p2 = get_parts(inner)
            case operator
            when @@sub
                return evaluate(p1) - evaluate(p2)
            when @@add
                return evaluate(p1) + evaluate(p2)
            when @@mul
                return evaluate(p1) * evaluate(p2)
            end
        end
    end

    def contains_nondigits?(string)
        string.scan(/[^0-9,-]/).size > 0
    end

    def get_parts(string)
        part1 = ""
        paranethesis_count = 0
        string.each_char.with_index do |c, idx|
            if c == "," && paranethesis_count == 0
                return [part1, string[idx+1..-1]]
            elsif c == ")"
                paranethesis_count -= 1 
                if paranethesis_count == 0
                    part1 << c
                    return [part1, string[idx+2..-1]]
                end
            elsif c == "("
                paranethesis_count += 1 
            end
            part1 << c
        end        
    end
end

le = LineEvaluator.new

goal = nil
node_count = 0
shortest_path = nil
directed_cycle_count = 0

map = {}

start = 'abs(add(add(multiply(193,40252),212),add(subtract(249,subtract(61,61837)),18)))'
queue = [le.evaluate(start)]

while queue.size > 0
    num = queue.shift
    uri = URI("#{BASE_URL}#{num}")
    response = Net::HTTP.get(uri).split("\n")

    if response[0] == "DEADEND"
        map[num] = "DEADEND"
    elsif response[0] == "GOAL"
        map[num] = "GOAL"
        goal = num
    else
        map[num] = []
        response.each do |line|                                
            new_num = le.evaluate(line)
            map[num] << new_num
            if map.has_key?(new_num) && map[new_num] != "GOAL" && map[new_num] != "DEADEND"
                directed_cycle_count += 1
            else
                queue << new_num unless queue.include? new_num
            end
        end
    end
end

def get_shortest_path(map, current, path)
    if map[current] == "GOAL"
        path << current
        return path
    end

    if map[current] == "DEADEND" || path.include?(current)
        return nil
    end

    nodes = map[current]
    shortest = nil
    nodes.each do |node|
        a_path = get_shortest_path(map, node, [path, current].flatten)
        if a_path != nil && (shortest == nil || a_path.size < shortest.size)
            shortest = a_path
        end
    end
    shortest
end

p map

shortest_path = get_shortest_path(map, map.keys[0], [])
answer = { :goal => goal, :node_count => map.keys.size, :shortest_path => shortest_path, :directed_cycle_count => directed_cycle_count }
puts answer.to_json
            

