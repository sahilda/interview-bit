// Simple Queries

/*
 * Complete the function below.
 */

    static int[] counts(int[] nums, int[] maxes) {
        if (maxes == null || maxes.length == 0) {
            return new int[0];
        } else if (nums == null || nums.length == 0) {
            return new int[maxes.length];
        }
        PriorityQueue<Integer> maxesHeap = makeHeap(maxes);
        PriorityQueue<Integer> numsHeap = makeHeap(nums);
        HashMap<Integer, ArrayList<Integer>> map = makeMap(maxes);
        int[] result = new int[maxes.length];
        
        int count = 0;
        while (maxesHeap.size() != 0) {
            int max = maxesHeap.poll();
            while (numsHeap.size() > 0 && numsHeap.peek() <= max) {
                count++;
                numsHeap.poll();
            }           
            ArrayList<Integer> list = map.get(max);
            int idx = list.get(0);
            list.remove(0);
            map.put(max, list);
            result[idx] = count;
        }        
        return result;
    }

    static HashMap<Integer, ArrayList<Integer>> makeMap(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list;
            if (map.containsKey(nums[i])) {
                list = map.get(nums[i]);
                list.add(i);
            } else {
                list = new ArrayList<>();
                list.add(i);
            }
            map.put(nums[i], list);
        }
        return map;
    }

    static PriorityQueue<Integer> makeHeap(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
        }
        return minHeap;
    }

