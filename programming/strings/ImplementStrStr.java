public class ImplementStrStr {

	public int strStr(final String haystack, final String needle) {
		if (needle.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                map.put(i, haystack.charAt(i) + "");
            }

            ArrayList<Integer> removal = new ArrayList<Integer>();
            ArrayList<Integer> add = new ArrayList<Integer>();

            for (Integer k : map.keySet()) {
                String current = map.get(k);
                int idx = current.length();
                if (current.equals(needle)) {
                    return k.intValue();
                }
                if (k.intValue() == i) {
                } else if (haystack.charAt(i) != needle.charAt(idx)) {
                    removal.add(k);
                } else {
                    add.add(k);
                }
            }
            for (Integer k : removal) {
                map.remove(k);
            }
            for (Integer k : add) {
                String current = map.get(k);
                current += haystack.charAt(i);
                map.put(k, current);
            }
        }

        for (Integer k : map.keySet()) {
            String current = map.get(k);
            if (current.equals(needle)) {
                return k.intValue();
            }
        }

        return -1;
    }

}
