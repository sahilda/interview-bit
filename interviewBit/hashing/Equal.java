public class Equal {
	
	public ArrayList<Integer> equalBrute(ArrayList<Integer> a) {
		int size = a.size();
		ArrayList<Integer> out = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				for (int k = i + 1; k < size; k++) {
					for (int l = k + 1; l < size; l++) {
						if ((a.get(i) + a.get(j)) == (a.get(k) + a.get(l)) && j != k && j !=l) {
							out.add(i);
							out.add(j);
							out.add(k);
							out.add(l);
							return out;
						}
					}
				}
			}
		}
		return out;
    }

    public ArrayList<Integer> equal(ArrayList<Integer> A) {        
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Node>> hashMap = new HashMap<>();
        int n;
        int sum;
        ArrayList<Node> nodes;
        Node curNode;
        n = A.size();
        
        if (A == null || A.size() < 4) {
            return res;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum = A.get(i) + A.get(j);
                curNode = new Node(i, j);
                
                if (hashMap.containsKey(sum)) {
                    nodes = hashMap.get(sum);
                } else {
                    nodes = new ArrayList<>();
                }
                
                nodes.add(curNode);
                hashMap.put(sum, nodes);                
            }
        }
        
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { 
                sum = A.get(i) + A.get(j);
                curNode = new Node(i, j);
                if (hashMap.containsKey(sum)) {
                    nodes = hashMap.get(sum);
                    for (Node node : nodes) {
                        if (overlaps(curNode, node)) {
                            continue;
                        }
                        res.add(curNode.i);
                        res.add(curNode.j);
                        res.add(node.i);
                        res.add(node.j);
                        return res;
                    }
                }
            }
        }
        return res;
    }
    
    public boolean overlaps(Node n1, Node n2) {        
        if (n1.i == n2.i || n1.i == n2.j || n1.j == n2.i || n1.j == n2.j) {
            return true;
        }        
        return false;
    }
    
    class Node {
        int i, j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}